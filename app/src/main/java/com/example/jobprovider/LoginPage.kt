package com.example.jobprovider

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jobprovider.databinding.ActivityLoginPageBinding
import com.example.jobprovider.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider
import com.google.firebase.firestore.auth.User
import java.util.regex.Matcher
import java.util.regex.Pattern

class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    private val ourmachinename = "Login Machine"
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        var em = findViewById<EditText>(R.id.editTextTextEmailAddress)
        var pass = findViewById<EditText>(R.id.editTextPhone)

        binding.textView7.setOnClickListener {
            startActivity(Intent(this,SignUp::class.java))
        }
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            var email = em.text.toString()
            var password = pass.text.toString()
            if (isValidPassword(password)){
                auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("hello", "createUserWithEmail:success")
                            Toast.makeText(baseContext,"Authentication Success",Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,MainPageActivity::class.java).putExtra("name",binding.editTextText2.text.toString()))
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Bye", "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext,
                                "Authentication failed.",
                                Toast.LENGTH_SHORT,
                            ).show()
                        }
                    }
            }
            else{
                Toast.makeText(this,"Password must contain one uppercase,one number and one special character",Toast.LENGTH_SHORT).show()
            }

        }
    }
    fun isValidPassword(password: String?): Boolean {
        val pattern: Pattern

        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"

        pattern = Pattern.compile(PASSWORD_PATTERN)
        val matcher: Matcher = pattern.matcher(password)

        return matcher.matches()
    }

}

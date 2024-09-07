package com.example.jobprovider

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jobprovider.databinding.ActivitySignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        var em = binding.editTextText2
        var pass = binding.editTextPhone

        binding.textView7.setOnClickListener {
            startActivity(Intent(this,LoginPage::class.java))
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
                            Toast.makeText(baseContext,"Authentication Success", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,LoginPage::class.java))
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
                Toast.makeText(this,"Password must contain one uppercase,one number and one special character",
                    Toast.LENGTH_SHORT).show()
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
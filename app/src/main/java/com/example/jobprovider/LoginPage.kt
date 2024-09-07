package com.example.jobprovider

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jobprovider.databinding.ActivityLoginPageBinding
import com.example.jobprovider.databinding.ActivityMainBinding

class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(binding.editTextText2.text!=null && binding.editTextTextEmailAddress.text!=null && binding.editTextPhone.text!=null){
            binding.button.setOnClickListener {
                startActivity(Intent(this, MainPageActivity::class.java))
                finish()
            }
        }else{
            Toast.makeText(this,"All Fields are Mandatory",Toast.LENGTH_SHORT).show()
            }

        }

    }

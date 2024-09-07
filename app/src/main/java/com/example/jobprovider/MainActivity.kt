package com.example.jobprovider

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jobprovider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.letsStartBtn.setOnClickListener {
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }

    }
}
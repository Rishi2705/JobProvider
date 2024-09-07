package com.example.jobprovider

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jobprovider.databinding.ActivityResumeBinding

class ResumeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResumeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResumeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        binding.web.loadUrl("https://www.kickresume.com/en/resume-checker/")

    }
}
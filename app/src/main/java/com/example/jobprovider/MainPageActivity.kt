package com.example.jobprovider

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jobprovider.databinding.ActivityMainPageBinding

class MainPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.userImg.setOnClickListener {
            startActivity(Intent(this, ProfilePage::class.java))
        }
        binding.filter.setOnClickListener {
            startActivity(Intent(this, FilterScreen::class.java))
        }

        binding.cv2.setOnClickListener{
            startActivity(Intent(this, ResumeActivity::class.java))
        }


    }
}
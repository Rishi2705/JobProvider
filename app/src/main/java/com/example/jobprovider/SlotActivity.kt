package com.example.jobprovider

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jobprovider.databinding.ActivitySlotBinding

class SlotActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySlotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.web.loadUrl("https://slot-booking-for-offline-exam.vercel.app/")
    }
}
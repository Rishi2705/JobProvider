package com.example.jobprovider

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.jobprovider.databinding.ActivitySlotBinding


class SlotActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySlotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.web.loadUrl("https://slot-booking-for-offline-exam.vercel.app/")

        binding.web.getSettings().javaScriptEnabled = true
        binding.web.webChromeClient = WebChromeClient()

        binding.web.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                if (url.startsWith("foo://")) {
                    return true
                }
                return false
            }
        })
    }
}
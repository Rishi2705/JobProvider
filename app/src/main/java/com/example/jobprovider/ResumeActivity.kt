package com.example.jobprovider

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
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
        binding.web.getSettings().javaScriptEnabled = true

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
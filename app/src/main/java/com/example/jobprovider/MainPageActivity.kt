package com.example.jobprovider

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jobprovider.databinding.ActivityMainPageBinding

class MainPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainPageBinding
    lateinit var al : ArrayList<user>
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

        binding.recycle.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val type = arrayOf("Development only","DSA only","Development only","Aptitude only","Dev&DSA","Dev,DSA&Aptitude")
        val date = arrayOf("07/09/2024","09/09/2024","11/09/2024","11/09/2024","07/09/2024","07/09/2024")
        val slot = arrayOf("09:30-12:30","01:30-4:30","09:30-12:30","10:30-01:30","01:30-04:30","02:30-08:30")
        val day = arrayOf("0d","2d","4d","4d","0d","0d")

        al = arrayListOf()
        for(i in type.indices){
            val item1 = user(type[i],date[i],slot[i],day[i])
            al.add(item1)
        }
        binding.recycle.adapter = ItemAdapter(this, al)

        binding.seeAll.setOnClickListener {
            startActivity(Intent(this,SlotActivity::class.java))
        }





    }
}
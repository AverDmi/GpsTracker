package com.dimthomas.gpstracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dimthomas.gpstracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBottomNavClicks()
    }

    private fun onBottomNavClicks() {
        binding.bNavV.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_btn -> Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                R.id.tracks_btn -> Toast.makeText(this, "Tracks", Toast.LENGTH_SHORT).show()
                R.id.settings_btn -> Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}
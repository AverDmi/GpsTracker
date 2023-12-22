package com.dimthomas.gpstracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimthomas.gpstracker.databinding.ActivityMainBinding
import com.dimthomas.gpstracker.fragments.MainFragment
import com.dimthomas.gpstracker.fragments.SettingsFragment
import com.dimthomas.gpstracker.fragments.TracksFragment
import com.dimthomas.gpstracker.utils.openFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBottomNavClicks()
        openFragment(MainFragment.newInstance())
    }

    private fun onBottomNavClicks() {
        binding.bNavV.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_btn -> openFragment(MainFragment.newInstance())
                R.id.tracks_btn -> openFragment(TracksFragment.newInstance())
                R.id.settings_btn -> openFragment(SettingsFragment())
            }
            true
        }
    }
}
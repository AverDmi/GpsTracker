package com.dimthomas.gpstracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dimthomas.gpstracker.R
import com.dimthomas.gpstracker.databinding.FragmentMainBinding
import com.dimthomas.gpstracker.databinding.FragmentSettingsBinding
import com.dimthomas.gpstracker.databinding.FragmentTracksBinding
import com.dimthomas.gpstracker.databinding.FragmentViewTrackBinding

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }
}
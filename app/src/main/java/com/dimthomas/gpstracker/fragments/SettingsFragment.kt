package com.dimthomas.gpstracker.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.Preference.OnPreferenceChangeListener
import androidx.preference.PreferenceFragmentCompat
import com.dimthomas.gpstracker.R

private const val UPDATE_TIME_KEY = "update_time_key"
private const val COLOR_KEY = "color_key"

class SettingsFragment: PreferenceFragmentCompat() {

    private lateinit var timePref: Preference
    private lateinit var colorPref: Preference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.main_preference, rootKey)
        init()
    }

    private fun init() {
        timePref = findPreference(UPDATE_TIME_KEY)!!
        colorPref = findPreference(COLOR_KEY)!!
        val changeListener = onChangeListener()
        timePref.onPreferenceChangeListener = changeListener
        colorPref.onPreferenceChangeListener = changeListener
        initPrefs()
    }

    private fun onChangeListener(): OnPreferenceChangeListener {
        return OnPreferenceChangeListener {
            pref, value ->
            when(pref.key) {
                UPDATE_TIME_KEY -> onTimeChange(value.toString())
                COLOR_KEY -> pref.icon?.setTint((Color.parseColor(value.toString())))
            }
            true
        }
    }

    private fun onTimeChange(value: String) {
        val nameArray = resources.getStringArray(R.array.loc_time_update_name)
        val valueArray = resources.getStringArray(R.array.loc_time_update_value)
        val title = timePref.title.toString().substringBefore(":")
        val position = valueArray.indexOf(value)
        timePref.title = "$title: ${nameArray[position]}"
    }

    private fun initPrefs() {

        val pref = timePref.preferenceManager.sharedPreferences
        val nameArray = resources.getStringArray(R.array.loc_time_update_name)
        val valueArray = resources.getStringArray(R.array.loc_time_update_value)
        val title = timePref.title
        val position = valueArray.indexOf(pref?.getString(UPDATE_TIME_KEY, "3000"))
        timePref.title = "$title: ${nameArray[position]}"

        val trackColor = pref?.getString(COLOR_KEY, "#FF134DE1")
        colorPref.icon?.setTint(Color.parseColor(trackColor))
    }
}
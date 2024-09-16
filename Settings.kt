package com.example.whatiamtest

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat

class ActivitySettings : AppCompatActivity() {
    private lateinit var themeSwitch: SwitchCompat
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        themeSwitch = findViewById(R.id.themeswitch)
        sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        editor = sharedPreferences.edit()

        // Check current theme preference
        val isDarkModeOn = sharedPreferences.getBoolean("isDarkModeOn", false)
        themeSwitch.isChecked = isDarkModeOn

        // Apply the current theme
        if (isDarkModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putBoolean("isDarkModeOn", true)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean("isDarkModeOn", false)
            }
            editor.apply()
        }
    }
}

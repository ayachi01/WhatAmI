package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ActivitySettings : AppCompatActivity() {

    lateinit var settingstohome: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)



        this.settingstohome = findViewById(R.id.settingstohome)
        settingstohome.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2) }

    }
}
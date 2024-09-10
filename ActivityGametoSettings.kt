package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityGametoSettings : AppCompatActivity() {

    lateinit var settingstohome: Button
    lateinit var quit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gameto_settings)

        this.settingstohome = findViewById(R.id.settingstohome)
        settingstohome.setOnClickListener {
            val intent2 = Intent(this, ActivityGame::class.java)
            startActivity(intent2) }
        this.quit = findViewById(R.id.quit)
        quit.setOnClickListener {
            val intent3 = Intent(this, MainActivity::class.java)
            startActivity(intent3)
        }

        }
    }

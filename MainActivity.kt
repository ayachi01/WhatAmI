package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var start: Button
    lateinit var settings: Button

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets }

            this.settings = findViewById(R.id.settings)
                settings.setOnClickListener {
                val intent1 = Intent(this, ActivitySettings::class.java)
                startActivity(intent1)
                    }

            this.start = findViewById(R.id.start)
                start.setOnClickListener {
                    val intent2 = Intent(this, ActivityGame::class.java)
                    startActivity(intent2)
                }

                
                val mediaPlayer = MediaPlayer.create(this, R.raw.diewithasmile)
        mediaPlayer.start()
        mediaPlayer.isLooping = true

    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.start()
    }

        }
    }

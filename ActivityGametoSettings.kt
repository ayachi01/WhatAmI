package com.example.myapplication

import android.content.Intent
import android.media.SoundPool
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
        val soundPool = SoundPool.Builder().build()
        val soundId = soundPool.load(this, R.raw.mouse_click, 1)
        settingstohome.setOnClickListener {
            soundPool.play(soundId, 1f, 1f, 1, 0, 1f)
            val intent2 = Intent(this, ActivityGame::class.java)
            startActivity(intent2) }


        this.quit = findViewById(R.id.quit)
        quit.setOnClickListener {
            soundPool.play(soundId, 1f, 1f, 1, 0, 1f)
            val intent3 = Intent(this, MainActivity::class.java)
            startActivity(intent3)
        }

        }
    }

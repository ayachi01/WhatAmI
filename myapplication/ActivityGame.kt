package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.media.SoundPool
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityGame : AppCompatActivity() {

    lateinit var settings2: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        this.settings2 = findViewById(R.id.settings2)
        val soundPool = SoundPool.Builder().build()
        val soundId = soundPool.load(this, R.raw.mouse_click, 1)
        settings2.setOnClickListener {
            soundPool.play(soundId, 1f, 1f, 1, 0, 1f)
            val intent2 = Intent(this, ActivityGametoSettings::class.java)
            startActivity(intent2)
        }

    }
}
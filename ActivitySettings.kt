package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.media.MediaPlayer
import android.widget.SeekBar


class ActivitySettings : AppCompatActivity() {

    private lateinit var settingstohome: Button
    private lateinit var music: SeekBar
    private lateinit var volume: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)


        this.settingstohome = findViewById(R.id.settingstohome)
        settingstohome.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
        }
        //...music
        val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        val music = findViewById<SeekBar>(R.id.music)
        music.max = maxVolume

        music.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }


            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null) {
                    var startPoint = seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null){
                var endPoint = seekBar.progress
                    }
            }
        })
        music.progress = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
            }
        }






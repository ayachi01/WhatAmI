package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.app.ServiceCompat


class MainActivity : AppCompatActivity() {

    private lateinit var start: Button
    private lateinit var settings: Button
    private var mediaPlayer: MediaPlayer? = null

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        this.settings = findViewById(R.id.settings)
        val soundPool = SoundPool.Builder().build()
        val soundId = soundPool.load(this, R.raw.mouse_click, 1)
        settings.setOnClickListener {
            soundPool.play(soundId, 1f, 1f, 1, 0, 1f)
            val intent1 = Intent(this, ActivitySettings::class.java)
            startActivity(intent1)

        }


        this.start = findViewById(R.id.start)
        start.setOnClickListener {
            soundPool.play(soundId, 1f, 1f, 1, 0, 1f)
            val intent2 = Intent(this, ActivityGame::class.java)
            startActivity(intent2)
            }


        val mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.start()
        mediaPlayer.isLooping = true


        val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val audioFocusRequest = AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
            .setOnAudioFocusChangeListener { focusChange ->
                when (focusChange) {
                    AudioManager.AUDIOFOCUS_LOSS -> mediaPlayer.pause()
                    AudioManager.AUDIOFOCUS_GAIN -> mediaPlayer.start()
                    // Handle other focus changes as needed
                }
            }
            .build()
        audioManager.requestAudioFocus(audioFocusRequest)
    }


    override fun onResume() {
        super.onResume()
        mediaPlayer?.release()
    }

    override fun onPause() {
        super.onPause()
    }

}






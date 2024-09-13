//...Main concept of game

package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
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
        settings2.setOnClickListener {
            val intent2 = Intent(this, ActivityGametoSettings::class.java)
            startActivity(intent2)}

    }
}

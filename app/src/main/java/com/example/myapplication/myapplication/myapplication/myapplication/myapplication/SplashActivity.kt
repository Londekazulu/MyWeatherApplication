package com.example.myapplication.myapplication.myapplication.myapplication.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.myapplication.myapplication.myapplication.myapplication.R.id.exitButton
import com.example.myapplication.myapplication.myapplication.myapplication.myapplication.R.id.startButton

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val startButton = findViewById<Button>(startButton)
        val exitButton = findViewById<Button>(exitButton)

        startButton.setOnClickListener {
            val intent = intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finish()
        }
    }
}

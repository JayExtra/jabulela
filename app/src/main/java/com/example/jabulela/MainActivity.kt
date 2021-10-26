package com.example.jabulela

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        val animation = AnimationUtils.loadAnimation(this, R.anim.top_animation)

        val animation2 = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        val image = findViewById<ImageView>(R.id.imggirl)

        val text = findViewById<TextView>(R.id.tvjab)

        image.startAnimation(animation)
        text.startAnimation(animation2)

        val button = findViewById<Button>(R.id.btn_1)
        button.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}

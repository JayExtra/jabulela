package com.example.jabulela

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        val button = findViewById<Button>(R.id.btn_3)
        button.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
            val button = findViewById<Button>(R.id.btn_sign_in)
            button.setOnClickListener {
                val intent = Intent(this, Profile::class.java)
                startActivity(intent)
            }
        }
    }
}
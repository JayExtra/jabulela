package com.example.jabulela

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class SignUp : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        auth = FirebaseAuth.getInstance()
        val button = findViewById<Button>(R.id.btn_sign_up)
        button.setOnClickListener {
            registerUser()
        }
    }
    private fun registerUser() {
        val email = findViewById<TextInputEditText>(R.id.et_email).text.toString()
        val password = findViewById<TextInputEditText>(R.id.et_password).text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    auth.createUserWithEmailAndPassword(email, password).await()
                    withContext(Dispatchers.Main) {
                        checkLoggedInState()
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@SignUp, e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun checkLoggedInState() {
        val view = findViewById<TextView>(R.id.tvLoggedIn)
        if (auth.currentUser == null) {
            view.text = "You are logged in "
        } else {
            view.text = "You are not logged in"
        }
    }
}

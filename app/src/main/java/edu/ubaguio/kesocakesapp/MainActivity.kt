package edu.ubaguio.kesocakesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login: Button = findViewById(R.id.btnLogin2)
        val register: Button = findViewById(R.id.btnSignUp4)


        login.setOnClickListener {
            val iLogin = Intent(this, Login::class.java)
            startActivity(iLogin)
        }

        register.setOnClickListener {
            val iRegister = Intent(this, Signup::class.java)
            startActivity(iRegister)
        }


    }
}
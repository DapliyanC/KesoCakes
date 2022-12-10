package edu.ubaguio.kesocakesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import edu.ubaguio.kesocakesapp.databinding.ActivitySignupBinding

class Signup : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding:ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth= Firebase.auth

        binding.btnSignUp2.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword3.text.toString()
            val passwordCon = binding.etConPassword.text.toString()
            //check empty fields
            if (email.isEmpty() || password.isEmpty() || passwordCon.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()

            }
            //check password match

            if (password != passwordCon) {
                Toast.makeText(this, "Password does not match", Toast.LENGTH_LONG).show()
            }

            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this, "New account created.", Toast.LENGTH_LONG).show()
                    finish()
                    //redirect user to login page
                    sendToMainActivity()
                }
                else{
                    Toast.makeText(this, "User account creation failed", Toast.LENGTH_LONG).show()
                }
            }
        }
    }private fun sendToMainActivity(){
        var sendToSignup = Intent(this@Signup, MainActivity::class.java)
        startActivity(sendToSignup)

    }
}
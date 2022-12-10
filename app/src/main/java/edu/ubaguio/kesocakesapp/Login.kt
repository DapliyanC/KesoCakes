package edu.ubaguio.kesocakesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import edu.ubaguio.kesocakesapp.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

         //Initialize Firebase Auth
        auth = Firebase.auth
        val register: Button = findViewById(R.id.btnSignUp4)
        val profile: Button = findViewById(R.id.btnProfile)
        binding.btnLogin2.setOnClickListener {
            //allow a valid user to login to the system
            val emailAdd = binding.etEmailAdd.text.toString()
            val userPassword = binding.etPassword2.text.toString()
            //authenticate registered user
            auth.signInWithEmailAndPassword(emailAdd, userPassword).addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this@Login, "Welcome $emailAdd", Toast.LENGTH_LONG).show()
                    val iUserProfile = Intent(this@Login, Profile::class.java)
                    startActivity(iUserProfile)
                } else if(emailAdd.isEmpty() && userPassword.isEmpty()){
                    Toast.makeText(this@Login, "All fields are required",Toast.LENGTH_LONG).show()
                }else{
                    //go to signup


                }
                }
            }


        register.setOnClickListener {
            val iRegister = Intent(this, Signup::class.java)
            startActivity(iRegister)
        }
        profile.setOnClickListener {
            val iProfile = Intent(this, Profile::class.java)
            startActivity(iProfile)
        }
        }
    private fun sendToSignUpActivity(){
        var sendToSignup = Intent(this@Login, Signup::class.java)
        startActivity(sendToSignup)

    }

}
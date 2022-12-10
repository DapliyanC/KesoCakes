package edu.ubaguio.kesocakesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Profile : AppCompatActivity() {
    private lateinit var  logout: Button
    private lateinit var number: EditText
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var saveSP: Button
    private lateinit var clearSP: Button
    private lateinit var viewSP: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // var saveSP: Button
        // var viewSP: Button
        // var clearSP: Button
        // var logout: Button
        // var register: Button

        var sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        //declare with 2 parameter -> filename and operating mode.
        val editor=sharedPref.edit()

        number = findViewById(R.id.etMobileNumber)
        lastName = findViewById(R.id.etLastName)
        firstName = findViewById(R.id.etFirstName)

        logout = findViewById(R.id.btnLogout2)


        saveSP=findViewById(R.id.btnSaveSP)
        saveSP.setOnClickListener {
            val userFN = firstName.text.toString()
            val userLN = lastName.text.toString()
            val userNumber = number.text.toString()

            editor.apply{
                putString("FirstName",userFN)
                putString("LastName",userLN)
                putString("Number",userNumber)
                apply()
            }
            Toast.makeText(this, "$userFN, $userLN, $userNumber successfully retrieved saved!",
                Toast.LENGTH_LONG).show()
        }
        //bind the clear shared pref button view
        clearSP=findViewById(R.id.btnClearSP)
        //clear the sharepref file
        clearSP.setOnClickListener {
            editor.clear()
            editor.apply()
            //Toast.makeText(this, "Successfully cleared saved!",
            //Toast.LENGTH_LONG).show()
        }
        //bind the view shared (read shared) with the view button
        viewSP=findViewById(R.id.btnViewSP)
        viewSP.setOnClickListener {
            firstName.setText("")
            lastName.setText("")
            number.setText("")


            firstName.setText(sharedPref.getString("FirstName", ""))
            lastName.setText(sharedPref.getString("LastName", ""))
            number.setText(sharedPref.getString("Number", ""))

        }


        logout.setOnClickListener {
            val iLogout = Intent(this, MainActivity::class.java)
            startActivity(iLogout)
        }

    }
}
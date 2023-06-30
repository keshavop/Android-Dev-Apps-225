package com.example.activity_shared_preference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var password : TextView
    lateinit var mobile : TextView
    lateinit var name : TextView
    lateinit var emailId : TextView
    lateinit var save : Button
    lateinit var clear : Button
    lateinit var fetch : Button
    lateinit var sharedPreferences: SharedPreferences
    val Name = "nameKey"
    val Email = "emailKey"
    val myfile = "myprefile"
    val Password = "passwordKey"
    val Mobile = "mobileKey"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.etName)
        emailId = findViewById(R.id.etEmail)
        save = findViewById(R.id.btnsave)
        fetch = findViewById(R.id.btnfetch)
        clear = findViewById(R.id.btnclear)

        password = findViewById(R.id.etPassword)
        mobile = findViewById(R.id.etMobile)

        sharedPreferences = getSharedPreferences(myfile,Context.MODE_PRIVATE)
        clear.setOnClickListener{
            name.text = ""
            emailId.text = ""
        }
        fetch.setOnClickListener{
            sharedPreferences = getSharedPreferences(myfile,Context.MODE_PRIVATE)
            name.text = sharedPreferences.getString(Name,"")
            emailId.text = sharedPreferences.getString(Email,"")
        }
    }
    fun save(v:View){
        val n = name.text.toString()
        val e = emailId.text.toString()
        val editor = sharedPreferences.edit()
        editor.putString(Name,n)
        editor.putString(Email,e)
        editor.putString(Password,e)
        editor.putString(Mobile,e)
        editor.apply()
    }
}
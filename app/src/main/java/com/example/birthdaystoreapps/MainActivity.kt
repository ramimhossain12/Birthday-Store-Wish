package com.example.birthdaystoreapps

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var e1: EditText? = null
    var e2: EditText? = null
    var b1: Button? = null
    var b2: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        e1 = findViewById<View>(R.id.name) as EditText
        e2 = findViewById<View>(R.id.bday) as EditText
        b1 = findViewById<View>(R.id.save) as Button
        b2 = findViewById<View>(R.id.show) as Button
        val mf = MyDBFunction(applicationContext)
        b1!!.setOnClickListener {
            val _name = e1!!.text.toString()
            val _bday = e2!!.text.toString()
            val dt = DataTemp(_name, _bday)
            mf.addingDataToTable(dt)
            Toast.makeText(applicationContext, "Data added successfully!", Toast.LENGTH_LONG).show()
        }
        b2!!.setOnClickListener { startActivity(Intent(applicationContext, Birthdaystore::class.java)) }
    }
}
package com.example.birthdaystoreapps

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
    var b3: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        e1 = findViewById<View>(R.id.name) as EditText
        e2 = findViewById<View>(R.id.bday) as EditText
        b1 = findViewById<View>(R.id.save) as Button
        b2 = findViewById<View>(R.id.show) as Button
        b3 = findViewById<View>(R.id.wishID) as Button


        val mf = MyDBFunction(applicationContext)
        b1!!.setOnClickListener {
            val _name = e1!!.text.toString()
            val _bday = e2!!.text.toString()
            val dt = DataTemp(_name, _bday)
            mf.addingDataToTable(dt)
            Toast.makeText(applicationContext, "Data added successfully!", Toast.LENGTH_LONG).show()
        }
        b2!!.setOnClickListener { startActivity(Intent(applicationContext, Birthdaystore::class.java)) }

        b3!!.setOnClickListener { startActivity(Intent(applicationContext, WishActivity::class.java)) }

    }


    //menu item find

    //menu item find
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //menu item selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (item.itemId == R.id.shareID) {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/type"
            val subject = "Note_Book app"
            val body = "This app  is very useful .\n com.example.notepad"
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, body)
            startActivity(Intent.createChooser(intent, "share with"))
        } else if (item.itemId == R.id.feedbackID) {
            val intent = Intent(applicationContext, FeadbackActivity::class.java)
            startActivity(intent)
        } else if (id == R.id.aboutId) {
            val intent = Intent(this, about::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
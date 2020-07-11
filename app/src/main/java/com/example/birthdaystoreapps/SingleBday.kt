package com.example.birthdaystoreapps

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SingleBday : AppCompatActivity() {
    var e: EditText? = null
    var b: Button? = null
    var d: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_bday)
        e = findViewById<View>(R.id.edittext) as EditText
        b = findViewById<View>(R.id.updatedatabase) as Button
        d = findViewById<View>(R.id.delete_data) as Button
        val rec_pos = intent.getIntExtra("MyKEY", 999)
        val obj = MyDBFunction(applicationContext)
        e!!.setText(obj.fetch_day(rec_pos + 1))
        e!!.setSelection(e!!.text.length)
        b!!.setOnClickListener {
            obj.update_birthday(rec_pos + 1, e!!.text.toString())
            Toast.makeText(this@SingleBday, "Updated Successfully!", Toast.LENGTH_SHORT).show()
        }
        d!!.setOnClickListener {
            obj.delete_bday(obj.fetch_day(rec_pos + 1))
            Toast.makeText(applicationContext, "Deleted Successfully!", Toast.LENGTH_SHORT).show()
        }
    }
}
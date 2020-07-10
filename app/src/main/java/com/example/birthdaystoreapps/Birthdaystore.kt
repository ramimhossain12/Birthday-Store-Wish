package com.example.birthdaystoreapps

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Birthdaystore : AppCompatActivity() {
    var lv: ListView? = null
    lateinit var data: Array<String?>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthdaystore)
        lv = findViewById<View>(R.id.myfriendbday) as ListView
        val mf = MyDBFunction(applicationContext)
        data = mf.my_data()
        lv!!.adapter = ArrayAdapter<Any?>(applicationContext, R.layout.lview, R.id.mytext, data)
        lv!!.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            val i = Intent(applicationContext, SingleBday::class.java)
            i.putExtra("MyKEY", position)
            startActivity(i)
        }
    }
}
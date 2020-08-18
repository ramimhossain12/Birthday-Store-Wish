package com.example.birthdaystoreapps


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.RatingBar.OnRatingBarChangeListener
import androidx.appcompat.app.AppCompatActivity

class FeadbackActivity : AppCompatActivity(), View.OnClickListener {
    private var sendButton: Button? = null
    private var clearButton: Button? = null
    private var nameeditText: EditText? = null
    private var massegeEditText: EditText? = null
    private var ratingBar: RatingBar? = null
    private var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_feadback)
        sendButton = findViewById(R.id.sendButtonID)
        clearButton = findViewById(R.id.clearButtonID)
        nameeditText = findViewById(R.id.nameEditTextID)
        massegeEditText = findViewById(R.id.massegeEditTextID)
        ratingBar = findViewById(R.id.rattingbarID)
        textView = findViewById(R.id.textViewIDI)
        ratingBar?.setOnRatingBarChangeListener(OnRatingBarChangeListener { ratingBar, rating, fromUser -> textView?.setText("Value :" + ratingBar.progress) })
        sendButton?.setOnClickListener(this)
        clearButton?.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        try {
            val name = nameeditText!!.text.toString()
            val massege = massegeEditText!!.text.toString()
            if (view.id == R.id.sendButtonID) {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/email"
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("ramimhossain6242@gmail.com"))
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from App")
                intent.putExtra(Intent.EXTRA_TEXT, "Name :$name\n Message :$massege")
                startActivity(Intent.createChooser(intent, "Feedback with"))
            } else if (view.id == R.id.clearButtonID) {
                nameeditText!!.setText("")
                massegeEditText!!.setText("")
            }
        } catch (e: Exception) {
            Toast.makeText(applicationContext, "Exception :$e", Toast.LENGTH_SHORT).show()
        }
    }
}
package com.example.kprzystalski.myapplication.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import com.example.kprzystalski.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var myText = editText as EditText
            val intent = GalleryActivity.newIntent(this)
            intent.putExtra("USER_NAME", myText.text.toString())
            startActivity(intent)
        }
    }

}

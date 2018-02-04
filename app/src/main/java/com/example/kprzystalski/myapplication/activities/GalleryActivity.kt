package com.example.kprzystalski.myapplication.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kprzystalski.myapplication.R
import com.example.kprzystalski.myapplication.adapters.InstaAdapter
import com.example.kprzystalski.myapplication.libraries.Instagram
import kotlinx.android.synthetic.main.activity_gallery.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.runBlocking

class GalleryActivity : AppCompatActivity() {
    var adapter: InstaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        var images = ArrayList<String>()
        runBlocking(CommonPool){
            images = Instagram().getImagesList(intent.getStringExtra("USER_NAME"))!!
        }

        imageGrid.adapter = InstaAdapter(this, images)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    companion object {

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, GalleryActivity::class.java)
            return intent
        }
    }

}
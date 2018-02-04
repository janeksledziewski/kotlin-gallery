package com.example.kprzystalski.myapplication.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.kprzystalski.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.img_entry.view.*

class InstaAdapter(context: Context, private var images: ArrayList<String>) : BaseAdapter() {

    var context: Context? = context

    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(position: Int): Any {
        return images[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val img = this.images[position]

        val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val imgView = inflator.inflate(R.layout.img_entry, null)
        Picasso.with(context).load(img).into(imgView.image)

        return imgView
    }

}

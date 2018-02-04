package com.example.kprzystalski.myapplication.libraries

import com.github.kittinunf.fuel.httpGet

class Instagram{

    fun getImagesList(usr: String): ArrayList<String>? {
        val imagesList:ArrayList<String>?
        val URL = "https://www.instagram.com/$usr/?__a=1"

        val (request, response, result) = URL.httpGet().responseObject(Insta.InstaDeserializer())
        val (user, err) = result
            imagesList = user

        return imagesList
    }
}
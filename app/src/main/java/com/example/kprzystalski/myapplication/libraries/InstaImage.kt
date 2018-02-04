package com.example.kprzystalski.myapplication.libraries

import com.beust.klaxon.Json
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.JsonParser

/**
 * Created by kprzystalski on 14/01/2018.
 */

class Insta {
     class InstaDeserializer : ResponseDeserializable<ArrayList<String>> {
          override fun deserialize(content: String): ArrayList<String> {
               var imageUrls = ArrayList<String>()
               var json = (JsonParser().parse(content))
               var mediaList = json.asJsonObject.get("user").asJsonObject.get("media").asJsonObject.get("nodes").asJsonArray
               println(mediaList.toString())

               for (media in mediaList) {
                    imageUrls.add(media.asJsonObject.get("thumbnail_src").asString)
               }
               return imageUrls
          }
     }
}
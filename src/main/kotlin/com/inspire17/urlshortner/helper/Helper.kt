package com.inspire17.urlshortner.helper

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.net.MalformedURLException
import java.net.URL

@Component
class Helper {

    fun isValidUrl(url: String): Boolean {
        return try {
            val parsedUrl = URL(url)
            parsedUrl.protocol == "http" || parsedUrl.protocol == "https"
        } catch (e: MalformedURLException) {
            false
        }

    }

    fun respondWithMessage(status: Int, message:String): ResponseEntity<String>{
        return ResponseEntity.status(status).body(message)
    }
}
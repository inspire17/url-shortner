package com.inspire17.urlshortner.controllers

import com.inspire17.urlshortner.helper.Helper
import com.inspire17.urlshortner.service.UrlShortenerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UrlRestController(private val urlShortenerService: UrlShortenerService, private val helper: Helper) {

    @GetMapping("/{shortCode:^(?!shorten$).*$}")
    fun redirectToOriginalUrl(@PathVariable shortCode: String): ResponseEntity<String> {
        val originalUrl = urlShortenerService.getOriginalUrl(shortCode)
        return if (originalUrl == "URL not found") {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.status(302)
                .header("Location", originalUrl)
                .build()
        }
    }


    @GetMapping("/short")
    fun createShortUrl(@RequestParam(required = true) url: String): ResponseEntity<String> {

        if (url.isBlank()) {
           return helper.respondWithMessage(200, "Blank. Enter a URL before proceeding")
        }

        if (url.length < 10) {
            helper.respondWithMessage(200,  "Let's not trim this URL further")
        }

        if (!helper.isValidUrl(url)) {
           helper.respondWithMessage(200, "Invalid URL format. Please enter a valid URL.")
        }

        return  helper.respondWithMessage(200, urlShortenerService.shortenUrl(url))
    }

}
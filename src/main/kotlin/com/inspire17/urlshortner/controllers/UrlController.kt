package com.inspire17.urlshortner.controllers

import com.inspire17.urlshortner.helper.Helper
import com.inspire17.urlshortner.service.UrlShortenerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
class UrlController (private val urlShortenerService: UrlShortenerService, private val helper:Helper) {

    @GetMapping("/")
    fun home(): String {
        return "home"
    }

    @PostMapping("/shorten")
    fun shortenUrl(@RequestParam url: String, model: Model): String {

        if (url.isBlank()) {
            model.addAttribute("shorturl", "Blank. Enter a URL before proceeding")
            return "home"
        }

        if (url.length < 10) {
            model.addAttribute("shorturl", "Let's not trim this URL further")
            return "home"
        }

        if (!helper.isValidUrl(url)) {
            model.addAttribute("shorturl", "Invalid URL format. Please enter a valid URL.")
            return "home"
        }

        val shortUrl = urlShortenerService.shortenUrl(url)
        model.addAttribute("shorturl", shortUrl)
        return "home"
    }

    @PostMapping("/extended")
    fun extendedUrl(@RequestParam shortUrl: String, model: Model): String {
        val extendedUrl = urlShortenerService.getOriginalUrl(shortUrl)
        model.addAttribute("originalurl", extendedUrl)
        return "home"
    }

}
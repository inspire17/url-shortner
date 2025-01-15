package com.inspire17.urlshortner.service

import com.inspire17.urlshortner.entity.URLMap
import com.inspire17.urlshortner.`interface`.UrlRepo
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class UrlShortenerService(private val urlRepo: UrlRepo) {

    @Value("\${spring.server.url}")
    private lateinit var baseUrl: String

    fun shortenUrl(originalUrl: String): String {
        val shortCode = generateShortCode(originalUrl)
        val map = URLMap(shortcode = shortCode, url = originalUrl)
        urlRepo.save(map)
        return baseUrl + shortCode
    }

    fun getOriginalUrl(shortUrl: String): String {
        val shortCode = shortUrl.removePrefix(baseUrl)
        return urlRepo.findByShortcode(shortCode)?.url ?: "URL not found"
    }

    private fun generateShortCode(originalUrl: String): String {
        val chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        return (1..7)
            .map { chars.random() }
            .joinToString("").plus("-" + originalUrl.length)
    }
}
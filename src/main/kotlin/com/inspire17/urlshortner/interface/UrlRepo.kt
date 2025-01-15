package com.inspire17.urlshortner.`interface`

import com.inspire17.urlshortner.entity.URLMap
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlRepo : JpaRepository<URLMap, Long> {
    fun findByShortcode(shortcode: String): URLMap?
}
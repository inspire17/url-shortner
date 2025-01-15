package com.inspire17.urlshortner.entity

import jakarta.persistence.*

@Entity
@Table(name = "urlmap")
data class URLMap(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val shortcode: String = "",

    @Column(nullable = false)
    val url: String = ""
)
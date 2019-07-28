package com.example.ainfo.model

data class Top(
    val end_date: String,
    val episodes: Int,
    val image_url: String,
    val mal_id: Int,
    val members: Int,
    val rank: Int,
    val score: Double,
    val start_date: String,
    val title: String,
    val type: String,
    val url: String
)
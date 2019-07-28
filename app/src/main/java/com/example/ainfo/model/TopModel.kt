package com.example.ainfo.model

data class TopModel(
    val request_cache_expiry: Int,
    val request_cached: Boolean,
    val request_hash: String,
    val top: List<Top>
)
package com.pew.monkeynews.model

data class NewsSource(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
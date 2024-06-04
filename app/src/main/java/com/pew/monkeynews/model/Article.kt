package com.pew.monkeynews.model

import androidx.compose.runtime.Immutable


data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    var title: String,
    val url: String,
    val urlToImage: String
)
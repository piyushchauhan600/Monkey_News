package com.pew.monkeynews.network

import androidx.compose.foundation.pager.PageSize
import com.pew.monkeynews.model.NewsSource
import com.pew.monkeynews.utils.ApiKeyProvider
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

interface NewsApi {

    @GET("/v2/top-headlines")
    suspend fun getNews(@Query("country") country:String, @Query("pageSize") pageSize: Int): Response<NewsSource>
}
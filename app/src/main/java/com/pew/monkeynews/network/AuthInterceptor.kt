package com.pew.monkeynews.network

import com.pew.monkeynews.utils.ApiKeyProvider
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(): Interceptor {

    val apiKeyProvider = ApiKeyProvider()
    val token = apiKeyProvider.getApi()


    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("Authorization","Bearer $token")
        return chain.proceed(request.build())
    }
}
package com.pew.monkeynews.utils

import javax.inject.Inject
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
private fun Any.decode(getApi: () -> String, default: Base64.Default): Any {
   return getApi
}

class ApiKeyProvider{
    companion object {
        init {
            System.loadLibrary("keys")
        }
    }
    external fun getApi(): String
    @OptIn(ExperimentalEncodingApi::class)
    val getkey: String = Base64.decode({ getApi() },Base64.Default).toString()
}



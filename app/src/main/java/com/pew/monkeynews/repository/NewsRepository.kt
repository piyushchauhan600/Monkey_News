package com.pew.monkeynews.repository

import android.util.Log
import com.pew.monkeynews.data.DataOrException
import com.pew.monkeynews.model.NewsSource
import com.pew.monkeynews.network.NewsApi

class NewsRepository(private val newsApi: NewsApi) {
    private var dataOrException = DataOrException<NewsSource, Boolean, Exception>()

    suspend fun getAllNews(): DataOrException<NewsSource,Boolean,java.lang.Exception> {
        try {
            dataOrException.isloding = true
            dataOrException.data = newsApi.getNews("in").body()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.isloding = false
        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("Exc", "getAllNews : ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }
}
package com.pew.monkeynews.screens

import android.net.http.UrlRequest.Status
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pew.monkeynews.data.DataOrException
import com.pew.monkeynews.model.Article
import com.pew.monkeynews.model.NewsSource
import com.pew.monkeynews.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository): ViewModel() {
    val data: MutableState<DataOrException<NewsSource,Boolean,Exception>> =
        mutableStateOf(DataOrException(null,true,Exception("")))

    init {
        getAllNews()
    }
    private fun getAllNews() {
        viewModelScope.launch {
            data.value.isloding = true
            data.value = newsRepository.getAllNews()
            if (data.value.data.toString().isNotEmpty()) data.value.isloding = false

        }
    }


}
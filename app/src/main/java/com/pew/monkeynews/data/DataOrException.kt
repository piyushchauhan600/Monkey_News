package com.pew.monkeynews.data

data class DataOrException<T,Boolean,Exception>
    (
    var data: T? = null,
    var isloding: Boolean? = null,
    var e: Exception? = null,

    )
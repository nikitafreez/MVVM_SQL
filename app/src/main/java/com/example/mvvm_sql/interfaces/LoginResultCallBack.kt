package com.example.mvvm_sql.interfaces

interface LoginResultCallBack {
    fun onSuccess(message: String)
    fun onError(message: String)
}
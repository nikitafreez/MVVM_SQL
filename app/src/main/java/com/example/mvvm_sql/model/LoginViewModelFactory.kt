package com.example.mvvm_sql.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_sql.interfaces.LoginResultCallBack

class LoginViewModelFactory (private val listener:LoginResultCallBack) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }
}
package com.example.mvvm_sql.model

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvm_sql.interfaces.LoginResultCallBack

class LoginViewModel (private val listener: LoginResultCallBack): ViewModel() {
    private val user:User = User("", "")

    val emailTextWatcher: TextWatcher
    get() = object:TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            user.setEmail(s.toString())
        }
    }

    val passwordTextWatcher: TextWatcher
    get() = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            user.setPassword(s.toString())
        }
    }

    fun onLoginClicked(v: View) {
        if(user.isDataValid){
            listener.onSuccess("Успешно")
        }
        else{
            listener.onError("Ты лох")
        }
    }
}
package com.example.mvvm_sql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm_sql.databinding.ActivityMainBinding
import com.example.mvvm_sql.interfaces.LoginResultCallBack
import com.example.mvvm_sql.model.LoginViewModel
import com.example.mvvm_sql.model.LoginViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginResultCallBack {
    var usersDB: DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usersDB = DatabaseHelper(this@MainActivity)

        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProviders.of(this, LoginViewModelFactory(this))
            .get(LoginViewModel::class.java)

    }
    override fun onSuccess(message: String) {
        val email: String = login.text.toString()
        val password: String = password.text.toString()

        val insertData: Boolean = usersDB!!.addData(email, password)

        if (insertData == true) {
            Toast.makeText(this@MainActivity, "Пользователь добавлен", Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(this@MainActivity, "Ошибка. Всё плохо", Toast.LENGTH_LONG).show()
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
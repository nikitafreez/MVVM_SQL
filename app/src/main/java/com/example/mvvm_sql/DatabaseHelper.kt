package com.example.mvvm_sql

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "users.db", null, 1) {
    val TABLE_NAME = "Users"
    val COL2 = "EMAIL"
    val COL3 = "PASSWORD"

    private val DROP_USER_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"


    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " EMAIL TEXT, PASSWORD TEXT)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL(DROP_USER_TABLE)
        onCreate(db)
    }

    fun addData(email: String?, password: String?): Boolean {

        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL2, email)
        contentValues.put(COL3, password)
        val result = db.insert(TABLE_NAME, null, contentValues)
        return result != -1L
    }

    //fun findData(email: String?): Boolean {
    //    val db = this.writableDatabase
    //    val findUser = "SELECT PASSWORD FROM $TABLE_NAME WHERE EMAIL = $email"
    //    Cursor c = db.rawQuery(findUser)
    //}
}
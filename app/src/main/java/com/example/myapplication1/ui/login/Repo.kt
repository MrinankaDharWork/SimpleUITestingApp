package com.example.myapplication1.ui.login

import android.content.Context
import android.content.SharedPreferences




class Repo {
    fun saveInPref(context: Context, key: String?, value: Int) {
        val sharedPref: SharedPreferences = context.getSharedPreferences("String",android.content.Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putInt(key, value)
        editor.apply()
    }
    fun getFromPref(context: Context, key: String): String? {
        val sharedPref: SharedPreferences =
            context.getSharedPreferences("String", android.content.Context.MODE_PRIVATE)
        return sharedPref.getString(key, null)
    }
}



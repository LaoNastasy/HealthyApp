package com.example.healthyapp

import android.content.Context

class PreferenceUtils(ctx: Context) {

    private val reader = ctx.getSharedPreferences(APP_TAG, Context.MODE_PRIVATE)
    private val writer = reader.edit()

    fun saveString(string: String, tag: String) = writer.putString(tag, string).commit()
    fun saveBoolean(boolean: Boolean, tag: String) = writer.putBoolean(tag, boolean).commit()
    fun saveInt(int: Int, tag: String) = writer.putInt(tag, int).commit()

    fun getString(tag: String) = reader.getString(tag, "")
    fun getBoolean(tag: String) = reader.getBoolean(tag, false)
    fun getInt(tag: String) = reader.getInt(tag, -1)

    companion object {
        private const val APP_TAG = "HealthyApp"
    }
}
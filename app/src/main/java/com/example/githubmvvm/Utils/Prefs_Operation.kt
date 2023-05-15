package com.example.githubmvvm.Utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

object Prefs_Operation {
    private lateinit var prefs: SharedPreferences
    private const val MY_PREFS = "myPrefs"

    // user login key
    const val IS_USER_LOGGED_IN = "IsUserLoggedIn"
    fun init(context: Context) {
        prefs = context.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE)
    }

    fun writeString(key: String, prefValue: String) {
        val editor: SharedPreferences.Editor = prefs.edit()
        with(editor) {
            putString(key, prefValue).apply()
        }
    }

    fun writeInt(key: String, prefValue: Int) {
        val editor: SharedPreferences.Editor = prefs.edit()
        with(editor) {
            putInt(key, prefValue).apply()
        }
    }
    fun writeBoolean(key: String, prefValue: Boolean) {
        val editor: SharedPreferences.Editor = prefs.edit()
        with(editor) {
            putBoolean(key, prefValue).apply()
        }
    }

    fun readString(strKey: String, defaultValue: String): String? {
        return prefs.getString(strKey, defaultValue)
    }
    fun readBoolean(strKey: String, defaultValue: Boolean): Boolean {
        return prefs.getBoolean(strKey, defaultValue)
    }
    fun readInt(strKey: String, defaultValue: Int): Int? {
        return prefs.getInt(strKey, defaultValue)
    }

    // Get saved Model class
    fun <T> getModelPref(name: String, model: Class<T>): T {
        val value = prefs.getString(name, "")
        return Gson().fromJson(value, model) as T
    }

    // Saving Model class
    fun setModelPref(name: String, model: Any) {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()

        val gson = Gson().toJson(model)
        prefsEditor.putString(name, gson).apply()

//        val gson = Gson()
//        val favData = gson.toJson(body)
//        Log.d(LogCalls_Debug.TAG, "savePrefsForNextScreen: fav data"+favData)
//        SharedPrefs.writeString(LoginConstant.LOGIN_RESPONSE,favData)
    }

    /* Check for user login
    return true if user logged in else return false*/
    fun isUserLoggedIn(): Boolean {
        return prefs.getBoolean(IS_USER_LOGGED_IN, false)
    }

    fun clear() {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        prefsEditor.clear()
        prefsEditor.apply()
    }
}

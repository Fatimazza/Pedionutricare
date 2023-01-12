package xyz.codingwithza.pedionutricare.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

class StoreUserData(private val context: Context) {

    // to make sure there is only one instance
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userData")

        val USER_NAME_KEY = stringPreferencesKey("user_name")
        val USER_AGE_KEY = intPreferencesKey("user_age")
    }

    //save data into datastore

    suspend fun saveUserName(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME_KEY] = name
        }
    }

    suspend fun saveUserAge(age: Int) {
        context.dataStore.edit { preferences ->
            preferences[USER_AGE_KEY] = age
        }
    }
}

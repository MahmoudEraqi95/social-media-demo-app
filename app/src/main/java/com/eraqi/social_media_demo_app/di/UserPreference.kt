package com.eraqi.social_media_demo_app.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferences @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    val isLoggedIn: Flow<String> =
        dataStore.data.map { preferences ->
            preferences[LAST_SYNC] ?: false
        }


}

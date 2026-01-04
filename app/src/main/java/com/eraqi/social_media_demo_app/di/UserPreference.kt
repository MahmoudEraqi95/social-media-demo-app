package com.eraqi.social_media_demo_app.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.eraqi.social_media_demo_app.di.PreferenceKeys.LAST_SYNC
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class UserPreferences @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    val isLoggedIn: Flow<Boolean> =
        dataStore.data.map { preferences ->
            preferences[LAST_SYNC] ?: false
        }


}

package io.github.aag.core.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import io.github.aag.core.domain.models.UserProfile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PrefsStorageImpl(
    private val dataStore: DataStore<Preferences>
) : PrefsStorage {
    override suspend fun saveProfile(userProfile: UserProfile) {
        dataStore.edit { prefs ->
            prefs[PROFILE_KEY] = Json.encodeToString(userProfile)
        }
    }

    override fun getProfile(): Flow<UserProfile> =
        dataStore.data
            .mapNotNull { prefs ->
                prefs[PROFILE_KEY]
                    ?.let { profileJson ->
                        Json.decodeFromString(UserProfile.serializer(), profileJson)

                    }
            }

    companion object {
        private val PROFILE_KEY = stringPreferencesKey("user_profile")
    }
}

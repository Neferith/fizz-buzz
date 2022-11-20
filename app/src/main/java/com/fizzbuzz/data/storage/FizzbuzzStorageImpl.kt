package com.fizzbuzz.data.storage

import android.content.SharedPreferences
import com.fizzbuzz.model.FizzbuzzEntity
import com.google.gson.Gson

class FizzbuzzStorageImpl(

    private val defaultSharedPreferences: SharedPreferences,
    private val builder: Gson
) : FizzbuzzStorage {

    companion object {
        const val PREFERENCE_LAST_ENTITY = "preference.last.entity"
    }

    override fun saveEntity(entity: FizzbuzzEntity) {
        defaultSharedPreferences.edit().putString(PREFERENCE_LAST_ENTITY, builder.toJson(entity))
            .apply()
    }

    override fun loadEntity(): FizzbuzzEntity {
        val json = defaultSharedPreferences.getString(PREFERENCE_LAST_ENTITY, null)
        if (json != null) {
            return builder.fromJson(json, FizzbuzzEntity::class.java)
        }
        return FizzbuzzEntity()
    }
}
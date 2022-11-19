package com.fizzbuzz.data.storage

import com.fizzbuzz.model.FizzbuzzEntity

interface FizzbuzzStorage {
    fun saveEntity(entity: FizzbuzzEntity)
    fun loadEntity(): FizzbuzzEntity
}
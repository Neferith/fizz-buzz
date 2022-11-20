package com.fizzbuzz.data.repository

import com.fizzbuzz.data.storage.FizzbuzzStorage
import com.fizzbuzz.model.FizzbuzzEntity
import javax.inject.Inject

class FizzbuzzRepository @Inject
constructor(private val fizzbuzzStorage: FizzbuzzStorage) {

    fun getCurrentFizzBuzzEntity(): FizzbuzzEntity {
        return fizzbuzzStorage.loadEntity()
    }

    fun setCurrentFizzBuzzEntity(entity: FizzbuzzEntity) {
        return fizzbuzzStorage.saveEntity(entity)
    }
}
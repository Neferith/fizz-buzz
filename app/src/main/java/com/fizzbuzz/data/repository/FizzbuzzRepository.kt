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

    fun generateFitBuzzString(index: Int, item: FizzbuzzEntity): String {
        var str = ""
        // All multiples of int1 are replaced by str1
        if (index % item.int1 == 0) {
            str += item.str1
        }
        // All multiples of int2 are replaced by str2
        if (index % item.int2 == 0) {
            str += item.str2
        }
        return str.ifEmpty { index.toString() }
    }
}
package com.fizzbuzz.domain

import com.fizzbuzz.data.repository.FizzbuzzRepository
import com.fizzbuzz.model.FizzbuzzEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFizzbuzzResultUseCase @Inject
constructor(private val fizzBuzzRepository: FizzbuzzRepository) {

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

    operator fun invoke(): Flow<List<String>> = flow {

        val entity = fizzBuzzRepository.getCurrentFizzBuzzEntity()
        val result: ArrayList<String> = ArrayList()
        for (i in 0..entity.limit) {
            // @TODO : Out Of Memory. Bab :)
            result.add(generateFitBuzzString(i, entity))
        }
        emit(result)
    }

}
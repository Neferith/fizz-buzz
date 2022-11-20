package com.fizzbuzz.domain

import com.fizzbuzz.model.FizzbuzzEntity
import javax.inject.Inject

@Deprecated("Use the new class GetFizzbuzzResultUseCase")
class GetFizzbuzzStringUseCase @Inject constructor() {

    private fun generateFitBuzzString(index: Int, item: FizzbuzzEntity): String {
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

    operator fun invoke(index: Int, entity: FizzbuzzEntity): String {
        return generateFitBuzzString(index, entity)
    }
}
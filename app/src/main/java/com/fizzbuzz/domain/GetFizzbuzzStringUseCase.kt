package com.fizzbuzz.domain

import com.fizzbuzz.model.FizzbuzzEntity
import javax.inject.Inject

class GetFizzbuzzStringUseCase @Inject
constructor() {

    /**
     * Generate fizzbuzz string of an index
     * @param index the index position in the list.
     * @property item the fizzbuzz parameters.
     * @return The fizzbuzz string
     */
    fun invoke(index: Long, item: FizzbuzzEntity): String {
        var str = ""
        // All multiples of int1 are replaced by str1
        if (index % item.int1 == 0.toLong()) {
            str += item.str1
        }
        // All multiples of int2 are replaced by str2
        if (index % item.int2 == 0.toLong()) {
            str += item.str2
        }
        return str.ifEmpty { index.toString() }
    }
}
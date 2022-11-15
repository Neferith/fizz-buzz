package com.fizzbuzz.utils

import com.fizzbuzz.model.FizzbuzzEntity

/**
 * Class fizzbuzz utils
 */
object FizzBuzzUtils {

    fun defaultFitBuzz(): FizzbuzzEntity {
        return FizzbuzzEntity(3, 5, Int.MAX_VALUE, "fizz", "buzz")
    }

    /**
     * Generate fizzbuzz string of an index
     * @param index the index position in the list.
     * @property item the fizzbuzz parameters.
     * @return The fizzbuzz string
     */
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
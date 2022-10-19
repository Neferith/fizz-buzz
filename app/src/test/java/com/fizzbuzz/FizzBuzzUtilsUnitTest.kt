package com.fizzbuzz

import com.fizzbuzz.utils.FizzBuzzUtils
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FizzBuzzUtilsUnitTest {
    @Test
    fun addition_isCorrect() {

        assertEquals("1", FizzBuzzUtils.generateFitBuzzString(1,FizzBuzzUtils.defaultFitBuzz()))
        assertEquals("2", FizzBuzzUtils.generateFitBuzzString(2,FizzBuzzUtils.defaultFitBuzz()))
        assertEquals("fizz", FizzBuzzUtils.generateFitBuzzString(3,FizzBuzzUtils.defaultFitBuzz()))
        assertNotEquals("3", FizzBuzzUtils.generateFitBuzzString(3,FizzBuzzUtils.defaultFitBuzz()))
    }
}
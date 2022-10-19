package com.fizzbuzz

import com.fizzbuzz.model.FizzbuzzMeta
import com.fizzbuzz.utils.FizzBuzzUtils
import org.junit.Test

import org.junit.Assert.*

/**
 * Test class FizzBuzzUtils.
 *
 */
class FizzBuzzUtilsUnitTest {
    @Test
    fun addition_isCorrect() {

        assertEquals("1", FizzBuzzUtils.generateFitBuzzString(1,FizzBuzzUtils.defaultFitBuzz()))
        assertEquals("2", FizzBuzzUtils.generateFitBuzzString(2,FizzBuzzUtils.defaultFitBuzz()))
        assertEquals("fizz", FizzBuzzUtils.generateFitBuzzString(3,FizzBuzzUtils.defaultFitBuzz()))
        assertNotEquals("3", FizzBuzzUtils.generateFitBuzzString(3,FizzBuzzUtils.defaultFitBuzz()))
        assertEquals("4", FizzBuzzUtils.generateFitBuzzString(4,FizzBuzzUtils.defaultFitBuzz()))
        assertEquals("buzz", FizzBuzzUtils.generateFitBuzzString(10,FizzBuzzUtils.defaultFitBuzz()))
        assertEquals("fizz", FizzBuzzUtils.generateFitBuzzString(6,FizzBuzzUtils.defaultFitBuzz()))
        assertEquals("fizzbuzz", FizzBuzzUtils.generateFitBuzzString(15,FizzBuzzUtils.defaultFitBuzz()))
        assertEquals("fizz", FizzBuzzUtils.generateFitBuzzString(27,FizzBuzzUtils.defaultFitBuzz()))
        assertEquals("fizzbuzz", FizzBuzzUtils.generateFitBuzzString(30,FizzBuzzUtils.defaultFitBuzz()))
        assertEquals("buzz", FizzBuzzUtils.generateFitBuzzString(35,FizzBuzzUtils.defaultFitBuzz()))
        assertEquals("fizzbuzz", FizzBuzzUtils.generateFitBuzzString(45,FizzBuzzUtils.defaultFitBuzz()))

       val darkVardor = FizzbuzzMeta(2,2,300,"dark"," vador")

        assertEquals("1", FizzBuzzUtils.generateFitBuzzString(1,darkVardor))
        assertEquals("dark vador", FizzBuzzUtils.generateFitBuzzString(2,darkVardor))
        assertEquals("3", FizzBuzzUtils.generateFitBuzzString(3,darkVardor))
        assertEquals("dark vador", FizzBuzzUtils.generateFitBuzzString(4,darkVardor))


        val testmeta = FizzbuzzMeta(2,3,300,"test","meta")

        assertEquals("1",
            FizzBuzzUtils.generateFitBuzzString(1,testmeta))
        assertEquals("test",
            FizzBuzzUtils.generateFitBuzzString(2,testmeta))
        assertEquals("meta",
            FizzBuzzUtils.generateFitBuzzString(3,testmeta))
        assertEquals("test", FizzBuzzUtils.generateFitBuzzString(4,testmeta))
        assertEquals("5", FizzBuzzUtils.generateFitBuzzString(5,testmeta))
        assertEquals("testmeta", FizzBuzzUtils.generateFitBuzzString(6,testmeta))
        assertEquals("7", FizzBuzzUtils.generateFitBuzzString(7,testmeta))
        assertEquals("test", FizzBuzzUtils.generateFitBuzzString(8,testmeta))
        assertEquals("meta", FizzBuzzUtils.generateFitBuzzString(9,testmeta))
        assertEquals("test", FizzBuzzUtils.generateFitBuzzString(10,testmeta))
        assertEquals("11", FizzBuzzUtils.generateFitBuzzString(11,testmeta))
        assertEquals("testmeta", FizzBuzzUtils.generateFitBuzzString(12,testmeta))

    }
}
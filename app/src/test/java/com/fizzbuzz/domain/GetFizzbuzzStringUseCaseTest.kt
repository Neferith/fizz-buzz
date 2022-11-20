package com.fizzbuzz.domain

import com.fizzbuzz.model.FizzbuzzEntity
import com.fizzbuzz.utils.FizzBuzzUtils
import io.mockk.*
import org.junit.Before
import org.junit.Test

class GetFizzbuzzStringUseCaseTest {

    companion object {
        private const val FIZZBUZZ_STRING: String = "FIZZBUZZ"

    }

    private var index: Int = 1
    private var entity: FizzbuzzEntity = mockk()

    private val useCase = GetFizzbuzzStringUseCase()

    @Before
    fun setUp() {
        mockkObject(FizzBuzzUtils)
        every { FizzBuzzUtils.generateFitBuzzString(index, entity) }.returns(FIZZBUZZ_STRING)
    }

    @Test
    fun `cache case`() {
        // Given
        //  val entity = FizzBuzzEntity(limit = 10)

        // When
        // val result = useCase.invoke(entity)

        //  val expectedResult = listOf(1, 2, "fizz", 4, "buzz", "fizz", 7, 8, "fizz", "buzz")

        // Then
        //  assertEquals()
    }
}
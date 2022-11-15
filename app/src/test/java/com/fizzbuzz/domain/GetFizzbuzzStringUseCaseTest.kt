package com.fizzbuzz.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
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

    private var useCase = GetFizzbuzzStringUseCase()

    @Before
    fun setUp() {
        mockkObject(FizzBuzzUtils)
        every { FizzBuzzUtils.generateFitBuzzString(index, entity) }.returns(FIZZBUZZ_STRING)
    }

    @Test
    fun `cache case`() {
        // When
        val result = useCase.invoke(index, entity)
        verify(exactly = 1) { FizzBuzzUtils.generateFitBuzzString(any(), any()) }

        // Then
        assertThat(result).isEqualTo(FIZZBUZZ_STRING)
    }
}
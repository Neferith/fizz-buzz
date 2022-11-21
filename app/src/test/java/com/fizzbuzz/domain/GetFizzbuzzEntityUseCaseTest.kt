package com.fizzbuzz.domain

import com.fizzbuzz.data.repository.FizzbuzzRepository
import com.fizzbuzz.model.FizzbuzzEntity
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetFizzbuzzEntityUseCaseTest {

    companion object {
        private val DEFAULT_ENTITY: FizzbuzzEntity = FizzbuzzEntity()

    }

    private var repository: FizzbuzzRepository = mockk()


    private val useCase = GetFizzbuzzEntityUseCase(repository)

    @Before
    fun setUp() {
        every { repository.loadCurrentFizzBuzzEntity() }.returns(DEFAULT_ENTITY)
    }

    @Test
    fun `When GetFizzbuzzEntityUseCase is invoked, Then returns current fizzbuzz entity`() {
        // Given
        //  nothing

        // When
        val result = useCase.invoke()

        val expectedResult = DEFAULT_ENTITY

        // Then
        verify(exactly = 1) { repository.loadCurrentFizzBuzzEntity() }
        assertEquals(result, expectedResult)

    }
}
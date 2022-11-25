package com.fizzbuzz.domain

import com.fizzbuzz.data.repository.FizzbuzzRepository
import com.fizzbuzz.model.FizzbuzzEntity
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class SaveFizzbuzzEntityUseCaseTest {

    private var repository: FizzbuzzRepository = mockk()


    private val useCase = SaveFizzbuzzEntityUseCase(repository)

    @Before
    fun setUp() {
        justRun { repository.saveCurrentFizzBuzzEntity(any()) }
    }

    @Test
    fun `When SaveFizzbuzzEntityUseCase is invoked, Then returns current fizzbuzz entity`() {
        // Given
        val entity = FizzbuzzEntity(5, 7, 1000, "buzz", "fizz")

        // When
        useCase.invoke(entity)

        // Then
        verify(exactly = 1) { repository.saveCurrentFizzBuzzEntity(entity) }

    }
}
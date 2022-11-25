package com.fizzbuzz.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.fizzbuzz.data.repository.FizzbuzzPagingSource
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetFizzbuzzPagerUseCaseTest {

    private var pager: Pager<Int, String> = Pager(PagingConfig(pageSize = 100)) {
        FizzbuzzPagingSource(mockk(), mockk())
    }

    private val useCase = GetFizzbuzzPagerUseCase(pager)

    @Test
    fun `When GetFizzbuzzPagerUseCase is invoked, Then return pager flow`() = runTest {
        // Given
        //  nothing

        // When
        val sentencesNumber = useCase.invoke()

        // Then
        Assert.assertEquals(sentencesNumber, pager.flow)
    }
}
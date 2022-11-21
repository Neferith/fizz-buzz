package com.fizzbuzz.ui.model.main

import com.fizzbuzz.domain.GetFizzbuzzEntityUseCase
import com.fizzbuzz.domain.SaveFizzbuzzEntityUseCase
import com.fizzbuzz.model.FizzbuzzEntity
import com.fizzbuzz.ui.main.FormMainViewModel
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class FormMainViewModelTest {

    companion object {
        private const val INT_1_GOOD_STR = "5"
        private const val INT_1_RESULT = 5
        private const val INT_1_BAD_STR = "33A"
        private const val INT_1_TOO_LONG_NUMBER = "33545645646464646464646"


        private const val INT_2_GOOD_STR = "6"
        private const val INT_2_RESULT = 6
        private const val INT_2_BAD_STR = "66B"
        private const val INT_2_TOO_LONG_NUMBER = "53545645646464646464646"


        private const val LIMIT_GOOD_STR = "100"
        private const val LIMIT_RESULT = 100
        private const val LIMIT_BAD_STR = "100B"
        private const val LIMIT_TOO_LONG_NUMBER = "535456456465464646464646"

        private const val STRING_1_VALUE = "BUZZ"
        private const val STRING_2_VALUE = "FIZZ"


        private val CURRENT_FIZZBUZZ_ENTITY: FizzbuzzEntity = FizzbuzzEntity()
    }

    private val saveFizzbuzzEntityUseCase: SaveFizzbuzzEntityUseCase = mockk()
    private val getFizzbuzzEntityUseCase: GetFizzbuzzEntityUseCase = mockk()


    private lateinit var mainViewModel: FormMainViewModel

    @Before
    fun setUp() {
        every { getFizzbuzzEntityUseCase.invoke() }.returns(CURRENT_FIZZBUZZ_ENTITY)
        justRun { saveFizzbuzzEntityUseCase.invoke(CURRENT_FIZZBUZZ_ENTITY) }
        mainViewModel = FormMainViewModel(
            saveFizzbuzzEntityUseCase,
            getFizzbuzzEntityUseCase
        )

    }

    @Test
    fun `When getCurrentItem then return FizzbuzzEntity`() {
        //Given
        //Nothing

        // When
        val result = mainViewModel.getCurrentItem()
        val expectedResult = CURRENT_FIZZBUZZ_ENTITY

        // Then
        Assert.assertEquals(result, expectedResult)
    }

    @Test
    fun `Given string number When mainViewModel call updateInt1() Then fizzbuzz entity updated`() {
        // Given
        val int1 = INT_1_GOOD_STR

        // When
        mainViewModel.updateInt1(int1)
        val expectedResult = INT_1_RESULT
        val currentInt1 = mainViewModel.getCurrentItem().int1

        // Then
        Assert.assertEquals(currentInt1, expectedResult)
    }


    @Test
    fun `Given bad string When mainViewModel call updateInt1() Then throw exception`() {
        // Given
        val int1 = INT_1_BAD_STR

        // When
        Assert.assertThrows(com.fizzbuzz.model.FormException::class.java)
        {
            mainViewModel.updateInt1(int1)
        }

    }

    @Test
    fun `Given too big number When mainViewModel call updateInt1() Then throw exception`() {
        // Given
        val int1 = INT_1_TOO_LONG_NUMBER

        // When
        Assert.assertThrows(
            com.fizzbuzz.model.FormException::class.java
        ) {
            mainViewModel.updateInt1(int1)
        }

    }

    @Test
    fun `Given string number When mainViewModel call updateInt2() Then fizzbuzz entity updated`() {
        // Given
        val int2 = INT_2_GOOD_STR

        // When
        mainViewModel.updateInt2(int2)
        val expectedResult = INT_2_RESULT
        val currentInt2 = mainViewModel.getCurrentItem().int2

        // Then
        Assert.assertEquals(currentInt2, expectedResult)
    }


    @Test
    fun `Given bad string When mainViewModel call updateInt2() Then throw exception`() {
        // Given
        val int2 = INT_2_BAD_STR

        // When
        Assert.assertThrows(com.fizzbuzz.model.FormException::class.java)
        {
            mainViewModel.updateInt2(int2)
        }

    }

    @Test
    fun `Given too big number When mainViewModel call updateInt2() Then throw exception`() {
        // Given
        val int2 = INT_2_TOO_LONG_NUMBER

        // When
        Assert.assertThrows(
            com.fizzbuzz.model.FormException::class.java
        ) {
            mainViewModel.updateInt2(int2)
        }

    }

    @Test
    fun `Given string number When mainViewModel call updateLimit() Then fizzbuzz entity updated`() {
        // Given
        val limit = LIMIT_GOOD_STR

        // When
        mainViewModel.updateLimit(limit)
        val expectedResult = LIMIT_RESULT
        val currentLimit = mainViewModel.getCurrentItem().limit

        // Then
        Assert.assertEquals(currentLimit, expectedResult)
    }


    @Test
    fun `Given bad string When mainViewModel call updateLimit() Then throw exception`() {
        // Given
        val limit = LIMIT_BAD_STR

        // When
        Assert.assertThrows(com.fizzbuzz.model.FormException::class.java)
        {
            mainViewModel.updateLimit(limit)
        }

    }

    @Test
    fun `Given too big number When mainViewModel call updateLimit() Then throw exception`() {
        // Given
        val limit = LIMIT_TOO_LONG_NUMBER

        // When
        Assert.assertThrows(
            com.fizzbuzz.model.FormException::class.java
        ) {
            mainViewModel.updateLimit(limit)
        }
    }

    @Test
    fun `Given string When mainViewModel call updateStr1() Then fizzbuzz entity updated`() {
        // Given
        val str1 = STRING_1_VALUE

        // When
        mainViewModel.updateStr1(str1)
        val expectedResult = STRING_1_VALUE
        val currentStr1 = mainViewModel.getCurrentItem().str1

        // Then
        Assert.assertEquals(currentStr1, expectedResult)
    }

    @Test
    fun `Given string When mainViewModel call updateStr2() Then fizzbuzz entity updated`() {
        // Given
        val str2 = STRING_2_VALUE

        // When
        mainViewModel.updateStr2(str2)
        val expectedResult = STRING_2_VALUE
        val currentStr2 = mainViewModel.getCurrentItem().str2

        // Then
        Assert.assertEquals(currentStr2, expectedResult)
    }

    @Test
    fun `When mainViewModel call submit() Then fizzbuzz entity saved`() {
        // Given
        // Nothing

        // When
        mainViewModel.submit()

        // Then
        verify(exactly = 1) { saveFizzbuzzEntityUseCase.invoke(CURRENT_FIZZBUZZ_ENTITY) }
    }


}
package com.fizzbuzz.ui.main

import androidx.lifecycle.ViewModel
import com.fizzbuzz.domain.GetFizzbuzzEntityUseCase
import com.fizzbuzz.domain.SaveFizzbuzzEntityUseCase
import com.fizzbuzz.model.FizzbuzzEntity
import com.fizzbuzz.model.FormException
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FormMainViewModel @Inject constructor(
    private val saveFizzbuzzEntityUseCase: SaveFizzbuzzEntityUseCase,
    getFizzbuzzEntityUseCase: GetFizzbuzzEntityUseCase
) : ViewModel() {

    private val currentItem: FizzbuzzEntity = getFizzbuzzEntityUseCase.invoke()

    fun getCurrentItem(): FizzbuzzEntity {
        return currentItem
    }

    fun updateInt1(value: Int) {

        currentItem.int1 = value

    }

    @Throws(FormException::class)
    fun updateInt2(value: Int) {
        try {
            currentItem.int2 = value
        } catch (e: NumberFormatException) {
            throw FormException()
        }
    }

    @Throws(FormException::class)
    fun updateLimit(value: Int) {
        try {
            currentItem.limit = value
        } catch (e: NumberFormatException) {
            throw FormException()
        }
    }

    fun updateStr1(value: String) {
        currentItem.str1 = value
    }

    fun updateStr2(value: String) {
        currentItem.str2 = value
    }

    fun submit() {
        saveFizzbuzzEntityUseCase.invoke(currentItem)
    }
}
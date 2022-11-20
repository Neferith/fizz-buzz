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

    @Throws(FormException::class)
    fun updateInt1(toString: String) {
        try {
            currentItem.int1 = toString.toInt()
        } catch (e: NumberFormatException) {
            throw FormException()
        }
    }

    @Throws(FormException::class)
    fun updateInt2(toString: String) {
        try {
            currentItem.int2 = toString.toInt()
        } catch (e: NumberFormatException) {
            throw FormException()
        }
    }

    @Throws(FormException::class)
    fun updateLimit(toString: String) {
        try {
            currentItem.limit = toString.toInt()
        } catch (e: NumberFormatException) {
            throw FormException()
        }
    }

    fun updateStr1(toString: String) {
        currentItem.str1 = toString
    }

    fun updateStr2(toString: String) {
        currentItem.str2 = toString
    }

    fun submit() {
        saveFizzbuzzEntityUseCase.invoke(currentItem)
    }
}
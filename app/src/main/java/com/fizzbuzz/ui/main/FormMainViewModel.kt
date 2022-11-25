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

    fun updateInt1(value: Long) {
        currentItem.int1 = value
    }

    @Throws(FormException::class)
    fun updateInt2(value: Long) {
        currentItem.int2 = value
    }

    @Throws(FormException::class)
    fun updateLimit(value: Long) {
        currentItem.limit = value
    }

    fun updateStr1(value: String) {
        currentItem.str1 = value
    }

    fun updateStr2(value: String) {
        currentItem.str2 = value
    }

    fun submit() = saveFizzbuzzEntityUseCase.invoke(currentItem)

}
package com.fizzbuzz.ui.main

import androidx.lifecycle.ViewModel
import com.fizzbuzz.model.FizzbuzzMeta
import com.fizzbuzz.model.FormException


class FormMainViewModel : ViewModel() {

    private val currentItem: FizzbuzzMeta =
        FizzbuzzMeta(3,5,100,"fizz","buzz")

    fun getCurrentItem():FizzbuzzMeta {
        return currentItem
    }

    @Throws(FormException::class)
    fun updateInt1(toString: String) {
        try {
            currentItem.int1 = toString.toInt()
        } catch (e:NumberFormatException) {
            throw FormException("Le champ n'est pas valide")
        }
    }

    fun updateInt2(toString: String) {
        try {
            currentItem.int2 = toString.toInt()
        } catch (e:NumberFormatException) {
            throw FormException("Le champ n'est pas valide")
        }

    }


    fun updateLimit(toString: String) {
        try {
            currentItem.limit = toString.toInt()
        } catch (e:NumberFormatException) {
            throw FormException("Le champ n'est pas valide")
        }
    }

    fun updateStr1(toString: String) {
        currentItem.str1 = toString
    }


    fun updateStr2(toString: String) {
        currentItem.str2 = toString
    }
}
package com.fizzbuzz.ui.result

import androidx.lifecycle.ViewModel
import com.fizzbuzz.domain.GetFizzbuzzStringUseCase
import com.fizzbuzz.model.FizzbuzzEntity
import com.fizzbuzz.utils.FizzBuzzUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val getFizzBuzzEntityUseCase: GetFizzbuzzStringUseCase
) : ViewModel() {

    var entity: FizzbuzzEntity = FizzBuzzUtils.defaultFitBuzz()

    /**
     * Method to initialize the parameters, of the view model
     */
    fun init(parcelable: FizzbuzzEntity?) {

        if (parcelable != null) {
            entity = parcelable
        }
    }

    fun generateFitBuzzString(i: Int, mItem: FizzbuzzEntity): CharSequence {
        return getFizzBuzzEntityUseCase.invoke(i, mItem)
    }

}
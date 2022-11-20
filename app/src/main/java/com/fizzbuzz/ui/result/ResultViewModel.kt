package com.fizzbuzz.ui.result

import androidx.lifecycle.ViewModel
import com.fizzbuzz.model.FizzbuzzEntity
import com.fizzbuzz.utils.FizzBuzzUtils

class ResultViewModel : ViewModel() {

    var entity: FizzbuzzEntity = FizzBuzzUtils.defaultFitBuzz()

    /**
     * Method to initialize the parameters, of the view model
     */
    fun init(parcelable: FizzbuzzEntity?) {

        if (parcelable != null) {
            entity = parcelable
        }
    }

}
package com.fizzbuzz.ui.result

import androidx.lifecycle.ViewModel
import com.fizzbuzz.model.FizzbuzzMeta
import com.fizzbuzz.utils.FizzBuzzUtils


class ResultViewModel : ViewModel() {

    var meta:FizzbuzzMeta = FizzBuzzUtils.defaultFitBuzz()

    /**
     * Method to initialize the paramerters, of the view model
     */
    fun init(parcelable: FizzbuzzMeta?) {

        if(parcelable != null) {
            meta = parcelable
        }
    }

}
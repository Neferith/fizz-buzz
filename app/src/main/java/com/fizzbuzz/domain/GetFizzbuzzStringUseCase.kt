package com.fizzbuzz.domain

import com.fizzbuzz.model.FizzbuzzEntity
import com.fizzbuzz.utils.FizzBuzzUtils
import javax.inject.Inject

class GetFizzbuzzStringUseCase @Inject constructor() {

    operator fun invoke(index: Int, entity: FizzbuzzEntity): String {
        return FizzBuzzUtils.generateFitBuzzString(index, entity)
    }
}
package com.fizzbuzz.domain

import androidx.paging.Pager
import javax.inject.Inject

class GetFizzbuzzPagerUseCase @Inject
constructor(
    private val pager: Pager<Int, String>
) {
    operator fun invoke() = pager.flow
}
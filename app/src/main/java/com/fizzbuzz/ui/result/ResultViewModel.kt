package com.fizzbuzz.ui.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.fizzbuzz.domain.GetFizzbuzzPagerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    getFizzbuzzPagerUseCase: GetFizzbuzzPagerUseCase
) : ViewModel() {
    val listData = getFizzbuzzPagerUseCase.invoke().cachedIn(viewModelScope)
}
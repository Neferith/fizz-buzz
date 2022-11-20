package com.fizzbuzz.ui.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.fizzbuzz.domain.GetFizzbuzzResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    getFizzbuzzResultUseCase: GetFizzbuzzResultUseCase
) : ViewModel() {
    val listData = getFizzbuzzResultUseCase.invoke().flow.cachedIn(viewModelScope)
}
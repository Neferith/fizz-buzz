package com.fizzbuzz.ui.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fizzbuzz.domain.CoroutineDispatcherProvider
import com.fizzbuzz.domain.GetFizzbuzzResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val getFizzbuzzResultUseCase: GetFizzbuzzResultUseCase
) : ViewModel() {

    private val _fizzBuzzString: MutableLiveData<List<String>> = MutableLiveData()
    val fizzBuzzString: LiveData<List<String>>
        get() = _fizzBuzzString

    init {
        viewModelScope.launch(coroutineDispatcherProvider.io) {

            getFizzbuzzResultUseCase.invoke().onEach { _fizzBuzzString.value = it }.launchIn(
                MainScope()
            )
        }
    }


}
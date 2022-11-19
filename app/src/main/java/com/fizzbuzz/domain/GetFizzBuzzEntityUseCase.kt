package com.fizzbuzz.domain

import com.fizzbuzz.data.repository.FizzBuzzRepository
import com.fizzbuzz.model.FizzbuzzEntity
import javax.inject.Inject

class GetFizzBuzzEntityUseCase @Inject
constructor(private val fizzBuzzRepository: FizzBuzzRepository) {

    operator fun invoke(): FizzbuzzEntity {
        return fizzBuzzRepository.getCurrentFizzBuzzEntity()
    }

}
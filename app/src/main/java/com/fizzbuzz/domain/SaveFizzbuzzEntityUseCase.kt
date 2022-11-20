package com.fizzbuzz.domain

import com.fizzbuzz.data.repository.FizzbuzzRepository
import com.fizzbuzz.model.FizzbuzzEntity
import javax.inject.Inject

class SaveFizzbuzzEntityUseCase @Inject
constructor(private val fizzBuzzRepository: FizzbuzzRepository) {

    operator fun invoke(entity: FizzbuzzEntity) {
        fizzBuzzRepository.setCurrentFizzBuzzEntity(entity)
    }

}
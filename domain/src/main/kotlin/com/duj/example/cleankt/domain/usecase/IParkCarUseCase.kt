package com.duj.example.cleankt.domain.usecase

import com.duj.example.cleankt.domain.entity.ParkedCar
import com.duj.example.cleankt.domain.stereotype.validation.SelfValidating
import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty

interface IParkCarUseCase {
    fun execute(parkingLotCode: String, car: Car): ParkedCar

    class Car(
        @NotEmpty
        val plate: String,
        val entryDate: LocalDateTime?
    ) : SelfValidating<Car>()

}
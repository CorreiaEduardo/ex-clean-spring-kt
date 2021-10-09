package com.duj.example.cleankt.domain.usecase.impl

import com.duj.example.cleankt.domain.entity.ParkedCar
import com.duj.example.cleankt.domain.gateway.ParkedCarDataProvider
import com.duj.example.cleankt.domain.gateway.ParkingLotDataProvider
import com.duj.example.cleankt.domain.usecase.IParkCarUseCase
import javax.inject.Named

@Named
internal class ParkCarUseCaseImpl(
    @Named val parkingLotDataProvider: ParkingLotDataProvider,
    @Named val parkedCarDataProvider: ParkedCarDataProvider
) : IParkCarUseCase {

    override fun execute(parkingLotCode: String, car: IParkCarUseCase.Car): ParkedCar {
        val parkingLot = parkingLotDataProvider
            .findByIdentifier(parkingLotCode)

        if (parkingLot.isFull()) throw IllegalStateException("Parking lot is full")
        if (!parkingLot.isOpen(car.entryDate)) throw IllegalStateException("Parking lot is closed")

        val parkedCarDTO = parkingLot
            .parkCar(car.plate, car.entryDate)

        parkedCarDataProvider.save(parkedCarDTO)

        return parkedCarDTO;
    }
}
package com.duj.example.cleankt.domain.usecase.impl

import com.duj.example.cleankt.domain.entity.ParkingLot
import com.duj.example.cleankt.domain.gateway.ParkingLotDataProvider
import com.duj.example.cleankt.domain.usecase.ICreateParkingLotUseCase
import com.duj.example.cleankt.domain.usecase.ICreateParkingLotUseCase.ParkingLotDTO
import javax.inject.Named

@Named
internal class CreateParkingLotUseCaseImpl constructor(
    @Named val parkingLotDataProvider: ParkingLotDataProvider,
) : ICreateParkingLotUseCase {
    override fun execute(parkingLot: ParkingLotDTO): ParkingLot {
        return parkingLotDataProvider.save(parkingLot.toDomain())
    }
}
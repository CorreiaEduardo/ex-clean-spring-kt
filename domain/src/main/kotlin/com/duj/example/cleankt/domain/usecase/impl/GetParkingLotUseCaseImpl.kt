package com.duj.example.cleankt.domain.usecase.impl

import com.duj.example.cleankt.domain.gateway.ParkingLotDataProvider
import com.duj.example.cleankt.domain.usecase.IGetParkingLotUseCase
import javax.inject.Named

@Named
internal class GetParkingLotUseCaseImpl(
    @Named private val parkingLotDataProvider: ParkingLotDataProvider
) : IGetParkingLotUseCase {

    override fun execute(code: String) = parkingLotDataProvider.findByIdentifier(code)
}
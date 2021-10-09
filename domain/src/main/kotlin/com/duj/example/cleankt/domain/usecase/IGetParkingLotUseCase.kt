package com.duj.example.cleankt.domain.usecase

import com.duj.example.cleankt.domain.entity.ParkingLot

interface IGetParkingLotUseCase {
    fun execute(code: String): ParkingLot
}
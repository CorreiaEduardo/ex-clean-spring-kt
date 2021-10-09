package com.duj.example.cleankt.domain.usecase

import com.duj.example.cleankt.domain.entity.ParkingLot
import com.duj.example.cleankt.domain.stereotype.validation.SelfValidating
import java.time.LocalTime
import javax.validation.constraints.NotNull

interface ICreateParkingLotUseCase {
    fun execute(parkingLot: ParkingLotDTO): ParkingLot

    class ParkingLotDTO(
        @NotNull val capacity: Int,
        @NotNull val openingTime: LocalTime,
        @NotNull val closingTime: LocalTime,
    ) : SelfValidating<ParkingLotDTO>() {
        fun toDomain() = ParkingLot(null, capacity, openingTime, closingTime, emptyList())
    }

}
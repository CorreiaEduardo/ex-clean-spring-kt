package com.duj.example.cleankt.api.gateway.postgres.mapper

import com.duj.example.cleankt.api.gateway.postgres.model.ParkingLotModel
import com.duj.example.cleankt.domain.entity.ParkingLot
import org.springframework.stereotype.Component

@Component
class ParkingLotModelMapper {
    fun toDomain(from: ParkingLotModel): ParkingLot {
        return ParkingLot(from.code!!, from.capacity, from.openingTime, from.closingTime, emptyList())
    }

    fun fromDomain(from: ParkingLot): ParkingLotModel {
        return ParkingLotModel(from.code, from.capacity, from.openingTime, from.closingTime)
    }
}

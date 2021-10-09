package com.duj.example.cleankt.domain.entity

import java.time.LocalDateTime
import java.time.LocalTime

class ParkingLot(
    val code: String?,
    val capacity: Int,
    val openingTime: LocalTime,
    val closingTime: LocalTime,
    parkedCars: List<ParkedCar>
) {
    var parkedCars = parkedCars
        private set

    fun isOpen(givenDateTime: LocalDateTime?): Boolean {
        val time = givenDateTime?.toLocalTime() ?: LocalTime.now()

        return time.isBefore(this.closingTime) && time.isAfter(openingTime)
    }

    fun isFull(): Boolean = parkedCars.size >= capacity

    fun parkCar(plate: String, entryDate: LocalDateTime?): ParkedCar {
        val parkedCar = ParkedCar(plate, entryDate, departureDate = null)
        this.parkedCars = this.parkedCars.toMutableList().apply { add(parkedCar) }

        return parkedCar
    }
}
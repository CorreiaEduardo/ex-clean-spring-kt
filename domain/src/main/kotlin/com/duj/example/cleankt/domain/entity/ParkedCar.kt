package com.duj.example.cleankt.domain.entity

import java.time.LocalDateTime

class ParkedCar(
    plate: String,
    entryDate: LocalDateTime?,
    val departureDate: LocalDateTime?
) {
    val plate: String
    val entryDate: LocalDateTime

    init {
        val isValid = Regex("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}").matches(plate)
        if (!isValid) throw IllegalArgumentException("The plate must be valid")

        this.plate = plate
        this.entryDate = entryDate ?: LocalDateTime.now()
    }
}
package com.duj.example.cleankt.api.entrypoint.controller.dto.response

import java.time.LocalTime

data class GetParkingLotByCodeResponse(
    val code: String,
    val capacity: Int,
    val openingTime: LocalTime,
    val closingTime: LocalTime,
)
package com.duj.example.cleankt.api.entrypoint.controller.dto.request

import javax.validation.constraints.NotNull

data class CreateParkingLotRequest(
    @NotNull val capacity: Int,
    @NotNull val openingTime: Time,
    @NotNull val closingTime: Time,
)

data class Time(
    @NotNull val hour: Int,
    @NotNull val minute: Int,
    @NotNull val second: Int,
)
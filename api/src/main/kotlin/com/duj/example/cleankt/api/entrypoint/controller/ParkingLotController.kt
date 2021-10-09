package com.duj.example.cleankt.api.entrypoint.controller

import com.duj.example.api.util.ApplicationLogger
import com.duj.example.cleankt.api.entrypoint.controller.dto.request.CreateParkingLotRequest
import com.duj.example.cleankt.api.entrypoint.controller.dto.response.CreateParkingLotResponse
import com.duj.example.cleankt.api.entrypoint.controller.dto.response.GetParkingLotByCodeResponse
import com.duj.example.cleankt.domain.usecase.ICreateParkingLotUseCase
import com.duj.example.cleankt.domain.usecase.ICreateParkingLotUseCase.ParkingLotDTO
import com.duj.example.cleankt.domain.usecase.IGetParkingLotUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalTime

@RestController("api/v1/parking-lots")
class ParkingLotController @Autowired constructor(
    private val getParkingLotUseCase: IGetParkingLotUseCase,
    private val createParkingLotUseCase: ICreateParkingLotUseCase
) {
    companion object : ApplicationLogger()

    @GetMapping("/{code}")
    fun getByCode(@PathVariable code: String): ResponseEntity<GetParkingLotByCodeResponse> {
        logger.info("GET /v1/parking-lots/{code}", code)
        val result = getParkingLotUseCase.execute(code)

        return ResponseEntity
            .ok(GetParkingLotByCodeResponse(result.code!!, result.capacity, result.openingTime, result.closingTime))
    }

    @PostMapping
    fun create(@RequestBody request: CreateParkingLotRequest): ResponseEntity<CreateParkingLotResponse> {
        logger.info("POST /v1/parking-lots :: body = {}", request)

        val result =
            createParkingLotUseCase.execute(
                ParkingLotDTO(
                    request.capacity,
                    LocalTime.of(request.openingTime.hour, request.openingTime.minute, request.openingTime.minute),
                    LocalTime.of(request.closingTime.hour, request.closingTime.minute, request.closingTime.minute)
                )
            )

        return ResponseEntity
            .status(CREATED)
            .body(CreateParkingLotResponse(result.code!!))
    }
}
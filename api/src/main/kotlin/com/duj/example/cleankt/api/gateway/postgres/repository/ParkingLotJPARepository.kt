package com.duj.example.cleankt.api.gateway.postgres.repository

import com.duj.example.cleankt.api.gateway.postgres.model.ParkingLotModel
import org.springframework.data.repository.CrudRepository

interface ParkingLotJPARepository : CrudRepository<ParkingLotModel, String>
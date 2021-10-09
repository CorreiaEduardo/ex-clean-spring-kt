package com.duj.example.cleankt.api.gateway.postgres.dataprovider

import com.duj.example.cleankt.api.exception.NotFoundException
import com.duj.example.cleankt.api.gateway.postgres.mapper.ParkingLotModelMapper
import com.duj.example.cleankt.api.gateway.postgres.repository.ParkingLotJPARepository
import com.duj.example.cleankt.domain.entity.ParkingLot
import com.duj.example.cleankt.domain.gateway.ParkingLotDataProvider
import org.springframework.beans.factory.annotation.Autowired
import javax.inject.Named

@Named
class ParkingLotDataProviderImpl @Autowired constructor(
    private val repository: ParkingLotJPARepository,
    private val modelMapper: ParkingLotModelMapper,
) : ParkingLotDataProvider {

    override fun findAll(): List<ParkingLot> {
        return repository.findAll()
            .map(modelMapper::toDomain)
    }

    override fun findByIdentifier(identifier: String): ParkingLot {
        return repository.findById(identifier)
            .map(modelMapper::toDomain)
            .orElseThrow { NotFoundException("Parking lot not found") }
    }

    override fun save(entity: ParkingLot): ParkingLot {
        val savedModel = repository.save(modelMapper.fromDomain(entity))
        return modelMapper.toDomain(savedModel)
    }
}
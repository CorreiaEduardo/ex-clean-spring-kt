package com.duj.example.cleankt.api.gateway.postgres.dataprovider

import com.duj.example.cleankt.domain.entity.ParkedCar
import com.duj.example.cleankt.domain.gateway.ParkedCarDataProvider
import javax.inject.Named

@Named
class ParkedCarDataProviderImpl : ParkedCarDataProvider {
    override fun save(entity: ParkedCar): ParkedCar {
        TODO("Not yet implemented")
    }
}
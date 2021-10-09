package com.duj.example.cleankt.domain.gateway

import com.duj.example.cleankt.domain.entity.ParkedCar
import com.duj.example.cleankt.domain.stereotype.dataprovider.IEntityKeeper

interface ParkedCarDataProvider : IEntityKeeper<ParkedCar>

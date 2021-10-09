package com.duj.example.cleankt.domain.gateway

import com.duj.example.cleankt.domain.entity.ParkingLot
import com.duj.example.cleankt.domain.stereotype.dataprovider.IEntityFinder
import com.duj.example.cleankt.domain.stereotype.dataprovider.IEntityKeeper

interface ParkingLotDataProvider : IEntityFinder<ParkingLot, String>, IEntityKeeper<ParkingLot>

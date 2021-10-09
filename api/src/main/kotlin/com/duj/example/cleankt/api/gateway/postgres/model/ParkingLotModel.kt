package com.duj.example.cleankt.api.gateway.postgres.model

import org.hibernate.annotations.GenericGenerator
import java.time.LocalTime
import javax.persistence.*

@Entity
@Table(name = "parking_lot")
class ParkingLotModel(
    @Id
    @GeneratedValue(generator = "UUID4")
    @GenericGenerator(
        name = "UUID4",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    val code: String? = null,

    @Column(name = "capacity", nullable = false, updatable = false)
    val capacity: Int,

    @Column(name = "opening_time", nullable = false, updatable = false)
    val openingTime: LocalTime,

    @Column(name = "closing_time", nullable = false, updatable = false)
    val closingTime: LocalTime,
)

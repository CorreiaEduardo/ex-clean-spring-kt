package com.duj.example.cleankt.domain.stereotype.dataprovider

interface IEntityKeeper<T> {
    fun save(entity: T): T
}
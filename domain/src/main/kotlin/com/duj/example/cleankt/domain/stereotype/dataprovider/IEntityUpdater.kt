package com.duj.example.cleankt.domain.stereotype.dataprovider

interface IEntityUpdater<T> {
    fun update(entity: T)
}
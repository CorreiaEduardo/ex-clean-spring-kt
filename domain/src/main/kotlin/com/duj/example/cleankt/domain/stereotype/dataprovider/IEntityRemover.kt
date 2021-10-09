package com.duj.example.cleankt.domain.stereotype.dataprovider

interface IEntityRemover<T, ID> {
    fun removeById(identifier: ID)
}
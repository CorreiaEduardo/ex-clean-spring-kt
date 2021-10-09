package com.duj.example.cleankt.domain.stereotype.dataprovider

interface IEntityFinder<T, ID> {
    fun findAll(): List<T>
    fun findByIdentifier(identifier: ID): T
}
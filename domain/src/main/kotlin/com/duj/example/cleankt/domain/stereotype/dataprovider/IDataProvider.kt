package com.duj.example.cleankt.domain.stereotype.dataprovider

interface IDataProvider<T, ID> : IEntityKeeper<T>, IEntityFinder<T, ID>, IEntityUpdater<T>, IEntityRemover<T, ID>
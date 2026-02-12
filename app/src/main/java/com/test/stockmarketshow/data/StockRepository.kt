package com.test.stockmarketshow.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

class StockRepository (
    private val source: StockDataSource
) {

    fun getStocks(): Flow<List<Stock>> {
        return source.connect()
            .conflate()                       // skip intermediate if UI slow
            .distinctUntilChanged()           // avoid same list emit
            .flowOn(Dispatchers.IO)
    }
}
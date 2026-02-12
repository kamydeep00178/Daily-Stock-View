package com.test.stockmarketshow.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StockDataSource {

    fun connect(): Flow<List<Stock>> = flow {

        var current = createInitial()

        while (true) {

            // Simulate partial price change
            current = current.map {
                it.copy(
                    price = it.price + (-2..2).random() + Math.random()
                )
            }

            emit(current)

            delay(1000)   // 1 sec realtime update
        }

    }

    private fun createInitial(): List<Stock> {
        return (1..50).map {
            Stock(
                id = it.toString(),
                name = "Stock $it",
                price = (100..500).random().toDouble(),
                lastUpdated = System.currentTimeMillis()
            )
        }
    }
}


package com.test.stockmarketshow.di

import com.test.stockmarketshow.data.StockDataSource
import com.test.stockmarketshow.data.StockRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object StockModule {

    @Provides
    fun provideDataSource(): StockDataSource {
        return StockDataSource()
    }

    @Provides
    fun provideRepo(
        source: StockDataSource
    ): StockRepository {
        return StockRepository(source)
    }
}
package com.berkaytuncel.data.repository

import com.berkaytuncel.data.api.CoinPaprikaApi
import com.berkaytuncel.data.extensions.toCoin
import com.berkaytuncel.domain.model.Coin
import com.berkaytuncel.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return api.getCoins().map { it.toCoin() }
    }
}
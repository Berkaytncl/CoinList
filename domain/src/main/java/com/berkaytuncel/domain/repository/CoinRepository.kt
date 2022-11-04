package com.berkaytuncel.domain.repository

import com.berkaytuncel.domain.model.Coin

interface CoinRepository {
    suspend fun getCoins(): List<Coin>
}
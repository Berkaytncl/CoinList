package com.berkaytuncel.data_mock.repository

import com.berkaytuncel.domain.model.Coin
import com.berkaytuncel.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(): CoinRepository{

    val coinList = arrayListOf(
        Coin("1", true, "Bitcoin", 1, "BTC"),
        Coin("2", true, "Stellar", 1, "XLM"),
    )
    override suspend fun getCoins(): List<Coin> = coinList
}
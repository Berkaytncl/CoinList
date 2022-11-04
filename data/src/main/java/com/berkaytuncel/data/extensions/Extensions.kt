package com.berkaytuncel.data.extensions

import com.berkaytuncel.data.model.CoinModel
import com.berkaytuncel.domain.model.Coin

fun CoinModel.toCoin(): Coin {
    return Coin(
        id, isActive, name, rank, symbol
    )
}
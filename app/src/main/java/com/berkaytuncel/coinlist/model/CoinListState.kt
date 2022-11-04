package com.berkaytuncel.coinlist.model

import com.berkaytuncel.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)

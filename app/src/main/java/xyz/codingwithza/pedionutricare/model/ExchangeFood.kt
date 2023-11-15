package xyz.codingwithza.pedionutricare.model

import androidx.annotation.StringRes

data class ExchangeFood (
    val id: Int,
    @StringRes val title: Int,
    val images: List<ExchangeFoodImage>
    )

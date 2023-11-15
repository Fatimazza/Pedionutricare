package xyz.codingwithza.pedionutricare.model

import androidx.annotation.StringRes

data class Recommendation (
    val id: Int,
    @StringRes val title: Int,
    @StringRes val recommended: Int,
    @StringRes val notrecommended: Int,
)

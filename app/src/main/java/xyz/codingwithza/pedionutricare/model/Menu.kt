package xyz.codingwithza.pedionutricare.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Menu(
    val id: Long,
    @DrawableRes val image: Int,
    @StringRes val title: Int,
)

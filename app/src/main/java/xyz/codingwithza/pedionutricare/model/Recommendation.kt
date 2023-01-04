package xyz.codingwithza.pedionutricare.model

data class Recommendation (
    val id: Int,
    val title: String,
    val recommended: String,
    val notrecommended: String,
)

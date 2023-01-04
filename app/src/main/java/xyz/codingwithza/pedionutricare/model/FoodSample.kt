package xyz.codingwithza.pedionutricare.model

data class FoodSample(
    val id: Int,
    val time: String,
    val foods: List<Foods>
)

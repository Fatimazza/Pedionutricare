package xyz.codingwithza.pedionutricare.model

data class Exchanged(
    val id: Int,
    val title: String,
    val foods: List<Category>
)

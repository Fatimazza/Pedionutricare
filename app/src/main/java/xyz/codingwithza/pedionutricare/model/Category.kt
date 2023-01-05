package xyz.codingwithza.pedionutricare.model

class Category(
    val id: Int,
    val title: String,
    val desc: String,
    val foods: List<Ingredients>
)

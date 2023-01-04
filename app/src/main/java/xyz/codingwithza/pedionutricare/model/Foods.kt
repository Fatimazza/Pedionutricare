package xyz.codingwithza.pedionutricare.model

data class Foods(
    val id: Int,
    val name: String,
    val ingredients: List<Ingredients>
)

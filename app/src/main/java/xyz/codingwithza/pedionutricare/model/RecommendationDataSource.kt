package xyz.codingwithza.pedionutricare.model

import xyz.codingwithza.pedionutricare.R

object RecommendationDataSource {
    val recommendationItems = listOf(
        Recommendation(
            1,
            R.string.recom_carbo_title,
            R.string.recom_carbo_yes,
            R.string.recom_carbo_not
        ),
        Recommendation(
            2,
            R.string.recom_animal_title,
            R.string.recom_animal_yes,
            R.string.recom_animal_not
        ),
        Recommendation(
            3,
            R.string.recom_veg_title,
            R.string.recom_veg_yes,
            R.string.recom_veg_not
        ),
        Recommendation(
            4,
            R.string.recom_fat_title,
            R.string.recom_fat_yes,
            R.string.recom_fat_not
        ),
        Recommendation(
            5,
            R.string.recom_veggies_title,
            R.string.recom_veggies_yes,
            R.string.recom_veggies_not
        ),
        Recommendation(
            6,
            R.string.recom_fruits_title,
            R.string.recom_fruits_yes,
            R.string.recom_fruits_not
        ),
        Recommendation(
            7,
            R.string.recom_milk_title,
            R.string.recom_milk_yes,
            R.string.recom_milk_not
        ),
        Recommendation(
            8,
            R.string.recom_snack_title,
            R.string.recom_snack_yes,
            R.string.recom_snack_not
        ),
    )
}

package xyz.codingwithza.pedionutricare.model

import xyz.codingwithza.pedionutricare.R

object ExchangeFoodDataSource {
    val exchangedItems = listOf(
        ExchangeFood(
            1,
            R.string.exchanged_carbo,
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_carbo
                )
            )
        ),
        ExchangeFood(
            2,
            R.string.exchanged_animal_protein,
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_prohe_1
                ),
                ExchangeFoodImage(
                    2, R.drawable.img_ex_prohe_2
                ),
                ExchangeFoodImage(
                    3, R.drawable.img_ex_prohe_3
                )
            )
        ),
        ExchangeFood(
            3,
            R.string.exchanged_vegetable_protein,
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_prona
                )
            )
        ),
        ExchangeFood(
            4,
            R.string.exchanged_vegetables,
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_veg
                )
            )
        ),
        ExchangeFood(
            5,
            R.string.exchanged_fruits_and_sugar,
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_buah
                )
            )
        ),
        ExchangeFood(
            6,
            R.string.exchanged_milk_and_its_product,
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_milk_1
                ),
                ExchangeFoodImage(
                    1, R.drawable.img_ex_milk_2
                ),
                ExchangeFoodImage(
                    1, R.drawable.img_ex_milk_3
                )
            )
        ),
        ExchangeFood(
            7,
            R.string.exchanged_oil_and_fat,
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_fat
                )
            )
        ),
        ExchangeFood(
            8,
            R.string.exchanged_calorie_free_food,
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_no_calory
                )
            )
        )
    )
}

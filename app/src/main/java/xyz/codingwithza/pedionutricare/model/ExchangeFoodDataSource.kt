package xyz.codingwithza.pedionutricare.model

import xyz.codingwithza.pedionutricare.R

object ExchangeFoodDataSource {
    val exchangedItems = listOf(
        ExchangeFood(
            1,
            "Karbohidrat",
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_carbo
                )
            )
        ),
        ExchangeFood(
            2,
            "Protein Hewani",
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_prohe_1
                ),
                ExchangeFoodImage(
                    1, R.drawable.img_ex_prohe_2
                ),
                ExchangeFoodImage(
                    1, R.drawable.img_ex_prohe_3
                )
            )
        ),
        ExchangeFood(
            3,
            "Protein Nabati",
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_prona_wrong
                )
            )
        ),
        ExchangeFood(
            4,
            "Susu dan Olahannya",
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
        )
    )
}

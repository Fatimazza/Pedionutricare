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
                    2, R.drawable.img_ex_prohe_2
                ),
                ExchangeFoodImage(
                    3, R.drawable.img_ex_prohe_3
                )
            )
        ),
        ExchangeFood(
            3,
            "Protein Nabati",
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_prona
                )
            )
        ),
        ExchangeFood(
            4,
            "Sayuran",
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_veg
                )
            )
        ),
        ExchangeFood(
            5,
            "Buah dan Gula",
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_buah
                )
            )
        ),
        ExchangeFood(
            6,
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
        ),
        ExchangeFood(
            7,
            "Minyak dan Lemak",
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_fat
                )
            )
        ),
        ExchangeFood(
            8,
            "Makanan Tanpa Kalori",
            listOf(
                ExchangeFoodImage(
                    1, R.drawable.img_ex_no_calory
                )
            )
        )
    )
}

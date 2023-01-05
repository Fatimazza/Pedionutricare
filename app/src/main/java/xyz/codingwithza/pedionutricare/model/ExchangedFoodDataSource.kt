package xyz.codingwithza.pedionutricare.model

object ExchangedFoodDataSource {
    val exchangedItems = listOf(
        Exchanged(
            1,
            "SUSU DAN OLAHANNYA",
            listOf(
                Category(
                    1,
                    "Susu Tanpa Lemak",
                    "1 Satuan Penukar = 75 Kalori, 7 g Protein, dan 10 g Karbohidrat",
                    listOf(
                        Ingredients(
                            1,
                            "Susu skim cair",
                            200,
                            "1 gls"
                        ),
                        Ingredients(
                            1,
                            "Tepung susu skim",
                            20,
                            "4 sdm"
                        )
                    )
                ),
                Category(
                    1,
                    "Susu Rendah Lemak",
                    "1 Satuan Penukar = 125 Kalori, 7 g Protein, 6 g Lemak dan 10 g Karbohidrat",
                    listOf(
                        Ingredients(
                            1,
                            "Keju",
                            35,
                            "1 ptg kcl"
                        ),
                        Ingredients(
                            2,
                            "Susu Kambing",
                            165,
                            "3/4 gls"
                        )
                    )
                )
            )
        )
    )
}

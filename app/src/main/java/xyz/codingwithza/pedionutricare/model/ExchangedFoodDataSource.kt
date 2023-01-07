package xyz.codingwithza.pedionutricare.model

object ExchangedFoodDataSource {
    val exchangedItems = listOf(
        Exchanged(
            1,
            "BAHAN MAKANAN SUMBER KARBOHIDRAT",
            listOf(
                Category(
                    1,
                    "",
                    "1 Satuan Penukar = 175 Kalori dan 4 g Protein dan 40 g karbohidrat.",
                    listOf(
                        Ingredients(
                            1,
                            "Bihun",
                            50,
                            "½ gls"
                        ),
                        Ingredients(
                            2,
                            "Bubur Beras",
                            400,
                            "2 gls"
                        ),
                        Ingredients(
                            3,
                            "Biskuit",
                            40,
                            "4 bh bsr"
                        ),
                        Ingredients(
                            4,
                            "Havermouth",
                            45,
                            "5 ½ sdm"
                        ),
                        Ingredients(
                            5,
                            "Kentang",
                            210,
                            "2 bj sdg"
                        ),
                        Ingredients(
                            6,
                            "Krackers",
                            50,
                            "5 bh sdg"
                        ),
                        Ingredients(
                            7,
                            "Makaroni",
                            50,
                            "½ gls"
                        ),
                        Ingredients(
                            8,
                            "Mi basah",
                            200,
                            "2 gls"
                        ),
                        Ingredients(
                            9,
                            "Mi Kering",
                            50,
                            "1 gls"
                        ),
                        Ingredients(
                            10,
                            "Nasi",
                            100,
                            "¾ gls"
                        ),
                        Ingredients(
                            11,
                            "Nasi Tim",
                            200,
                            "1 gls"
                        ),
                        Ingredients(
                            12,
                            "Roti Putih",
                            70,
                            "3 iris"
                        ),
                        Ingredients(
                            13,
                            "Singkong",
                            120,
                            "1 ptg"
                        ),
                        Ingredients(
                            14,
                            "Talas",
                            125,
                            "1 ptg"
                        ),
                        Ingredients(
                            15,
                            "Tepung Beras",
                            150,
                            "8 sdm"
                        )
                    )
                )
            )
        ),
        Exchanged(
            2,
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
                            2,
                            "Tepung susu skim",
                            20,
                            "4 sdm"
                        ),
                        Ingredients(
                            3,
                            "Yogurt non fat",
                            120,
                            "⅔ gls"
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
                            "¾ gls"
                        ),
                        Ingredients(
                            3,
                            "Susu Sapi",
                            200,
                            "1 gls"
                        ),
                        Ingredients(
                            4,
                            "Susu Kental Manis",
                            100,
                            "½ gls"
                        ),
                        Ingredients(
                            5,
                            "Yogurt Susu",
                            100,
                            "1 gls"
                        )
                    )
                )
            )
        )
    )
}

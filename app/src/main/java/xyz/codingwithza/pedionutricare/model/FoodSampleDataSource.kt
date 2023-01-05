package xyz.codingwithza.pedionutricare.model

object FoodSampleDataSource {
    val sampleItems = listOf(
        FoodSample(
            1,
            "Makan Pagi (06.30)",
            listOf(
                Foods(
                    1,
                    "Nasi Goreng",
                    listOf(
                        Ingredients(
                            1, "nasi", 100, "7 sdm"
                        ),
                        Ingredients(
                            2, "telur puyuh", 30, "2 butir"
                        ),
                        Ingredients(
                            3, "wortel", 10, "1 sdm"
                        ),
                        Ingredients(
                            4, "daun bawang", 5, "1 sdt"
                        ),
                        Ingredients(
                            3, "minyak", 5, "1 sdt"
                        )
                    )
                )
            )
        ),
        FoodSample(
            2,
            "Snack Pagi (09.00)",
            listOf(
                Foods(
                    1,
                    "Roti Panggang",
                    listOf(
                        Ingredients(
                            1, "roti tawar", 40, "1 lembar"
                        ),
                        Ingredients(
                            2, "mentega", 5, "1 sdt"
                        )
                    )
                )
            )
        ),
        FoodSample(
            3,
            "Makan Siang (12.00)",
            listOf(
                Foods(
                    1,
                    "Nasi",
                    listOf(
                        Ingredients(
                            1, "nasi", 100, "7 sdm"
                        )
                    )
                ),
                Foods(
                    2,
                    "Tahu Krispi",
                    listOf(
                        Ingredients(
                            1, "tahu putih", 50, "1 bj sdg"
                        ),
                        Ingredients(
                            2, "tepung bumbu", 20, "2 sdm"
                        ),
                        Ingredients(
                            3, "minyak", 5, "1 sdt"
                        )
                    )
                ),
                Foods(
                    3,
                    "Bening Bayam",
                    listOf(
                        Ingredients(
                            1, "bayam", 30, "3 sdm"
                        ),
                        Ingredients(
                            2, "labu siam", 20, "2 sdm"
                        )
                    )
                ),
                Foods(
                    4,
                    "Jus Buah",
                    listOf(
                        Ingredients(
                            1, "semangka", 100, "1 ptg sdg"
                        )
                    )
                )
            )
        ),
        FoodSample(
            4,
            "Snack Sore (15.00)",
            listOf(
                Foods(
                    1,
                    "Bola Ubi Ungu",
                    listOf(
                        Ingredients(
                            1, "ubi ungu", 50, "1 bj kcl"
                        ),
                        Ingredients(
                            2, "tepung roti", 10, "1 sdm"
                        ),
                        Ingredients(
                            3, "minyak", 5, "1 sdt"
                        )
                    )
                )
            )
        ),
        FoodSample(
            5,
            "Makan Malam (18.00)",
            listOf(
                Foods(
                    1,
                    "Kentang Goreng",
                    listOf(
                        Ingredients(
                            1, "kentang", 100, "1 bj sdg"
                        ),
                        Ingredients(
                            2, "minyak", 5, "1 sdt"
                        )
                    )
                ),
                Foods(
                    2,
                    "Ikan Goreng",
                    listOf(
                        Ingredients(
                            1, "ikan fillet", 25, "1 ptg kcl"
                        ),
                        Ingredients(
                            2, "tepung bumbu", 5, "1 sdt"
                        ),
                        Ingredients(
                            3, "tepung roti", 5, "1 sdt"
                        ),
                        Ingredients(
                            4, "minyak", 5, "1 sdt"
                        )
                    )
                ),
                Foods(
                    2,
                    "Mix Vegetable",
                    listOf(
                        Ingredients(
                            1, "buncis", 10, "1 sdm"
                        ),
                        Ingredients(
                            2, "wortel", 10, "1 sdm"
                        ),
                        Ingredients(
                            3, "jagung manis", 10, "1 sdm"
                        )
                    )
                )
            )
        ),
        FoodSample(
            6,
            "Snack malam (21.00)",
            listOf(
                Foods(
                    1,
                    "Susu",
                    listOf(
                        Ingredients(
                            1, "susu", 200, "1 gelas"
                        )
                    )
                )
            )
        )
    )
}

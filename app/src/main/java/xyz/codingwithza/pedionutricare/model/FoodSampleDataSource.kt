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
                )
            )
        )
    )
}

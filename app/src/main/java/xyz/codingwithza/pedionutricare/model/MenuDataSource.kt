package xyz.codingwithza.pedionutricare.model

import xyz.codingwithza.pedionutricare.R

object MenuDataSource {
    val menuItems = listOf(
        Menu(1, R.drawable.img_menu_need, "Kebutuhan Zat Gizi"),
        Menu(2, R.drawable.img_menu_tips, "Tips Pemenuhan Gizi Anak"),
        Menu(3, R.drawable.img_menu_recommended, "Bahan Makanan yang Dianjurkan dan Tidak"),
        Menu(4, R.drawable.img_menu_exchanged, "Bahan Makanan Penukar"),
        Menu(5, R.drawable.img_menu_sample, "Contoh Menu"),
        Menu(6, R.drawable.img_menu_daily, "Kebutuhan Bahan Makanan Sehari")
    )
}

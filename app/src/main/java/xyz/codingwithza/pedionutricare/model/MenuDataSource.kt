package xyz.codingwithza.pedionutricare.model

import xyz.codingwithza.pedionutricare.R

object MenuDataSource {
    val menuItems = listOf(
        Menu(1, R.drawable.img_menu_need, R.string.menu_nutrition_needs),
        Menu(2, R.drawable.img_menu_tips, R.string.menu_nutrition_tips),
        Menu(3, R.drawable.img_menu_recommended, R.string.menu_food_recommendation),
        Menu(4, R.drawable.img_menu_exchanged, R.string.menu_food_exchanged),
        Menu(5, R.drawable.img_menu_sample, R.string.menu_food_sample),
        Menu(6, R.drawable.img_menu_daily, R.string.menu_daily_needs)
    )
}

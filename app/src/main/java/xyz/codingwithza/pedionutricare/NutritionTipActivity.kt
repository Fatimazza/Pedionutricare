package xyz.codingwithza.pedionutricare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme

class NutritionTipActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PedionutricareTheme {
                NutritionTipScreen()
            }
        }
    }
}

@Composable
fun NutritionTipScreen() {
}

@Preview(showBackground = true)
@Composable
fun NutritionTipPreview() {
    PedionutricareTheme {
        NutritionTipScreen()
    }
}

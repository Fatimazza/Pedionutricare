package xyz.codingwithza.pedionutricare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import xyz.codingwithza.pedionutricare.model.NeedsDataSource
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme

class NutritionNeedsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PedionutricareTheme {
                NutritionNeedsScreen()
            }
        }
    }
}

@Composable
fun NutritionNeedsScreen() {
    NutritionNeeds()
}

@Composable
fun NutritionNeeds() {
    val needItems = NeedsDataSource.needItems
    LazyColumn() {
        items(needItems) { data ->
            Text(data.title)
            Text(data.desc)
        }
        item {
            Text("Tambahan")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PedionutricareTheme {
        NutritionNeedsScreen()
    }
}

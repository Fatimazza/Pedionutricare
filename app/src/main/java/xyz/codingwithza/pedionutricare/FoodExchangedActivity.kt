package xyz.codingwithza.pedionutricare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.codingwithza.pedionutricare.model.ExchangedFoodDataSource
import xyz.codingwithza.pedionutricare.ui.components.TableCell
import xyz.codingwithza.pedionutricare.ui.theme.DarkYellow
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme

class FoodExchangedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PedionutricareTheme {
                FoodExchangedScreen()
            }
        }
    }
}

@Composable
fun FoodExchangedScreen() {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(stringResource(R.string.app_name))
        })
    }) {
        FoodExchanged()
    }
}

@Composable
fun FoodExchanged(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier.padding(16.dp)
    ) {
        val exchangedItems = ExchangedFoodDataSource.exchangedItems
        val columnEx1Weight = 0.52f
        val columnEx2Weight = 0.2f
        val columnEx3Weight = 0.28f

        items(exchangedItems) { data ->
            Text(
                text = data.title,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Spacer(
                modifier = modifier.height(12.dp)
            )
            data.foods.forEach { item ->
                Text(
                    text = item.title,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Normal,
                    fontSize = 22.sp
                )
                Text(
                    text = item.desc,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp
                )
                Row(Modifier.background(DarkYellow)) {
                    TableCell(text = "Bahan Makanan", columnEx1Weight)
                    TableCell(text = "Berat", columnEx2Weight)
                    TableCell(text = "URT", columnEx3Weight)
                }
                item.foods.forEach {
                    Row(Modifier.fillMaxWidth()) {
                        TableCell(text = it.bahan, columnEx1Weight)
                        TableCell(text = "${it.gram} g", columnEx2Weight)
                        TableCell(text = it.URT, columnEx3Weight)
                    }
                }
                Spacer(
                    modifier = modifier.height(12.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodExchangedPreview() {
    PedionutricareTheme {
        FoodExchangedScreen()
    }
}

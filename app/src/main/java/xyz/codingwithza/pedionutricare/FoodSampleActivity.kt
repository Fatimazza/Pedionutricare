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
import xyz.codingwithza.pedionutricare.model.FoodSampleDataSource
import xyz.codingwithza.pedionutricare.ui.components.TableCell
import xyz.codingwithza.pedionutricare.ui.theme.DarkYellow
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme

class FoodSampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PedionutricareTheme {
                FoodSampleScreen()
            }
        }
    }
}

@Composable
fun FoodSampleScreen() {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(stringResource(R.string.app_name))
        })
    }) {
        FoodSample()
    }
}

@Composable
fun FoodSample(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier.padding(16.dp)
    ) {
        val foodSamples = FoodSampleDataSource.sampleItems

        item {
            Text(
                text = "Contoh Menu Usia 1 - 6 tahun",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = modifier.fillMaxWidth(),
            )
            Spacer(
                modifier = modifier.height(16.dp)
            )
        }
        items(foodSamples) { data ->
            Text(
                text = data.time,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            data.foods.forEach { item ->
                Text(
                    text = item.name,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Normal,
                    fontSize = 22.sp
                )
                Row(Modifier.background(DarkYellow)) {
                    TableCell(text = "Bahan", weight = 0.5f)
                    TableCell(text = "gram", weight = 0.2f)
                    TableCell(text = "URT", weight = 0.3f)
                }
                item.ingredients.forEach {
                    Row(Modifier.fillMaxWidth()) {
                        TableCell(text = it.bahan, weight = 0.5f)
                        TableCell(text = it.gram.toString(), weight = 0.2f)
                        TableCell(text = it.URT, weight = 0.3f)
                    }
                }
            }
            Spacer(
                modifier = modifier.height(20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodSamplePreview() {
    PedionutricareTheme {
        FoodSampleScreen()
    }
}

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
import xyz.codingwithza.pedionutricare.model.FluidsDataSource
import xyz.codingwithza.pedionutricare.model.NeedsDataSource
import xyz.codingwithza.pedionutricare.model.NutritionDataSource
import xyz.codingwithza.pedionutricare.ui.components.TableCell
import xyz.codingwithza.pedionutricare.ui.components.TableCellCenter
import xyz.codingwithza.pedionutricare.ui.theme.DarkYellow
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
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(stringResource(R.string.app_name))
        })
    }) {
        NutritionNeeds()
    }
}

@Composable
fun NutritionNeeds(
    modifier: Modifier = Modifier
) {
    val needItems = NeedsDataSource.needItems
    LazyColumn(
        modifier.padding(16.dp)
    ) {
        items(needItems) { data ->
            val index = needItems.indexOf(data)
            Text(
                text = data.title,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Text(
                text = data.desc,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
            if (index == 3 || index == 4) {
                Spacer(
                    modifier = modifier.height(18.dp)
                )
                NutritionNeedAdditional(index)
            }
            Spacer(
                modifier = modifier.height(20.dp)
            )
        }
    }
}

@Composable
fun NutritionNeedAdditional(index: Int) {
    val nutritionItems = NutritionDataSource.nutritionItem
    val fluidItems = FluidsDataSource.fluidItems
    val columnNut1Weight = 0.35f
    val columnNut2Weight = 0.65f
    val columnFluid1Weight = 0.28f
    val columnFluid2Weight = 0.36f
    val columnFluid3Weight = 0.72f
    when (index) {
        3 -> {
            Text(
                text = "Makanan Sumber Vitamin dan Mineral",
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
            Row(Modifier.background(DarkYellow)) {
                TableCell(text = "Zat Gizi", columnNut1Weight)
                TableCell(text = "Sumber Makanan", columnNut2Weight)
            }
            nutritionItems.forEach{ item ->
                Row(Modifier.fillMaxWidth()) {
                    TableCell(text = item.nutrition, columnNut1Weight)
                    TableCell(text = item.source, columnNut2Weight)
                }
            }
        }
        4 -> {
            Row(Modifier.background(DarkYellow)) {
                TableCell(text = "Usia", columnFluid1Weight)
                TableCell(text = "Laki - Laki", columnFluid2Weight)
                TableCell(text = "Perempuan", columnFluid2Weight)
            }
            fluidItems.forEach { item ->
                val index = fluidItems.indexOf(item)
                Row(Modifier.fillMaxWidth()) {
                    TableCell(text = item.age, columnFluid1Weight)
                    if (index <= 3) {
                        TableCellCenter(
                            text = item.male, weight = columnFluid3Weight,
                        )
                    } else {
                        TableCell(text = item.male, columnFluid2Weight)
                        TableCell(text = item.female, columnFluid2Weight)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NutritionNeedsPreview() {
    PedionutricareTheme {
        NutritionNeedsScreen()
    }
}

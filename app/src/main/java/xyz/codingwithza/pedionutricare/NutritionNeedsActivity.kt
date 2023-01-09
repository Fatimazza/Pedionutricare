package xyz.codingwithza.pedionutricare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.codingwithza.pedionutricare.model.Needs
import xyz.codingwithza.pedionutricare.model.NeedsDataSource
import xyz.codingwithza.pedionutricare.model.NutritionDataSource
import xyz.codingwithza.pedionutricare.ui.components.TableCell
import xyz.codingwithza.pedionutricare.ui.theme.DarkYellow
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme
import xyz.codingwithza.pedionutricare.ui.theme.Yellow_Awake

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
fun NutritionNeedsScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(stringResource(R.string.app_name))
        })
    }) {
        val needItems = NeedsDataSource.needItems
        LazyColumn(
            modifier.background(Yellow_Awake)
        ) {
            items(needItems) { data ->
                NutritionNeeds(needItems, data)
            }
        }
    }
}

@Composable
fun NutritionNeeds(
    needItems: List<Needs>,
    data: Needs,
    modifier: Modifier = Modifier
) {
    val index = needItems.indexOf(data)
    Card(
        modifier = modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier.padding(8.dp)
        ){
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
                NutritionNeedAdditional(index)
            }
            Spacer(
                modifier = modifier.height(20.dp)
            )
        }
    }
}

@Composable
fun NutritionNeedAdditional(
    index: Int,
    modifier: Modifier = Modifier
) {
    val nutritionItems = NutritionDataSource.nutritionItem
    val columnNut1Weight = 0.35f
    val columnNut2Weight = 0.65f
    when (index) {
        3 -> {
            Spacer(
                modifier = modifier.height(18.dp)
            )
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
            val painter  = painterResource(id = R.drawable.table_liquid)
            Image(
                painter = painter,
                contentDescription = "Tabel Kebutuhan Cairan",
                modifier = modifier
                    .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
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

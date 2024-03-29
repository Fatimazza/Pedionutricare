package xyz.codingwithza.pedionutricare

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
    }) { innerPadding ->
        val context = LocalContext.current
        ActivityInfo.SCREEN_ORIENTATION_PORTRAIT.also {
            (context as? Activity)?.requestedOrientation = it
        }

        val needItems = NeedsDataSource.needItems
        LazyColumn(
            modifier
                .padding(innerPadding)
                .background(Yellow_Awake)
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
        ) {
            Text(
                text = data.title,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Spacer(
                modifier = modifier.height(20.dp)
            )
            Text(
                text = data.desc,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
            NutritionNeedAdditional(index)
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
        0 -> {
            val painter = painterResource(id = R.drawable.img_carbo)
            Image(
                painter = painter,
                contentDescription = stringResource(R.string.daily_carbo_desc),
                modifier = modifier
                    .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
        }

        1 -> {
            val painter = painterResource(id = R.drawable.img_protein)
            Image(
                painter = painter,
                contentDescription = stringResource(R.string.daily_protein_desc),
                modifier = modifier
                    .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
        }

        2 -> {
            val painter = painterResource(id = R.drawable.img_fat)
            Image(
                painter = painter,
                contentDescription = stringResource(R.string.daily_fat_desc),
                modifier = modifier
                    .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
        }

        3 -> {
            Spacer(
                modifier = modifier.height(18.dp)
            )
            Text(
                text = stringResource(R.string.daily_vitamin_mineral_desc),
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
            Row(Modifier.background(DarkYellow)) {
                TableCell(text = stringResource(R.string.daily_nutrition_column), columnNut1Weight)
                TableCell(text = stringResource(R.string.daily_food_column), columnNut2Weight)
            }
            nutritionItems.forEach { item ->
                Row(Modifier.fillMaxWidth()) {
                    TableCell(text = item.nutrition, columnNut1Weight)
                    TableCell(text = item.source, columnNut2Weight)
                }
            }
        }

        4 -> {
            val painter = painterResource(id = R.drawable.table_liquid)
            Image(
                painter = painter,
                contentDescription = stringResource(R.string.daily_needs_fluid),
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

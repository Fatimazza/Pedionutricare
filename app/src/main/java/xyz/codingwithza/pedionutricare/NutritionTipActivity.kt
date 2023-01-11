package xyz.codingwithza.pedionutricare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.codingwithza.pedionutricare.model.Tip
import xyz.codingwithza.pedionutricare.model.TipDataSource
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme
import xyz.codingwithza.pedionutricare.ui.theme.Yellow_Awake

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
fun NutritionTipScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(stringResource(R.string.app_name))
        })
    }) {
        val tipItems = TipDataSource.tipItems
        LazyColumn(
            modifier.background(Yellow_Awake)
        ) {
            items(tipItems) { data ->
                NutritionTip(tipItems, data)
            }
        }
    }
}

@Composable
fun NutritionTip(
    tipItems: List<Tip>,
    data: Tip,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column() {
            Text(
                text = data.title,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            if (data.desc.isNotEmpty()) {
                Text(
                    text = data.desc,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    lineHeight = 25.sp,
                )
            }
            Text(
                text = data.point,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                lineHeight = 25.sp
            )
            Spacer(
                modifier = modifier.height(20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NutritionTipPreview() {
    PedionutricareTheme {
        NutritionTipScreen()
    }
}

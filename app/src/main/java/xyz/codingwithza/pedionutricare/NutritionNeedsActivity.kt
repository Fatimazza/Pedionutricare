package xyz.codingwithza.pedionutricare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
    when (index) {
        3 -> {
            Text(
                text = "Something",
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
        }
        4 -> {
            Text(
                text = "Something Lagi",
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
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

package xyz.codingwithza.pedionutricare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.codingwithza.pedionutricare.model.ExchangeFood
import xyz.codingwithza.pedionutricare.model.ExchangeFoodDataSource
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
        val exchangedItems = ExchangeFoodDataSource.exchangedItems
        LazyColumn(
            modifier = Modifier.background(MaterialTheme.colors.background)
        ) {
            items(exchangedItems) { data ->
                FoodExchangedItem(exchangedItems, data)
            }
        }
    }
}

@Composable
fun FoodExchangedItem(
    needItems: List<ExchangeFood>,
    data: ExchangeFood,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = data.title,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
private fun FoodExchangedButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

}

@Preview(showBackground = true)
@Composable
fun FoodExchangedPreview() {
    PedionutricareTheme {
        FoodExchangedScreen()
    }
}

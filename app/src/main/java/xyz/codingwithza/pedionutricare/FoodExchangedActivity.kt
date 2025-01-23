package xyz.codingwithza.pedionutricare

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import xyz.codingwithza.pedionutricare.model.ExchangeFood
import xyz.codingwithza.pedionutricare.model.ExchangeFoodDataSource
import xyz.codingwithza.pedionutricare.model.ExchangeFoodImage
import xyz.codingwithza.pedionutricare.ui.theme.DarkGray
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme
import xyz.codingwithza.pedionutricare.ui.theme.Yellow
import xyz.codingwithza.pedionutricare.ui.theme.Yellow_Awake
import xyz.codingwithza.pedionutricare.ui.theme.Yellow_Deep

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
fun FoodExchangedScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(stringResource(R.string.app_name))
            })
        },
    ) { innerPadding ->
        val context = LocalContext.current
        ActivityInfo.SCREEN_ORIENTATION_PORTRAIT.also {
            (context as? Activity)?.requestedOrientation = it
        }

        val exchangedItems = ExchangeFoodDataSource.exchangedItems
        LazyColumn(
            modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Yellow_Awake)
        ) {
            items(exchangedItems) { data ->
                FoodExchangedItem(data)
            }
        }
    }
}

@Composable
fun FoodExchangedItem(
    data: ExchangeFood,
    modifier: Modifier = Modifier,
    darkTheme: Boolean = isSystemInDarkTheme()
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier.padding(8.dp),
        elevation = 4.dp,
        backgroundColor = if (darkTheme) Yellow else MaterialTheme.colors.surface
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    color = DarkGray,
                    text = stringResource(id = data.title),
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(Modifier.weight(1f))
                FoodExchangedButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                    darkTheme = darkTheme
                )
            }
            if (expanded) {
                ExchangedFoodDesc(data.images)
            }
        }
    }
}

@Composable
fun ExchangedFoodDesc(
    images: List<ExchangeFoodImage>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        images.forEach { image ->
            val painter = painterResource(id = image.image)
            Image(
                painter = painter,
                contentDescription = stringResource(R.string.exchanged_food_image_desc),
                modifier = modifier
                    .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Composable
private fun FoodExchangedButton(
    expanded: Boolean,
    onClick: () -> Unit,
    darkTheme: Boolean
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess
            else Icons.Filled.ExpandMore,
            tint = if (darkTheme) DarkGray else Yellow_Deep,
            contentDescription = stringResource(R.string.exchanged_food_expand_button)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FoodExchangedPreview() {
    PedionutricareTheme {
        FoodExchangedScreen()
    }
}

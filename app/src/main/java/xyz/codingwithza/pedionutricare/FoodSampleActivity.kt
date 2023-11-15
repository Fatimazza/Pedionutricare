package xyz.codingwithza.pedionutricare

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import xyz.codingwithza.pedionutricare.datastore.StoreUserData
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme
import xyz.codingwithza.pedionutricare.ui.theme.Yellow_Awake

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
fun FoodSampleScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(stringResource(R.string.app_name))
        })
    }) { innerPadding ->
        LazyColumn(
            modifier
                .padding(innerPadding)
                .background(Yellow_Awake)
        ) {
            item {
                FoodSample()
            }
        }
    }
}

@Composable
fun FoodSample(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val dataStore = StoreUserData(context)

    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT.also {
        (context as? Activity)?.requestedOrientation = it
    }

    val userName = dataStore
        .getUserName.collectAsState(initial = "Hero")
    val userAge = dataStore
        .getUserAge.collectAsState(initial = 1)

    Card(
        modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier.padding(4.dp)
        ) {
            Spacer(
                modifier = modifier.height(16.dp)
            )
            Text(
                text = stringResource(R.string.sample_name, userName.value),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                modifier = modifier.fillMaxWidth(),
            )
            Text(
                text = stringResource(R.string.sample_age, userAge.value),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                modifier = modifier.fillMaxWidth(),
            )
            Spacer(
                modifier = modifier.height(16.dp)
            )
            Text(
                text = stringResource(R.string.sample_menu_titile, stringResource(id = getFoodTitle(userAge.value))),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = modifier.fillMaxWidth(),
            )
            Spacer(
                modifier = modifier.height(4.dp)
            )
            val painter = painterResource(getFoodImage(userAge.value))
            Image(
                painter = painter,
                contentDescription = stringResource(R.string.sample_image_desc),
                modifier = modifier
                    .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
        }
    }
}

fun getFoodImage(age: Int): Int {
    return when (age) {
        in 0..6 -> R.drawable.img_sample_1ke6
        in 7..9 -> R.drawable.img_sample_7ke9
        in 10..12 -> R.drawable.img_sample_10ke12
        else -> R.drawable.img_sample_13ke18
    }
}

fun getFoodTitle(age: Int): Int {
    return when (age) {
        in 0..6 -> R.string.sample_1_to_6
        in 7..9 -> R.string.sample_7_to_9
        in 10..12 -> R.string.sample_10_to_12
        else -> R.string.sample_13_to_18
    }
}

@Preview(showBackground = true)
@Composable
fun FoodSamplePreview() {
    PedionutricareTheme {
        FoodSampleScreen()
    }
}

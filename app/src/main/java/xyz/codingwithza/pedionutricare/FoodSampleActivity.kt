package xyz.codingwithza.pedionutricare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
    val context = LocalContext.current
    val dataStore = StoreUserData(context)

    val userName = dataStore
        .getUserName.collectAsState(initial = "")
    val userAge = dataStore
        .getUserAge.collectAsState(initial = 0)

    LazyColumn(
        modifier.padding(16.dp)
    ) {
        item {
            Text(
                text = "Halo ${userName.value}!",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = modifier.fillMaxWidth(),
            )
            Text(
                text = "Contoh Menu Usia ${userAge.value} tahun",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = modifier.fillMaxWidth(),
            )
            Spacer(
                modifier = modifier.height(16.dp)
            )
            val painter = painterResource(id = R.drawable.img_sample_1ke6)
            Image(
                painter = painter,
                contentDescription = "Exchanged Food Image",
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
fun FoodSamplePreview() {
    PedionutricareTheme {
        FoodSampleScreen()
    }
}

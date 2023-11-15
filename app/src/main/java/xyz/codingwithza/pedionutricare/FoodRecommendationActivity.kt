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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import xyz.codingwithza.pedionutricare.model.Recommendation
import xyz.codingwithza.pedionutricare.model.RecommendationDataSource
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme
import xyz.codingwithza.pedionutricare.ui.theme.Yellow_Awake

class FoodRecommendationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PedionutricareTheme {
                FoodRecommendationScreen()
            }
        }
    }
}

@Composable
fun FoodRecommendationScreen(
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
        LazyColumn(
            modifier
                .padding(innerPadding)
                .background(Yellow_Awake)
        ) {
            val recomItems = RecommendationDataSource.recommendationItems
            items(recomItems) { data ->
                FoodRecommendation(data)
            }
        }
    }
}

@Composable
fun FoodRecommendation(
    data: Recommendation,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                text = data.title,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = modifier.padding(8.dp)
            )
            Spacer(
                modifier = modifier.height(20.dp)
            )
            Row(
                modifier = modifier.padding(
                    start = 8.dp,
                    top = 0.dp,
                    bottom = 0.dp,
                    end = 0.dp
                )
            ) {
                Image(
                    painterResource(R.drawable.ic_check),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = modifier.size(32.dp)
                )
                Text(
                    text = " Dianjurkan:",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    lineHeight = 30.sp
                )
            }
            Text(
                text = data.recommended,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                lineHeight = 25.sp,
                modifier = modifier.padding(8.dp)
            )
            Row(
                modifier = modifier.padding(
                    start = 8.dp,
                    top = 0.dp,
                    bottom = 0.dp,
                    end = 0.dp
                )
            ) {
                Image(
                    painterResource(R.drawable.ic_not),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = modifier.size(32.dp)
                )
                Text(
                    text = " Tidak Dianjurkan:",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    lineHeight = 30.sp,
                )
            }
            Text(
                text = data.notrecommended,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                lineHeight = 25.sp,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodRecommendationPreview() {
    PedionutricareTheme {
        FoodRecommendationScreen()
    }
}

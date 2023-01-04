package xyz.codingwithza.pedionutricare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    LazyColumn(
        modifier.padding(16.dp)
    ) {
        
    }
}

@Preview(showBackground = true)
@Composable
fun FoodSamplePreview() {
    PedionutricareTheme {
        FoodSampleScreen()
    }
}

package xyz.codingwithza.pedionutricare

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme

class DailyNeedsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PedionutricareTheme {
                DailyNeedsScreen()
            }
        }
    }
}

@Composable
fun DailyNeedsScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.app_name))
                }
            )
        }
    ) {
        val context = LocalContext.current
        ActivityInfo.SCREEN_ORIENTATION_PORTRAIT.also { (context as? Activity)?.requestedOrientation = it }

        DailyNeeds()
    }
}

@Composable
fun DailyNeeds() {

}

@Preview(showBackground = true)
@Composable
fun DailyNeedsPreview() {
    PedionutricareTheme {
        DailyNeedsScreen()
    }
}

package xyz.codingwithza.pedionutricare

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.codingwithza.pedionutricare.ui.theme.DarkGray
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme
import xyz.codingwithza.pedionutricare.ui.theme.Yellow_Awake
import xyz.codingwithza.pedionutricare.ui.theme.Yellow_Deep

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
fun DailyNeedsScreen() {
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
fun DailyNeeds(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Yellow_Awake)
            .padding(8.dp, 8.dp),
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "20 Kg") },
            label = { Text("Berat Badan") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Yellow_Deep,
                unfocusedBorderColor = DarkGray,
                focusedLabelColor = Yellow_Deep
            ),
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Yellow_Deep
            )
        ) {
            Text(text = "Lihat Hasil", textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DailyNeedsPreview() {
    PedionutricareTheme {
        DailyNeedsScreen()
    }
}

package xyz.codingwithza.pedionutricare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PedionutricareTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp, 16.dp),
    ) {
        Text(
            text = "Selamat Datang di",
            style = MaterialTheme.typography.h5,
            modifier = modifier.padding(4.dp)
        )
        Text(
            text = "Pedionutricare",
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Light,
            modifier = modifier.padding(8.dp)
        )
        Spacer(
            modifier = modifier.height(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    PedionutricareTheme {
        LoginScreen()
    }
}

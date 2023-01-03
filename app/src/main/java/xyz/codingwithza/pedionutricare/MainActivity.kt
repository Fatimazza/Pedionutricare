package xyz.codingwithza.pedionutricare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PedionutricareTheme {
                PedionutricareApp()
            }
        }
    }
}

@Composable
fun PedionutricareApp() {

}

@Preview(showBackground = true)
@Composable
fun PedionutricarePreview() {
    PedionutricareTheme {
        PedionutricareApp()
    }
}

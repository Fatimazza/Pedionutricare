package xyz.codingwithza.pedionutricare

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.codingwithza.pedionutricare.model.MenuDataSource
import xyz.codingwithza.pedionutricare.ui.components.ButtonImageMenu
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
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.app_name))
                }
            )
        }
    ) {
        MainContent()
    }
}

@Composable
fun MainContent(
    modifier: Modifier = Modifier
) {
    val menuItems = MenuDataSource.menuItems
    val context = LocalContext.current

    LazyColumn(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        items(menuItems) { data ->
            ButtonImageMenu(image = data.image, title = data.title, onClick = { openOtherScreen(data.id, context)})
        }
    }
}

fun openOtherScreen(id: Long, context: Context) {
    Toast.makeText(context, "Menu $id clicked", Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true)
@Composable
fun PedionutricarePreview() {
    PedionutricareTheme {
        PedionutricareApp()
    }
}

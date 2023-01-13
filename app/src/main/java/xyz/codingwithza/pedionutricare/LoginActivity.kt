package xyz.codingwithza.pedionutricare

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import xyz.codingwithza.pedionutricare.datastore.StoreUserData
import xyz.codingwithza.pedionutricare.ui.theme.DarkGray
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme
import xyz.codingwithza.pedionutricare.ui.theme.Yellow_Awake
import xyz.codingwithza.pedionutricare.ui.theme.Yellow_Deep

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
    val name = rememberSaveable { mutableStateOf("") }
    val age = rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current
    val dataStore = StoreUserData(context)
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Yellow_Awake)
            .padding(8.dp, 8.dp),
    ) {
        Text(
            text = "Selamat Datang di",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Pedionutricare",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Light,
            modifier = modifier.padding(8.dp)
        )
        val painter = painterResource(R.drawable.img_app_logo_pedionutricare)
        Image(
            painter = painter,
            contentDescription = "PedioNutriCare Logo",
            modifier = modifier
                .size(250.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(
            modifier = modifier.height(8.dp)
        )
        OutlinedTextField(
            value = name.value,
            onValueChange = { value ->
                if (value.length <= 25) {
                    name.value = value
                        .filter { it.isLetter().or(it.isWhitespace()) }
                }
            },
            placeholder = { Text(text = "Nama Anda") },
            label = { Text("Masukkan Nama") },
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
        OutlinedTextField(
            value = age.value,
            onValueChange = { value ->
                if (value.length <= 2) {
                    age.value = value.filter { it.isDigit() }
                }
            },
            placeholder = { Text(text = "10 Tahun") },
            label = { Text("Masukkan Umur") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Yellow_Deep,
                unfocusedBorderColor = DarkGray,
                focusedLabelColor = Yellow_Deep
            ),
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                scope.launch {
                    val storedName =
                        name.value.ifEmpty { "Hero" }
                    val storedAge =
                        if (age.value.isNotEmpty()) age.value.toInt() else 1
                    dataStore.saveUserName(storedName)
                    dataStore.saveUserAge(storedAge)
                }
                context.startActivity(
                    Intent(context, MainActivity::class.java)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Yellow_Deep
            )
        ) {
            Text(text = "Masuk", textAlign = TextAlign.Center)
        }
        val userName = dataStore
            .getUserName.collectAsState(initial = "Hero")
        val userAge = dataStore
            .getUserAge.collectAsState(initial = 1)
        Text(text = userName.value)
        Text(text = userAge.value.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    PedionutricareTheme {
        LoginScreen()
    }
}

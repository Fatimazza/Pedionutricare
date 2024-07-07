package xyz.codingwithza.pedionutricare

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
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
    val focusManager = LocalFocusManager.current
    val dataStore = StoreUserData(context)
    val scope = rememberCoroutineScope()

    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT.also {
        (context as? Activity)?.requestedOrientation = it
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Yellow_Awake)
            .padding(8.dp, 8.dp),
    ) {
        Text(
            text = stringResource(R.string.login_welcome),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Light,
            modifier = modifier.padding(8.dp)
        )
        val painter = painterResource(R.drawable.img_app_logo_pedionutricare)
        Image(
            painter = painter,
            contentDescription = stringResource(R.string.app_name),
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
            placeholder = { Text(text = stringResource(R.string.login_name_placeholder)) },
            label = { Text(stringResource(R.string.login_name)) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Yellow_Deep,
                unfocusedBorderColor = DarkGray,
                focusedLabelColor = Yellow_Deep
            ),
            maxLines = 1,
            singleLine = true,
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = age.value,
            onValueChange = { value ->
                val ageLength = if (value.isNotEmpty() && value.first() in '0'..'1') 2 else 1
                if (value.length <= ageLength) {
                    age.value = value.filter { it.isDigit() }
                }
            },
            placeholder = { Text(text = stringResource(R.string.login_age_placeholder)) },
            label = { Text(stringResource(R.string.login_age)) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Yellow_Deep,
                unfocusedBorderColor = DarkGray,
                focusedLabelColor = Yellow_Deep
            ),
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
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
            Text(text = stringResource(R.string.login_button), textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    PedionutricareTheme {
        LoginScreen()
    }
}

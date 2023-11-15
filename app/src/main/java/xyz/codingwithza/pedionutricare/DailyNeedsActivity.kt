package xyz.codingwithza.pedionutricare

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.compose.ui.unit.sp
import xyz.codingwithza.pedionutricare.datastore.StoreUserData
import xyz.codingwithza.pedionutricare.ui.theme.DarkGray
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme
import xyz.codingwithza.pedionutricare.ui.theme.Yellow_Awake
import xyz.codingwithza.pedionutricare.ui.theme.Yellow_Deep
import kotlin.math.roundToInt

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
    ) { innerPadding ->
        val context = LocalContext.current
        ActivityInfo.SCREEN_ORIENTATION_PORTRAIT.also {
            (context as? Activity)?.requestedOrientation = it
        }

        LazyColumn(
            modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Yellow_Awake)
        ) {
            item {
                DailyNeeds(context)
            }
        }
    }
}

@Composable
fun DailyNeeds(
    context: Context,
    modifier: Modifier = Modifier
) {
    val dataStore = StoreUserData(context)
    val userName = dataStore
        .getUserName.collectAsState(initial = "Hero")
    val userAge = dataStore
        .getUserAge.collectAsState(initial = 1)

    val focusManager = LocalFocusManager.current

    var weight by remember { mutableStateOf("") }
    val genderOptions = listOf(
        stringResource(R.string.daily_gender_male),
        stringResource(R.string.daily_gender_female)
    )
    var simpleGender by remember { mutableStateOf(genderOptions[0]) }
    var isGenderFemale by remember { mutableStateOf(false) }
    var isSimpleDropDownExpanded by remember { mutableStateOf(false) }
    var isResultCardVisible by remember { mutableStateOf(false) }

    var chosenWeight by remember { mutableDoubleStateOf(0.0) }
    var energy by remember { mutableIntStateOf(0) }
    var protein by remember { mutableIntStateOf(0) }
    var fat by remember { mutableIntStateOf(0) }
    var carbo by remember { mutableIntStateOf(0) }

    Card(
        modifier = modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp, 8.dp),
        ) {
            Spacer(
                modifier = modifier.height(16.dp)
            )
            Text(
                text = stringResource(R.string.daily_name, userName.value),
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .fillMaxWidth()
            )
            Spacer(
                modifier = modifier.height(8.dp)
            )
            Text(
                text = stringResource(R.string.daily_age, userAge.value),
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .fillMaxWidth()
            )
            Spacer(
                modifier = modifier.height(10.dp)
            )
            Box {
                OutlinedTextField(
                    value = simpleGender,
                    onValueChange = { },
                    placeholder = { Text(text = stringResource(R.string.daily_gender_placeholder)) },
                    label = { Text(stringResource(R.string.daily_gender)) },
                    enabled = false,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        disabledTextColor = LocalContentColor
                            .current.copy(LocalContentAlpha.current),
                        disabledBorderColor = MaterialTheme
                            .colors.onSurface.copy(alpha = ContentAlpha.high),
                        disabledLabelColor = MaterialTheme
                            .colors.onSurface.copy(ContentAlpha.medium),
                    ),
                    modifier = Modifier
                        .clickable {
                            isSimpleDropDownExpanded = true
                        }
                        .padding(16.dp, 0.dp, 16.dp, 0.dp)
                        .fillMaxWidth()
                )
                DropdownMenu(
                    expanded = isSimpleDropDownExpanded,
                    onDismissRequest = { isSimpleDropDownExpanded = false },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    genderOptions.forEach {
                        DropdownMenuItem(
                            onClick = {
                                simpleGender = it
                                isSimpleDropDownExpanded = false
                                isResultCardVisible = false
                            }, modifier = Modifier
                                .wrapContentWidth()
                        ) { Text(it) }
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = weight,
                onValueChange = { value ->
                    if (value.length <= 4) {
                        weight = value.takeIf { it.contains(",") }
                            ?.replace(",", ".") ?: value.takeIf { it.contains("-") }
                            ?.replace("-", "") ?: value.takeIf { it.contains(" ") }
                            ?.replace(" ", "") ?: value
                    }
                    isResultCardVisible = false
                },
                placeholder = { Text(text = stringResource(R.string.daily_weight_placeholder)) },
                label = { Text(stringResource(R.string.daily_weight)) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Yellow_Deep,
                    unfocusedBorderColor = DarkGray,
                    focusedLabelColor = Yellow_Deep
                ),
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    isResultCardVisible = true
                    isGenderFemale = simpleGender == genderOptions[1]
                    chosenWeight = if (weight.isNotEmpty())
                        weight.toDouble() else 0.0
                    energy = getEnergyByBMR(userAge.value, chosenWeight, isGenderFemale).toInt()
                    protein = (((12.0 / 100) * energy) / 4).roundToInt()
                    fat = (((25.0 / 100) * energy) / 9).roundToInt()
                    carbo = (((63.0 / 100) * energy) / 4).roundToInt()
                    focusManager.clearFocus()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Yellow_Deep
                )
            ) {
                Text(
                    text = stringResource(R.string.daily_result_button),
                    textAlign = TextAlign.Center
                )
            }
        }
    }

    AnimatedVisibility(
        visible = isResultCardVisible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Card(
            modifier = modifier.padding(8.dp),
            elevation = 4.dp,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = modifier
                    .fillMaxSize()
                    .padding(8.dp, 8.dp),
            ) {
                Spacer(
                    modifier = modifier.height(16.dp)
                )
                Text(
                    text = stringResource(R.string.daily_nutrition_needs),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(
                    modifier = modifier.height(18.dp)
                )
                Text(
                    text = stringResource(R.string.daily_energy_and_protein, energy, protein),
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp
                )
                Spacer(
                    modifier = modifier.height(8.dp)
                )
                Text(
                    text = stringResource(R.string.daily_fat_and_carbo, fat, carbo),
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp
                )
                Spacer(
                    modifier = modifier.height(18.dp)
                )
                Text(
                    text = stringResource(R.string.daily_needs_a_day),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier.fillMaxWidth(),
                )
                Spacer(
                    modifier = modifier.height(8.dp)
                )
                val painter = painterResource(getDailyImage(energy))
                Image(
                    painter = painter,
                    contentDescription = stringResource(R.string.daily_needs_image),
                    modifier = modifier
                        .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height)
                        .fillMaxWidth()
                        .padding(8.dp, 0.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

fun getDailyImage(energy: Int): Int {
    return when (energy) {
        in 0..1000 -> R.drawable.img_eng_1000
        in 1001..1250 -> R.drawable.img_eng_1251
        in 1251..1500 -> R.drawable.img_eng_1500
        in 1501..1750 -> R.drawable.img_eng_1750
        in 1751..2000 -> R.drawable.img_eng_2000
        else -> R.drawable.img_eng_more_2000
    }
}

fun getEnergyByBMR(age: Int, weight: Double, isFemale: Boolean): Number {
    val additionalFactor16 = 1.6
    val additionalFactor14 = 1.4
    return when (age) {
        in 0..2 ->
            if (isFemale)
                ((61 * weight - 51) * additionalFactor16)
            else
                ((60.9 * weight - 54) * additionalFactor16)

        in 3..9 ->
            if (isFemale)
                ((22.5 * weight + 499) * additionalFactor16)
            else
                ((22.7 * weight + 495) * additionalFactor16)

        else ->
            if (isFemale)
                ((12.2 * weight + 746) * additionalFactor14)
            else
                ((17.5 * weight + 651) * additionalFactor14)
    }
}

@Preview(showBackground = true)
@Composable
fun DailyNeedsPreview() {
    PedionutricareTheme {
        DailyNeedsScreen()
    }
}

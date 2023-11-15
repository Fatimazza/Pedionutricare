package xyz.codingwithza.pedionutricare

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.codingwithza.pedionutricare.model.Tip
import xyz.codingwithza.pedionutricare.model.TipDataSource
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme
import xyz.codingwithza.pedionutricare.ui.theme.Yellow_Awake
import xyz.codingwithza.pedionutricare.ui.theme.Yellow_Deep

class NutritionTipActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PedionutricareTheme {
                NutritionTipScreen()
            }
        }
    }
}

@Composable
fun NutritionTipScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(stringResource(R.string.app_name))
        })
    }) { innerPadding ->
        val context = LocalContext.current
        ActivityInfo.SCREEN_ORIENTATION_PORTRAIT.also { (context as? Activity)?.requestedOrientation = it }

        val tipItems = TipDataSource.tipItems
        LazyColumn(
            modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Yellow_Awake)
        ) {
            items(tipItems) { data ->
                NutritionTip(tipItems, data)
            }
        }
    }
}

@Composable
fun NutritionTip(
    tipItems: List<Tip>,
    data: Tip,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data.title,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.weight(1f))
                NutritionTipButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }
            if (expanded) {
                NutritionTipDesc(data)
            }
        }
    }
}

@Composable
fun NutritionTipDesc(
    data: Tip,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        if (data.desc.isNotEmpty()) {
            Text(
                text = data.desc,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                lineHeight = 25.sp,
            )
        }
        Text(
            text = data.point,
            textAlign = TextAlign.Justify,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            lineHeight = 25.sp
        )
        Spacer(
            modifier = modifier.height(20.dp)
        )
    }
}

@Composable
private fun NutritionTipButton(
    expanded: Boolean,
    onClick: () -> Unit,
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess
            else Icons.Filled.ExpandMore,
            tint = Yellow_Deep,
            contentDescription = "Nutrition Tip Expand Button"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NutritionTipPreview() {
    PedionutricareTheme {
        NutritionTipScreen()
    }
}

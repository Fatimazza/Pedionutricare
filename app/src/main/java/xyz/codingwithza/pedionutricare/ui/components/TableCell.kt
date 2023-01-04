package xyz.codingwithza.pedionutricare.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.codingwithza.pedionutricare.ui.theme.DarkYellow

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float
) {
    Text(
        text = text,
        Modifier
            .border(1.dp, DarkYellow)
            .weight(weight)
            .padding(8.dp),
        fontSize = 20.sp
    )
}

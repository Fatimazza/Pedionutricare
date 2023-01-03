package xyz.codingwithza.pedionutricare.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import xyz.codingwithza.pedionutricare.R
import xyz.codingwithza.pedionutricare.ui.theme.PedionutricareTheme

@Composable
fun ButtonImageMenu(
    image: Int,
    title: String,
    onClick: () -> Unit,
) {
    Button(onClick = onClick) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = title
            )
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                lineHeight = 30.sp,
                maxLines = 2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonImagePreview() {
    PedionutricareTheme {
        ButtonImageMenu(
            R.drawable.ic_launcher_foreground,
            "This is Menu Long Menu Long 2",
            onClick = {})
    }
}

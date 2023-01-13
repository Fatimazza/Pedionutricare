package xyz.codingwithza.pedionutricare.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = DarkYellow,
    primaryVariant = Yellow_Deep,
    secondary = DarkGray
)

private val LightColorPalette = lightColors(
    primary = Yellow,
    primaryVariant = Yellow_Deep,
    secondary = White
)

@Composable
fun PedionutricareTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = if (darkTheme) DarkGray else Yellow
    )
    systemUiController.setStatusBarColor(
        color = if (darkTheme) DarkGray else Yellow
    )
}

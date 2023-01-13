package xyz.codingwithza.pedionutricare.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val DarkYellowColorPalette = darkColors(
    primary = DarkYellow,
    primaryVariant = Yellow_Deep,
    secondary = DarkGray
)

private val LightYellowColorPalette = lightColors(
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
        DarkYellowColorPalette
    } else {
        LightYellowColorPalette
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

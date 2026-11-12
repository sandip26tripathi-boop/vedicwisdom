package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = ImperialGold,
    onPrimary = LuxuryMidnightBlack,
    primaryContainer = LuxuryCardDark,
    onPrimaryContainer = ImperialGoldLight,
    secondary = ImperialGoldDark,
    onSecondary = CleanAlabasterWhite,
    secondaryContainer = LuxuryCardElevated,
    onSecondaryContainer = ImperialGoldLight,
    tertiary = ImperialGoldLight,
    background = LuxuryMidnightBlack,
    onBackground = CleanAlabasterWhite,
    surface = LuxuryCardDark,
    onSurface = CleanAlabasterWhite,
    surfaceVariant = LuxuryCardElevated,
    onSurfaceVariant = WarmIvoryMuted,
    outline = LuxuryCardBorder,
    outlineVariant = BorderSubtle
)

private val LightColorScheme = lightColorScheme(
    primary = ImperialGold,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFDF8EC),
    onPrimaryContainer = Color(0xFF8A6826),
    secondary = ImperialGoldDark,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFF1F5F9),
    onSecondaryContainer = Color(0xFF0F172A),
    tertiary = ImperialGoldLight,
    background = Color(0xFFFAF9F6),
    onBackground = Color(0xFF0F172A),
    surface = Color.White,
    onSurface = Color(0xFF0F172A),
    surfaceVariant = Color(0xFFF8FAFC),
    onSurfaceVariant = Color(0xFF64748B),
    outline = Color(0x4DC5A059),
    outlineVariant = Color(0xFFE2E8F0)
)

@Composable
fun VedicWisdomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

package com.example.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.AppScreen
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderNav(
    currentScreen: AppScreen,
    language: AppLanguage,
    onLanguageToggle: () -> Unit,
    onNavigate: (AppScreen) -> Unit,
    modifier: Modifier = Modifier
) {
    var isDrawerOpen by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(ForestGreenPrimary)
            .border(
                width = 1.dp,
                brush = Brush.verticalGradient(
                    colors = listOf(ChampagneGold.copy(alpha = 0.3f), Color.Transparent)
                ),
                shape = RectangleShape
            )
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Brand Logo & Name
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { onNavigate(AppScreen.HOME) }
                    .padding(4.dp)
                    .testTag("brand_logo_button")
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = ChampagneGold,
                    modifier = Modifier.size(36.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Explore,
                            contentDescription = "Vedic Wisdom Logo",
                            tint = ForestGreenPrimary,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "VEDIC WISDOM",
                        style = TextStyle(
                            fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp,
                            color = ChampagneGold,
                            letterSpacing = 1.sp
                        )
                    )
                    Text(
                        text = if (language == AppLanguage.EN) "CONSULTANCY & RESEARCH" else "परामर्श एवं अनुसंधान",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 9.sp,
                            color = WarmIvory.copy(alpha = 0.8f),
                            letterSpacing = 0.5.sp
                        )
                    )
                }
            }

            // Right Actions: Language Switcher, Portal, Book CTA & Hamburger
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Language Switcher Toggle
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = ForestGreenSecondary,
                    border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold.copy(alpha = 0.4f)),
                    modifier = Modifier
                        .clickable { onLanguageToggle() }
                        .testTag("language_toggle_button")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Language,
                            contentDescription = "Language",
                            tint = ChampagneGold,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (language == AppLanguage.EN) "EN | हिंदी" else "हिंदी | EN",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = WarmIvory,
                                fontSize = 12.sp
                            )
                        )
                    }
                }

                // Portal Access
                IconButton(
                    onClick = { onNavigate(AppScreen.PORTAL) },
                    modifier = Modifier.testTag("portal_nav_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Portal",
                        tint = ChampagneGold
                    )
                }

                // Primary CTA (Consultation)
                Button(
                    onClick = { onNavigate(AppScreen.BOOK_CONSULTATION) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ChampagneGold,
                        contentColor = ForestGreenPrimary
                    ),
                    shape = RoundedCornerShape(20.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                    modifier = Modifier.testTag("header_book_cta")
                ) {
                    Text(
                        text = if (language == AppLanguage.EN) "BOOK CONSULTATION" else "परामर्श बुक करें",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp
                        )
                    )
                }

                // Hamburger Menu for Full Navigation
                IconButton(
                    onClick = { isDrawerOpen = !isDrawerOpen },
                    modifier = Modifier.testTag("hamburger_menu_button")
                ) {
                    Icon(
                        imageVector = if (isDrawerOpen) Icons.Default.Close else Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = WarmIvory
                    )
                }
            }
        }
    }

    // Full Height Navigation Drawer Modal
    AnimatedVisibility(
        visible = isDrawerOpen,
        enter = fadeIn() + slideInVertically(),
        exit = fadeOut() + slideOutVertically()
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(ForestGreenPrimary),
            color = ForestGreenPrimary
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (language == AppLanguage.EN) "NAVIGATION MENU" else "नेविगेशन मेनू",
                        style = TextStyle(
                            fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
                            color = ChampagneGold,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                    )
                    IconButton(onClick = { isDrawerOpen = false }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close", tint = WarmIvory)
                    }
                }

                HorizontalDivider(color = ChampagneGold.copy(alpha = 0.3f), modifier = Modifier.padding(vertical = 16.dp))

                val navItems = listOf(
                    AppScreen.HOME to (if (language == AppLanguage.EN) "1. Home" else "1. होम"),
                    AppScreen.ABOUT_US to (if (language == AppLanguage.EN) "2. About Us & Leadership" else "2. हमारे बारे में"),
                    AppScreen.VASTU_CONSULTANCY to (if (language == AppLanguage.EN) "3. Vastu Consultancy" else "3. वास्तु परामर्श"),
                    AppScreen.ASTRO_VASTU to (if (language == AppLanguage.EN) "4. Astro-Vastu Consultancy" else "4. एस्ट्रो-वास्तु"),
                    AppScreen.KP_ASTROLOGY to (if (language == AppLanguage.EN) "5. KP Astrology" else "5. केपी ज्योतिष"),
                    AppScreen.VASTU_COMPASS to (if (language == AppLanguage.EN) "6. Vastu Compass & Panchtatva" else "6. वास्तु कंपास एवं पंचतत्व"),
                    AppScreen.ACADEMY to (if (language == AppLanguage.EN) "7. Courses & Academy" else "7. कोर्सेज एवं अकादमिक"),
                    AppScreen.BLOGS to (if (language == AppLanguage.EN) "8. Blogs & Knowledge Hub" else "8. ब्लॉग्स एवं ज्ञान केंद्र"),
                    AppScreen.CLIENT_FEEDBACK to (if (language == AppLanguage.EN) "9. Client Experiences" else "9. क्लाइंट्स के अनुभव"),
                    AppScreen.FAQS to (if (language == AppLanguage.EN) "10. Frequently Asked Questions" else "10. सामान्य प्रश्न (FAQ)"),
                    AppScreen.BOOK_CONSULTATION to (if (language == AppLanguage.EN) "11. Book Consultation" else "11. परामर्श बुक करें"),
                    AppScreen.CONTACT_US to (if (language == AppLanguage.EN) "12. Contact Us & Global Hub" else "12. संपर्क करें एवं वैश्विक केंद्र")
                )

                navItems.forEach { (screen, label) ->
                    val isSelected = currentScreen == screen
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable {
                                isDrawerOpen = false
                                onNavigate(screen)
                            },
                        shape = RoundedCornerShape(12.dp),
                        color = if (isSelected) ForestGreenSecondary else Color.Transparent,
                        border = if (isSelected) androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold) else null
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = label,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    color = if (isSelected) ChampagneGold else WarmIvory,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            if (isSelected) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = null,
                                    tint = ChampagneGold,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Bottom Call to Action in Mobile Menu
                Button(
                    onClick = {
                        isDrawerOpen = false
                        onNavigate(AppScreen.BOOK_CONSULTATION)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = ChampagneGold, contentColor = ForestGreenPrimary),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = if (language == AppLanguage.EN) "BOOK A CONSULTATION" else "परामर्श बुक करें",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
    }
}

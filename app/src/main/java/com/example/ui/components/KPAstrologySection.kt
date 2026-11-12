package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.ui.theme.*

@Composable
fun KPAstrologySection(
    language: AppLanguage,
    onNavigateToBooking: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(WarmIvory)
            .padding(horizontal = 20.dp, vertical = 36.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = ForestGreenPrimary,
            modifier = Modifier.padding(bottom = 12.dp)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Psychology,
                    contentDescription = null,
                    tint = ChampagneGold,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "KRISHNAMURTI PADDHATI (KP SYSTEM)",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = ChampagneGold,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                )
            }
        }

        Text(
            text = if (language == AppLanguage.EN) "KP ASTROLOGY – DETAILED ANALYSIS THROUGH CUSP AND SUB-LORDS" else "केपी ज्योतिष – कस्प एवं सब-लॉर्ड्स के माध्यम से विस्तृत विश्लेषण",
            style = MaterialTheme.typography.displayMedium.copy(
                fontFamily = FontFamily.Serif,
                color = ForestGreenPrimary,
                fontSize = 22.sp
            )
        )

        Text(
            text = if (language == AppLanguage.EN)
                "Krishnamurti Paddhati (KP Astrology) provides a scientific, sub-lord based analytical methodology for precise astrological evaluations."
            else
                "कृष्णमूर्ति पद्धति (केपी ज्योतिष) सटीक ज्योतिषीय मूल्यांकन के लिए एक वैज्ञानिक, सब-लॉर्ड आधारित विश्लेषणात्मक पद्धति प्रदान करती है।",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MutedCharcoal,
                fontSize = 14.sp
            ),
            modifier = Modifier.padding(top = 6.dp, bottom = 20.dp)
        )

        // Services Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = ElegantWhite),
            border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderGold)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = if (language == AppLanguage.EN) "KP Astrology Consultancy Services" else "केपी ज्योतिष परामर्श सेवाएँ",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = FontFamily.Serif,
                        color = ForestGreenPrimary,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                val kpServices = listOf(
                    Pair("KP Birth Chart & Placidus Cusp Analysis", "केपी जन्म कुंडली एवं प्लैसिडस कस्प विश्लेषण"),
                    Pair("Cusp Sub-Lord & Nakshatra Significators", "कस्प सब-लॉर्ड एवं नक्षत्र सूचक"),
                    Pair("Career, Employment & Business Astrology", "करियर, रोजगार एवं व्यावसायिक ज्योतिष"),
                    Pair("Financial & Property Related Timing Analysis", "वित्तीय एवं संपत्ति संबंधी समय विश्लेषण"),
                    Pair("Vimshottari Dasha & Transit Interpretation", "विंशोत्तरी दशा एवं गोचर की व्याख्या"),
                    Pair("Vedic Birth Chart Consultation", "पारंपरिक वैदिक जन्म कुंडली परामर्श")
                )

                kpServices.forEach { (enKp, hiKp) ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint = ChampagneGoldDark,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = if (language == AppLanguage.EN) enKp else hiKp,
                                style = MaterialTheme.typography.bodyMedium.copy(color = SubtleCharcoal, fontWeight = FontWeight.SemiBold)
                            )
                            Text(
                                text = if (language == AppLanguage.EN) hiKp else enKp,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = MutedCharcoal,
                                    fontSize = 11.sp,
                                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                                )
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = WarmIvoryVariant,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = if (language == AppLanguage.EN)
                            "Analytical Note: KP Astrology evaluates event possibilities based on house cusps and planetary significators without exaggerated claims or speculative guarantees."
                        else
                            "विश्लेषणात्मक नोट: केपी ज्योतिष अतिरंजित दावों के बिना भाव कस्प और ग्रह संकेतकों के आधार पर घटनाओं की संभावनाओं का मूल्यांकन करता है।",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MutedCharcoal,
                            fontSize = 11.sp
                        ),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }

        OutlinedButton(
            onClick = onNavigateToBooking,
            border = androidx.compose.foundation.BorderStroke(1.dp, ForestGreenPrimary),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = ForestGreenPrimary),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .testTag("kp_astrology_cta_button")
        ) {
            Text(
                text = if (language == AppLanguage.EN) "BOOK KP ASTROLOGY CONSULTATION" else "केपी ज्योतिष परामर्श बुक करें",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}

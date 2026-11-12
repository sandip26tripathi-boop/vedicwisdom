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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.AppScreen
import com.example.ui.theme.*

@Composable
fun AstroVastuSection(
    language: AppLanguage,
    onNavigateToBooking: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(ForestGreenPrimary)
            .padding(horizontal = 20.dp, vertical = 36.dp)
    ) {
        // Section Badge
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = ForestGreenSecondary,
            border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold),
            modifier = Modifier.padding(bottom = 12.dp)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Stars,
                    contentDescription = null,
                    tint = ChampagneGold,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "ASTROLOGICAL & SPATIAL INTEGRATION",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = ChampagneGold,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                )
            }
        }

        Text(
            text = if (language == AppLanguage.EN) "ASTRO-VASTU CONSULTANCY" else "एस्ट्रो-वास्तु परामर्श",
            style = MaterialTheme.typography.displayMedium.copy(
                fontFamily = FontFamily.Serif,
                color = ChampagneGold,
                fontSize = 24.sp
            )
        )
        Text(
            text = if (language == AppLanguage.EN)
                "Combining Traditional Vastu Principles with Personal Astrological Analysis for Targeted Spatial Harmony."
            else
                "व्यक्तिगत स्थानिक सामंजस्य के लिए व्यक्तिगत ज्योतिषीय विश्लेषण के साथ पारंपरिक वास्तु सिद्धांतों को मिलाना।",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = WarmIvory.copy(alpha = 0.9f),
                fontSize = 14.sp
            ),
            modifier = Modifier.padding(top = 6.dp, bottom = 24.dp)
        )

        // Services Grid / List
        val servicesList = listOf(
            Pair("Personalised Birth Chart-Based Vastu Assessment", "व्यक्तिगत जन्म कुंडली आधारित वास्तु मूल्यांकन"),
            Pair("Individual Planetary Influences on Spatial Energy", "स्थानिक ऊर्जा पर व्यक्तिगत ग्रहों के प्रभाव"),
            Pair("Residential, Commercial & Industrial Astro-Vastu", "आवासीय, व्यावसायिक और औद्योगिक एस्ट्रो-वास्तु"),
            Pair("Career & Profession-Related Astro-Vastu Guidance", "करियर और व्यवसाय संबंधी एस्ट्रो-वास्तु मार्गदर्शन"),
            Pair("Property Selection Through Astro-Vastu Alignment", "एस्ट्रो-वास्तु संरेखण के माध्यम से संपत्ति का चयन"),
            Pair("Traditional Non-Demolition Recommendations", "पारंपरिक बिना तोड़-फोड़ की सिफारिशें")
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = ForestGreenSecondary),
            border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold.copy(alpha = 0.4f))
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = if (language == AppLanguage.EN) "Key Astro-Vastu Offerings" else "मुख्य एस्ट्रो-वास्तु सेवाएँ",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = WarmIvory,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                servicesList.forEach { (enItem, hiItem) ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = ChampagneGold,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = if (language == AppLanguage.EN) enItem else hiItem,
                                style = MaterialTheme.typography.bodyMedium.copy(color = WarmIvory, fontWeight = FontWeight.SemiBold)
                            )
                            Text(
                                text = if (language == AppLanguage.EN) hiItem else enItem,
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = ChampagneGoldLight,
                                    fontSize = 11.sp,
                                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                                )
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = ChampagneGold.copy(alpha = 0.2f))
                Spacer(modifier = Modifier.height(16.dp))

                // Required Information Callout
                Text(
                    text = if (language == AppLanguage.EN) "Required Information for Astro-Vastu:" else "एस्ट्रो-वास्तु के लिए आवश्यक जानकारी:",
                    style = MaterialTheme.typography.labelLarge.copy(color = ChampagneGold, fontWeight = FontWeight.Bold)
                )
                Text(
                    text = if (language == AppLanguage.EN)
                        "• Property Floor Plan with Compass Orientation\n• Complete Birth Details (Name, Date of Birth, Exact Time of Birth, Place of Birth)"
                    else
                        "• कंपास अभिविन्यास के साथ संपत्ति का फ्लोर प्लान\n• संपूर्ण जन्म विवरण (नाम, जन्म तिथि, जन्म का सटीक समय, जन्म स्थान)",
                    style = MaterialTheme.typography.bodySmall.copy(color = WarmIvory.copy(alpha = 0.85f)),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        Button(
            onClick = onNavigateToBooking,
            colors = ButtonDefaults.buttonColors(containerColor = ChampagneGold, contentColor = ForestGreenPrimary),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .testTag("astro_vastu_cta_button")
        ) {
            Text(
                text = if (language == AppLanguage.EN) "BOOK ASTRO-VASTU CONSULTATION" else "एस्ट्रो-वास्तु परामर्श बुक करें",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}

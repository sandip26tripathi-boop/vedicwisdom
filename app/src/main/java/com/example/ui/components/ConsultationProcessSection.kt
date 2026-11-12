package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.ui.theme.*

@Composable
fun ConsultationProcessSection(
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(WarmIvory)
            .padding(horizontal = 20.dp, vertical = 36.dp)
    ) {
        Text(
            text = if (language == AppLanguage.EN) "SIX-STEP CONSULTATION PROCESS" else "छह चरणों की परामर्श प्रक्रिया",
            style = MaterialTheme.typography.displayMedium.copy(
                fontFamily = FontFamily.Serif,
                color = ForestGreenPrimary,
                fontSize = 24.sp
            )
        )
        Text(
            text = if (language == AppLanguage.EN)
                "Structured, transparent procedure from initial enquiry to final report delivery."
            else
                "प्रारंभिक पूछताछ से अंतिम रिपोर्ट डिलीवरी तक संरचित, पारदर्शी प्रक्रिया।",
            style = MaterialTheme.typography.bodyMedium.copy(color = MutedCharcoal),
            modifier = Modifier.padding(top = 4.dp, bottom = 24.dp)
        )

        val steps = listOf(
            Triple(
                "STEP 1 – INITIAL ENQUIRY",
                "चरण 1 – प्रारंभिक पूछताछ",
                Pair("Submit your consultation request via form or WhatsApp with property details.", "वेबसाइट फॉर्म या व्हाट्सएप के माध्यम से अपनी पूछताछ सबमिट करें।")
            ),
            Triple(
                "STEP 2 – CLIENT REQUIREMENTS",
                "चरण 2 – आवश्यकताओं को समझना",
                Pair("Preliminary discussion to understand property type (Residential/Industrial/Commercial).", "संपत्ति के प्रकार और प्राथमिकताओं को समझने के लिए प्रारंभिक चर्चा।")
            ),
            Triple(
                "STEP 3 – PLANS & DIRECTION DATA",
                "चरण 3 – फ्लोर प्लान एवं डेटा संग्रह",
                Pair("Submission of CAD/scaled floor plans, compass degree orientation & photos.", "स्केल्ड फ्लोर प्लान, कंपास दिशा और प्रासंगिक विवरण जमा करना।")
            ),
            Triple(
                "STEP 4 – VASTU & ASTRO ASSESSMENT",
                "चरण 4 – पेशेवर वास्तु एवं एस्ट्रो मूल्यांकन",
                Pair("Analytical evaluation of 16 directional zones, Panchtatva balance & KP horoscope.", "16 दिशात्मक क्षेत्रों, पंचतत्व और केपी सब-लॉर्ड्स का गहन विश्लेषण।")
            ),
            Triple(
                "STEP 5 – PERSONALIZED DIGITAL REPORT",
                "चरण 5 – व्यक्तिगत डिजिटल रिपोर्ट",
                Pair("Delivery of comprehensive digital report with practical, non-demolition remedies.", "व्यावहारिक, बिना तोड़-फोड़ समाधानों के साथ व्यापक डिजिटल रिपोर्ट।")
            ),
            Triple(
                "STEP 6 – FOLLOW-UP DISCUSSION",
                "चरण 6 – अनुवर्ती परामर्श चर्चा",
                Pair("Consultation discussion call to review recommendations and address queries.", "सिफारिशों की समीक्षा और प्रश्नों के समाधान के लिए फॉलो-अप कॉल।")
            )
        )

        steps.forEachIndexed { index, (titleEn, titleHi, descPair) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                verticalAlignment = Alignment.Top
            ) {
                Surface(
                    shape = CircleShape,
                    color = ForestGreenPrimary,
                    modifier = Modifier.size(36.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = "${index + 1}",
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = ChampagneGold,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.width(14.dp))
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = ElegantWhite,
                    border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderGold),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = if (language == AppLanguage.EN) titleEn else titleHi,
                            style = MaterialTheme.typography.titleSmall.copy(
                                color = ForestGreenPrimary,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = if (language == AppLanguage.EN) titleHi else titleEn,
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = ChampagneGoldDark,
                                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = if (language == AppLanguage.EN) descPair.first else descPair.second,
                            style = MaterialTheme.typography.bodySmall.copy(color = SubtleCharcoal)
                        )
                    }
                }
            }
        }
    }
}

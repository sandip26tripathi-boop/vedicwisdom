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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.VedicData
import com.example.model.AppLanguage
import com.example.ui.theme.*

@Composable
fun AboutLeadershipSection(
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(WarmIvory)
            .padding(horizontal = 20.dp, vertical = 36.dp)
    ) {
        // Section Title
        Text(
            text = if (language == AppLanguage.EN) "ABOUT VEDIC WISDOM" else "वैदिक विजडम के बारे में",
            style = MaterialTheme.typography.displayMedium.copy(
                fontFamily = FontFamily.Serif,
                color = ForestGreenPrimary,
                fontSize = 24.sp
            )
        )
        Text(
            text = if (language == AppLanguage.EN)
                "A knowledge-driven consultancy platform dedicated to traditional Vastu Shastra, Astro-Vastu, KP Astrology, and practical educational guidance globally."
            else
                "पारंपरिक वास्तु शास्त्र, एस्ट्रो-वास्तु, केपी ज्योतिष और व्यावहारिक शैक्षणिक मार्गदर्शन के लिए समर्पित परामर्श मंच।",
            style = MaterialTheme.typography.bodyMedium.copy(color = MutedCharcoal),
            modifier = Modifier.padding(top = 6.dp, bottom = 24.dp)
        )

        // 6 Core Values Grid
        Text(
            text = if (language == AppLanguage.EN) "OUR 6 CORE VALUES" else "हमारे 6 मूल मूल्य",
            style = MaterialTheme.typography.titleLarge.copy(
                fontFamily = FontFamily.Serif,
                color = ForestGreenPrimary,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 12.dp)
        )

        val coreValues = if (language == AppLanguage.EN) listOf(
            "Integrity" to "Uncompromising ethical standards in all consultancy.",
            "Transparency" to "Clear explanations without mystification or fear.",
            "Professionalism" to "Punctual, structured reports & CAD evaluations.",
            "Traditional Knowledge" to "Rooted in authentic ancient shastras & mathematics.",
            "Personalised Guidance" to "Individual solutions tailored to specific floor plans.",
            "Continuous Learning" to "Academic research & ongoing educational programs."
        ) else listOf(
            "सत्यनिष्ठा" to "सभी परामर्शों में बिना किसी समझौते के नैतिक मानक।",
            "पारदर्शिता" to "बिना किसी भय या भ्रम के स्पष्ट व्याख्या।",
            "पेशेवर कार्यशैली" to "समयबद्ध, संरचित रिपोर्ट और सीएडी मूल्यांकन।",
            "पारंपरिक ज्ञान" to "प्रामाणिक प्राचीन शास्त्रों और गणित पर आधारित।",
            "व्यक्तिगत मार्गदर्शन" to "विशिष्ट लेआउट के अनुसार अनुकूलित समाधान।",
            "निरंतर अध्ययन" to "अकादमिक अनुसंधान और सतत शैक्षणिक कार्यक्रम।"
        )

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            coreValues.chunked(2).forEach { pair ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    pair.forEach { (title, desc) ->
                        Surface(
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp),
                            color = ElegantWhite,
                            border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderGold)
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = title,
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        color = ChampagneGoldDark,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp
                                    )
                                )
                                Text(
                                    text = desc,
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = SubtleCharcoal,
                                        fontSize = 11.sp
                                    ),
                                    modifier = Modifier.padding(top = 2.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // LEADERSHIP PROFILES
        Text(
            text = if (language == AppLanguage.EN) "LEADERSHIP & RESEARCHERS" else "नेतृत्व एवं शोधकर्ता",
            style = MaterialTheme.typography.displayMedium.copy(
                fontFamily = FontFamily.Serif,
                color = ForestGreenPrimary,
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 1. FOUNDER PROFILE: MR. RAVINDRA PATHAK
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .testTag("founder_profile_card"),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = ForestGreenPrimary),
            border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = CircleShape,
                        color = ChampagneGold,
                        modifier = Modifier.size(56.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = "RP",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    color = ForestGreenPrimary,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "MR. RAVINDRA PATHAK",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontFamily = FontFamily.Serif,
                                color = ChampagneGold,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "FOUNDER – VEDIC WISDOM",
                            style = MaterialTheme.typography.labelMedium.copy(
                                color = WarmIvory.copy(alpha = 0.8f),
                                letterSpacing = 0.5.sp
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = if (language == AppLanguage.EN)
                        "Mr. Ravindra Pathak founded Vedic Wisdom with a vision to establish a global, research-backed consultancy platform dedicated to traditional Vastu Shastra, Astro-Vastu, and analytical astrology. Under his leadership, the organization prioritizes professional integrity, practical non-demolition methods, and academic excellence."
                    else
                        "श्री रवीन्द्र पाठक ने पारंपरिक वास्तु शास्त्र, एस्ट्रो-वास्तु और विश्लेषणात्मक ज्योतिष के लिए एक वैश्विक शोध-आधारित परामर्श मंच स्थापित करने के दृष्टिकोण के साथ वैदिक विजडम की स्थापना की। उनके नेतृत्व में संस्था पेशेवर सत्यनिष्ठा और व्यावहारिक गैर-विध्वंस विधियों को प्राथमिकता देती है।",
                    style = MaterialTheme.typography.bodyMedium.copy(color = WarmIvory)
                )
            }
        }

        // 2. PRINCIPAL RESEARCHER & EDUCATOR: SANDEEP TRIPATHI
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .testTag("researcher_profile_card"),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = ForestGreenSecondary),
            border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = CircleShape,
                        color = ChampagneGold,
                        modifier = Modifier.size(56.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = "ST",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    color = ForestGreenPrimary,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "SANDEEP TRIPATHI",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontFamily = FontFamily.Serif,
                                color = ChampagneGold,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "PRINCIPAL RESEARCHER & EDUCATOR",
                            style = MaterialTheme.typography.labelMedium.copy(
                                color = WarmIvory.copy(alpha = 0.9f),
                                letterSpacing = 0.5.sp
                            )
                        )
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = ChampagneGold.copy(alpha = 0.2f),
                            modifier = Modifier.padding(top = 4.dp)
                        ) {
                            Text(
                                text = "12+ YEARS EXPERIENCE",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = ChampagneGold,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp
                                ),
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = if (language == AppLanguage.EN)
                        "Sandeep Tripathi is associated with the research, study and educational application of traditional Vastu and astrological principles, with particular emphasis on practical solutions for existing properties and specialised factory, industrial and commercial Vastu assessment."
                    else
                        "संदीप त्रिपाठी पारंपरिक वास्तु और ज्योतिषीय सिद्धांतों के अनुसंधान, अध्ययन और शैक्षणिक अनुप्रयोग से जुड़े हैं, जिसमें निर्मित संपत्तियों के लिए व्यावहारिक समाधान और विशेष कारखाना, औद्योगिक और व्यावसायिक वास्तु मूल्यांकन पर मुख्य बल दिया गया है।",
                    style = MaterialTheme.typography.bodyMedium.copy(color = WarmIvory)
                )

                Text(
                    text = if (language == AppLanguage.EN)
                        "Hindi: संदीप त्रिपाठी 12+ वर्षों से निर्मित संपत्तियों के व्यावहारिक एवं औद्योगिक वास्तु अध्ययन में समर्पित हैं।"
                    else
                        "English: Dedicated to the study & research of non-demolition and industrial Vastu for over 12 years.",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = ChampagneGoldLight,
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                    ),
                    modifier = Modifier.padding(top = 4.dp)
                )

                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = if (language == AppLanguage.EN) "Areas of Specialisation:" else "विशेषज्ञता के क्षेत्र:",
                    style = MaterialTheme.typography.labelLarge.copy(color = ChampagneGold, fontWeight = FontWeight.Bold)
                )

                val specs = listOf(
                    Pair("Practical Vastu Analysis & Vastu Without Demolition", "व्यावहारिक वास्तु विश्लेषण एवं बिना तोड़-फोड़ वास्तु"),
                    Pair("Industrial and Factory Vastu Layout Planning", "औद्योगिक एवं कारखाना वास्तु लेआउट योजना"),
                    Pair("Commercial and Corporate Vastu Assessments", "व्यावसायिक एवं कॉर्पोरेट वास्तु मूल्यांकन"),
                    Pair("Astro-Vastu Research & Planetary Alignment", "एस्ट्रो-वास्तु अनुसंधान एवं ग्रह संरेखण"),
                    Pair("KP Astrology & Traditional Knowledge Education", "केपी ज्योतिष एवं पारंपरिक ज्ञान शिक्षा")
                )

                specs.forEach { (enSpec, hiSpec) ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 3.dp)
                    ) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(14.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = if (language == AppLanguage.EN) enSpec else hiSpec,
                                style = MaterialTheme.typography.bodySmall.copy(color = WarmIvory, fontWeight = FontWeight.Medium)
                            )
                            Text(
                                text = if (language == AppLanguage.EN) hiSpec else enSpec,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = ChampagneGoldLight,
                                    fontSize = 10.sp,
                                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                                )
                            )
                        }
                    }
                }
            }
        }

        // 3. OUR ADVISORY & KNOWLEDGE PANEL (7 Cards)
        Text(
            text = if (language == AppLanguage.EN) "ADVISORY & KNOWLEDGE PANEL" else "सलाहकार एवं ज्ञान पैनल",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontFamily = FontFamily.Serif,
                color = ForestGreenPrimary,
                fontSize = 20.sp
            ),
            modifier = Modifier.padding(bottom = 12.dp)
        )

        VedicData.ADVISORY_PANEL.forEach { panelItem ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = ElegantWhite),
                border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderGold)
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = ForestGreenSecondary,
                        modifier = Modifier.size(40.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = ChampagneGold,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = if (language == AppLanguage.EN) panelItem.titleEn else panelItem.titleHi,
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = ForestGreenPrimary,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = if (language == AppLanguage.EN) panelItem.specialisationEn else panelItem.specialisationHi,
                            style = MaterialTheme.typography.bodySmall.copy(color = MutedCharcoal)
                        )
                    }
                }
            }
        }
    }
}

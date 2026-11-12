package com.example.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.model.AppLanguage
import com.example.model.AppScreen
import com.example.ui.theme.*

@Composable
fun HeroSection(
    language: AppLanguage,
    onNavigate: (AppScreen) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(ForestGreenPrimary)
    ) {
        // Hero Background Image with Gradient Overlay
        Image(
            painter = painterResource(id = R.drawable.img_hero_architectural_1794441484093),
            contentDescription = "Vedic Wisdom Architectural Mansion",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(490.dp)
        )

        // Refined Dark Gradient Overlay for High Contrast & Luxury Aesthetic
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(490.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            ForestGreenPrimary.copy(alpha = 0.88f),
                            ForestGreenPrimary.copy(alpha = 0.96f),
                            ForestGreenPrimary
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Elegant Badge / Pill
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = ForestGreenSecondary,
                border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold),
                modifier = Modifier.padding(bottom = 14.dp)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Explore,
                        contentDescription = null,
                        tint = ChampagneGold,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (language == AppLanguage.EN)
                            "INTERNATIONAL VASTU & ASTRO-VASTU CONSULTANCY"
                        else
                            "अंतरराष्ट्रीय वास्तु एवं एस्ट्रो-वास्तु परामर्श",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = ChampagneGold,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.5.sp
                        )
                    )
                }
            }

            // Main H1 Headline with Paired Bilingual Translation
            Text(
                text = if (language == AppLanguage.EN)
                    "TRANSFORM YOUR SPACES THROUGH THE WISDOM OF VASTU."
                else
                    "वास्तु के पारंपरिक सिद्धांतों से अपने घर, व्यवसाय और कार्यस्थल के बेहतर नियोजन की दिशा में एक व्यावहारिक कदम।",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontFamily = FontFamily.Serif,
                    color = WarmIvory,
                    textAlign = TextAlign.Center,
                    fontSize = if (language == AppLanguage.EN) 26.sp else 22.sp,
                    lineHeight = if (language == AppLanguage.EN) 34.sp else 30.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 6.dp)
            )

            // Paired Translation Subtitle
            Text(
                text = if (language == AppLanguage.EN)
                    "वास्तु के पारंपरिक सिद्धांतों से अपने घर और कार्यस्थल का व्यावहारिक नियोजन।"
                else
                    "Transform Your Spaces Through The Traditional Wisdom of Vastu.",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = ChampagneGoldLight,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic,
                    fontSize = 13.sp
                ),
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // Tagline in English & Hindi
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                Text(
                    text = "Traditional Wisdom. Analytical Thinking. Practical Awareness.",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = WarmIvory,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp
                    )
                )
                Text(
                    text = "परंपरागत ज्ञान, तार्किक दृष्टिकोण और व्यावहारिक समझ।",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = ChampagneGold,
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp
                    ),
                    modifier = Modifier.padding(top = 2.dp)
                )
            }

            // 4 Key Highlights with paired English/Hindi
            val highlights = listOf(
                Pair(
                    "Practical Vastu Solutions Without Unnecessary Demolition",
                    "बिना किसी अनावश्यक तोड़-फोड़ के व्यावहारिक वास्तु समाधान"
                ),
                Pair(
                    "Specialised Industrial & Factory Vastu",
                    "विशेषज्ञ औद्योगिक एवं कारखाना वास्तु"
                ),
                Pair(
                    "Personalised Astro-Vastu Consultation",
                    "व्यक्तिगत जन्म कुंडली आधारित एस्ट्रो-वास्तु परामर्श"
                ),
                Pair(
                    "KP Astrology & Traditional Scientific Knowledge",
                    "केपी ज्योतिष एवं पारंपरिक वैज्ञानिक ज्ञान"
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 22.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                highlights.forEach { (enText, hiText) ->
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = ForestGreenSecondary.copy(alpha = 0.7f),
                        border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold.copy(alpha = 0.25f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = ChampagneGold,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = if (language == AppLanguage.EN) enText else hiText,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = WarmIvory,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 13.sp
                                    )
                                )
                                Text(
                                    text = if (language == AppLanguage.EN) hiText else enText,
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = ChampagneGoldLight,
                                        fontSize = 11.sp,
                                        fontStyle = FontStyle.Italic
                                    )
                                )
                            }
                        }
                    }
                }
            }

            // 3 Action Buttons
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = { onNavigate(AppScreen.BOOK_CONSULTATION) },
                    colors = ButtonDefaults.buttonColors(containerColor = ChampagneGold, contentColor = ForestGreenPrimary),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .testTag("hero_book_button")
                ) {
                    Icon(Icons.Default.Explore, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (language == AppLanguage.EN) "BOOK A CONSULTATION" else "परामर्श बुक करें",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = { onNavigate(AppScreen.VASTU_CONSULTANCY) },
                        border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = WarmIvory),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .testTag("hero_explore_services_button")
                    ) {
                        Text(
                            text = if (language == AppLanguage.EN) "SERVICES" else "सेवाएँ",
                            style = MaterialTheme.typography.labelLarge.copy(color = WarmIvory, fontWeight = FontWeight.Bold)
                        )
                    }

                    Button(
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/919009448601"))
                            context.startActivity(intent)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen, contentColor = ElegantWhite),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1.2f)
                            .height(48.dp)
                            .testTag("hero_whatsapp_button")
                    ) {
                        Icon(imageVector = Icons.Default.Phone, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "WHATSAPP",
                            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Sub-hero Trust Strip with Non-Demolition Note
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = ForestGreenSecondary.copy(alpha = 0.8f),
                shape = RoundedCornerShape(12.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold.copy(alpha = 0.35f))
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "TRADITIONAL KNOWLEDGE. PERSONALISED ANALYSIS. PRACTICAL GUIDANCE.",
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = ChampagneGold,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.5.sp
                        ),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "परंपरागत ज्ञान। व्यक्तिगत विश्लेषण। व्यावहारिक मार्गदर्शन।",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = ChampagneGoldLight,
                            fontStyle = FontStyle.Italic
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = if (language == AppLanguage.EN)
                            "Vedic Wisdom focuses on practical, non-structural recommendations wherever feasible. Recommendations depend on individual property conditions."
                        else
                            "वैदिक विजडम जहां भी संभव हो व्यावहारिक, गैर-संरचनात्मक सिफारिशों पर ध्यान केंद्रित करता है। सिफारिशें व्यक्तिगत संपत्ति की स्थितियों पर निर्भर करती हैं।",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = WarmIvory.copy(alpha = 0.85f),
                            fontSize = 11.sp,
                            lineHeight = 16.sp
                        ),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

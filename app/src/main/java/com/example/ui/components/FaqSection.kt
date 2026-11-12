package com.example.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.VedicData
import com.example.model.AppLanguage
import com.example.model.FaqItem
import com.example.ui.theme.*

@Composable
fun FaqSection(
    language: AppLanguage,
    onNavigateToBooking: () -> Unit,
    modifier: Modifier = Modifier
) {
    var expandedFaqId by remember { mutableStateOf<String?>("faq_1") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(WarmIvory)
            .padding(horizontal = 20.dp, vertical = 36.dp)
    ) {
        // Section Badge
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = ForestGreenPrimary,
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.HelpOutline, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = if (language == AppLanguage.EN) "FREQUENTLY ASKED QUESTIONS" else "अक्सर पूछे जाने वाले प्रश्न",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = ChampagneGold,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                )
            }
        }

        Text(
            text = if (language == AppLanguage.EN) "FREQUENTLY ASKED QUESTIONS" else "सामान्य प्रश्न एवं उत्तर",
            style = MaterialTheme.typography.displayMedium.copy(
                fontFamily = FontFamily.Serif,
                color = ForestGreenPrimary,
                fontSize = 24.sp
            )
        )

        Text(
            text = if (language == AppLanguage.EN)
                "Clear answers regarding non-demolition methods, industrial audits, KP astrology, and international consultations."
            else
                "बिना तोड़-फोड़ वास्तु, औद्योगिक ऑडिट, केपी ज्योतिष और अंतरराष्ट्रीय परामर्श पर स्पष्ट उत्तर।",
            style = MaterialTheme.typography.bodyMedium.copy(color = MutedCharcoal),
            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
        )
        Text(
            text = if (language == AppLanguage.EN)
                "Hindi: किसी भी अतिरिक्त प्रश्न के लिए आप हमसे सीधे संपर्क कर सकते हैं।"
            else
                "English: For any additional queries, feel free to reach out to us directly.",
            style = MaterialTheme.typography.bodySmall.copy(
                color = ChampagneGoldDark,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            ),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        VedicData.FAQS.forEach { faq ->
            val isExpanded = expandedFaqId == faq.id
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { expandedFaqId = if (isExpanded) null else faq.id }
                    .testTag("faq_item_${faq.id}"),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isExpanded) ElegantWhite else WarmIvoryVariant
                ),
                border = androidx.compose.foundation.BorderStroke(
                    1.dp,
                    if (isExpanded) ChampagneGold else CardBorderGold
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = if (language == AppLanguage.EN) faq.questionEn else faq.questionHi,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    color = ForestGreenPrimary,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                            )
                            Text(
                                text = if (language == AppLanguage.EN) faq.questionHi else faq.questionEn,
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = MutedCharcoal,
                                    fontSize = 12.sp,
                                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                                ),
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }

                        Icon(
                            imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                            contentDescription = if (isExpanded) "Collapse" else "Expand",
                            tint = ChampagneGoldDark
                        )
                    }

                    AnimatedVisibility(visible = isExpanded) {
                        Column(modifier = Modifier.padding(top = 12.dp)) {
                            HorizontalDivider(color = CardBorderGold, modifier = Modifier.padding(bottom = 8.dp))
                            Text(
                                text = if (language == AppLanguage.EN) faq.answerEn else faq.answerHi,
                                style = MaterialTheme.typography.bodyMedium.copy(color = SubtleCharcoal, lineHeight = 22.sp)
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = if (language == AppLanguage.EN) faq.answerHi else faq.answerEn,
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = MutedCharcoal,
                                    fontSize = 12.sp,
                                    lineHeight = 18.sp
                                )
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onNavigateToBooking,
            colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary, contentColor = ChampagneGold),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth().height(48.dp)
        ) {
            Text(
                text = if (language == AppLanguage.EN) "HAVE MORE QUESTIONS? BOOK A CALL" else "अन्य प्रश्न हैं? परामर्श कॉल बुक करें",
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}

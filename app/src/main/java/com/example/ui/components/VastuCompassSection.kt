package com.example.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.VedicData
import com.example.model.AppLanguage
import com.example.model.VastuDirectionZone
import com.example.ui.theme.*

@Composable
fun VastuCompassSection(
    language: AppLanguage,
    onNavigateToBooking: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedZone by remember { mutableStateOf(VedicData.VASTU_DIRECTIONS[0]) }

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
                Icon(
                    imageVector = Icons.Default.Explore,
                    contentDescription = null,
                    tint = ChampagneGold,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = if (language == AppLanguage.EN) "INTERACTIVE VASTU COMPASS & PANCHTATVA" else "इंटरएक्टिव वास्तु कंपास एवं पंचतत्व",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = ChampagneGold,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                )
            }
        }

        Text(
            text = if (language == AppLanguage.EN)
                "DIRECTIONAL HARMONY & FIVE ELEMENTS GUIDE"
            else
                "दिशात्मक सामंजस्य एवं पंचतत्व मार्गदर्शन",
            style = MaterialTheme.typography.displayMedium.copy(
                fontFamily = FontFamily.Serif,
                color = ForestGreenPrimary,
                fontSize = 24.sp
            )
        )

        // Bilingual Subtitle Pair
        Text(
            text = if (language == AppLanguage.EN)
                "Explore the 8 fundamental directions, elemental governing energies (Water, Air, Fire, Earth, Space), and spatial zoning."
            else
                "8 मुख्य दिशाओं, पंचतत्व (जल, वायु, अग्नि, पृथ्वी, आकाश) और उनके उपयुक्त कक्ष विन्यास को समझें।",
            style = MaterialTheme.typography.bodyMedium.copy(color = MutedCharcoal),
            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
        )
        Text(
            text = if (language == AppLanguage.EN)
                "Hindi: 8 मुख्य दिशाओं और उनके पंचतत्वीय ऊर्जा संतुलन का व्यावहारिक ज्ञान।"
            else
                "English: Practical knowledge of the 8 directions and elemental energy balance.",
            style = MaterialTheme.typography.bodySmall.copy(
                color = ChampagneGoldDark,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            ),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // Direction Selection Chips Grid
        Text(
            text = if (language == AppLanguage.EN) "Select a Direction Zone to Explore:" else "दिशा चुनें और विश्लेषण देखें:",
            style = MaterialTheme.typography.labelLarge.copy(color = ForestGreenPrimary, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            val directions = VedicData.VASTU_DIRECTIONS
            // Show in 2 scrollable or wrapped rows
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    directions.take(4).forEach { zone ->
                        val isSelected = selectedZone.zoneCode == zone.zoneCode
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = if (isSelected) ForestGreenPrimary else ElegantWhite,
                            border = androidx.compose.foundation.BorderStroke(
                                1.dp,
                                if (isSelected) ChampagneGold else CardBorderGold
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .clickable { selectedZone = zone }
                                .testTag("direction_chip_${zone.zoneCode}")
                        ) {
                            Column(
                                modifier = Modifier.padding(vertical = 10.dp, horizontal = 4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = zone.zoneCode,
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        color = if (isSelected) ChampagneGold else ForestGreenPrimary,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp
                                    )
                                )
                                Text(
                                    text = if (language == AppLanguage.EN) zone.zoneCode else zone.nameHi.take(4),
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        color = if (isSelected) WarmIvory else MutedCharcoal,
                                        fontSize = 10.sp
                                    )
                                )
                            }
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    directions.drop(4).forEach { zone ->
                        val isSelected = selectedZone.zoneCode == zone.zoneCode
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = if (isSelected) ForestGreenPrimary else ElegantWhite,
                            border = androidx.compose.foundation.BorderStroke(
                                1.dp,
                                if (isSelected) ChampagneGold else CardBorderGold
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .clickable { selectedZone = zone }
                                .testTag("direction_chip_${zone.zoneCode}")
                        ) {
                            Column(
                                modifier = Modifier.padding(vertical = 10.dp, horizontal = 4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = zone.zoneCode,
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        color = if (isSelected) ChampagneGold else ForestGreenPrimary,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp
                                    )
                                )
                                Text(
                                    text = if (language == AppLanguage.EN) zone.zoneCode else zone.nameHi.take(4),
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        color = if (isSelected) WarmIvory else MutedCharcoal,
                                        fontSize = 10.sp
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }

        // Selected Zone Detail Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
                .testTag("direction_detail_card"),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = ElegantWhite),
            border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = if (language == AppLanguage.EN) selectedZone.nameEn else selectedZone.nameHi,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontFamily = FontFamily.Serif,
                                color = ForestGreenPrimary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        )
                        Text(
                            text = "Traditional Sthan: ${selectedZone.traditionalName}",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = ChampagneGoldDark,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = ForestGreenPrimary
                    ) {
                        Text(
                            text = if (language == AppLanguage.EN) selectedZone.elementEn else selectedZone.elementHi,
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = ChampagneGold,
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp
                            ),
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }
                }

                HorizontalDivider(color = CardBorderGold, modifier = Modifier.padding(vertical = 12.dp))

                // Core Qualities
                Text(
                    text = if (language == AppLanguage.EN) "Governing Energies & Attributes:" else "दिशा के मुख्य गुण एवं प्रभाव:",
                    style = MaterialTheme.typography.labelMedium.copy(color = ForestGreenPrimary, fontWeight = FontWeight.Bold)
                )
                Text(
                    text = if (language == AppLanguage.EN) selectedZone.qualitiesEn else selectedZone.qualitiesHi,
                    style = MaterialTheme.typography.bodyMedium.copy(color = SubtleCharcoal),
                    modifier = Modifier.padding(top = 2.dp, bottom = 10.dp)
                )

                // Ideal Usage
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = ForestGreenLightTint,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = SuccessGreen, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = if (language == AppLanguage.EN) "Recommended Activities / Rooms:" else "उपयुक्त गतिविधियाँ / कक्ष:",
                                style = MaterialTheme.typography.labelSmall.copy(color = ForestGreenPrimary, fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = if (language == AppLanguage.EN) selectedZone.idealForEn else selectedZone.idealForHi,
                                style = MaterialTheme.typography.bodySmall.copy(color = SubtleCharcoal, fontSize = 12.sp)
                            )
                        }
                    }
                }

                // Cautions
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = Color(0xFFFFF7ED),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(Icons.Default.Warning, contentDescription = null, tint = AlertWarningOrange, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = if (language == AppLanguage.EN) "Vastu Cautions to Avoid:" else "सावधानियाँ (क्या न करें):",
                                style = MaterialTheme.typography.labelSmall.copy(color = Color(0xFF9A3412), fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = if (language == AppLanguage.EN) selectedZone.cautionEn else selectedZone.cautionHi,
                                style = MaterialTheme.typography.bodySmall.copy(color = SubtleCharcoal, fontSize = 12.sp)
                            )
                        }
                    }
                }
            }
        }

        // CTA
        OutlinedButton(
            onClick = onNavigateToBooking,
            border = androidx.compose.foundation.BorderStroke(1.dp, ForestGreenPrimary),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = ForestGreenPrimary),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Icon(Icons.Default.Apartment, contentDescription = null, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = if (language == AppLanguage.EN) "GET YOUR PROPERTY'S DIRECTIONAL CAD AUDIT" else "अपनी संपत्ति का सीएडी दिशात्मक ऑडिट करवाएं",
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}

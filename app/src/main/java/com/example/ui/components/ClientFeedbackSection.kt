package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.VedicData
import com.example.model.AppLanguage
import com.example.model.TestimonialItem
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientFeedbackSection(
    testimonials: List<TestimonialItem>,
    language: AppLanguage,
    selectedCategory: String,
    onCategoryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val filterCategories = listOf("ALL", "Residential Vastu", "Industrial Vastu", "Commercial Vastu", "Astro-Vastu", "KP Astrology")

    val filteredList = testimonials.filter {
        selectedCategory == "ALL" || it.category.equals(selectedCategory, ignoreCase = true)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(ForestGreenPrimary)
            .padding(horizontal = 20.dp, vertical = 36.dp)
    ) {
        // Badge
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = ForestGreenSecondary,
            border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold),
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            Text(
                text = "CLIENT EXPERIENCES & FEEDBACK",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = ChampagneGold,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    letterSpacing = 0.5.sp
                ),
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
            )
        }

        Text(
            text = if (language == AppLanguage.EN) "CLIENT EXPERIENCES & FEEDBACK" else "हमारे क्लाइंट्स के अनुभव एवं प्रतिक्रियाएँ",
            style = MaterialTheme.typography.displayMedium.copy(
                fontFamily = FontFamily.Serif,
                color = ChampagneGold,
                fontSize = 22.sp
            )
        )
        Text(
            text = if (language == AppLanguage.EN)
                "Read authentic feedback from homeowners, industrialists and corporate executives worldwide."
            else
                "विश्व भर के गृहस्वामियों, उद्योगपतियों और कॉर्पोरेट अधिकारियों के अनुभव पढ़ें।",
            style = MaterialTheme.typography.bodyMedium.copy(color = WarmIvory.copy(alpha = 0.9f)),
            modifier = Modifier.padding(top = 4.dp, bottom = 18.dp)
        )

        // Filter Chips
        androidx.compose.foundation.lazy.LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(filterCategories.size) { index ->
                val cat = filterCategories[index]
                val isSelected = selectedCategory == cat
                FilterChip(
                    selected = isSelected,
                    onClick = { onCategoryChange(cat) },
                    label = { Text(if (cat == "ALL") "All Testimonials" else cat, style = MaterialTheme.typography.labelSmall) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = ChampagneGold,
                        selectedLabelColor = ForestGreenPrimary,
                        containerColor = ForestGreenSecondary,
                        labelColor = WarmIvory
                    )
                )
            }
        }

        // Testimonial Cards
        filteredList.forEach { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 14.dp)
                    .testTag("testimonial_card_${item.id}"),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = ForestGreenSecondary),
                border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold.copy(alpha = 0.3f))
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = item.clientName,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    color = WarmIvory,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "${item.location} • ${item.category}",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = ChampagneGold,
                                    fontSize = 11.sp
                                )
                            )
                        }

                        // Rating Stars
                        Row {
                            repeat(item.rating) {
                                Icon(Icons.Default.Star, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(14.dp))
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = if (language == AppLanguage.EN) "\"${item.textEn}\"" else "\"${item.textHi}\"",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = WarmIvory.copy(alpha = 0.95f),
                            fontSize = 13.sp,
                            fontFamily = FontFamily.Serif
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Mandatory Testimonial Disclaimer
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            color = ForestGreenSecondary.copy(alpha = 0.6f),
            border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold.copy(alpha = 0.3f))
        ) {
            Row(
                modifier = Modifier.padding(12.dp),
                verticalAlignment = Alignment.Top
            ) {
                Icon(Icons.Default.Info, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (language == AppLanguage.EN) VedicData.TESTIMONIAL_DISCLAIMER_EN else VedicData.TESTIMONIAL_DISCLAIMER_HI,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = WarmIvory.copy(alpha = 0.85f),
                        fontSize = 11.sp,
                        lineHeight = 15.sp
                    )
                )
            }
        }
    }
}

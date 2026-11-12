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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.BlogArticle
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlogsHubSection(
    blogs: List<BlogArticle>,
    language: AppLanguage,
    searchQuery: String,
    selectedCategory: String,
    onSearchQueryChange: (String) -> Unit,
    onCategoryChange: (String) -> Unit,
    onReadArticleClick: (BlogArticle) -> Unit,
    modifier: Modifier = Modifier
) {
    val categories = listOf("ALL", "Non-Demolition Vastu", "Industrial Vastu", "Astro-Vastu", "Commercial Vastu", "KP Astrology", "Vastu Principles")

    val filteredBlogs = blogs.filter { article ->
        val matchesCategory = selectedCategory == "ALL" || article.category.equals(selectedCategory, ignoreCase = true)
        val matchesSearch = searchQuery.isBlank() ||
                article.titleEn.contains(searchQuery, ignoreCase = true) ||
                article.titleHi.contains(searchQuery, ignoreCase = true) ||
                article.shortDescEn.contains(searchQuery, ignoreCase = true)
        matchesCategory && matchesSearch && article.isPublished
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(WarmIvory)
            .padding(horizontal = 20.dp, vertical = 36.dp)
    ) {
        // Section Header
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = ForestGreenPrimary,
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            Text(
                text = "KNOWLEDGE & RESEARCH HUB",
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
            text = if (language == AppLanguage.EN) "VEDIC WISDOM – BLOGS & KNOWLEDGE HUB" else "वैदिक विजडम – ब्लॉग्स एवं ज्ञान केंद्र",
            style = MaterialTheme.typography.displayMedium.copy(
                fontFamily = FontFamily.Serif,
                color = ForestGreenPrimary,
                fontSize = 24.sp
            )
        )
        Text(
            text = if (language == AppLanguage.EN)
                "Explore Traditional Vastu Knowledge, Astro-Vastu Insights and KP Astrology research articles."
            else
                "पारंपरिक वास्तु ज्ञान, एस्ट्रो-वास्तु अंतर्दृष्टि और केपी ज्योतिष अनुसंधान लेख पढ़ें।",
            style = MaterialTheme.typography.bodyMedium.copy(color = MutedCharcoal),
            modifier = Modifier.padding(top = 4.dp, bottom = 20.dp)
        )

        // Search Field
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            placeholder = { Text(if (language == AppLanguage.EN) "Search Vastu & Astrology articles..." else "ब्लॉग खोजें...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = ForestGreenPrimary) },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { onSearchQueryChange("") }) {
                        Icon(Icons.Default.Clear, contentDescription = "Clear")
                    }
                }
            },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = ChampagneGold,
                unfocusedBorderColor = CardBorderGold,
                focusedContainerColor = ElegantWhite,
                unfocusedContainerColor = ElegantWhite
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .testTag("blog_search_input")
        )

        // Category Filter Row
        androidx.compose.foundation.lazy.LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(categories.size) { index ->
                val cat = categories[index]
                val isSelected = selectedCategory == cat
                FilterChip(
                    selected = isSelected,
                    onClick = { onCategoryChange(cat) },
                    label = { Text(if (cat == "ALL") "All Articles" else cat, style = MaterialTheme.typography.labelSmall) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = ForestGreenPrimary,
                        selectedLabelColor = ChampagneGold,
                        containerColor = ElegantWhite,
                        labelColor = SubtleCharcoal
                    )
                )
            }
        }

        // Blog Articles Cards (10 Featured Initial Articles)
        if (filteredBlogs.isEmpty()) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                color = ElegantWhite
            ) {
                Box(modifier = Modifier.padding(32.dp), contentAlignment = Alignment.Center) {
                    Text(
                        text = if (language == AppLanguage.EN) "No articles found matching your criteria." else "आपकी खोज से मेल खाता कोई लेख नहीं मिला।",
                        style = MaterialTheme.typography.bodyMedium.copy(color = MutedCharcoal)
                    )
                }
            }
        } else {
            filteredBlogs.forEach { article ->
                BlogCard(
                    article = article,
                    language = language,
                    onReadClick = { onReadArticleClick(article) }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun BlogCard(
    article: BlogArticle,
    language: AppLanguage,
    onReadClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("blog_card_${article.id}"),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = ElegantWhite),
        border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderGold)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = ForestGreenPrimary
                ) {
                    Text(
                        text = article.category,
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = ChampagneGold,
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp
                        ),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Schedule, contentDescription = null, tint = MutedCharcoal, modifier = Modifier.size(12.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${article.readTimeMinutes} min read",
                        style = MaterialTheme.typography.labelSmall.copy(color = MutedCharcoal, fontSize = 11.sp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = if (language == AppLanguage.EN) article.titleEn else article.titleHi,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = FontFamily.Serif,
                    color = ForestGreenPrimary,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = if (language == AppLanguage.EN) article.shortDescEn else article.shortDescHi,
                style = MaterialTheme.typography.bodyMedium.copy(color = SubtleCharcoal),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "By ${article.author} • ${article.publishedDate}",
                    style = MaterialTheme.typography.bodySmall.copy(color = MutedCharcoal, fontSize = 11.sp)
                )

                TextButton(
                    onClick = onReadClick,
                    modifier = Modifier.testTag("read_article_${article.id}")
                ) {
                    Text(
                        text = if (language == AppLanguage.EN) "Read More →" else "पढ़ें →",
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = ForestGreenSecondary,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}

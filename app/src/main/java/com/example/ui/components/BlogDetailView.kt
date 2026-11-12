package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.BlogArticle
import com.example.ui.theme.*

@Composable
fun BlogDetailView(
    article: BlogArticle,
    language: AppLanguage,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(WarmIvory)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        // Back Button
        OutlinedButton(
            onClick = onBackClick,
            shape = RoundedCornerShape(20.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, ForestGreenPrimary),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = ForestGreenPrimary),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .testTag("blog_detail_back_button")
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back", modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text(if (language == AppLanguage.EN) "Back to Knowledge Hub" else "ब्लॉग्स सूची पर वापस")
        }

        Surface(
            shape = RoundedCornerShape(8.dp),
            color = ForestGreenPrimary,
            modifier = Modifier.padding(bottom = 12.dp)
        ) {
            Text(
                text = article.category,
                style = MaterialTheme.typography.labelSmall.copy(
                    color = ChampagneGold,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                ),
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
            )
        }

        Text(
            text = if (language == AppLanguage.EN) article.titleEn else article.titleHi,
            style = MaterialTheme.typography.displayMedium.copy(
                fontFamily = FontFamily.Serif,
                color = ForestGreenPrimary,
                fontSize = 24.sp,
                lineHeight = 32.sp
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(Icons.Default.Person, contentDescription = null, tint = MutedCharcoal, modifier = Modifier.size(14.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "${article.author} • ${article.publishedDate} • ${article.readTimeMinutes} min read",
                style = MaterialTheme.typography.bodySmall.copy(color = MutedCharcoal, fontSize = 12.sp)
            )
        }

        HorizontalDivider(color = CardBorderGold, modifier = Modifier.padding(bottom = 20.dp))

        // Full Content Card
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = ElegantWhite,
            border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderGold),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = if (language == AppLanguage.EN) article.fullContentEn else article.fullContentHi,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = SubtleCharcoal,
                        lineHeight = 24.sp
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Related Article Disclaimer
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = WarmIvoryVariant,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Text(
                    text = if (language == AppLanguage.EN) "ABOUT VEDIC WISDOM RESEARCH" else "वैदिक विजडम अनुसंधान के बारे में",
                    style = MaterialTheme.typography.labelLarge.copy(color = ForestGreenPrimary, fontWeight = FontWeight.Bold)
                )
                Text(
                    text = if (language == AppLanguage.EN)
                        "All articles published on Vedic Wisdom are written for educational and analytical purposes, drawing from traditional Vastu and astrological shastras without non-scientific guarantees."
                    else
                        "वैदिक विजडम पर प्रकाशित सभी लेख शैक्षणिक और विश्लेषणात्मक उद्देश्यों के लिए लिखे गए हैं।",
                    style = MaterialTheme.typography.bodySmall.copy(color = MutedCharcoal),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

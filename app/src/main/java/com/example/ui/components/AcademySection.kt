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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.VedicData
import com.example.model.AppLanguage
import com.example.model.CourseItem
import com.example.ui.theme.*

@Composable
fun AcademySection(
    language: AppLanguage,
    onCourseEnquireClick: (CourseItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(ForestGreenPrimary)
            .padding(horizontal = 20.dp, vertical = 36.dp)
    ) {
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
                Icon(Icons.Default.School, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "ACADEMIC & EDUCATION WING",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = ChampagneGold,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                )
            }
        }

        Text(
            text = if (language == AppLanguage.EN) "VEDIC WISDOM ACADEMY" else "वैदिक विजडम अकादमिक",
            style = MaterialTheme.typography.displayMedium.copy(
                fontFamily = FontFamily.Serif,
                color = ChampagneGold,
                fontSize = 24.sp
            )
        )

        Text(
            text = if (language == AppLanguage.EN) "LEARN. EXPLORE. UNDERSTAND. APPLY." else "सीखें। अन्वेषण करें। समझें। लागू करें।",
            style = MaterialTheme.typography.titleMedium.copy(
                color = WarmIvory.copy(alpha = 0.9f),
                letterSpacing = 1.sp
            ),
            modifier = Modifier.padding(top = 4.dp, bottom = 20.dp)
        )

        // Features Strip
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            shape = RoundedCornerShape(12.dp),
            color = ForestGreenSecondary,
            border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold.copy(alpha = 0.3f))
        ) {
            Row(
                modifier = Modifier.padding(14.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                val academyFeatures = listOf("Live Classes", "Recorded", "Bilingual", "Case Studies")
                academyFeatures.forEach { feature ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Check, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(14.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(feature, style = MaterialTheme.typography.labelSmall.copy(color = WarmIvory, fontSize = 11.sp))
                    }
                }
            }
        }

        // 9 Courses List
        VedicData.INITIAL_COURSES.forEach { course ->
            CourseCard(
                course = course,
                language = language,
                onEnquireClick = { onCourseEnquireClick(course) }
            )
            Spacer(modifier = Modifier.height(14.dp))
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Certification Compliance Note
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            color = ForestGreenSecondary.copy(alpha = 0.8f)
        ) {
            Text(
                text = if (language == AppLanguage.EN)
                    "Note: Certificates in Vedic Wisdom Academy are offered strictly upon fulfilling actual course completion requirements and assessments."
                else
                    "नोट: वैदिक विजडम अकादमी में प्रमाण पत्र केवल वास्तविक पाठ्यक्रम समापन आवश्यकताओं और मूल्यांकनों को पूरा करने पर ही प्रदान किए जाते हैं।",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = WarmIvory.copy(alpha = 0.8f),
                    fontSize = 11.sp
                ),
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

@Composable
fun CourseCard(
    course: CourseItem,
    language: AppLanguage,
    onEnquireClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("course_card_${course.id}"),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = ForestGreenSecondary),
        border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold.copy(alpha = 0.4f))
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = ChampagneGold
                ) {
                    Text(
                        text = course.category,
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = ForestGreenPrimary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp
                        ),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                Text(
                    text = course.duration,
                    style = MaterialTheme.typography.labelSmall.copy(color = ChampagneGold)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = if (language == AppLanguage.EN) course.titleEn else course.titleHi,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = FontFamily.Serif,
                    color = WarmIvory,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = if (language == AppLanguage.EN) course.descriptionEn else course.descriptionHi,
                style = MaterialTheme.typography.bodyMedium.copy(color = WarmIvory.copy(alpha = 0.9f)),
                modifier = Modifier.padding(vertical = 8.dp)
            )

            course.highlights.forEach { h ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 2.dp)
                ) {
                    Icon(Icons.Default.Star, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(12.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(h, style = MaterialTheme.typography.bodySmall.copy(color = WarmIvory.copy(alpha = 0.85f), fontSize = 12.sp))
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            OutlinedButton(
                onClick = onEnquireClick,
                border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = ChampagneGold),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = if (language == AppLanguage.EN) "ENQUIRE ABOUT COURSE" else "पाठ्यक्रम पूछताछ करें",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}

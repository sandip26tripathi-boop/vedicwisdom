package com.example.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.VedicData
import com.example.model.AppLanguage
import com.example.model.AppScreen
import com.example.model.LegalModalType
import com.example.ui.theme.*

@Composable
fun FooterSection(
    language: AppLanguage,
    onNavigate: (AppScreen) -> Unit,
    onOpenLegalModal: (LegalModalType) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(ForestGreenPrimary)
            .padding(horizontal = 20.dp, vertical = 36.dp)
    ) {
        // Brand & Tagline
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Explore, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(28.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "VEDIC WISDOM",
                style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = ChampagneGold,
                    letterSpacing = 1.5.sp
                )
            )
        }

        Text(
            text = if (language == AppLanguage.EN) "Traditional Wisdom. Analytical Thinking. Practical Awareness." else "परंपरागत ज्ञान, तार्किक दृष्टिकोण और व्यावहारिक समझ।",
            style = MaterialTheme.typography.bodySmall.copy(color = WarmIvory.copy(alpha = 0.8f)),
            modifier = Modifier.padding(top = 4.dp, bottom = 20.dp)
        )

        HorizontalDivider(color = ChampagneGold.copy(alpha = 0.3f), modifier = Modifier.padding(bottom = 20.dp))

        // Contact Info Box
        Text(
            text = if (language == AppLanguage.EN) "HEADQUARTERS & CONTACT" else "मुख्यालय एवं संपर्क",
            style = MaterialTheme.typography.titleMedium.copy(color = ChampagneGold, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 12.dp)
        )

        Row(
            modifier = Modifier.padding(vertical = 4.dp),
            verticalAlignment = Alignment.Top
        ) {
            Icon(Icons.Default.LocationOn, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = "C21 Maple Heights, Hoshangabad Road, In Front of Ashima Mall, Bhopal, Madhya Pradesh, India.",
                    style = MaterialTheme.typography.bodyMedium.copy(color = WarmIvory)
                )
                Text(
                    text = "Google Maps Location",
                    style = MaterialTheme.typography.labelSmall.copy(color = ChampagneGold, fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com/?q=Bhopal+Ashima+Mall"))
                            context.startActivity(intent)
                        }
                        .padding(top = 2.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(vertical = 6.dp)
                .clickable {
                    val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:ask.vedicwisdom@gmail.com"))
                    context.startActivity(intent)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Email, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text("ask.vedicwisdom@gmail.com", style = MaterialTheme.typography.bodyMedium.copy(color = WarmIvory))
        }

        Row(
            modifier = Modifier
                .padding(vertical = 6.dp)
                .clickable {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919009448601"))
                    context.startActivity(intent)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Phone, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text("+91 90094 48601", style = MaterialTheme.typography.bodyMedium.copy(color = WarmIvory))
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Mandatory Disclaimer Box (English & Hindi)
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = ForestGreenSecondary,
            border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold.copy(alpha = 0.4f)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Text(
                    text = "MANDATORY LEGAL DISCLAIMER",
                    style = MaterialTheme.typography.labelMedium.copy(color = ChampagneGold, fontWeight = FontWeight.Bold, letterSpacing = 0.5.sp)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = VedicData.MANDATORY_DISCLAIMER_EN,
                    style = MaterialTheme.typography.bodySmall.copy(color = WarmIvory.copy(alpha = 0.9f), fontSize = 11.sp, lineHeight = 15.sp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = VedicData.MANDATORY_DISCLAIMER_HI,
                    style = MaterialTheme.typography.bodySmall.copy(color = WarmIvory.copy(alpha = 0.85f), fontSize = 11.sp, lineHeight = 15.sp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Legal Links Row
        Text(
            text = "LEGAL & COMPLIANCE POLICIES",
            style = MaterialTheme.typography.labelSmall.copy(color = ChampagneGold, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        val legalItems = listOf(
            LegalModalType.PRIVACY_POLICY to "Privacy Policy",
            LegalModalType.TERMS_AND_CONDITIONS to "Terms & Conditions",
            LegalModalType.DISCLAIMER to "Disclaimer",
            LegalModalType.REFUND_POLICY to "Cancellation & Refunds",
            LegalModalType.DATA_PROTECTION to "Data Protection Consent"
        )

        legalItems.forEach { (type, label) ->
            Text(
                text = "• $label",
                style = MaterialTheme.typography.bodySmall.copy(color = WarmIvory, fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .clickable { onOpenLegalModal(type) }
                    .padding(vertical = 4.dp)
                    .testTag("legal_link_${type.name}")
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        HorizontalDivider(color = ChampagneGold.copy(alpha = 0.3f))
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "© 2026 VEDIC WISDOM. All Rights Reserved. International Vastu & Astro-Vastu Consultancy.",
            style = MaterialTheme.typography.bodySmall.copy(color = WarmIvory.copy(alpha = 0.6f), fontSize = 11.sp)
        )
    }
}

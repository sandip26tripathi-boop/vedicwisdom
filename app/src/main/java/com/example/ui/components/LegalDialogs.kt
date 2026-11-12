package com.example.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.VedicData
import com.example.model.AppLanguage
import com.example.model.LegalModalType
import com.example.ui.theme.*

@Composable
fun LegalModalDialog(
    type: LegalModalType,
    language: AppLanguage,
    onDismiss: () -> Unit
) {
    if (type == LegalModalType.NONE) return

    val title = when (type) {
        LegalModalType.PRIVACY_POLICY -> "Privacy Policy"
        LegalModalType.TERMS_AND_CONDITIONS -> "Terms & Conditions"
        LegalModalType.DISCLAIMER -> "Mandatory Disclaimer"
        LegalModalType.REFUND_POLICY -> "Cancellation & Refund Policy"
        LegalModalType.DATA_PROTECTION -> "Data Protection & Privacy Consent"
        else -> ""
    }

    val content = when (type) {
        LegalModalType.PRIVACY_POLICY -> """
            VEDIC WISDOM PRIVACY POLICY
            
            1. Information Collection: We collect client names, email addresses, phone numbers, location data, property floor plans, and birth details strictly for providing Vastu and Astrological consultancy services.
            2. Data Security: All submitted information is treated with strict confidentiality. We do not sell or transfer client data to third-party advertisers.
            3. Client Consent: Consent is explicitly required prior to submitting floor plans or birth chart details.
        """.trimIndent()
        LegalModalType.TERMS_AND_CONDITIONS -> """
            TERMS & CONDITIONS OF SERVICE
            
            1. Scope of Services: Vedic Wisdom provides consultancy based on traditional Vastu Shastra, Astro-Vastu, and KP Astrology principles.
            2. Manual Confirmation: All consultation enquiries are subject to manual review and schedule confirmation by the consultancy team.
            3. No Fabrication: We do not promise guaranteed medical, financial, or legal outcomes.
        """.trimIndent()
        LegalModalType.DISCLAIMER -> """
            ${VedicData.MANDATORY_DISCLAIMER_EN}
            
            ----------------------------------------
            
            ${VedicData.MANDATORY_DISCLAIMER_HI}
        """.trimIndent()
        LegalModalType.REFUND_POLICY -> """
            CANCELLATION & REFUND POLICY
            
            1. Consultation Cancellation: Clients may request cancellation at least 24 hours prior to the scheduled Zoom/Google Meet call.
            2. Report Generation: Once a CAD/Floor plan assessment report has been generated, fees are non-refundable.
        """.trimIndent()
        LegalModalType.DATA_PROTECTION -> """
            DATA PROTECTION & CONSENT
            
            Client information and property blueprints are processed securely for spatial and astrological calculations only. Clients retain the right to request deletion of their records at any time via ask.vedicwisdom@gmail.com.
        """.trimIndent()
        else -> ""
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    color = ForestGreenPrimary,
                    fontWeight = FontWeight.Bold
                )
            )
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = content,
                    style = MaterialTheme.typography.bodyMedium.copy(color = SubtleCharcoal)
                )
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = ChampagneGold, contentColor = ForestGreenPrimary),
                modifier = Modifier.testTag("close_legal_dialog_button")
            ) {
                Text("Close")
            }
        }
    )
}

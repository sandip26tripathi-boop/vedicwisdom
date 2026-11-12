package com.example.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.AppScreen
import com.example.model.ContactMessage
import com.example.ui.theme.*
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactUsSection(
    language: AppLanguage,
    lastSubmittedMessage: ContactMessage?,
    onSubmitContactMessage: (ContactMessage) -> Unit,
    onClearConfirmation: () -> Unit,
    onNavigateToBooking: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("India") }
    var serviceType by remember { mutableStateOf("Residential Vastu") }
    var message by remember { mutableStateOf("") }
    var formError by remember { mutableStateOf<String?>(null) }

    val countries = listOf("India", "USA", "UK", "Canada", "Australia", "UAE", "Singapore", "Other Global")
    val services = listOf(
        "Residential Vastu Consultancy",
        "Industrial & Factory Vastu",
        "Commercial & Corporate Vastu",
        "Vastu Without Demolition",
        "Astro-Vastu Consultation",
        "KP Astrology Consultation",
        "Academy Course Admission"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(WarmIvory)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 24.dp)
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
                Icon(Icons.Default.SupportAgent, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = if (language == AppLanguage.EN) "INTERNATIONAL CLIENT DESK" else "अंतरराष्ट्रीय क्लाइंट डेस्क",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = ChampagneGold,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                )
            }
        }

        Text(
            text = if (language == AppLanguage.EN) "CONTACT US & GLOBAL ADVISORY" else "हमसे संपर्क करें एवं वैश्विक परामर्श",
            style = MaterialTheme.typography.displayMedium.copy(
                fontFamily = FontFamily.Serif,
                color = ForestGreenPrimary,
                fontSize = 24.sp
            )
        )

        // Paired English/Hindi Subtitle
        Text(
            text = if (language == AppLanguage.EN)
                "Reach out for residential, commercial, or industrial project assessments worldwide."
            else
                "विश्व भर में आवासीय, व्यावसायिक अथवा औद्योगिक परियोजनाओं के मूल्यांकन हेतु संपर्क करें।",
            style = MaterialTheme.typography.bodyMedium.copy(color = MutedCharcoal),
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = if (language == AppLanguage.EN)
                "Hindi: त्वरित प्रतिक्रिया के लिए ईमेल, व्हाट्सएप या नीचे दिए फॉर्म का उपयोग करें।"
            else
                "English: Use Email, WhatsApp, or the form below for prompt assistance.",
            style = MaterialTheme.typography.bodySmall.copy(
                color = ChampagneGoldDark,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            ),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // Quick Direct Contact Buttons Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/919009448601"))
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen, contentColor = ElegantWhite),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(46.dp)
                    .testTag("contact_whatsapp_direct_button")
            ) {
                Icon(Icons.Default.Phone, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("WhatsApp", style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold))
            }

            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:ask.vedicwisdom@gmail.com"))
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary, contentColor = ChampagneGold),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(46.dp)
                    .testTag("contact_email_direct_button")
            ) {
                Icon(Icons.Default.Email, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("Email Us", style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold))
            }
        }

        // Office Location Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = ElegantWhite),
            border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderGold)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = ForestGreenPrimary,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(Icons.Default.LocationOn, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(20.dp))
                        }
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = if (language == AppLanguage.EN) "HEADQUARTERS & REGISTERED OFFICE" else "मुख्यालय एवं पंजीकृत कार्यालय",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontFamily = FontFamily.Serif,
                                color = ForestGreenPrimary,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text("Bhopal, Madhya Pradesh, India", style = MaterialTheme.typography.labelSmall.copy(color = MutedCharcoal))
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "C21 Maple Heights, Hoshangabad Road, In Front of Ashima Mall, Bhopal, Madhya Pradesh, India.",
                    style = MaterialTheme.typography.bodyMedium.copy(color = SubtleCharcoal)
                )

                Spacer(modifier = Modifier.height(10.dp))
                OutlinedButton(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com/?q=Bhopal+Ashima+Mall"))
                        context.startActivity(intent)
                    },
                    border = androidx.compose.foundation.BorderStroke(1.dp, ForestGreenPrimary),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = ForestGreenPrimary),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Default.Directions, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(if (language == AppLanguage.EN) "View on Google Maps" else "गूगल मैप्स पर देखें")
                }
            }
        }

        // Global Client Advisory Timings Box
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = ForestGreenPrimary,
            border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold.copy(alpha = 0.4f)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text(
                    text = if (language == AppLanguage.EN) "GLOBAL TIMEZONES & VIRTUAL HOURS" else "वैश्विक समय क्षेत्र एवं ऑनलाइन परामर्श समय",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontFamily = FontFamily.Serif,
                        color = ChampagneGold,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "• India (IST): 10:00 AM – 08:00 PM\n• United States (EST / PST): Flexible evening / morning appointments\n• UK & Europe (GMT / CET): 08:00 AM – 03:00 PM GMT\n• UAE / Gulf (GST): 09:30 AM – 07:30 PM GST\n• Australia & Singapore (AEDT / SGT): Coordinated weekend & morning slots",
                    style = MaterialTheme.typography.bodySmall.copy(color = WarmIvory, lineHeight = 20.sp)
                )
            }
        }

        // Interactive Message Form or Confirmation
        if (lastSubmittedMessage != null) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = ForestGreenPrimary),
                border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(Icons.Default.CheckCircle, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(48.dp))
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = if (language == AppLanguage.EN) "MESSAGE SENT SUCCESSFULLY" else "संदेश सफलतापूर्वक भेजा गया",
                        style = MaterialTheme.typography.titleLarge.copy(color = ChampagneGold, fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = "Thank you, ${lastSubmittedMessage.name}. Our executive team will review your message regarding ${lastSubmittedMessage.serviceType} and reply via ${lastSubmittedMessage.email} within 24 hours.",
                        style = MaterialTheme.typography.bodyMedium.copy(color = WarmIvory, textAlign = androidx.compose.ui.text.style.TextAlign.Center),
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                    Button(
                        onClick = onClearConfirmation,
                        colors = ButtonDefaults.buttonColors(containerColor = ChampagneGold, contentColor = ForestGreenPrimary)
                    ) {
                        Text(if (language == AppLanguage.EN) "Send Another Message" else "दूसरा संदेश भेजें")
                    }
                }
            }
        } else {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = ElegantWhite),
                border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderGold)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = if (language == AppLanguage.EN) "SEND US A DIRECT INQUIRY" else "हमें सीधा संदेश भेजें",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontFamily = FontFamily.Serif,
                            color = ForestGreenPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = if (language == AppLanguage.EN)
                            "Fill out the form below. We treat all property plans with strict confidentiality."
                        else
                            "नीचे दिया गया फॉर्म भरें। हम सभी जानकारी को पूरी गोपनीयता के साथ रखते हैं।",
                        style = MaterialTheme.typography.bodySmall.copy(color = MutedCharcoal),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Your Name *") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                            .testTag("contact_form_name_input")
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email Address *") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                            .testTag("contact_form_email_input")
                    )

                    OutlinedTextField(
                        value = phone,
                        onValueChange = { phone = it },
                        label = { Text("WhatsApp Phone Number *") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                            .testTag("contact_form_phone_input")
                    )

                    OutlinedTextField(
                        value = country,
                        onValueChange = { country = it },
                        label = { Text("Country (e.g. India, USA, UK, UAE)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )

                    OutlinedTextField(
                        value = message,
                        onValueChange = { message = it },
                        label = { Text("Message / Property Details *") },
                        minLines = 3,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp)
                            .testTag("contact_form_message_input")
                    )

                    if (formError != null) {
                        Text(
                            text = formError!!,
                            style = MaterialTheme.typography.labelSmall.copy(color = AlertWarningOrange),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }

                    Button(
                        onClick = {
                            if (name.isBlank() || email.isBlank() || phone.isBlank() || message.isBlank()) {
                                formError = "Please fill in all required fields marked with *."
                            } else {
                                formError = null
                                val contactMsg = ContactMessage(
                                    id = "msg_" + UUID.randomUUID().toString().take(6),
                                    name = name,
                                    email = email,
                                    phone = phone,
                                    country = country,
                                    serviceType = serviceType,
                                    message = message
                                )
                                onSubmitContactMessage(contactMsg)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = ForestGreenPrimary, contentColor = ChampagneGold),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("contact_form_submit_button")
                    ) {
                        Text(
                            text = if (language == AppLanguage.EN) "SUBMIT INQUIRY" else "पूछताछ सबमिट करें",
                            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }
        }
    }
}

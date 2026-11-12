package com.example.ui.components

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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.*
import com.example.ui.theme.*
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingFormSection(
    language: AppLanguage,
    initialCategory: ServiceCategory,
    lastSubmittedEnquiry: ConsultationEnquiry?,
    onSubmitEnquiry: (ConsultationEnquiry) -> Unit,
    onClearConfirmation: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Form States
    var selectedService by remember { mutableStateOf(
        when(initialCategory) {
            ServiceCategory.INDUSTRIAL -> "Industrial Vastu Consultancy"
            ServiceCategory.COMMERCIAL -> "Commercial & Corporate Vastu"
            ServiceCategory.NON_DEMOLITION -> "Vastu Without Demolition"
            ServiceCategory.PRE_PURCHASE -> "Property Selection & Pre-Purchase Vastu"
            else -> "Residential Vastu Consultancy"
        }
    ) }
    var selectedCategory by remember { mutableStateOf(
        if (initialCategory == ServiceCategory.INDUSTRIAL) ServiceCategory.INDUSTRIAL
        else if (initialCategory == ServiceCategory.COMMERCIAL) ServiceCategory.COMMERCIAL
        else ServiceCategory.RESIDENTIAL
    ) }
    var selectedMode by remember { mutableStateOf(ConsultationMode.ONLINE_ZOOM) }
    var preferredDate by remember { mutableStateOf("15 Nov 2026") }
    var preferredTime by remember { mutableStateOf("11:00 AM") }
    var selectedTimezone by remember { mutableStateOf("IST (UTC+5:30)") }
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var selectedCountry by remember { mutableStateOf("India") }
    var phone by remember { mutableStateOf("") }
    var requirements by remember { mutableStateOf("") }
    var selectedCurrency by remember { mutableStateOf("USD ($)") }

    // Attachment
    var isFloorPlanAttached by remember { mutableStateOf(false) }
    var attachedFileName by remember { mutableStateOf<String?>(null) }

    // Birth details toggle
    val isBirthDetailsNeeded = selectedService.contains("Astro", ignoreCase = true) || selectedService.contains("KP", ignoreCase = true)
    var birthName by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var timeOfBirth by remember { mutableStateOf("") }
    var placeOfBirth by remember { mutableStateOf("") }

    var privacyConsent by remember { mutableStateOf(false) }
    var validationError by remember { mutableStateOf<String?>(null) }

    val countries = listOf("India", "USA", "UK", "Canada", "Australia", "UAE", "Singapore", "Other Global")
    val timezones = listOf("IST (UTC+5:30)", "EST (UTC-5:00)", "PST (UTC-8:00)", "GMT (UTC+0:00)", "GST (UTC+4:00)", "SGT (UTC+8:00)", "AEDT (UTC+11:00)")
    val serviceOptions = listOf(
        "Residential Vastu Consultancy",
        "Industrial & Factory Vastu",
        "Commercial & Corporate Vastu",
        "Vastu Without Demolition",
        "Property Selection & Pre-Purchase",
        "Astro-Vastu Consultation",
        "KP Astrology Consultation"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(WarmIvory)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        if (lastSubmittedEnquiry != null) {
            // CONFIRMATION SCREEN
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
                    .testTag("booking_confirmation_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = ForestGreenPrimary),
                border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Success",
                        tint = ChampagneGold,
                        modifier = Modifier.size(56.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = if (language == AppLanguage.EN) "ENQUIRY RECEIVED" else "पूछताछ प्राप्त हुई",
                        style = MaterialTheme.typography.displayMedium.copy(
                            fontFamily = FontFamily.Serif,
                            color = ChampagneGold,
                            fontSize = 24.sp
                        )
                    )

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = ForestGreenSecondary,
                        modifier = Modifier.padding(vertical = 12.dp)
                    ) {
                        Text(
                            text = "STATUS: ${lastSubmittedEnquiry.status}",
                            style = MaterialTheme.typography.labelLarge.copy(
                                color = WarmIvory,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            ),
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                        )
                    }

                    Text(
                        text = if (language == AppLanguage.EN)
                            "Thank you, ${lastSubmittedEnquiry.clientName}. Your enquiry ID is #${lastSubmittedEnquiry.id}. Our consultancy team will review your requirements and contact you via email (${lastSubmittedEnquiry.email}) or WhatsApp (${lastSubmittedEnquiry.phone}) for manual confirmation."
                        else
                            "धन्यवाद, ${lastSubmittedEnquiry.clientName}। आपकी पूछताछ आईडी #${lastSubmittedEnquiry.id} है। हमारी टीम आपके विवरणों की समीक्षा करेगी और सत्यापन के बाद आपसे संपर्क करेगी।",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = WarmIvory,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = onClearConfirmation,
                        colors = ButtonDefaults.buttonColors(containerColor = ChampagneGold, contentColor = ForestGreenPrimary),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(if (language == AppLanguage.EN) "BOOK ANOTHER CONSULTATION" else "दूसरी पूछताछ सबमिट करें")
                    }
                }
            }
        } else {
            // BOOKING FORM
            Text(
                text = if (language == AppLanguage.EN) "ONLINE CONSULTATION & BOOKING SYSTEM" else "ऑनलाइन परामर्श एवं बुकिंग फॉर्म",
                style = MaterialTheme.typography.displayMedium.copy(
                    fontFamily = FontFamily.Serif,
                    color = ForestGreenPrimary,
                    fontSize = 22.sp
                )
            )

            Text(
                text = if (language == AppLanguage.EN)
                    "Submit your consultation enquiry. All bookings require manual confirmation by Vedic Wisdom team."
                else
                    "अपनी परामर्श पूछताछ सबमिट करें। सभी बुकिंग के लिए मैनुअल पुष्टि की आवश्यकता होती है।",
                style = MaterialTheme.typography.bodyMedium.copy(color = MutedCharcoal),
                modifier = Modifier.padding(top = 4.dp, bottom = 20.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = ElegantWhite),
                border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderGold)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    // Multi-Currency Selection Display
                    Column(modifier = Modifier.padding(bottom = 12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = if (language == AppLanguage.EN) "Consultation & Fee Advisory" else "परामर्श एवं शुल्क विवरण",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontFamily = FontFamily.Serif,
                                    color = ForestGreenPrimary,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = ForestGreenPrimary
                            ) {
                                Text(
                                    text = selectedCurrency,
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        color = ChampagneGold,
                                        fontWeight = FontWeight.Bold
                                    ),
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = if (language == AppLanguage.EN) "Select Currency:" else "मुद्रा चुनें:",
                            style = MaterialTheme.typography.labelSmall.copy(color = MutedCharcoal)
                        )
                        androidx.compose.foundation.lazy.LazyRow(
                            modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            val currencies = listOf("USD ($)", "EUR (€)", "GBP (£)", "AED (د.إ)", "CAD (C$)", "AUD (A$)", "SGD (S$)", "INR (₹)")
                            items(currencies.size) { index ->
                                val cur = currencies[index]
                                val isSel = selectedCurrency == cur
                                FilterChip(
                                    selected = isSel,
                                    onClick = { selectedCurrency = cur },
                                    label = { Text(cur, style = MaterialTheme.typography.labelSmall) },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = ForestGreenPrimary,
                                        selectedLabelColor = ChampagneGold,
                                        containerColor = WarmIvoryVariant,
                                        labelColor = SubtleCharcoal
                                    )
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Service Selection Dropdown / Radio List
                    Text(if (language == AppLanguage.EN) "Select Service:" else "सेवा चुनें:", style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold))
                    Column(modifier = Modifier.padding(vertical = 4.dp)) {
                        serviceOptions.forEach { option ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { selectedService = option }
                                    .padding(vertical = 2.dp)
                            ) {
                                RadioButton(selected = selectedService == option, onClick = { selectedService = option })
                                Text(option, style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Mode Selection
                    Text(if (language == AppLanguage.EN) "Consultation Mode:" else "परामर्श माध्यम:", style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        ConsultationMode.values().forEach { mode ->
                            val isSel = selectedMode == mode
                            FilterChip(
                                selected = isSel,
                                onClick = { selectedMode = mode },
                                label = {
                                    Text(
                                        when(mode) {
                                            ConsultationMode.ONLINE_ZOOM -> "Zoom Call"
                                            ConsultationMode.ONLINE_GOOGLE_MEET -> "Google Meet"
                                            ConsultationMode.ONSITE_VISIT -> "Onsite Visit"
                                        },
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Date, Time & Timezone
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = preferredDate,
                            onValueChange = { preferredDate = it },
                            label = { Text("Preferred Date") },
                            modifier = Modifier
                                .weight(1f)
                                .testTag("booking_date_input")
                        )
                        OutlinedTextField(
                            value = preferredTime,
                            onValueChange = { preferredTime = it },
                            label = { Text("Preferred Time") },
                            modifier = Modifier
                                .weight(1f)
                                .testTag("booking_time_input")
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = selectedTimezone,
                        onValueChange = { selectedTimezone = it },
                        label = { Text("Timezone (e.g. IST, EST, PST, GMT, GST)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("booking_timezone_input")
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Contact Details
                    Text(if (language == AppLanguage.EN) "Contact Details:" else "संपर्क विवरण:", style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold))

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Full Name *") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .testTag("booking_name_input")
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email Address *") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .testTag("booking_email_input")
                    )

                    OutlinedTextField(
                        value = selectedCountry,
                        onValueChange = { selectedCountry = it },
                        label = { Text("Country * (e.g. India, USA, UK, UAE)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .testTag("booking_country_input")
                    )

                    OutlinedTextField(
                        value = phone,
                        onValueChange = { phone = it },
                        label = { Text("Phone / WhatsApp (with Country Code) *") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .testTag("booking_phone_input")
                    )

                    OutlinedTextField(
                        value = requirements,
                        onValueChange = { requirements = it },
                        label = { Text("Property / Project Requirements Description") },
                        minLines = 3,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .testTag("booking_requirements_input")
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Floor Plan & Attachment Picker
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = WarmIvoryVariant,
                        border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderGold),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Default.AttachFile, contentDescription = null, tint = ForestGreenPrimary)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = if (language == AppLanguage.EN) "Attach Floor Plan / Layout Photo" else "फ्लोर प्लान अटैच करें",
                                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 13.sp)
                                    )
                                }

                                Button(
                                    onClick = {
                                        isFloorPlanAttached = !isFloorPlanAttached
                                        attachedFileName = if (isFloorPlanAttached) "Sample_FloorPlan_Layout.pdf" else null
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = if (isFloorPlanAttached) SuccessGreen else ForestGreenPrimary
                                    ),
                                    modifier = Modifier.testTag("attach_file_button")
                                ) {
                                    Text(if (isFloorPlanAttached) "Attached ✓" else "Browse...")
                                }
                            }

                            if (attachedFileName != null) {
                                Text(
                                    text = "Selected File: $attachedFileName",
                                    style = MaterialTheme.typography.labelSmall.copy(color = SuccessGreen, fontWeight = FontWeight.Bold),
                                    modifier = Modifier.padding(top = 6.dp)
                                )
                            }
                        }
                    }

                    // Conditional Birth Details for Astro-Vastu or KP
                    if (isBirthDetailsNeeded) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = ForestGreenPrimary.copy(alpha = 0.05f),
                            border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Default.Stars, contentDescription = null, tint = ChampagneGoldDark)
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (language == AppLanguage.EN) "Birth Details (Required for Astro-Vastu & KP)" else "जन्म विवरण (एस्ट्रो-वास्तु एवं केपी के लिए आवश्यक)",
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            color = ForestGreenPrimary,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp
                                        )
                                    )
                                }

                                OutlinedTextField(
                                    value = birthName,
                                    onValueChange = { birthName = it },
                                    label = { Text("Name on Birth Chart") },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 8.dp)
                                        .testTag("birth_name_input")
                                )

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    OutlinedTextField(
                                        value = dateOfBirth,
                                        onValueChange = { dateOfBirth = it },
                                        label = { Text("Date of Birth") },
                                        modifier = Modifier
                                            .weight(1f)
                                            .testTag("dob_input")
                                    )
                                    OutlinedTextField(
                                        value = timeOfBirth,
                                        onValueChange = { timeOfBirth = it },
                                        label = { Text("Exact Time of Birth") },
                                        modifier = Modifier
                                            .weight(1f)
                                            .testTag("tob_input")
                                    )
                                }

                                OutlinedTextField(
                                    value = placeOfBirth,
                                    onValueChange = { placeOfBirth = it },
                                    label = { Text("Place of Birth (City, State, Country)") },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 4.dp)
                                        .testTag("pob_input")
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Privacy Consent Checkbox
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { privacyConsent = !privacyConsent }
                    ) {
                        Checkbox(
                            checked = privacyConsent,
                            onCheckedChange = { privacyConsent = it },
                            modifier = Modifier.testTag("privacy_consent_checkbox")
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (language == AppLanguage.EN)
                                "I accept the Privacy Policy and consent to data processing for consultancy."
                            else
                                "मैं गोपनीयता नीति स्वीकार करता/करती हूँ।",
                            style = MaterialTheme.typography.bodySmall.copy(color = SubtleCharcoal)
                        )
                    }

                    if (validationError != null) {
                        Text(
                            text = validationError!!,
                            style = MaterialTheme.typography.labelSmall.copy(color = AlertWarningOrange),
                            modifier = Modifier.padding(top = 6.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            if (name.isBlank() || email.isBlank() || phone.isBlank()) {
                                validationError = "Please fill in all required fields marked with *."
                            } else if (!privacyConsent) {
                                validationError = "Please accept the data protection consent before submitting."
                            } else {
                                validationError = null
                                val newEnquiry = ConsultationEnquiry(
                                    id = "VW-" + (1000..9999).random(),
                                    serviceName = selectedService,
                                    category = selectedCategory,
                                    mode = selectedMode,
                                    preferredDate = preferredDate,
                                    preferredTime = preferredTime,
                                    timezone = selectedTimezone,
                                    clientName = name,
                                    email = email,
                                    country = selectedCountry,
                                    phone = phone,
                                    currency = selectedCurrency,
                                    requirements = requirements,
                                    floorPlanAttached = isFloorPlanAttached,
                                    floorPlanFileName = attachedFileName,
                                    isBirthDetailsProvided = isBirthDetailsNeeded,
                                    birthName = birthName.ifBlank { null },
                                    dateOfBirth = dateOfBirth.ifBlank { null },
                                    timeOfBirth = timeOfBirth.ifBlank { null },
                                    placeOfBirth = placeOfBirth.ifBlank { null },
                                    privacyConsentAccepted = true
                                )
                                onSubmitEnquiry(newEnquiry)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = ChampagneGold, contentColor = ForestGreenPrimary),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .testTag("submit_booking_enquiry_button")
                    ) {
                        Text(
                            text = if (language == AppLanguage.EN) "SUBMIT CONSULTATION ENQUIRY" else "परामर्श पूछताछ सबमिट करें",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }
        }
    }
}

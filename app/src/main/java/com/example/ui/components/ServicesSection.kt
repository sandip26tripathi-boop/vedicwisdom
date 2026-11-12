package com.example.ui.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.model.AppLanguage
import com.example.model.AppScreen
import com.example.model.ServiceCategory
import com.example.ui.theme.*

@Composable
fun ServicesSection(
    language: AppLanguage,
    onNavigateToBooking: (ServiceCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableStateOf(ServiceCategory.ALL) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(WarmIvory)
            .padding(horizontal = 20.dp, vertical = 32.dp)
    ) {
        // Section Header
        Text(
            text = if (language == AppLanguage.EN) "OUR CONSULTANCY SERVICES" else "हमारी परामर्श सेवाएँ",
            style = MaterialTheme.typography.displayMedium.copy(
                fontFamily = FontFamily.Serif,
                color = ForestGreenPrimary,
                fontSize = 24.sp
            )
        )
        Text(
            text = if (language == AppLanguage.EN)
                "Comprehensive, practical and analytical Vastu consultancy tailored for residential, commercial and industrial properties worldwide."
            else
                "विश्व भर में आवासीय, व्यावसायिक और औद्योगिक संपत्तियों के लिए व्यापक और व्यावहारिक वास्तु परामर्श।",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MutedCharcoal,
                fontSize = 14.sp
            ),
            modifier = Modifier.padding(top = 6.dp, bottom = 20.dp)
        )

        // Category Filter Chips
        androidx.compose.foundation.lazy.LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val filterOptions = listOf(
                ServiceCategory.ALL to (if (language == AppLanguage.EN) "All Services" else "सभी सेवाएँ"),
                ServiceCategory.INDUSTRIAL to (if (language == AppLanguage.EN) "Industrial Vastu" else "औद्योगिक वास्तु"),
                ServiceCategory.NON_DEMOLITION to (if (language == AppLanguage.EN) "Non-Demolition" else "बिना तोड़-फोड़"),
                ServiceCategory.RESIDENTIAL to (if (language == AppLanguage.EN) "Residential" else "आवासीय वास्तु"),
                ServiceCategory.COMMERCIAL to (if (language == AppLanguage.EN) "Commercial & Office" else "व्यावसायिक वास्तु"),
                ServiceCategory.PRE_PURCHASE to (if (language == AppLanguage.EN) "Pre-Purchase Evaluation" else "खरीद-पूर्व मूल्यांकन")
            )

            items(filterOptions.size) { index ->
                val (cat, label) = filterOptions[index]
                val isSelected = selectedTab == cat
                FilterChip(
                    selected = isSelected,
                    onClick = { selectedTab = cat },
                    label = { Text(label, style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold)) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = ForestGreenPrimary,
                        selectedLabelColor = ChampagneGold,
                        containerColor = ElegantWhite,
                        labelColor = SubtleCharcoal
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        enabled = true,
                        selected = isSelected,
                        borderColor = ChampagneGold,
                        selectedBorderColor = ChampagneGold
                    ),
                    modifier = Modifier.testTag("service_filter_${cat.name}")
                )
            }
        }

        // 1. Feature Banner: INDUSTRIAL & FACTORY VASTU (High Prominence)
        if (selectedTab == ServiceCategory.ALL || selectedTab == ServiceCategory.INDUSTRIAL) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
                    .testTag("industrial_vastu_prominent_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = ForestGreenPrimary),
                border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold)
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.img_industrial_vastu_1794441497481),
                        contentDescription = "Industrial & Factory Vastu",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    )
                    Column(modifier = Modifier.padding(20.dp)) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = ChampagneGold,
                            modifier = Modifier.padding(bottom = 10.dp)
                        ) {
                            Text(
                                text = "FEATURED SPECIALISATION",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    color = ForestGreenPrimary,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp
                                ),
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }

                        Text(
                            text = if (language == AppLanguage.EN)
                                "INDUSTRIAL & FACTORY VASTU CONSULTANCY"
                            else
                                "औद्योगिक एवं कारखाना वास्तु परामर्श",
                            style = MaterialTheme.typography.headlineLarge.copy(
                                fontFamily = FontFamily.Serif,
                                color = ChampagneGold,
                                fontSize = 20.sp
                            )
                        )
                        Text(
                            text = if (language == AppLanguage.EN)
                                "Planning Spaces for Business and Industry. Personalised assessments for factory owners, industrialists, and corporate business groups."
                            else
                                "व्यवसाय और उद्योग के लिए स्थान नियोजन। कारखाने के मालिकों और उद्योगपतियों के लिए व्यक्तिगत मूल्यांकन।",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = WarmIvory.copy(alpha = 0.9f)
                            ),
                            modifier = Modifier.padding(vertical = 8.dp)
                        )

                        val industrialServices = if (language == AppLanguage.EN) listOf(
                            "Factory & Manufacturing Unit Vastu Layouts",
                            "Heavy Machinery & Transformer Placement",
                            "Raw Material Storage & Finished Goods Dispatch",
                            "Warehouse, Logistics & Administrative Office Seating"
                        ) else listOf(
                            "फैक्ट्री एवं विनिर्माण इकाई वास्तु लेआउट",
                            "भारी मशीनरी और ट्रांसफार्मर स्थापना",
                            "कच्चा माल भंडारण और तैयार माल प्रेषण",
                            "गोदाम, लॉजिस्टिक्स और प्रशासनिक कार्यालय सीटिंग"
                        )

                        industrialServices.forEach { service ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(vertical = 3.dp)
                            ) {
                                Icon(Icons.Default.Factory, contentDescription = null, tint = ChampagneGold, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(service, style = MaterialTheme.typography.bodySmall.copy(color = WarmIvory))
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { onNavigateToBooking(ServiceCategory.INDUSTRIAL) },
                            colors = ButtonDefaults.buttonColors(containerColor = ChampagneGold, contentColor = ForestGreenPrimary),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth().testTag("industrial_vastu_cta")
                        ) {
                            Text(
                                text = if (language == AppLanguage.EN) "DISCUSS YOUR INDUSTRIAL PROJECT" else "अपने औद्योगिक प्रोजेक्ट पर चर्चा करें",
                                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                            )
                        }
                    }
                }
            }
        }

        // 2. VASTU WITHOUT DEMOLITION (Major Differentiator)
        if (selectedTab == ServiceCategory.ALL || selectedTab == ServiceCategory.NON_DEMOLITION) {
            ServiceCard(
                title = if (language == AppLanguage.EN) "VASTU WITHOUT DEMOLITION" else "बिना तोड़-फोड़ वास्तु समाधान",
                subtitle = if (language == AppLanguage.EN) "PRACTICAL VASTU SOLUTIONS WITHOUT UNNECESSARY DEMOLITION." else "बिना अनावश्यक तोड़-फोड़ के व्यावहारिक वास्तु समाधान।",
                description = if (language == AppLanguage.EN)
                    "Many existing properties can be assessed for practical improvements without automatically recommending structural demolition or expensive reconstruction."
                else
                    "कई मौजूदा संपत्तियों का मूल्यांकन संरचनात्मक तोड़-फोड़ के बिना व्यावहारिक सुधारों के लिए किया जा सकता है।",
                icon = Icons.Default.Build,
                bulletPoints = if (language == AppLanguage.EN) listOf(
                    "Furniture & seating adjustments",
                    "Directional color considerations",
                    "Traditional elemental balancing (Panchtatva)",
                    "Non-structural traditional remedies & space organization"
                ) else listOf(
                    "फर्नीचर और बैठने के समायोजन",
                    "दिशात्मक रंग विचार",
                    "पारंपरिक तत्वीय संतुलन (पंचतत्व)",
                    "गैर-संरचनात्मक पारंपरिक उपाय"
                ),
                ctaText = if (language == AppLanguage.EN) "EXPLORE NON-DEMOLITION VASTU" else "बिना तोड़-फोड़ वास्तु देखें",
                onCtaClick = { onNavigateToBooking(ServiceCategory.NON_DEMOLITION) },
                isHighlight = true,
                testTag = "non_demolition_card"
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // 3. RESIDENTIAL VASTU CONSULTANCY
        if (selectedTab == ServiceCategory.ALL || selectedTab == ServiceCategory.RESIDENTIAL) {
            ServiceCard(
                title = if (language == AppLanguage.EN) "RESIDENTIAL VASTU CONSULTANCY" else "आवासीय वास्तु परामर्श",
                subtitle = if (language == AppLanguage.EN) "Harmonious Living Spaces for Homes & Villas" else "घरों एवं विला के लिए सामंजस्यपूर्ण जीवन वातावरण",
                description = if (language == AppLanguage.EN)
                    "Comprehensive directional assessment for independent houses, apartments, villas, and new home planning."
                else
                    "स्वतंत्र मकानों, अपार्टमेंट, विला और नए घर के नियोजन के लिए व्यापक दिशात्मक मूल्यांकन।",
                icon = Icons.Default.Home,
                bulletPoints = if (language == AppLanguage.EN) listOf(
                    "Main Entrance Analysis & Orientation",
                    "Master Bedroom & Kitchen Positioning",
                    "Living & Dining Space Energy Flow",
                    "Existing Property Vastu Assessment"
                ) else listOf(
                    "मुख्य प्रवेश द्वार विश्लेषण और अभिविन्यास",
                    "मास्टर बेडरूम और रसोई की स्थिति",
                    "लिविंग और डाइनिंग स्पेस ऊर्जा प्रवाह",
                    "मौजूदा संपत्ति वास्तु मूल्यांकन"
                ),
                ctaText = if (language == AppLanguage.EN) "BOOK RESIDENTIAL VASTU" else "आवासीय वास्तु बुक करें",
                onCtaClick = { onNavigateToBooking(ServiceCategory.RESIDENTIAL) },
                testTag = "residential_card"
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // 4. COMMERCIAL AND CORPORATE VASTU
        if (selectedTab == ServiceCategory.ALL || selectedTab == ServiceCategory.COMMERCIAL) {
            ServiceCard(
                title = if (language == AppLanguage.EN) "COMMERCIAL & CORPORATE VASTU" else "व्यावसायिक एवं कॉर्पोरेट वास्तु",
                subtitle = if (language == AppLanguage.EN) "Optimizing Productivity for Businesses & Retail" else "व्यवसायों और रिटेल के लिए उत्पादकता अनुकूलन",
                description = if (language == AppLanguage.EN)
                    "Tailored spatial planning for corporate offices, shops, showrooms, hotels, restaurants, and medical clinics."
                else
                    "कॉर्पोरेट कार्यालयों, दुकानों, शो-रूम, होटलों और क्लीनिकों के लिए अनुकूलित स्थान नियोजन।",
                icon = Icons.Default.Business,
                bulletPoints = if (language == AppLanguage.EN) listOf(
                    "Corporate Office & Executive Seating",
                    "Shops, Showrooms & Reception Layouts",
                    "Commercial Property Assessment",
                    "Cash Counter & Finance Zone Alignment"
                ) else listOf(
                    "कॉर्पोरेट कार्यालय और कार्यकारी सीटिंग",
                    "दुकानें, शो-रूम और रिसेप्शन लेआउट",
                    "व्यावसायिक संपत्ति मूल्यांकन",
                    "कैश काउंटर और वित्त क्षेत्र संरेखण"
                ),
                ctaText = if (language == AppLanguage.EN) "BOOK COMMERCIAL VASTU" else "व्यावसायिक वास्तु बुक करें",
                onCtaClick = { onNavigateToBooking(ServiceCategory.COMMERCIAL) },
                testTag = "commercial_card"
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // 5. PROPERTY SELECTION & PRE-PURCHASE VASTU
        if (selectedTab == ServiceCategory.ALL) {
            ServiceCard(
                title = if (language == AppLanguage.EN) "PROPERTY SELECTION & PRE-PURCHASE VASTU" else "संपत्ति चयन एवं खरीद-पूर्व वास्तु",
                subtitle = if (language == AppLanguage.EN) "Evaluate Before You Invest" else "निवेश से पहले मूल्यांकन करें",
                description = if (language == AppLanguage.EN)
                    "Pre-purchase analysis for residential flats, commercial plots, and industrial land before making financial commitments."
                else
                    "वित्तीय प्रतिबद्धता करने से पहले आवासीय फ्लैटों, व्यावसायिक भूखंडों और औद्योगिक भूमि के लिए खरीद-पूर्व विश्लेषण।",
                icon = Icons.Default.Checklist,
                bulletPoints = if (language == AppLanguage.EN) listOf(
                    "Residential & Commercial Plot Geometry",
                    "Building Orientation & Cardinal Compass Grid",
                    "Layout & Floor Plan Directional Analysis",
                    "Practical Property Evaluation Report"
                ) else listOf(
                    "आवासीय और व्यावसायिक प्लॉट ज्यामिति",
                    "इमारत अभिविन्यास और कार्डिनल कंपास ग्रिड",
                    "लेआउट और फ्लोर प्लान दिशात्मक विश्लेषण",
                    "व्यावहारिक संपत्ति मूल्यांकन रिपोर्ट"
                ),
                ctaText = if (language == AppLanguage.EN) "CHECK YOUR PROPERTY" else "अपनी संपत्ति की जाँच करें",
                onCtaClick = { onNavigateToBooking(ServiceCategory.PRE_PURCHASE) },
                testTag = "pre_purchase_card"
            )
        }
    }
}

@Composable
fun ServiceCard(
    title: String,
    subtitle: String,
    description: String,
    icon: ImageVector,
    bulletPoints: List<String>,
    ctaText: String,
    onCtaClick: () -> Unit,
    isHighlight: Boolean = false,
    testTag: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag(testTag),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isHighlight) ForestGreenSecondary else ElegantWhite
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = if (isHighlight) ChampagneGold else CardBorderGold
        )
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = if (isHighlight) ChampagneGold else ForestGreenPrimary,
                    modifier = Modifier.size(40.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = if (isHighlight) ForestGreenPrimary else ChampagneGold,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontFamily = FontFamily.Serif,
                            color = if (isHighlight) ChampagneGold else ForestGreenPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = if (isHighlight) WarmIvory.copy(alpha = 0.8f) else MutedCharcoal
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = if (isHighlight) WarmIvory else SubtleCharcoal
                )
            )

            Spacer(modifier = Modifier.height(12.dp))
            bulletPoints.forEach { point ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 2.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = ChampagneGold,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = point,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = if (isHighlight) WarmIvory else SubtleCharcoal
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                onClick = onCtaClick,
                border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = if (isHighlight) ChampagneGold else ForestGreenPrimary
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(ctaText, style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold))
            }
        }
    }
}

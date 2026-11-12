package com.example.model

enum class AppLanguage {
    EN, HI
}

enum class AppScreen {
    HOME,
    ABOUT_US,
    VASTU_CONSULTANCY,
    ASTRO_VASTU,
    KP_ASTROLOGY,
    VASTU_COMPASS,
    ACADEMY,
    BLOGS,
    CLIENT_FEEDBACK,
    FAQS,
    BOOK_CONSULTATION,
    CONTACT_US,
    PORTAL,
    BLOG_DETAIL
}

enum class ServiceCategory {
    ALL,
    RESIDENTIAL,
    INDUSTRIAL,
    COMMERCIAL,
    NON_DEMOLITION,
    PRE_PURCHASE
}

enum class ConsultationMode {
    ONLINE_ZOOM,
    ONLINE_GOOGLE_MEET,
    ONSITE_VISIT
}

enum class UserRole {
    CLIENT,
    ADMIN
}

data class ConsultationEnquiry(
    val id: String,
    val serviceName: String,
    val category: ServiceCategory,
    val mode: ConsultationMode,
    val preferredDate: String,
    val preferredTime: String,
    val timezone: String,
    val clientName: String,
    val email: String,
    val country: String,
    val phone: String,
    val currency: String = "USD ($)",
    val requirements: String,
    val floorPlanAttached: Boolean = false,
    val floorPlanFileName: String? = null,
    // Birth details for Astro-Vastu or KP Astrology
    val isBirthDetailsProvided: Boolean = false,
    val birthName: String? = null,
    val dateOfBirth: String? = null,
    val timeOfBirth: String? = null,
    val placeOfBirth: String? = null,
    val privacyConsentAccepted: Boolean,
    val status: String = "Enquiry Received – Pending Manual Confirmation",
    val timestamp: Long = System.currentTimeMillis()
)

data class ContactMessage(
    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val country: String,
    val serviceType: String,
    val message: String,
    val timestamp: Long = System.currentTimeMillis()
)

data class BlogArticle(
    val id: String,
    val slug: String,
    val titleEn: String,
    val titleHi: String,
    val shortDescEn: String,
    val shortDescHi: String,
    val fullContentEn: String,
    val fullContentHi: String,
    val category: String,
    val readTimeMinutes: Int,
    val imageDrawableRes: Int? = null,
    val imageUrl: String? = null,
    val author: String = "Vedic Wisdom Research Team",
    val publishedDate: String = "Nov 2026",
    val isPublished: Boolean = true
)

data class CourseItem(
    val id: String,
    val titleEn: String,
    val titleHi: String,
    val category: String,
    val level: String,
    val duration: String,
    val mode: String,
    val descriptionEn: String,
    val descriptionHi: String,
    val highlights: List<String>
)

data class TestimonialItem(
    val id: String,
    val clientName: String,
    val location: String,
    val category: String, // Residential, Industrial, Commercial, Astro-Vastu, KP
    val rating: Int = 5,
    val textEn: String,
    val textHi: String,
    val date: String
)

data class AdvisoryPanelItem(
    val id: String,
    val name: String,
    val titleEn: String,
    val titleHi: String,
    val specialisationEn: String,
    val specialisationHi: String,
    val iconName: String
)

data class FaqItem(
    val id: String,
    val questionEn: String,
    val questionHi: String,
    val answerEn: String,
    val answerHi: String,
    val category: String
)

data class VastuDirectionZone(
    val zoneCode: String,
    val nameEn: String,
    val nameHi: String,
    val traditionalName: String,
    val elementEn: String,
    val elementHi: String,
    val qualitiesEn: String,
    val qualitiesHi: String,
    val idealForEn: String,
    val idealForHi: String,
    val cautionEn: String,
    val cautionHi: String,
    val colorTone: String
)

enum class LegalModalType {
    NONE,
    PRIVACY_POLICY,
    TERMS_AND_CONDITIONS,
    DISCLAIMER,
    REFUND_POLICY,
    DATA_PROTECTION
}

package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.model.*
import com.example.ui.components.*
import com.example.ui.theme.*
import com.example.viewmodel.VedicViewModel

// Vedic Wisdom - International Vastu & Astro-Vastu Consultancy
class MainActivity : ComponentActivity() {

    private val viewModel: VedicViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            VedicWisdomTheme {
                val language by viewModel.language.collectAsState()
                val currentScreen by viewModel.currentScreen.collectAsState()
                val selectedCategory by viewModel.selectedServiceCategory.collectAsState()
                val selectedBlogId by viewModel.selectedBlogId.collectAsState()
                val blogSearchQuery by viewModel.blogSearchQuery.collectAsState()
                val blogCategoryFilter by viewModel.blogCategoryFilter.collectAsState()
                val testimonialCategoryFilter by viewModel.testimonialCategoryFilter.collectAsState()
                val activeLegalModal by viewModel.activeLegalModal.collectAsState()
                val userRole by viewModel.userRole.collectAsState()
                val enquiries by viewModel.enquiries.collectAsState()
                val blogs by viewModel.blogs.collectAsState()
                val testimonials by viewModel.testimonials.collectAsState()
                val lastSubmittedEnquiry by viewModel.lastSubmittedEnquiry.collectAsState()
                val selectedCourseForEnquiry by viewModel.selectedCourseForEnquiry.collectAsState()
                val lastSubmittedContactMessage by viewModel.lastSubmittedContactMessage.collectAsState()

                // BackHandler for sub-screens
                if (currentScreen != AppScreen.HOME) {
                    BackHandler {
                        viewModel.navigateTo(AppScreen.HOME)
                    }
                }

                Scaffold(
                    topBar = {
                        HeaderNav(
                            currentScreen = currentScreen,
                            language = language,
                            onLanguageToggle = { viewModel.toggleLanguage() },
                            onNavigate = { screen -> viewModel.navigateTo(screen) }
                        )
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(WarmIvory)
                    ) {
                        when (currentScreen) {
                            AppScreen.HOME -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    HeroSection(
                                        language = language,
                                        onNavigate = { screen -> viewModel.navigateTo(screen) }
                                    )
                                    ServicesSection(
                                        language = language,
                                        onNavigateToBooking = { cat -> viewModel.navigateTo(AppScreen.BOOK_CONSULTATION, category = cat) }
                                    )
                                    AstroVastuSection(
                                        language = language,
                                        onNavigateToBooking = { viewModel.navigateTo(AppScreen.BOOK_CONSULTATION, category = ServiceCategory.ALL) }
                                    )
                                    KPAstrologySection(
                                        language = language,
                                        onNavigateToBooking = { viewModel.navigateTo(AppScreen.BOOK_CONSULTATION, category = ServiceCategory.ALL) }
                                    )
                                    VastuCompassSection(
                                        language = language,
                                        onNavigateToBooking = { viewModel.navigateTo(AppScreen.BOOK_CONSULTATION, category = ServiceCategory.ALL) }
                                    )
                                    AboutLeadershipSection(language = language)
                                    AcademySection(
                                        language = language,
                                        onCourseEnquireClick = { course -> viewModel.openCourseEnquiry(course) }
                                    )
                                    BlogsHubSection(
                                        blogs = blogs,
                                        language = language,
                                        searchQuery = blogSearchQuery,
                                        selectedCategory = blogCategoryFilter,
                                        onSearchQueryChange = { q -> viewModel.setBlogSearchQuery(q) },
                                        onCategoryChange = { c -> viewModel.setBlogCategoryFilter(c) },
                                        onReadArticleClick = { b -> viewModel.navigateTo(AppScreen.BLOG_DETAIL, blogId = b.id) }
                                    )
                                    ClientFeedbackSection(
                                        testimonials = testimonials,
                                        language = language,
                                        selectedCategory = testimonialCategoryFilter,
                                        onCategoryChange = { c -> viewModel.setTestimonialCategoryFilter(c) }
                                    )
                                    ConsultationProcessSection(language = language)
                                    FaqSection(
                                        language = language,
                                        onNavigateToBooking = { viewModel.navigateTo(AppScreen.BOOK_CONSULTATION, category = ServiceCategory.ALL) }
                                    )
                                    FooterSection(
                                        language = language,
                                        onNavigate = { screen -> viewModel.navigateTo(screen) },
                                        onOpenLegalModal = { modal -> viewModel.openLegalModal(modal) }
                                    )
                                }
                            }

                            AppScreen.ABOUT_US -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    AboutLeadershipSection(language = language)
                                    FooterSection(
                                        language = language,
                                        onNavigate = { screen -> viewModel.navigateTo(screen) },
                                        onOpenLegalModal = { modal -> viewModel.openLegalModal(modal) }
                                    )
                                }
                            }

                            AppScreen.VASTU_CONSULTANCY -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    ServicesSection(
                                        language = language,
                                        onNavigateToBooking = { cat -> viewModel.navigateTo(AppScreen.BOOK_CONSULTATION, category = cat) }
                                    )
                                    FooterSection(
                                        language = language,
                                        onNavigate = { screen -> viewModel.navigateTo(screen) },
                                        onOpenLegalModal = { modal -> viewModel.openLegalModal(modal) }
                                    )
                                }
                            }

                            AppScreen.ASTRO_VASTU -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    AstroVastuSection(
                                        language = language,
                                        onNavigateToBooking = { viewModel.navigateTo(AppScreen.BOOK_CONSULTATION, category = ServiceCategory.ALL) }
                                    )
                                    FooterSection(
                                        language = language,
                                        onNavigate = { screen -> viewModel.navigateTo(screen) },
                                        onOpenLegalModal = { modal -> viewModel.openLegalModal(modal) }
                                    )
                                }
                            }

                            AppScreen.KP_ASTROLOGY -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    KPAstrologySection(
                                        language = language,
                                        onNavigateToBooking = { viewModel.navigateTo(AppScreen.BOOK_CONSULTATION, category = ServiceCategory.ALL) }
                                    )
                                    FooterSection(
                                        language = language,
                                        onNavigate = { screen -> viewModel.navigateTo(screen) },
                                        onOpenLegalModal = { modal -> viewModel.openLegalModal(modal) }
                                    )
                                }
                            }

                            AppScreen.VASTU_COMPASS -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    VastuCompassSection(
                                        language = language,
                                        onNavigateToBooking = { viewModel.navigateTo(AppScreen.BOOK_CONSULTATION, category = ServiceCategory.ALL) }
                                    )
                                    FooterSection(
                                        language = language,
                                        onNavigate = { screen -> viewModel.navigateTo(screen) },
                                        onOpenLegalModal = { modal -> viewModel.openLegalModal(modal) }
                                    )
                                }
                            }

                            AppScreen.ACADEMY -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    AcademySection(
                                        language = language,
                                        onCourseEnquireClick = { course -> viewModel.openCourseEnquiry(course) }
                                    )
                                    FooterSection(
                                        language = language,
                                        onNavigate = { screen -> viewModel.navigateTo(screen) },
                                        onOpenLegalModal = { modal -> viewModel.openLegalModal(modal) }
                                    )
                                }
                            }

                            AppScreen.BLOGS -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    BlogsHubSection(
                                        blogs = blogs,
                                        language = language,
                                        searchQuery = blogSearchQuery,
                                        selectedCategory = blogCategoryFilter,
                                        onSearchQueryChange = { q -> viewModel.setBlogSearchQuery(q) },
                                        onCategoryChange = { c -> viewModel.setBlogCategoryFilter(c) },
                                        onReadArticleClick = { b -> viewModel.navigateTo(AppScreen.BLOG_DETAIL, blogId = b.id) }
                                    )
                                    FooterSection(
                                        language = language,
                                        onNavigate = { screen -> viewModel.navigateTo(screen) },
                                        onOpenLegalModal = { modal -> viewModel.openLegalModal(modal) }
                                    )
                                }
                            }

                            AppScreen.BLOG_DETAIL -> {
                                val article = blogs.find { it.id == selectedBlogId } ?: blogs.first()
                                Column(
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    BlogDetailView(
                                        article = article,
                                        language = language,
                                        onBackClick = { viewModel.navigateTo(AppScreen.BLOGS) },
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                            }

                            AppScreen.CLIENT_FEEDBACK -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    ClientFeedbackSection(
                                        testimonials = testimonials,
                                        language = language,
                                        selectedCategory = testimonialCategoryFilter,
                                        onCategoryChange = { c -> viewModel.setTestimonialCategoryFilter(c) }
                                    )
                                    FooterSection(
                                        language = language,
                                        onNavigate = { screen -> viewModel.navigateTo(screen) },
                                        onOpenLegalModal = { modal -> viewModel.openLegalModal(modal) }
                                    )
                                }
                            }

                            AppScreen.FAQS -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    FaqSection(
                                        language = language,
                                        onNavigateToBooking = { viewModel.navigateTo(AppScreen.BOOK_CONSULTATION, category = ServiceCategory.ALL) }
                                    )
                                    FooterSection(
                                        language = language,
                                        onNavigate = { screen -> viewModel.navigateTo(screen) },
                                        onOpenLegalModal = { modal -> viewModel.openLegalModal(modal) }
                                    )
                                }
                            }

                            AppScreen.BOOK_CONSULTATION -> {
                                Column(
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    BookingFormSection(
                                        language = language,
                                        initialCategory = selectedCategory,
                                        lastSubmittedEnquiry = lastSubmittedEnquiry,
                                        onSubmitEnquiry = { enq -> viewModel.submitConsultationEnquiry(enq) },
                                        onClearConfirmation = { viewModel.clearLastSubmittedEnquiry() },
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                            }

                            AppScreen.CONTACT_US -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    ContactUsSection(
                                        language = language,
                                        lastSubmittedMessage = lastSubmittedContactMessage,
                                        onSubmitContactMessage = { msg -> viewModel.submitContactMessage(msg) },
                                        onClearConfirmation = { viewModel.clearLastSubmittedContactMessage() },
                                        onNavigateToBooking = { viewModel.navigateTo(AppScreen.BOOK_CONSULTATION) }
                                    )
                                    FooterSection(
                                        language = language,
                                        onNavigate = { screen -> viewModel.navigateTo(screen) },
                                        onOpenLegalModal = { modal -> viewModel.openLegalModal(modal) }
                                    )
                                }
                            }

                            AppScreen.PORTAL -> {
                                Column(
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    PortalSection(
                                        userRole = userRole,
                                        enquiries = enquiries,
                                        blogs = blogs,
                                        language = language,
                                        onRoleToggle = { role -> viewModel.setUserRole(role) },
                                        onAddBlogArticle = { tEn, tHi, cat, sEn, sHi, fEn, fHi ->
                                            viewModel.addBlogArticle(tEn, tHi, cat, sEn, sHi, fEn, fHi)
                                        },
                                        onToggleBlogPublish = { bId -> viewModel.toggleBlogPublishStatus(bId) },
                                        onDeleteBlogArticle = { bId -> viewModel.deleteBlogArticle(bId) },
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                            }
                        }

                        // Legal Modal
                        LegalModalDialog(
                            type = activeLegalModal,
                            language = language,
                            onDismiss = { viewModel.closeLegalModal() }
                        )

                        // Course Enquiry Dialog
                        if (selectedCourseForEnquiry != null) {
                            val course = selectedCourseForEnquiry!!
                            AlertDialog(
                                onDismissRequest = { viewModel.closeCourseEnquiry() },
                                title = { Text("Enquire: ${if (language == AppLanguage.EN) course.titleEn else course.titleHi}") },
                                text = {
                                    Text(
                                        "To enroll or ask questions regarding ${course.titleEn} (${course.duration}, ${course.mode}), please contact Vedic Wisdom Academy via ask.vedicwisdom@gmail.com or WhatsApp +91 90094 48601."
                                    )
                                },
                                confirmButton = {
                                    Button(
                                        onClick = {
                                            viewModel.closeCourseEnquiry()
                                            viewModel.navigateTo(AppScreen.BOOK_CONSULTATION)
                                        },
                                        colors = ButtonDefaults.buttonColors(containerColor = ChampagneGold, contentColor = ForestGreenPrimary)
                                    ) {
                                        Text("Proceed to Booking")
                                    }
                                },
                                dismissButton = {
                                    TextButton(onClick = { viewModel.closeCourseEnquiry() }) {
                                        Text("Close")
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

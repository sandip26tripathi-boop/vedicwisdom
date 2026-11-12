package com.example.viewmodel

import androidx.lifecycle.ViewModel
import com.example.data.VedicData
import com.example.model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID

class VedicViewModel : ViewModel() {

    private val _language = MutableStateFlow(AppLanguage.EN)
    val language: StateFlow<AppLanguage> = _language.asStateFlow()

    private val _currentScreen = MutableStateFlow(AppScreen.HOME)
    val currentScreen: StateFlow<AppScreen> = _currentScreen.asStateFlow()

    private val _selectedServiceCategory = MutableStateFlow(ServiceCategory.ALL)
    val selectedServiceCategory: StateFlow<ServiceCategory> = _selectedServiceCategory.asStateFlow()

    private val _selectedBlogId = MutableStateFlow<String?>(null)
    val selectedBlogId: StateFlow<String?> = _selectedBlogId.asStateFlow()

    private val _blogSearchQuery = MutableStateFlow("")
    val blogSearchQuery: StateFlow<String> = _blogSearchQuery.asStateFlow()

    private val _blogCategoryFilter = MutableStateFlow("ALL")
    val blogCategoryFilter: StateFlow<String> = _blogCategoryFilter.asStateFlow()

    private val _testimonialCategoryFilter = MutableStateFlow("ALL")
    val testimonialCategoryFilter: StateFlow<String> = _testimonialCategoryFilter.asStateFlow()

    private val _activeLegalModal = MutableStateFlow(LegalModalType.NONE)
    val activeLegalModal: StateFlow<LegalModalType> = _activeLegalModal.asStateFlow()

    private val _userRole = MutableStateFlow(UserRole.CLIENT)
    val userRole: StateFlow<UserRole> = _userRole.asStateFlow()

    private val _enquiries = MutableStateFlow<List<ConsultationEnquiry>>(emptyList())
    val enquiries: StateFlow<List<ConsultationEnquiry>> = _enquiries.asStateFlow()

    private val _blogs = MutableStateFlow(VedicData.INITIAL_BLOGS)
    val blogs: StateFlow<List<BlogArticle>> = _blogs.asStateFlow()

    private val _testimonials = MutableStateFlow(VedicData.INITIAL_TESTIMONIALS)
    val testimonials: StateFlow<List<TestimonialItem>> = _testimonials.asStateFlow()

    private val _courses = MutableStateFlow(VedicData.INITIAL_COURSES)
    val courses: StateFlow<List<CourseItem>> = _courses.asStateFlow()

    // Last submitted enquiry for confirmation screen
    private val _lastSubmittedEnquiry = MutableStateFlow<ConsultationEnquiry?>(null)
    val lastSubmittedEnquiry: StateFlow<ConsultationEnquiry?> = _lastSubmittedEnquiry.asStateFlow()

    // Course Enquiry Dialog State
    private val _selectedCourseForEnquiry = MutableStateFlow<CourseItem?>(null)
    val selectedCourseForEnquiry: StateFlow<CourseItem?> = _selectedCourseForEnquiry.asStateFlow()

    // Contact messages state
    private val _contactMessages = MutableStateFlow<List<ContactMessage>>(emptyList())
    val contactMessages: StateFlow<List<ContactMessage>> = _contactMessages.asStateFlow()

    private val _lastSubmittedContactMessage = MutableStateFlow<ContactMessage?>(null)
    val lastSubmittedContactMessage: StateFlow<ContactMessage?> = _lastSubmittedContactMessage.asStateFlow()

    fun submitContactMessage(message: ContactMessage) {
        _contactMessages.value = _contactMessages.value + message
        _lastSubmittedContactMessage.value = message
    }

    fun clearLastSubmittedContactMessage() {
        _lastSubmittedContactMessage.value = null
    }

    fun toggleLanguage() {
        _language.value = if (_language.value == AppLanguage.EN) AppLanguage.HI else AppLanguage.EN
    }

    fun setLanguage(lang: AppLanguage) {
        _language.value = lang
    }

    fun navigateTo(screen: AppScreen, category: ServiceCategory = ServiceCategory.ALL, blogId: String? = null) {
        _selectedServiceCategory.value = category
        if (blogId != null) {
            _selectedBlogId.value = blogId
        }
        _currentScreen.value = screen
    }

    fun setBlogSearchQuery(query: String) {
        _blogSearchQuery.value = query
    }

    fun setBlogCategoryFilter(category: String) {
        _blogCategoryFilter.value = category
    }

    fun setTestimonialCategoryFilter(category: String) {
        _testimonialCategoryFilter.value = category
    }

    fun openLegalModal(type: LegalModalType) {
        _activeLegalModal.value = type
    }

    fun closeLegalModal() {
        _activeLegalModal.value = LegalModalType.NONE
    }

    fun setUserRole(role: UserRole) {
        _userRole.value = role
    }

    fun submitConsultationEnquiry(enquiry: ConsultationEnquiry) {
        val updatedList = _enquiries.value + enquiry
        _enquiries.value = updatedList
        _lastSubmittedEnquiry.value = enquiry
    }

    fun clearLastSubmittedEnquiry() {
        _lastSubmittedEnquiry.value = null
    }

    fun openCourseEnquiry(course: CourseItem) {
        _selectedCourseForEnquiry.value = course
    }

    fun closeCourseEnquiry() {
        _selectedCourseForEnquiry.value = null
    }

    // Admin Blog Management Actions
    fun addBlogArticle(titleEn: String, titleHi: String, category: String, shortDescEn: String, shortDescHi: String, fullEn: String, fullHi: String) {
        val newArticle = BlogArticle(
            id = "b_" + UUID.randomUUID().toString().take(6),
            slug = titleEn.lowercase().replace(" ", "-").replace("[^a-z0-9-]".toRegex(), ""),
            titleEn = titleEn,
            titleHi = titleHi,
            shortDescEn = shortDescEn,
            shortDescHi = shortDescHi,
            fullContentEn = fullEn,
            fullContentHi = fullHi,
            category = category,
            readTimeMinutes = 5,
            publishedDate = "Nov 2026",
            isPublished = true
        )
        _blogs.value = listOf(newArticle) + _blogs.value
    }

    fun toggleBlogPublishStatus(blogId: String) {
        _blogs.value = _blogs.value.map {
            if (it.id == blogId) it.copy(isPublished = !it.isPublished) else it
        }
    }

    fun deleteBlogArticle(blogId: String) {
        _blogs.value = _blogs.value.filterNot { it.id == blogId }
    }
}

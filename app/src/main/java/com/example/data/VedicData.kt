package com.example.data

import com.example.model.*

object VedicData {

    const val MANDATORY_DISCLAIMER_EN =
        "Vedic Wisdom provides consultancy and educational guidance based on traditional Vastu Shastra, Astro-Vastu, KP Astrology and Vedic Astrology principles. These systems are rooted in traditional beliefs and classical interpretations. Our services are intended for informational, educational and personal guidance purposes. We do not guarantee any specific financial, professional, health, relationship or other outcome. Results may vary depending on individual circumstances. Our services are not a substitute for qualified legal, medical, financial, architectural or engineering advice."

    const val TESTIMONIAL_DISCLAIMER_EN =
        "Individual client experiences are personal and do not represent guaranteed outcomes. (Sample client feedback shown with consent.)"

    data class PricingTier(
        val id: String,
        val serviceName: String,
        val category: String,
        val priceInr: String,
        val priceUsd: String,
        val originalPriceInr: String,
        val originalPriceUsd: String,
        val discountTag: String,
        val deliveryTime: String,
        val deliverables: List<String>
    )

    val CONSULTATION_PRICING = listOf(
        PricingTier(
            id = "astrology_personal",
            serviceName = "Classical Vedic & KP Astrology Consultation",
            category = "Astrology Advisory",
            priceInr = "₹2,499",
            priceUsd = "$49",
            originalPriceInr = "₹4,000",
            originalPriceUsd = "$79",
            discountTag = "38% OFF",
            deliveryTime = "45-Minute Live Video Call + Digital Chart",
            deliverables = listOf(
                "Full Birth Chart & KP Cusp Sub-Lord Analysis",
                "Career, Wealth & Key Dasha Timing Roadmap",
                "Specific Query Clarification with Remedies",
                "Audio Recording of Session Provided"
            )
        ),
        PricingTier(
            id = "varshphal_report",
            serviceName = "Yearly Varshphal & KP Planetary Transit Report",
            category = "Digital Report",
            priceInr = "₹999",
            priceUsd = "$19",
            originalPriceInr = "₹2,000",
            originalPriceUsd = "$39",
            discountTag = "50% OFF",
            deliveryTime = "Digital PDF Dossier (38–45 Pages)",
            deliverables = listOf(
                "Month-by-Month Predictive Cashflow & Career Index",
                "Exact Dates for Saturn & Jupiter Transit Triggers",
                "Muntha Lord Position & Annual Ruler Strength",
                "Custom Non-Demolition Remedial Guidance"
            )
        ),
        PricingTier(
            id = "business_blueprint",
            serviceName = "Business, Wealth & Career Blueprint",
            category = "Enterprise Report",
            priceInr = "₹1,499",
            priceUsd = "$29",
            originalPriceInr = "₹3,000",
            originalPriceUsd = "$59",
            discountTag = "50% OFF",
            deliveryTime = "Same-Day PDF Delivery (50–60 Pages)",
            deliverables = listOf(
                "KP Cuspal Interlink Analysis of 2nd, 6th, 10th & 11th Houses",
                "5-Year Financial & Commercial Growth Trajectory",
                "Favorable Windows for Expansion, Partnerships & Assets",
                "Name Spelling & Brand Number Alignment Score"
            )
        ),
        PricingTier(
            id = "residential_vastu",
            serviceName = "Residential Vastu & Astro-Vastu Audit",
            category = "Residential Vastu",
            priceInr = "₹7,999",
            priceUsd = "$119",
            originalPriceInr = "₹12,000",
            originalPriceUsd = "$169",
            discountTag = "34% OFF",
            deliveryTime = "3 to 5 Business Days Delivery",
            deliverables = listOf(
                "16 Directional Zones CAD Floor Plan Evaluation",
                "Main Entrance Cardinal Degree Verification",
                "0% Demolition Remedies: Color, Metallic Tapes & Furniture",
                "Personalized Astro-Vastu Birth Chart Synchronization"
            )
        ),
        PricingTier(
            id = "commercial_vastu",
            serviceName = "Commercial Office & Corporate Vastu Audit",
            category = "Commercial Vastu",
            priceInr = "₹12,999",
            priceUsd = "$189",
            originalPriceInr = "₹18,000",
            originalPriceUsd = "$249",
            discountTag = "28% OFF",
            deliveryTime = "4 to 6 Business Days Delivery",
            deliverables = listOf(
                "Workstation Seating, MD Cabin & Boardroom Directional Grid",
                "Cash Counter, Accounts Desk & Finance Zone Realignment",
                "IT Server Room & Heavy Hardware Orientation",
                "Comprehensive Digital CAD Blueprint & Implementation Guide"
            )
        ),
        PricingTier(
            id = "industrial_vastu",
            serviceName = "Industrial & Factory Comprehensive Vastu Audit",
            category = "Industrial Vastu",
            priceInr = "₹24,999",
            priceUsd = "$349",
            originalPriceInr = "₹35,000",
            originalPriceUsd = "$499",
            discountTag = "29% OFF",
            deliveryTime = "5 to 7 Business Days Delivery",
            deliverables = listOf(
                "Production Machinery, Furnace & Boiler Alignment",
                "Raw Material Storage vs Finished Goods Dispatch Flow",
                "High-Voltage Transformer & Generator Placement",
                "Zero Downtime Phased Remedial Implementation"
            )
        )
    )

    val ADVISORY_PANEL = listOf(
        AdvisoryPanelItem("adv_1", "Senior Vastu Advisor", "Senior Vastu Advisor", "Senior Vastu Advisor", "Residential & Cardinal Grid Alignment", "Residential & Cardinal Grid Alignment", "home"),
        AdvisoryPanelItem("adv_2", "Industrial Vastu Specialist", "Industrial Vastu Specialist", "Industrial Vastu Specialist", "Factory Layouts & Plant Logistics", "Factory Layouts & Plant Logistics", "factory"),
        AdvisoryPanelItem("adv_3", "Astro-Vastu Research Advisor", "Astro-Vastu Research Advisor", "Astro-Vastu Research Advisor", "Birth Chart & Spatial Energy Synergy", "Birth Chart & Spatial Energy Synergy", "stars"),
        AdvisoryPanelItem("adv_4", "KP Astrology Research Advisor", "KP Astrology Research Advisor", "KP Astrology Research Advisor", "Cusp Sub-Lord & Precise Timing Analytics", "Cusp Sub-Lord & Precise Timing Analytics", "psychology"),
        AdvisoryPanelItem("adv_5", "Architecture & Space Planning Advisor", "Architecture & Space Planning Advisor", "Architecture & Space Planning Advisor", "Structural Synergy & Spatial Optimization", "Structural Synergy & Spatial Optimization", "architecture"),
        AdvisoryPanelItem("adv_6", "Education & Training Advisor", "Education & Training Advisor", "Education & Training Advisor", "Academic Curriculum & Certification Standards", "Academic Curriculum & Certification Standards", "school"),
        AdvisoryPanelItem("adv_7", "Business Strategy Advisor", "Business Strategy Advisor", "Business Strategy Advisor", "Commercial Premises & Operational Harmony", "Commercial Premises & Operational Harmony", "business")
    )

    val INITIAL_COURSES = listOf(
        CourseItem(
            id = "c1",
            titleEn = "Industrial & Commercial Vastu Masterclass",
            titleHi = "Industrial & Commercial Vastu Masterclass",
            category = "Industrial Vastu",
            level = "Professional Practitioner",
            duration = "10 Weeks (30 Hours + Field Audits)",
            mode = "Live Cohort + 3D CAD Layouts",
            descriptionEn = "Specialized certification for industrial plots, production plant machinery orientation, raw material storage, and administrative office suites.",
            descriptionHi = "Specialized certification for industrial plots, production plant machinery orientation, raw material storage, and administrative office suites.",
            highlights = listOf(
                "Fee: ₹18,500 / $249 (Reg: ₹30,000 / $399 — 38% OFF)",
                "Factory Machinery Footing & Transformer Zoning",
                "Dispatch Docks & Logistics Flow Optimization",
                "Official Vedic Wisdom Certificate of Mastery"
            )
        ),
        CourseItem(
            id = "c2",
            titleEn = "Complete 3-in-1 Vastu Masterclass",
            titleHi = "Complete 3-in-1 Vastu Masterclass",
            category = "Vastu Shastra",
            level = "Basic to Professional",
            duration = "10 Weeks (Live Sessions)",
            mode = "Live Interactive Cohort",
            descriptionEn = "Master 16 cardinal zones, 5 elements (Panchtatva), 45 Devta energy fields, 32 entrances, and practical 0% non-demolition remedies.",
            descriptionHi = "Master 16 cardinal zones, 5 elements (Panchtatva), 45 Devta energy fields, 32 entrances, and practical 0% non-demolition remedies.",
            highlights = listOf(
                "Fee: ₹16,999 / $219 (Reg: ₹28,000 / $349 — 39% OFF)",
                "16 Directional Zones & 45 Energy Fields",
                "Non-Demolition Metallic Taping & Color Balancing",
                "Practical Case Studies of Real Client Properties"
            )
        ),
        CourseItem(
            id = "c3",
            titleEn = "KP Astrology & Cuspal Interlink Mastery",
            titleHi = "KP Astrology & Cuspal Interlink Mastery",
            category = "KP Astrology",
            level = "Advanced Analytical",
            duration = "8 Weeks (Live Weekend Batches)",
            mode = "Live Classes + Recorded Access",
            descriptionEn = "Placidus house system, Star Lords, Sub-Lord and Sub-Sub Lord calculations, and Cuspal Interlink Theory (CIL) for event timing.",
            descriptionHi = "Placidus house system, Star Lords, Sub-Lord and Sub-Sub Lord calculations, and Cuspal Interlink Theory (CIL) for event timing.",
            highlights = listOf(
                "Fee: ₹14,999 / $199 (Reg: ₹24,999 / $299 — 40% OFF)",
                "Sub-Lord & Sub-Sub Lord Calculation Precision",
                "Ruling Planets (RP) for Birth Time Rectification",
                "Career, Business & Financial Timing House Groupings"
            )
        ),
        CourseItem(
            id = "c4",
            titleEn = "Nadi Astrology & Planetary Transits",
            titleHi = "Nadi Astrology & Planetary Transits",
            category = "Astrology",
            level = "Intermediate to Advanced",
            duration = "6 Weeks (Live Classes)",
            mode = "Live Sessions + Transit Software",
            descriptionEn = "Planetary Karakattwas, directional trine links (1-5-9, 2-6-10, 3-7-11), and transit triggers over natal planets for career promotion and wealth.",
            descriptionHi = "Planetary Karakattwas, directional trine links (1-5-9, 2-6-10, 3-7-11), and transit triggers over natal planets for career promotion and wealth.",
            highlights = listOf(
                "Fee: ₹8,999 / $119 (Reg: ₹14,999 / $199 — 40% OFF)",
                "Jupiter, Saturn & Venus Karaka Combinations",
                "Saturn Transit Timing for Professional Shifts",
                "High-Definition Class Recordings Included"
            )
        ),
        CourseItem(
            id = "c5",
            titleEn = "Jaimini Astrology & Chara Dasha",
            titleHi = "Jaimini Astrology & Chara Dasha",
            category = "Astrology",
            level = "Practitioner Masterclass",
            duration = "8 Weeks (24 Live Hours)",
            mode = "Masterclass + Sutra Decryption",
            descriptionEn = "Chara Karakas (Atmakaraka, Amatyakaraka), Karakamsha Kundli, Navamsha decoding for soul mission, and Arudha Padas.",
            descriptionHi = "Chara Karakas (Atmakaraka, Amatyakaraka), Karakamsha Kundli, Navamsha decoding for soul mission, and Arudha Padas.",
            highlights = listOf(
                "Fee: ₹7,999 / $99 (Reg: ₹12,999 / $169 — 38% OFF)",
                "Chara Dasha System & Arudha Padas (A1 to A12)",
                "Navamsha Decoding for Career & Marriage",
                "Official Certificate of Completion"
            )
        )
    )

    val INITIAL_TESTIMONIALS = listOf(
        TestimonialItem(
            id = "t1",
            clientName = "Rajesh Sharma",
            location = "Delhi NCR, India",
            category = "Residential Vastu",
            rating = 5,
            textEn = "The non-demolition approach was extremely practical. Simple furniture realignment and directional color balancing made a noticeable difference in our apartment's ambiance.",
            textHi = "The non-demolition approach was extremely practical. Simple furniture realignment and directional color balancing made a noticeable difference in our apartment's ambiance.",
            date = "Oct 2026"
        ),
        TestimonialItem(
            id = "t2",
            clientName = "Vikram Patel",
            location = "Ahmedabad, Gujarat",
            category = "Industrial Vastu",
            rating = 5,
            textEn = "Sandeep Tripathi provided scientific and logical guidance for our factory machinery layout and raw material dispatch zones. Very professional analytical approach without production interruption.",
            textHi = "Sandeep Tripathi provided scientific and logical guidance for our factory machinery layout and raw material dispatch zones. Very professional analytical approach without production interruption.",
            date = "Sep 2026"
        ),
        TestimonialItem(
            id = "t3",
            clientName = "Ananya Roy",
            location = "London, UK",
            category = "Astro-Vastu",
            rating = 5,
            textEn = "Combining horoscope analysis with spatial Vastu zones gave us clear clarity for our international home purchase in London. Highly methodical virtual consultation.",
            textHi = "Combining horoscope analysis with spatial Vastu zones gave us clear clarity for our international home purchase in London. Highly methodical virtual consultation.",
            date = "Oct 2026"
        ),
        TestimonialItem(
            id = "t4",
            clientName = "Suresh Menon",
            location = "Bengaluru, Karnataka",
            category = "Commercial Vastu",
            rating = 5,
            textEn = "Our tech office workstation seating and reception area planning was guided smoothly without structural changes. Excellent corporate consultation.",
            textHi = "Our tech office workstation seating and reception area planning was guided smoothly without structural changes. Excellent corporate consultation.",
            date = "Aug 2026"
        ),
        TestimonialItem(
            id = "t5",
            clientName = "Dr. Meenakshi Sundaram",
            location = "Chennai, Tamil Nadu",
            category = "KP Astrology",
            rating = 5,
            textEn = "The KP Astrology cusp sub-lord breakdown was logical, precise, and devoid of superstition. Great focus on analytical reasoning.",
            textHi = "The KP Astrology cusp sub-lord breakdown was logical, precise, and devoid of superstition. Great focus on analytical reasoning.",
            date = "Nov 2026"
        ),
        TestimonialItem(
            id = "t6",
            clientName = "Harpreet Singh",
            location = "Ludhiana, Punjab",
            category = "Industrial Vastu",
            rating = 5,
            textEn = "We consulted Vedic Wisdom for our textile manufacturing unit expansion. The warehouse dispatch alignment guidance was immensely practical.",
            textHi = "We consulted Vedic Wisdom for our textile manufacturing unit expansion. The warehouse dispatch alignment guidance was immensely practical.",
            date = "Sep 2026"
        ),
        TestimonialItem(
            id = "t7",
            clientName = "Amitabh Saxena",
            location = "Dubai, UAE",
            category = "Astro-Vastu",
            rating = 5,
            textEn = "Prompt online consultation via Zoom. The detailed digital report and clear explanation of directional elements were impressive.",
            textHi = "Prompt online consultation via Zoom. The detailed digital report and clear explanation of directional elements were impressive.",
            date = "Oct 2026"
        ),
        TestimonialItem(
            id = "t8",
            clientName = "Pooja Malhotra",
            location = "Mumbai, Maharashtra",
            category = "Residential Vastu",
            rating = 5,
            textEn = "Pre-purchase flat assessment saved us from choosing an awkwardly oriented apartment. The directional layout breakdown was eye-opening.",
            textHi = "Pre-purchase flat assessment saved us from choosing an awkwardly oriented apartment. The directional layout breakdown was eye-opening.",
            date = "Nov 2026"
        )
    )

    val VASTU_DIRECTIONS = listOf(
        VastuDirectionZone(
            zoneCode = "N",
            nameEn = "North Zone (0° - 360°)",
            nameHi = "North Zone (0°)",
            traditionalName = "Kubera Sthan",
            elementEn = "Water Element (Jal)",
            elementHi = "Water Element",
            qualitiesEn = "Career growth, financial opportunities, wealth inflow & business expansion.",
            qualitiesHi = "Career growth, financial opportunities, wealth inflow & business expansion.",
            idealForEn = "Main entrance, living room, treasury, open fountain, reception desk.",
            idealForHi = "Main entrance, living room, treasury, open fountain, reception desk.",
            cautionEn = "Avoid kitchen (fire), heavy dead storage, or red/orange color themes.",
            cautionHi = "Avoid kitchen (fire), heavy dead storage, or red/orange color themes.",
            colorTone = "#D4AF37"
        ),
        VastuDirectionZone(
            zoneCode = "NE",
            nameEn = "North-East Zone (45°)",
            nameHi = "North-East Zone (45°)",
            traditionalName = "Ishan Sthan",
            elementEn = "Water & Divine Space",
            elementHi = "Water & Divine Space",
            qualitiesEn = "Mental clarity, vision, analytical sharpness, health & spiritual balance.",
            qualitiesHi = "Mental clarity, vision, analytical sharpness, health & spiritual balance.",
            idealForEn = "Meditation space, library, study table, light greenery, clean open terrace.",
            idealForHi = "Meditation space, library, study table, light greenery, clean open terrace.",
            cautionEn = "Strictly avoid toilets, septic tanks, heavy structural columns, or trash.",
            cautionHi = "Strictly avoid toilets, septic tanks, heavy structural columns, or trash.",
            colorTone = "#D4AF37"
        ),
        VastuDirectionZone(
            zoneCode = "E",
            nameEn = "East Zone (90°)",
            nameHi = "East Zone (90°)",
            traditionalName = "Indra Sthan",
            elementEn = "Air Element (Vayu)",
            elementHi = "Air Element",
            qualitiesEn = "Social networking, government connections, reputation, vitality.",
            qualitiesHi = "Social networking, government connections, reputation, vitality.",
            idealForEn = "Balconies, large windows, consultation room, living area, green plants.",
            idealForHi = "Balconies, large windows, consultation room, living area, green plants.",
            cautionEn = "Avoid blocking morning natural daylight; avoid dark clutter.",
            cautionHi = "Avoid blocking morning natural daylight; avoid dark clutter.",
            colorTone = "#D4AF37"
        ),
        VastuDirectionZone(
            zoneCode = "SE",
            nameEn = "South-East Zone (135°)",
            nameHi = "South-East Zone (135°)",
            traditionalName = "Agni Sthan",
            elementEn = "Fire Element (Agni)",
            elementHi = "Fire Element",
            qualitiesEn = "Dynamic energy, operational drive, cash liquidity, quick payment realization.",
            qualitiesHi = "Dynamic energy, operational drive, cash liquidity, quick payment realization.",
            idealForEn = "Kitchen cooking stove, electric transformers, boilers, manufacturing heating units.",
            idealForHi = "Kitchen cooking stove, electric transformers, boilers, manufacturing heating units.",
            cautionEn = "Strictly avoid underground water tanks, borewells, or blue/black shades.",
            cautionHi = "Strictly avoid underground water tanks, borewells, or blue/black shades.",
            colorTone = "#B45309"
        ),
        VastuDirectionZone(
            zoneCode = "S",
            nameEn = "South Zone (180°)",
            nameHi = "South Zone (180°)",
            traditionalName = "Yama Sthan",
            elementEn = "Fire / Earth Element",
            elementHi = "Fire / Earth Element",
            qualitiesEn = "Brand recognition, public prestige, legal strength, restful sleep.",
            qualitiesHi = "Brand recognition, public prestige, legal strength, restful sleep.",
            idealForEn = "Executive cabins, master bedroom, corporate boardroom.",
            idealForHi = "Executive cabins, master bedroom, corporate boardroom.",
            cautionEn = "Keep higher than North; avoid water depressions or water borewells.",
            cautionHi = "Keep higher than North; avoid water depressions or water borewells.",
            colorTone = "#B45309"
        ),
        VastuDirectionZone(
            zoneCode = "SW",
            nameEn = "South-West Zone (225°)",
            nameHi = "South-West Zone (225°)",
            traditionalName = "Nairutya Sthan",
            elementEn = "Earth Element (Prithvi)",
            elementHi = "Earth Element",
            qualitiesEn = "Steadfast stability, skill retention, executive authority, relationship grounding.",
            qualitiesHi = "Steadfast stability, skill retention, executive authority, relationship grounding.",
            idealForEn = "CEO / MD office desk, master bedroom, heavy machinery, raw material store.",
            idealForHi = "CEO / MD office desk, master bedroom, heavy machinery, raw material store.",
            cautionEn = "Never create cut corners, extensions, toilets, or underground water tanks here.",
            cautionHi = "Never create cut corners, extensions, toilets, or underground water tanks here.",
            colorTone = "#D4AF37"
        ),
        VastuDirectionZone(
            zoneCode = "W",
            nameEn = "West Zone (270°)",
            nameHi = "West Zone (270°)",
            traditionalName = "Varuna Sthan",
            elementEn = "Space Element (Akash)",
            elementHi = "Space Element",
            qualitiesEn = "Profits, fulfillment of wishes, client retention, business returns.",
            qualitiesHi = "Profits, fulfillment of wishes, client retention, business returns.",
            idealForEn = "Children study space, dining area, sales and marketing office, server room.",
            idealForHi = "Children study space, dining area, sales and marketing office, server room.",
            cautionEn = "Avoid green plant overload or inappropriate water drainage.",
            cautionHi = "Avoid green plant overload or inappropriate water drainage.",
            colorTone = "#D4AF37"
        ),
        VastuDirectionZone(
            zoneCode = "NW",
            nameEn = "North-West Zone (315°)",
            nameHi = "North-West Zone (315°)",
            traditionalName = "Vayu Sthan",
            elementEn = "Air Element (Vayu)",
            elementHi = "Air Element",
            qualitiesEn = "Commercial mobility, finished goods turnover, banking support, logistical flow.",
            qualitiesHi = "Commercial mobility, finished goods turnover, banking support, logistical flow.",
            idealForEn = "Finished goods warehouse, shipping & dispatch docks, guest bedrooms.",
            idealForHi = "Finished goods warehouse, shipping & dispatch docks, guest bedrooms.",
            cautionEn = "Avoid master bedroom for owner or heavy stationary dead storage.",
            cautionHi = "Avoid master bedroom for owner or heavy stationary dead storage.",
            colorTone = "#D4AF37"
        )
    )

    val FAQS = listOf(
        FaqItem(
            id = "faq_1",
            questionEn = "How does Vastu Without Demolition actually work?",
            questionHi = "How does Vastu Without Demolition actually work?",
            answerEn = "Traditional Vastu Shastra is fundamentally based on Panchtatva (Five Elements) balance and directional energy flows. By adjusting furniture layouts, workstation positions, color spectrums, metal balancing tapes (brass/copper), and space utility, energy bottlenecks can be resolved without breaking walls.",
            answerHi = "Traditional Vastu Shastra is fundamentally based on Panchtatva (Five Elements) balance and directional energy flows. By adjusting furniture layouts, workstation positions, color spectrums, metal balancing tapes (brass/copper), and space utility, energy bottlenecks can be resolved without breaking walls.",
            category = "Non-Demolition Vastu"
        ),
        FaqItem(
            id = "faq_2",
            questionEn = "Can factory and industrial layouts be audited without disrupting ongoing manufacturing?",
            questionHi = "Can factory and industrial layouts be audited without disrupting ongoing manufacturing?",
            answerEn = "Yes. Our industrial consultations evaluate CAD architectural drawings, production line flow, transformer placement, raw material storage, and dispatch bays analytically. We provide actionable, phased realignment recommendations that do not stop production.",
            answerHi = "Yes. Our industrial consultations evaluate CAD architectural drawings, production line flow, transformer placement, raw material storage, and dispatch bays analytically. We provide actionable, phased realignment recommendations that do not stop production.",
            category = "Industrial Vastu"
        ),
        FaqItem(
            id = "faq_3",
            questionEn = "What is the difference between General Vastu and Astro-Vastu?",
            questionHi = "What is the difference between General Vastu and Astro-Vastu?",
            answerEn = "General Vastu establishes directional harmony for the property as a whole. Astro-Vastu cross-references the individual owner's horoscope (birth chart, planetary dashas, and house significators) with specific directional zones, tailoring recommendations specifically to the person occupying the space.",
            answerHi = "General Vastu establishes directional harmony for the property as a whole. Astro-Vastu cross-references the individual owner's horoscope (birth chart, planetary dashas, and house significators) with specific directional zones, tailoring recommendations specifically to the person occupying the space.",
            category = "Astro-Vastu"
        ),
        FaqItem(
            id = "faq_4",
            questionEn = "How does KP Astrology differ from traditional predictive astrology?",
            questionHi = "How does KP Astrology differ from traditional predictive astrology?",
            answerEn = "Krishnamurti Paddhati (KP) uses the Placidus house cusp system and subdivides each constellation into Star Lords and Sub-Lords. By analyzing exact Cusp Sub-Lords and Ruling Planets, it offers logical, mathematically precise timing of events without speculative generalizations.",
            answerHi = "Krishnamurti Paddhati (KP) uses the Placidus house cusp system and subdivides each constellation into Star Lords and Sub-Lords. By analyzing exact Cusp Sub-Lords and Ruling Planets, it offers logical, mathematically precise timing of events without speculative generalizations.",
            category = "KP Astrology"
        ),
        FaqItem(
            id = "faq_5",
            questionEn = "How do online consultations work for international clients (USA, UK, UAE, etc.)?",
            questionHi = "How do online consultations work for international clients (USA, UK, UAE, etc.)?",
            answerEn = "International clients provide scaled floor plans/blueprints with cardinal compass degrees, property photographs, and videos. Consultations are conducted via Zoom or Google Meet scheduled in the client's local timezone (EST, PST, GMT, GST, SGT, AEDT). A comprehensive digital PDF report is delivered subsequently.",
            answerHi = "International clients provide scaled floor plans/blueprints with cardinal compass degrees, property photographs, and videos. Consultations are conducted via Zoom or Google Meet scheduled in the client's local timezone (EST, PST, GMT, GST, SGT, AEDT). A comprehensive digital PDF report is delivered subsequently.",
            category = "International Consultancy"
        ),
        FaqItem(
            id = "faq_6",
            questionEn = "What documents are required to book a pre-purchase property assessment?",
            questionHi = "What documents are required to book a pre-purchase property assessment?",
            answerEn = "We require the builder layout plan, apartment unit floor plan with north direction marked, Google location/coordinates, and surrounding road alignment details. We review and deliver an assessment before you commit financially.",
            answerHi = "We require the builder layout plan, apartment unit floor plan with north direction marked, Google location/coordinates, and surrounding road alignment details. We review and deliver an assessment before you commit financially.",
            category = "Property Selection"
        ),
        FaqItem(
            id = "faq_7",
            questionEn = "Are the course certificates from Vedic Wisdom Academy recognized?",
            questionHi = "Are the course certificates from Vedic Wisdom Academy recognized?",
            answerEn = "Certificates are awarded strictly upon completing the curriculum, attending required live sessions, and submitting practical case study evaluations. They signify formal academic and practical completion of the specific course level.",
            answerHi = "Certificates are awarded strictly upon completing the curriculum, attending required live sessions, and submitting practical case study evaluations. They signify formal academic and practical completion of the specific course level.",
            category = "Academy"
        ),
        FaqItem(
            id = "faq_8",
            questionEn = "How long does it take to receive the personalized digital Vastu report?",
            questionHi = "How long does it take to receive the personalized digital Vastu report?",
            answerEn = "Standard residential and commercial reports are prepared within 3 to 5 business days after receiving verified floor plans and directions. Complex industrial plant audits take 5 to 7 business days.",
            answerHi = "Standard residential and commercial reports are prepared within 3 to 5 business days after receiving verified floor plans and directions. Complex industrial plant audits take 5 to 7 business days.",
            category = "Consultancy Process"
        )
    )

    val INITIAL_BLOGS = listOf(
        BlogArticle(
            id = "b1",
            slug = "vastu-without-demolition-practical-solutions",
            titleEn = "VASTU WITHOUT DEMOLITION – Practical Vastu Solutions for Existing Buildings",
            titleHi = "VASTU WITHOUT DEMOLITION – Practical Vastu Solutions for Existing Buildings",
            shortDescEn = "Explore how directional color balance, furniture orientation, and elemental harmony can optimize existing residential and commercial properties without structural breaking.",
            shortDescHi = "Explore how directional color balance, furniture orientation, and elemental harmony can optimize existing residential and commercial properties without structural breaking.",
            fullContentEn = """
                Many property owners assume that applying Vastu Shastra principles to an existing building requires major structural demolition or expensive alterations. At Vedic Wisdom, our practical approach emphasizes Non-Demolition Vastu Solutions wherever feasible.
                
                ### Understanding Spatial Harmony Without Breaking Walls
                Every structure consists of 16 directional zones and 5 primordial elements (Panchtatva: Earth, Water, Fire, Air, and Space). When an existing layout has an imbalance—such as a kitchen in an inappropriate zone or an executive desk facing a sub-optimal direction—structural modification is rarely the only choice.
                
                ### Key Non-Demolition Strategies:
                1. Directional Color Balancing: Utilizing natural color tones corresponding to specific elemental zones (e.g., light green for East, warm gold/cream for South-West).
                2. Furniture & Workstation Realignment: Shifting seating angles, bed positions, and heavy appliances to align with favorable directional grids.
                3. Metal & Elemental Taping: Applying non-invasive elemental strips or brass/copper wire boundaries to balance energy transitions across rooms.
                4. Space De-Cluttering & Light Optimization: Enhancing natural daylight and ventilation in key cardinal zones (North and East).
                
                Note: Recommendations depend on individual property conditions and floor plans. A formal assessment determines the exact feasibility of non-demolition remedies.
            """.trimIndent(),
            fullContentHi = """
                Many property owners assume that applying Vastu Shastra principles to an existing building requires major structural demolition or expensive alterations. At Vedic Wisdom, our practical approach emphasizes Non-Demolition Vastu Solutions wherever feasible.
            """.trimIndent(),
            category = "Non-Demolition Vastu",
            readTimeMinutes = 5
        ),
        BlogArticle(
            id = "b2",
            slug = "industrial-vastu-principles-factory-planning",
            titleEn = "INDUSTRIAL VASTU – Important Vastu Principles for Factory Planning",
            titleHi = "INDUSTRIAL VASTU – Important Vastu Principles for Factory Planning",
            shortDescEn = "Key considerations for industrial plots, heavy machinery positioning, raw material storage, production flow, and administrative office placement.",
            shortDescHi = "Key considerations for industrial plots, heavy machinery positioning, raw material storage, production flow, and administrative office placement.",
            fullContentEn = """
                Industrial Vastu requires a rigorous, analytical approach focused on workflow efficiency, safety, and operational stability. Unlike residential spaces, a factory complex involves heavy machinery, high-voltage electrical transformers, dispatch yards, and multi-tier storage.
                
                ### Critical Zones in Industrial Vastu Assessment:
                - Raw Material Storage: Positioned in heavy, stabilizing zones such as South-West or South to maintain inventory control and steady supply.
                - Production Line & Heavy Machinery: Heavy plant equipment requires sound structural footing and alignment with South or South-West sectors.
                - Transformer & Heat Processing: Boilers, furnaces, and electrical distribution panels naturally align with the Agni (Fire) zone in the South-East.
                - Finished Goods Dispatch: Positioned in North-West (Vayu/Movement) to facilitate swift market distribution and continuous order fulfillment.
                - Administrative & Promoter Cabin: Designed in the South-West or West to promote decisive leadership and financial stability.
                
                Industrial consultancy at Vedic Wisdom provides tailored CAD layout reviews for manufacturing units, industrial parks, and processing plants globally.
            """.trimIndent(),
            fullContentHi = """
                Industrial Vastu requires a rigorous, analytical approach focused on workflow efficiency, safety, and operational stability.
            """.trimIndent(),
            category = "Industrial Vastu",
            readTimeMinutes = 6
        ),
        BlogArticle(
            id = "b3",
            slug = "astro-vastu-connection-astrology-spatial-energy",
            titleEn = "ASTRO-VASTU – Understanding the Connection Between Astrology and Vastu",
            titleHi = "ASTRO-VASTU – Understanding the Connection Between Astrology and Vastu",
            shortDescEn = "How personalized birth chart analysis merges with 16 Vastu zones to create customized spatial harmony for individuals and business owners.",
            shortDescHi = "How personalized birth chart analysis merges with 16 Vastu zones to create customized spatial harmony for individuals and business owners.",
            fullContentEn = """
                Astro-Vastu bridges two profound traditional disciplines: Vastu Shastra (spatial directional study) and Vedic Astrology (horoscope planetary analysis).
                
                While classic Vastu provides general directional rules for all occupants, Astro-Vastu recognizes that every individual possesses a unique birth chart governed by planetary dasha periods and specific house significations.
                
                ### How Astro-Vastu Works:
                1. Horoscope Planetary Mapping: Identifying key planets governing an individual's career, finance, and health in their birth chart.
                2. Zone Mapping: Linking each planet to its corresponding directional zone in the home or office premises.
                3. Custom Alignment: Adjusting objects or activities in specific zones according to the individual's current astrological periods, resolving personal bottlenecks without unnecessary changes.
            """.trimIndent(),
            fullContentHi = """
                Astro-Vastu bridges two profound traditional disciplines: Vastu Shastra and Vedic Astrology.
            """.trimIndent(),
            category = "Astro-Vastu",
            readTimeMinutes = 5
        ),
        BlogArticle(
            id = "b4",
            slug = "property-vastu-evaluating-property-before-buying",
            titleEn = "PROPERTY VASTU – How to Evaluate a Property Before Buying It",
            titleHi = "PROPERTY VASTU – How to Evaluate a Property Before Buying It",
            shortDescEn = "A practical guide to pre-purchase evaluations for residential flats, commercial plots, and industrial land.",
            shortDescHi = "A practical guide to pre-purchase evaluations for residential flats, commercial plots, and industrial land.",
            fullContentEn = """
                Evaluating a property prior to financial commitment is one of the most effective steps in spatial planning. Pre-purchase Vastu assessment analyzes plot shape, road cuts, cardinal orientation, entrance directions, and surrounding environmental features.
                
                ### Key Checkpoints Before Purchase:
                - Plot Orientation & Geometry: Preferring regular rectangular or square geometries; avoiding irregular cut corners in critical zones.
                - Main Entrance Location: Assessing the precise degree angle of the entrance door using directional compass grids.
                - Water & Drainage Features: Checking the location of underground water tanks, borewells, and septic lines.
                - Surrounding Topography: Observing surrounding high-rise structures, slope inclination, and adjacent road alignments.
            """.trimIndent(),
            fullContentHi = """
                Evaluating a property prior to financial commitment is one of the most effective steps in spatial planning.
            """.trimIndent(),
            category = "Property Selection",
            readTimeMinutes = 4
        ),
        BlogArticle(
            id = "b5",
            slug = "commercial-vastu-principles-for-business-spaces",
            titleEn = "COMMERCIAL VASTU – Traditional Vastu Principles for Business Spaces",
            titleHi = "COMMERCIAL VASTU – Traditional Vastu Principles for Business Spaces",
            shortDescEn = "Enhancing operational productivity, customer engagement, and administrative efficiency in shops, showrooms, and corporate complexes.",
            shortDescHi = "Enhancing operational productivity, customer engagement, and administrative efficiency in shops, showrooms, and corporate complexes.",
            fullContentEn = """
                Commercial Vastu focuses on creating balanced environments for businesses, retail stores, corporate offices, hospitals, and hospitality premises.
                
                ### Core Principles for Business Spaces:
                - Reception & Customer Flow: Welcoming entrance zones that foster clear navigation and inviting engagement.
                - Executive Seating: Placing leadership and decision-makers in supportive zones facing North, East, or West.
                - Accounts & Financial Records: Aligning cash counters and financial document archives in prosperous directional sectors.
                - Staff Workstations: Ensuring balanced lighting, ergonomic orientation, and conflict-free spatial zoning.
            """.trimIndent(),
            fullContentHi = """
                Commercial Vastu focuses on creating balanced environments for businesses, retail stores, corporate offices, hospitals, and hospitality premises.
            """.trimIndent(),
            category = "Commercial Vastu",
            readTimeMinutes = 5
        ),
        BlogArticle(
            id = "b6",
            slug = "kp-astrology-cusp-sub-lords-planetary-significators",
            titleEn = "KP ASTROLOGY – Understanding Cusp Sub-Lords and Planetary Significators",
            titleHi = "KP ASTROLOGY – Understanding Cusp Sub-Lords and Planetary Significators",
            shortDescEn = "An introduction to Krishnamurti Paddhati (KP), Placidus house cusps, and star lord sub-lord analytical methodology.",
            shortDescHi = "An introduction to Krishnamurti Paddhati (KP), Placidus house cusps, and star lord sub-lord analytical methodology.",
            fullContentEn = """
                KP Astrology (Krishnamurti Paddhati) is a celebrated analytical system of astrology developed by Late Prof. K.S. Krishnamurti. It brings scientific precision to horoscope readings by dividing each nakshatra (constellation) into sub-divisions governed by Sub-Lords.
                
                ### Key Features of KP Astrology:
                - Placidus House Cusp System: Calculating exact house boundaries rather than whole-sign houses.
                - Cusp Sub-Lord Dominance: Determining whether a house promise will manifest based on its Cusp Sub-Lord.
                - Planetary Significators: Identifying houses signified by a planet through its Star Lord.
                - Logical Event Timing: Using Vimshottari Dasha and Ruling Planets to evaluate timing of events logically.
            """.trimIndent(),
            fullContentHi = """
                KP Astrology brings scientific precision to horoscope readings.
            """.trimIndent(),
            category = "KP Astrology",
            readTimeMinutes = 6
        ),
        BlogArticle(
            id = "b7",
            slug = "office-vastu-seating-directions-space-utilisation",
            titleEn = "OFFICE VASTU – Seating, Directions and Effective Space Utilisation",
            titleHi = "OFFICE VASTU – Seating, Directions and Effective Space Utilisation",
            shortDescEn = "Practical guidelines for executive desks, meeting rooms, IT server placement, and team collaboration zones.",
            shortDescHi = "Practical guidelines for executive desks, meeting rooms, IT server placement, and team collaboration zones.",
            fullContentEn = """
                Optimizing office space involves arranging team seating, managerial offices, conference rooms, and technical hardware to support focus and collaboration.
                
                ### Key Office Zones:
                - CEO / MD Cabin: Ideally in South-West for grounded leadership and decision stability.
                - Sales & Marketing Teams: Positioned in North-West or East for active outreach and networking.
                - Finance Department: Situated in North or East sectors associated with accounting clarity.
                - Server Room & Tech Racks: Located in South-East or West zones to manage heat dissipation and technical infrastructure.
            """.trimIndent(),
            fullContentHi = """
                Optimizing office space involves arranging team seating to support focus and collaboration.
            """.trimIndent(),
            category = "Commercial Vastu",
            readTimeMinutes = 5
        ),
        BlogArticle(
            id = "b8",
            slug = "five-elements-in-vastu-panchtatva-introduction",
            titleEn = "FIVE ELEMENTS IN VASTU – A Practical Introduction to Traditional Vastu Concepts",
            titleHi = "FIVE ELEMENTS IN VASTU – A Practical Introduction to Traditional Vastu Concepts",
            shortDescEn = "Understanding Water, Fire, Earth, Air, and Space elements and how balancing them fosters harmony in living environments.",
            shortDescHi = "Understanding Water, Fire, Earth, Air, and Space elements and how balancing them fosters harmony in living environments.",
            fullContentEn = """
                The Panchtatva (Five Primordial Elements) forms the foundational bedrock of Vastu Shastra. Every directional zone corresponds to a specific element:
                
                - Water (Jal): North & North-East — Clarity, opportunities, and flow.
                - Air (Vayu): East — Growth, social connection, and renewal.
                - Fire (Agni): South-East — Energy, passion, cash flow, and drive.
                - Earth (Prithvi): South-West — Stability, skill retention, and grounding.
                - Space (Akash): Center (Brahmasthan) & West — Expansion, space, and realization.
                
                Balancing these elements creates balanced spatial energy without requiring structural disruption.
            """.trimIndent(),
            fullContentHi = """
                The Panchtatva forms the foundational bedrock of Vastu Shastra.
            """.trimIndent(),
            category = "Vastu Principles",
            readTimeMinutes = 5
        ),
        BlogArticle(
            id = "b9",
            slug = "residential-vastu-importance-of-directions-home",
            titleEn = "RESIDENTIAL VASTU – Understanding the Importance of Directions",
            titleHi = "RESIDENTIAL VASTU – Understanding the Importance of Directions",
            shortDescEn = "A comprehensive overview of room placement, bedroom alignment, kitchen positioning, and main entrance assessment.",
            shortDescHi = "A comprehensive overview of room placement, bedroom alignment, kitchen positioning, and main entrance assessment.",
            fullContentEn = """
                A residential home is a sanctuary where individuals spend a significant portion of their lives. Aligning room functions with cardinal and ordinal directions nurtures rest, health, and family bonding.
                
                ### Essential Home Orientations:
                - Master Bedroom: Best located in South-West for restful sleep and family stability.
                - Kitchen: Ideally placed in South-East (Agni zone) for balanced culinary energy.
                - Children's Room / Study: Positioned in West or North-East to foster focus and learning.
                - Living Room & Dining: Placed in East, North, or North-West for welcoming hospitality.
            """.trimIndent(),
            fullContentHi = """
                A residential home is a sanctuary where individuals spend a significant portion of their lives.
            """.trimIndent(),
            category = "Residential Vastu",
            readTimeMinutes = 4
        ),
        BlogArticle(
            id = "b10",
            slug = "kp-astrology-for-career-traditional-approaches",
            titleEn = "KP ASTROLOGY FOR CAREER – Traditional Astrological Approaches to Career Analysis",
            titleHi = "KP ASTROLOGY FOR CAREER – Traditional Astrological Approaches to Career Analysis",
            shortDescEn = "Evaluating the 2nd, 6th, 10th, and 11th houses in KP astrology for professional choices, business growth, and timing.",
            shortDescHi = "Evaluating the 2nd, 6th, 10th, and 11th houses in KP astrology for professional choices, business growth, and timing.",
            fullContentEn = """
                In KP Astrology, career and financial prospects are evaluated by analyzing specific house groupings:
                - 2nd House: Financial inflow and assets.
                - 6th House: Employment, service, competitive exams, and day-to-day work.
                - 10th House: Profession, status, recognition, and business enterprise.
                - 11th House: Gains, fulfillment of desires, and profit margins.
                
                Analyzing the Cusp Sub-Lords of these houses provides clear guidance regarding employment versus business suitability, key timing periods, and professional growth.
            """.trimIndent(),
            fullContentHi = """
                In KP Astrology, career and financial prospects are evaluated by analyzing specific house groupings.
            """.trimIndent(),
            category = "KP Astrology",
            readTimeMinutes = 5
        )
    )
}

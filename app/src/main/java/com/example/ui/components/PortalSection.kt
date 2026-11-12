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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortalSection(
    userRole: UserRole,
    enquiries: List<ConsultationEnquiry>,
    blogs: List<BlogArticle>,
    language: AppLanguage,
    onRoleToggle: (UserRole) -> Unit,
    onAddBlogArticle: (String, String, String, String, String, String, String) -> Unit,
    onToggleBlogPublish: (String) -> Unit,
    onDeleteBlogArticle: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var showAddBlogDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(WarmIvory)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        // Portal Header & Role Switcher
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = if (userRole == UserRole.CLIENT) "CLIENT PORTAL" else "ADMIN DASHBOARD",
                    style = MaterialTheme.typography.displayMedium.copy(
                        fontFamily = FontFamily.Serif,
                        color = ForestGreenPrimary,
                        fontSize = 22.sp
                    )
                )
                Text(
                    text = "Vedic Wisdom Secure Portal",
                    style = MaterialTheme.typography.labelSmall.copy(color = MutedCharcoal)
                )
            }

            // Role Switcher
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = ForestGreenPrimary,
                modifier = Modifier.testTag("portal_role_switcher")
            ) {
                Row(modifier = Modifier.padding(4.dp)) {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = if (userRole == UserRole.CLIENT) ChampagneGold else Color.Transparent,
                        modifier = Modifier
                            .clickable { onRoleToggle(UserRole.CLIENT) }
                            .padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "Client View",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = if (userRole == UserRole.CLIENT) ForestGreenPrimary else WarmIvory,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = if (userRole == UserRole.ADMIN) ChampagneGold else Color.Transparent,
                        modifier = Modifier
                            .clickable { onRoleToggle(UserRole.ADMIN) }
                            .padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "Admin View",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = if (userRole == UserRole.ADMIN) ForestGreenPrimary else WarmIvory,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }

        if (userRole == UserRole.CLIENT) {
            // CLIENT VIEW DASHBOARD
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = ElegantWhite),
                border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderGold)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.AccountCircle, contentDescription = null, tint = ForestGreenPrimary, modifier = Modifier.size(32.dp))
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text("Welcome, Valued Client", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold))
                            Text("Signed in via Demo Authentication", style = MaterialTheme.typography.bodySmall.copy(color = MutedCharcoal))
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalDivider(color = CardBorderGold)
                    Spacer(modifier = Modifier.height(16.dp))

                    Text("YOUR CONSULTATION ENQUIRIES & REPORTS", style = MaterialTheme.typography.titleMedium.copy(color = ForestGreenPrimary, fontWeight = FontWeight.Bold))

                    if (enquiries.isEmpty()) {
                        Text(
                            text = "No active enquiries found. Submit a booking enquiry to track appointment status.",
                            style = MaterialTheme.typography.bodyMedium.copy(color = MutedCharcoal),
                            modifier = Modifier.padding(vertical = 12.dp)
                        )
                    } else {
                        enquiries.forEach { enq ->
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = WarmIvoryVariant,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp)
                            ) {
                                Column(modifier = Modifier.padding(14.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text("#${enq.id} - ${enq.serviceName}", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold, fontSize = 14.sp))
                                        Surface(
                                            shape = RoundedCornerShape(6.dp),
                                            color = ChampagneGold
                                        ) {
                                            Text(enq.status, style = MaterialTheme.typography.labelSmall.copy(color = ForestGreenPrimary, fontSize = 9.sp, fontWeight = FontWeight.Bold), modifier = Modifier.padding(4.dp))
                                        }
                                    }
                                    Text("Client: ${enq.clientName} (${enq.email})", style = MaterialTheme.typography.bodySmall.copy(color = MutedCharcoal))
                                    Text("Mode: ${enq.mode.name} | Date: ${enq.preferredDate} (${enq.timezone})", style = MaterialTheme.typography.bodySmall.copy(color = MutedCharcoal))
                                }
                            }
                        }
                    }
                }
            }
        } else {
            // ADMIN VIEW DASHBOARD
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .testTag("admin_dashboard_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = ForestGreenPrimary),
                border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text("ADMINISTRATIVE MANAGEMENT", style = MaterialTheme.typography.titleLarge.copy(color = ChampagneGold, fontWeight = FontWeight.Bold))
                    Text("Manage Consultation Enquiries, Blog Articles, Testimonials & Client Records", style = MaterialTheme.typography.bodySmall.copy(color = WarmIvory.copy(alpha = 0.8f)))

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("BLOG ARTICLES MANAGEMENT (${blogs.size})", style = MaterialTheme.typography.titleMedium.copy(color = WarmIvory, fontWeight = FontWeight.Bold))
                        Button(
                            onClick = { showAddBlogDialog = true },
                            colors = ButtonDefaults.buttonColors(containerColor = ChampagneGold, contentColor = ForestGreenPrimary),
                            modifier = Modifier.testTag("admin_add_blog_button")
                        ) {
                            Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("New Article")
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    blogs.forEach { blog ->
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = ForestGreenSecondary,
                            border = androidx.compose.foundation.BorderStroke(1.dp, ChampagneGold.copy(alpha = 0.3f)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(blog.titleEn, style = MaterialTheme.typography.titleSmall.copy(color = WarmIvory, fontWeight = FontWeight.Bold))
                                    Text("${blog.category} • Published: ${blog.isPublished}", style = MaterialTheme.typography.bodySmall.copy(color = ChampagneGold, fontSize = 11.sp))
                                }

                                Row {
                                    IconButton(onClick = { onToggleBlogPublish(blog.id) }) {
                                        Icon(
                                            imageVector = if (blog.isPublished) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                            contentDescription = "Toggle Publish",
                                            tint = ChampagneGold
                                        )
                                    }
                                    IconButton(onClick = { onDeleteBlogArticle(blog.id) }) {
                                        Icon(Icons.Default.Delete, contentDescription = "Delete", tint = AlertWarningOrange)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Add Blog Dialog
    if (showAddBlogDialog) {
        var titleEn by remember { mutableStateOf("") }
        var category by remember { mutableStateOf("Non-Demolition Vastu") }
        var shortDesc by remember { mutableStateOf("") }
        var fullContent by remember { mutableStateOf("") }

        AlertDialog(
            onDismissRequest = { showAddBlogDialog = false },
            title = { Text("Publish New Article") },
            text = {
                Column {
                    OutlinedTextField(value = titleEn, onValueChange = { titleEn = it }, label = { Text("Article Title") }, modifier = Modifier.fillMaxWidth())
                    OutlinedTextField(value = category, onValueChange = { category = it }, label = { Text("Category") }, modifier = Modifier.fillMaxWidth())
                    OutlinedTextField(value = shortDesc, onValueChange = { shortDesc = it }, label = { Text("Short Description") }, modifier = Modifier.fillMaxWidth())
                    OutlinedTextField(value = fullContent, onValueChange = { fullContent = it }, label = { Text("Full Article Content") }, minLines = 3, modifier = Modifier.fillMaxWidth())
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (titleEn.isNotBlank()) {
                            onAddBlogArticle(titleEn, titleEn, category, shortDesc, shortDesc, fullContent, fullContent)
                            showAddBlogDialog = false
                        }
                    }
                ) {
                    Text("Publish Article")
                }
            },
            dismissButton = {
                TextButton(onClick = { showAddBlogDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

package com.eraqi.social_media_demo_app.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API

class SampleIssueRegistry : IssueRegistry() {
    override val issues = listOf(
        SampleDetector.ISSUE,
        NamingDetector.ISSUE_VIEW_MODEL_NAMING,
        RawLogDetector.ISSUE_RAW_LOG,
        ComposeHardcodedStringDetector.ISSUE_HARDCODED_COMPOSE_STRING
    )
    override val api = CURRENT_API
    override val minApi = 12

    override val vendor = Vendor(
        vendorName = "Social Media Demo App",
        feedbackUrl = "https://github.com/eraqi/socialmediademoapp/issues",
        contact = "https://github.com/eraqi/socialmediademoapp"
    )
}

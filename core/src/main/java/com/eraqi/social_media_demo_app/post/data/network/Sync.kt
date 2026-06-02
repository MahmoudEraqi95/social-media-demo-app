package com.eraqi.social_media_demo_app.post.data.network

import com.eraqi.social_media_demo_app.post.data.NetworkPost

data class SyncRequest(
    val created: List<NetworkPost> = emptyList(),
    val updated: List<NetworkPost> = emptyList(),
    val deleted: List<Int> = emptyList()
)

data class SyncResponse(
    val success: Boolean,
    val currentVersion: Int
)

package com.samplejetpeckcompose.data.user

data class UserResponse(
    val `data`: ArrayList<UserDTO>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)
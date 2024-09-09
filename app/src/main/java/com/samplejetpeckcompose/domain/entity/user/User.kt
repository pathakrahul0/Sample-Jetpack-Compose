package com.samplejetpeckcompose.domain.entity.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val avatar: String,
    val email: String,
    val mobileNo: String?,
    val gender: String?,
    val dob: String?,
    val first_name: String,
    val id: Int,
    val last_name: String
) : Parcelable
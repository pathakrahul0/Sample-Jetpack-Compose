package com.samplejetpeckcompose.common

import com.samplejetpeckcompose.data.user.UserDTO
import com.samplejetpeckcompose.domain.entity.user.User


fun UserDTO.toDomain(): User {
    return User(
        first_name = first_name,
        last_name = last_name,
        id = id,
        avatar = avatar,
        email = email,
        gender = gender,
        dob = dob,
        mobileNo = mobileNo
    )
}

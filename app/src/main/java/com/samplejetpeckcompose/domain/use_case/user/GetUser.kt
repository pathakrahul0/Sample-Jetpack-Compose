package com.domain.use_case.user

import com.samplejetpeckcompose.domain.repository.user.UserDataSource


class GetUser(private val userRepository: UserDataSource) {
    suspend operator fun invoke(emailId: String) = userRepository.getUser(emailId = emailId)
}
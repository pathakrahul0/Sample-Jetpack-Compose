package com.samplejetpeckcompose.domain.use_case.user

import com.samplejetpeckcompose.domain.entity.user.User
import com.samplejetpeckcompose.domain.repository.user.UserDataSource

class RemoveUser(private val userRepository: UserDataSource) {
    suspend operator fun invoke(user: User) = userRepository.removeUser(user = user)
}
package com.samplejetpeckcompose.domain.use_case.user

import com.samplejetpeckcompose.domain.repository.user.UserDataSource
import javax.inject.Inject


class GetAllUser @Inject constructor(private val userRepository: UserDataSource) {
     suspend  operator fun invoke() = userRepository.getAllUser()
}
package com.samplejetpeckcompose.domain.repository.user

import com.samplejetpeckcompose.domain.entity.user.User
import io.reactivex.Single

interface UserDataSource {
    suspend fun addUser(user: User)
    suspend fun getUser(emailId: String): User?
    suspend fun getAllUser(): Single<ArrayList<User>>
    suspend fun removeUser(user: User)
}
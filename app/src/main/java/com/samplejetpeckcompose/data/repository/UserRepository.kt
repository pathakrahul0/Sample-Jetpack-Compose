package com.samplejetpeckcompose.data.repository

import com.samplejetpeckcompose.common.toDomain
import com.samplejetpeckcompose.data.network.ApiService
import com.samplejetpeckcompose.data.user.UserDTO
import com.samplejetpeckcompose.domain.entity.user.User
import com.samplejetpeckcompose.domain.repository.user.UserDataSource
import io.reactivex.Single


class UserRepository(private val apiService: ApiService) : UserDataSource {
    //    suspend fun addUser(user: User) = userDataSource.addUser(user)
//    suspend fun getUser(emailId: String): User? = userDataSource.getUser(emailId = emailId)
//    suspend fun getAllUser(): ArrayList<User> = userDataSource.getAllUser()
//    suspend fun removeUser(user: User) = userDataSource.removeUser(user)
    override suspend fun addUser(user: User) {

    }

    override suspend fun getUser(emailId: String): User {
        return apiService.getUser()
    }

    override suspend fun getAllUser(): Single<ArrayList<User>> {
        return apiService.getAllUser().map { it -> it.data.map { it.toDomain() } } as Single<ArrayList<User>>
    }

    override suspend fun removeUser(user: User) {

    }

}
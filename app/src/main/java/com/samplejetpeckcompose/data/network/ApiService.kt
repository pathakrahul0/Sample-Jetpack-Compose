package com.samplejetpeckcompose.data.network


import com.samplejetpeckcompose.data.user.UserDTO
import com.samplejetpeckcompose.data.user.UserResponse
import com.samplejetpeckcompose.domain.entity.user.User
import io.reactivex.Single
import retrofit2.http.GET


interface ApiService {

    @GET("users")
    fun getAllUser(): Single<UserResponse>

//
//    @GET("repos/{owner}/{name}")
//    fun getRepo(
//        @Path("owner") owner: String?,
//        @Path("name") name: String?
//    ): Single<Repo?>?

    @GET("countries.json")
    suspend fun getUser(): User

    @GET("countries.json")
    suspend fun addUser()

    @GET("countries.json")
    suspend fun removeUser()


}
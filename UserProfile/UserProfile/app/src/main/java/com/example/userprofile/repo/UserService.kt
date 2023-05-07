package com.example.userprofile.repo

import com.example.userprofile.data.User
import retrofit2.Call
import retrofit2.http.*


interface UserService {
    @POST("api/user/info")
    fun createUser(@Body user: User?): Call<User?>?

    @GET("/api/user/info?")
    fun getUser(@Query("email") id: String): Call<User?>?
}
package com.example.userprofile.repo

import com.example.userprofile.data.User
import retrofit2.Call
import retrofit2.http.*


interface UserService {
    @POST("api/user/info")
    @Headers("Content-Type: application/json")
    fun createUser(@Body user: User): Call<Void>?

    @GET("/api/user/info?")
    @Headers("Content-Type: application/json")
    fun getUser(@Query("email") id: String): Call<User?>?
}
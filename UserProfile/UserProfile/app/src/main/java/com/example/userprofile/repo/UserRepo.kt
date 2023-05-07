package com.example.userprofile.repo

import com.example.userprofile.data.User
import retrofit2.Call

class UserRepo(val userService: UserService) {

    fun updateUser(user: User) {
        userService.createUser(user = user)
    }

    suspend fun getUser(email: String): Call<User?>? {
        return userService.getUser(id = email)
    }
}
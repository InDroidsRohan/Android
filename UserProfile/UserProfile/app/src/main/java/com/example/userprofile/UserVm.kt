package com.example.userprofile

import androidx.lifecycle.ViewModel
import com.example.userprofile.data.User
import com.example.userprofile.repo.UserRepo
import com.example.userprofile.repo.UserService
import com.example.userprofile.utils.getRetroFit
import retrofit2.Call

class UserVm : ViewModel() {
    val userRepo = UserRepo(getRetroFit().create(UserService::class.java))

    fun createUser(user: User) {
        userRepo.userService.createUser(user = user)
    }

    fun getUser(email: String): Call<User?>? {
        return userRepo.userService.getUser(id = email)
    }
}
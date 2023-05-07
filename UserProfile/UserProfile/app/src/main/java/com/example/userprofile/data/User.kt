package com.example.userprofile.data

data class User(
    val id: Long,
    val email: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val cymbalsRole: String,
    val timeStamp: String? =null,
)
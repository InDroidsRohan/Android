package com.example.userprofile.data

import com.google.gson.annotations.SerializedName

data class User(

    val id: Long,
    @SerializedName("email")
    val email: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("cymbalsRole")
    val cymbalsRole: String,
    val timeStamp: String? = null,
)
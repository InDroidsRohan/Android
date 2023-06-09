package com.example.userprofile.utils

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun getRetroFit(): Retrofit {
    val gson = GsonBuilder()
        .setLenient()
        .create()
    return Retrofit.Builder()
        .baseUrl("http://ec2-54-186-135-34.us-west-2.compute.amazonaws.com:8080/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

}
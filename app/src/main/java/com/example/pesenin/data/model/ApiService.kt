package com.example.pesenin.data.model

import android.view.MenuItem
import com.example.pesenin.ApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("product") // Ini sesuai dengan endpoint yang Anda gunakan
    suspend fun getMenu(): Response<MenuResponse>
}

data class ApiResponse(
    val status: Boolean,
    val message: String,
    val data: List<MenuKopi>
)
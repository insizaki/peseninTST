package com.example.pesenin

import com.example.pesenin.data.model.MenuKopi
import retrofit2.Callback

data class ApiResponse(
    val status: Boolean,
    val massage: String,
    val data: List<MenuKopi>
) {
    fun enqueue(callback: Callback<List<MenuKopi>>) {

    }
}
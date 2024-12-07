package com.example.pesenin.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pesenin.data.model.ApiService
import com.example.pesenin.data.model.Menu
import com.example.pesenin.data.model.MenuKopi
import com.example.pesenin.data.model.User
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MenuKopiRepository(    private val apiService: ApiService
){
    private val _menusKopi = MutableLiveData<List<MenuKopi>>(emptyList()) // Inisialisasi dengan empty list
    val menusKopi: LiveData<List<MenuKopi>> get() = _menusKopi

    suspend fun fetchMenusKopi(): List<MenuKopi> {
        val response = apiService.getMenu()

        if (response.isSuccessful) {
            val menuResponse = response.body() // Mendapatkan objek MenuResponse
            return menuResponse?.data ?: emptyList() // Mengambil daftar data (menu kopi) dari response
        } else {
            Log.e("MenuKopiRepository", "Error: ${response.code()}")
            return emptyList()
        }
    }
}
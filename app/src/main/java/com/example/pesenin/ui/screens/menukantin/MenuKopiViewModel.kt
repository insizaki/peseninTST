package com.example.pesenin.ui.screens.menukantin

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pesenin.ApiClient
import com.example.pesenin.data.model.Menu
import com.example.pesenin.data.model.MenuKopi
import com.example.pesenin.data.repository.AuthRepository
import com.example.pesenin.data.repository.MenuKopiRepository
import com.example.pesenin.data.repository.MenuRepository
import com.example.pesenin.data.repository.StorageRepository
import com.google.android.engage.common.datamodel.Price
import io.grpc.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MenuKopiViewModel(
    private val AuthRepository: AuthRepository = AuthRepository(),
    private val menuKopiRepository: MenuKopiRepository = MenuKopiRepository(ApiClient.retrofit), // Menambahkan MenuKopiRepository
    //    private val StorageRepository: StorageRepository = StorageRepository()
): ViewModel() {

    private val _apiMenus = MutableStateFlow<List<MenuKopi>>(emptyList())
    val apiMenus: StateFlow<List<MenuKopi>> = _apiMenus

    fun fetchApiMenus() {
        viewModelScope.launch {
            try {
                // Memanggil repository untuk mendapatkan menu dari API
                val menus = menuKopiRepository.fetchMenusKopi()
                // Mengupdate state apiMenus dengan data yang diterima
                _apiMenus.value = menus
                print("MENUSMENUSMENUS di viewmodel kopi " + menus)
            } catch (e: Exception) {
                // Tangani error jika API gagal atau terjadi exception
                println("Error saat memuat menu API: ${e.message}")
            }
        }
    }



    data class MenuState(
        val name:String = "",
        val price: String = "",
        var photo: Uri? = null,
        val bitmap: Bitmap? =null,
        val img: String ="",
        var imageUri: Uri? = null
    )
//
//

}
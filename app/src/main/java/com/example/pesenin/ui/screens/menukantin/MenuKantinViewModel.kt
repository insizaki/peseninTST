package com.example.pesenin.ui.screens.menukantin

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pesenin.data.model.Menu
import com.example.pesenin.data.repository.AuthRepository
import com.example.pesenin.data.repository.MenuRepository
import com.example.pesenin.data.repository.StorageRepository
import com.google.android.engage.common.datamodel.Price
import io.grpc.Context

class MenuKantinViewModel(
    private val AuthRepository: AuthRepository = AuthRepository(),
    private val MenuRepository: MenuRepository = MenuRepository(),
    private val StorageRepository: StorageRepository = StorageRepository()
): ViewModel() {



    fun GetAllMenu(callback: (List<Pair<String, Menu>>) -> Unit){
        MenuRepository.GetAllMenu { menus ->
            callback(menus)

            print("### MENUSMENUSMENUS" + menus)
        }
    }



    var menuState by mutableStateOf(MenuState())
        private set

    fun onAddMenuName(name: String){
        menuState = menuState.copy(name = name)
    }

    fun onAddMenuPrice(price: String){
        menuState = menuState.copy(price = price)
    }

    fun onAddMenuPhoto(bitmap:Bitmap, imageUri:Uri, img: String){
        menuState = menuState.copy(bitmap = bitmap)
        menuState = menuState.copy(img = img)
        menuState = menuState.copy(imageUri = imageUri)    }

    fun addMenu(context: ComponentActivity){
        val menu = Menu(
            name = menuState.name,
            price = menuState.price.toInt(), // Pastikan harga dikonversi ke Int
            photo = menuState.photo.toString() // Konversi Uri ke String
        )

        MenuRepository.AddMenu(
            menu = menu,
            onSuccess = {
                println("Menu berhasil ditambahkan")
            },
            onFailure = { exception ->
                println("Gagal menambahkan menu: ${exception.message}")
            }
        )

    }

    fun getMenuByKey(key: String, callback: (Menu?) -> Unit) {
        MenuRepository.GetAllMenu { menus ->
            val menu = menus.find { it.first == key }?.second
            callback(menu)
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
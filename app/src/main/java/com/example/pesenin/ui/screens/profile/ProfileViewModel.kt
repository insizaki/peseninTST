package com.example.pesenin.ui.screens.profile

import androidx.lifecycle.ViewModel
import com.example.pesenin.data.model.User
import com.example.pesenin.data.repository.AuthRepository
import com.example.pesenin.data.repository.StorageRepository
import com.example.pesenin.data.repository.UserRepository

class ProfileViewModel(
    private val AuthRepository: AuthRepository = AuthRepository(),
    private val UserRepository: UserRepository = UserRepository(),
    private val StorageRepository: StorageRepository = StorageRepository()
) : ViewModel(){

    fun GetUserData(callback:(User)-> Unit){
        UserRepository.GetUserLogin(AuthRepository.getUserId()){user ->

            StorageRepository.getUserProfileImage(user.profil ?:""){url ->
                user.profil = url.toString()
                println("IIIIIIIIIIIIIII $url")
                println("XXXXXXXXXXXXX ${user.profil} ")
                println("BBBBBBBBBBBBBBBBBBB")
                println("##################" + AuthRepository.getUserId())
            }
            callback(user)
        }
    }

    fun logOut(){
        AuthRepository.logOut()
    }
}
package com.example.pesenin.ui.screens.menukantin

import com.example.pesenin.data.repository.AuthRepository
import com.example.pesenin.data.repository.MenuRepository
import com.example.pesenin.data.repository.StorageRepository

class TambahMenuViewModel(
    private val AuthRepository: AuthRepository = AuthRepository(),
    private val MenuRepository: MenuRepository = MenuRepository(),
    private val StorageRepository: StorageRepository = StorageRepository()
) {

}
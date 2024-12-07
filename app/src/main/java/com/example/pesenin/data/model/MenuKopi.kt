package com.example.pesenin.data.model

data class MenuKopi (
    val id: Int,
    val name: String,
    val sku: String,
    val price: String,
    val description: String,
    val image: String,
    val createdAt: String,
    val updatedAt: String
    )

data class MenuResponse(
    val status: Boolean,
    val massage: String,  // Tidak ada kesalahan ketik pada 'massage', sesuai JSON yang diberikan
    val data: List<MenuKopi> // Data menu kopi yang akan kita ambil
)
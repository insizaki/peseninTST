package com.example.pesenin.data.repository

import android.util.Log
import com.example.pesenin.data.model.Menu
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

class MenuRepository {
    private val database: DatabaseReference = FirebaseDatabase.getInstance().reference.child("Menu")

    fun GetAllMenu(callback: (List<Pair<String, Menu>>) -> Unit){
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val menus = snapshot.children
                    .mapNotNull {childSnapshot ->
                        val key = childSnapshot.key
                        val menu = childSnapshot.getValue(Menu::class.java)
                        if (key != null && menu != null) Pair(key, menu) else null
                    }
                    .take(10)

                callback(menus)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }
    fun AddMenu(menu: Menu, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val newMenuRef = database.push() // Generate ID otomatis
        newMenuRef.setValue(menu)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { exception ->
                onFailure(exception)
            }
    }


}
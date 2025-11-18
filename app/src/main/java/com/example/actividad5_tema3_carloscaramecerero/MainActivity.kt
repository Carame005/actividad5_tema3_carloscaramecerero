package com.example.actividad5_tema3_carloscaramecerero

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.actividad5_tema3_carloscaramecerero.screen.LoginScreen
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val auth = Firebase.auth
            val currentUser = auth.currentUser

            if(currentUser == null){
                LoginScreen { email, password ->
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if(task.isSuccessful){
                                // usuario logueado -> mostrar listado
                                startActivity(Intent(this, ItemListActivity::class.java))
                                finish()
                            } else {
                                Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            } else {
                // ya logueado -> mostrar listado directamente
                startActivity(Intent(this, ItemListActivity::class.java))
                finish()
            }
        }
    }
}



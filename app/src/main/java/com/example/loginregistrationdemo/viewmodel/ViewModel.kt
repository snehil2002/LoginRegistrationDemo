package com.example.loginregistrationdemo.viewmodel


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch


class ViewModel():ViewModel() {

    var loading= mutableStateOf(false)
    val auth=FirebaseAuth.getInstance()

    fun login(email:String,pass:String,success:()->Unit,failure:()->Unit){
        loading.value=true
        viewModelScope.launch { auth.signInWithEmailAndPassword(email,pass).addOnSuccessListener {
            success()
            loading.value=false
        }.addOnFailureListener{
            failure()
            loading.value=false


        }}

    }

    fun sinin(email:String,pass:String,success:()->Unit,failure: () -> Unit){
        loading.value=true
        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(email,pass).addOnSuccessListener {
                success()
                loading.value=false
            }.addOnFailureListener{
                failure()
                loading.value=false
            }
        }

    }
}
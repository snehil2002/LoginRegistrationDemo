package com.example.loginregistrationdemo.utils

import android.content.Context
import android.widget.Toast



fun toastmessagel(context:Context, message:String){
    Toast.makeText(context,message,Toast.LENGTH_LONG).show()

}

fun toastmessages(context:Context, message:String){
    Toast.makeText(context,message,Toast.LENGTH_SHORT).show()

}


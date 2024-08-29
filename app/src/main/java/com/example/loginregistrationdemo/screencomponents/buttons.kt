package com.example.loginregistrationdemo.screencomponents


import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp




@Composable fun submitbutton(label:String, modifier: Modifier=Modifier, tcolor: Color= Color.Black, buttoncolor: Color= Color.Black, onclick:()->Unit={}){
    Button(onClick = {onclick()}, modifier =modifier, colors = ButtonDefaults.buttonColors(containerColor =  buttoncolor, contentColor = Color.DarkGray)) {
        Text(text = label, fontSize = 20.sp, fontWeight = FontWeight.Light, color = tcolor)

    }
}



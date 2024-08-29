package com.example.loginregistrationdemo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginregistrationdemo.R
import com.example.loginregistrationdemo.screencomponents.submitbutton
import com.example.loginregistrationdemo.utils.toastmessagel
import com.google.firebase.auth.FirebaseAuth

@Composable fun homeScreen(navController: NavController){
    val auth=FirebaseAuth.getInstance()
    val context= LocalContext.current
    
    Surface (modifier = Modifier.fillMaxSize()){
        Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom){
            Surface(modifier = Modifier.size(300.dp).padding(20.dp), shape = RoundedCornerShape(20.dp), shadowElevation = 20.dp) {
                Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    Text(
                        text = "Welcome",
                        fontSize = 25.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                    Text(
                        text = auth.currentUser?.email?.split("@")?.get(0) ?:"User" ,
                        fontSize = 30.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                    
                }

                
            }
            submitbutton(label = "LOGOUT", modifier =Modifier.fillMaxWidth().height(60.dp).padding(10.dp), tcolor = Color.LightGray){
                auth.signOut()
                toastmessagel(context,"Logged Out")
                navController.navigate(AppScreens.LOGINSCREEN.name){
                    popUpTo(AppScreens.SPLASHSCREEN.name){
                        inclusive=false
                    }
                }

            }
            Spacer(modifier = Modifier.height(140.dp))

            Icon(
                painter = painterResource(id = R.drawable.splashscreen_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .padding(5.dp),
                tint = Color.Black
            )
            
            
        }
        
    }

}
package com.example.loginregistrationdemo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.loginregistrationdemo.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay


@Composable fun splashScreen(navController: NavController) {

    LaunchedEffect(key1 = true) {
        delay(1600L)
        if (FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()) {
            navController.navigate(AppScreens.LOGINSCREEN.name)

        } else {
            navController.navigate(AppScreens.HOMESCREEN.name)

        }

    }
    Surface(modifier = Modifier.fillMaxSize()) {


        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Icon(
                painter = painterResource(id = R.drawable.splashscreen_icon),
                contentDescription = "",
                modifier = Modifier.size(100.dp),
                tint = Color.Black
            )


        }
    }
}

package com.example.loginregistrationdemo.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginregistrationdemo.screens.AppScreens
import com.example.loginregistrationdemo.screens.homeScreen
import com.example.loginregistrationdemo.screens.loginScreen
import com.example.loginregistrationdemo.screens.signupScreen
import com.example.loginregistrationdemo.screens.splashScreen
import com.example.loginregistrationdemo.viewmodel.ViewModel

@Composable fun navigation(){
    val navController= rememberNavController()
    val viewModel= viewModel<ViewModel>()
    
    NavHost(navController = navController, startDestination = AppScreens.SPLASHSCREEN.name){
        
        composable(route=AppScreens.SPLASHSCREEN.name){
            splashScreen(navController=navController)
        }
        
        composable(route=AppScreens.HOMESCREEN.name){
            homeScreen(navController = navController)
        }
        
        composable(route = AppScreens.SIGNUPSCREEN.name){
            signupScreen(navController = navController,viewModel=viewModel)
        }
        composable(route = AppScreens.LOGINSCREEN.name){
            loginScreen(viewModel = viewModel, navController = navController)
        }
        
    }
}
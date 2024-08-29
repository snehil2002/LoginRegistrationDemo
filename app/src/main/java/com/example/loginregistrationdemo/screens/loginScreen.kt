package com.example.loginregistrationdemo.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginregistrationdemo.R
import com.example.loginregistrationdemo.screencomponents.MovingProgressIndicator
import com.example.loginregistrationdemo.screencomponents.normaltextfield
import com.example.loginregistrationdemo.screencomponents.passfield
import com.example.loginregistrationdemo.screencomponents.submitbutton
import com.example.loginregistrationdemo.utils.toastmessagel
import com.example.loginregistrationdemo.viewmodel.ViewModel


@Composable fun loginScreen(navController:NavController, viewModel: ViewModel){
    val context= LocalContext.current

    var emailinput= rememberSaveable {
        mutableStateOf("")
    }
    var passinput=rememberSaveable{
        mutableStateOf("")
    }
    var passvisvibility=rememberSaveable{
        mutableStateOf(false)
    }
    var passfocus=FocusRequester()
    val keyboardcontroller=LocalSoftwareKeyboardController.current
    var valid=if (emailinput.value.trim().isNotEmpty() && passinput.value.trim().isNotEmpty()) true else false

        if (viewModel.loading.value){
           MovingProgressIndicator()
        }
    Column(modifier = Modifier
        .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {


        Column(modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {


            Text(
                text = "Login",
                fontSize = 30.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
            normaltextfield(textvalue =emailinput , singleline =true , label ="Email", modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), keyboardtype = KeyboardType.Email, onaction = {passfocus.requestFocus()})
            passfield(passvalue = passinput, singleline = true, imeaction = ImeAction.Done, label = "Password", passvisibility = passvisvibility, modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .focusRequester(passfocus), onaction = { keyboardcontroller?.hide() })
            submitbutton(label = "Login", modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(
                    CircleShape
                ), buttoncolor = if (valid) Color.Black else Color.LightGray,
                tcolor =if (valid) Color.White else Color.Black ){
                if(valid){
                    keyboardcontroller?.hide()
                    viewModel.login(emailinput.value,passinput.value, success = {
                        toastmessagel(
                            context = context,
                            message = "Succesfully Logged In"
                        )
                        navController.navigate(AppScreens.HOMESCREEN.name){
                            popUpTo(AppScreens.SPLASHSCREEN.name){
                                inclusive=false
                            }
                        }

                    },
                        failure = { toastmessagel(context = context, message ="Invalid Email or Password" )})}
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), horizontalArrangement = Arrangement.Center) {
                Text(text = "New User? ", color = Color.Black, fontSize = 20.sp)
                Text(text = "Register", fontWeight = FontWeight.ExtraBold, color = Color.Black, fontSize = 23.sp,
                    modifier = Modifier.clickable { navController.navigate(AppScreens.SIGNUPSCREEN.name) })


            }



        }
        Spacer(modifier = Modifier.height(100.dp))

        Icon(
            painter = painterResource(id = R.drawable.splashscreen_icon),
            contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .padding(5.dp),
            tint = Color.Black
        )




    }}

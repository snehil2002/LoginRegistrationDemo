package com.example.loginregistrationdemo.screencomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginregistrationdemo.R


@Composable fun normaltextfield(
    textvalue:MutableState<String> =remember { mutableStateOf("") },singleline:Boolean=true,modifier:Modifier=Modifier,
    label:String="textfield",keyboardtype:KeyboardType= KeyboardType.Text,imeaction:ImeAction= ImeAction.Next,
    onaction:()->Unit={}
){

    OutlinedTextField(value = textvalue.value, onValueChange ={
        textvalue.value=it
    }, enabled = true, shape = RoundedCornerShape(20.dp), singleLine = singleline,
    modifier = modifier, textStyle = TextStyle(fontSize = 20.sp),
        label={ Text(text = label, fontSize = 17.sp)}, keyboardOptions = KeyboardOptions(
            keyboardType = keyboardtype, imeAction = imeaction
        ), keyboardActions = KeyboardActions(onAny = {onaction()}),
        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.LightGray, unfocusedBorderColor = Color.Black ,
        cursorColor = Color.Black, focusedLabelColor = Color.Black,
        unfocusedLabelColor = Color.Black, focusedContainerColor = Color.White, unfocusedContainerColor = Color.White)

    )


}



@Composable fun passfield(
    passvalue:MutableState<String> =remember { mutableStateOf("") },singleline:Boolean=true,modifier:Modifier=Modifier,
    label:String="passfield",imeaction:ImeAction= ImeAction.Next,
    onaction:()->Unit={},
    passvisibility:MutableState<Boolean> =remember { mutableStateOf(true) }
){
    OutlinedTextField(value = passvalue.value, onValueChange ={
        passvalue.value=it
    }, enabled = true, singleLine = singleline, shape = RoundedCornerShape(20.dp),
        modifier = modifier, textStyle = TextStyle(fontSize = 20.sp),
        label={ Text(text = label, fontSize = 17.sp)}, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password, imeAction = imeaction
        ), keyboardActions = KeyboardActions(onAny = {onaction()}),
        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.LightGray, unfocusedBorderColor = Color.Black ,
            cursorColor = Color.Black, focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black, focusedContainerColor = Color.White, unfocusedContainerColor = Color.White),
        visualTransformation =if (passvisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            if (passvisibility.value)
                Icon(painter = painterResource(id = R.drawable.visibleon), contentDescription = "", tint = Color.Black,
                    modifier = Modifier.clickable { passvisibility.value=false })
            else Icon(painter = painterResource(id = R.drawable.visibleoff), contentDescription = "",tint= Color.LightGray,
                modifier = Modifier.clickable { passvisibility.value=true })}

    )


}

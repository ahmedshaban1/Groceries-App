package com.ahmed.groceriesapp.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ahmed.groceriesapp.R

@Composable
fun GTextField(value:String,label:String,keyboardType:KeyboardType = KeyboardType.Text,onValueChange:(String)->Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth(),
        maxLines = 1,
        keyboardOptions =  KeyboardOptions(keyboardType = keyboardType))
}

@Composable
fun GPasswordTextField(value:String,label:String,keyboardType:KeyboardType = KeyboardType.Password,onValueChange:(String)->Unit) {
    var passwordVisibility by remember { mutableStateOf(true) }
    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth(),
        maxLines = 1,
        keyboardOptions =  KeyboardOptions(keyboardType = keyboardType),
        visualTransformation =  if(passwordVisibility) PasswordVisualTransformation()  else  VisualTransformation.None,
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(painterResource(id = R.drawable.pass_icon),contentDescription = "",Modifier.size(25.dp))

            }
        }
    )
}
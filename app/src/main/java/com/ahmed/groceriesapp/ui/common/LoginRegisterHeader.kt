package com.ahmed.groceriesapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.groceriesapp.R
import com.ahmed.groceriesapp.ui.theme.GroceriesAppTheme
import com.ahmed.groceriesapp.ui.theme.spacing

@Composable
fun LoginRegisterHeader(title:String,subTitle:String) {

    Column(Modifier.fillMaxWidth()) {
        VerticalSpacer(40.dp)
        Box(Modifier.fillMaxWidth(),contentAlignment = Alignment.Center) {
            Image(
                painterResource(id = R.drawable.gazer),
                contentDescription = "",
                modifier = Modifier.size(48.dp, 56.dp)
            )
        }
        VerticalSpacer(80.dp)
        Text(text = title,fontSize = 26.sp,color = Color.Black,fontWeight = FontWeight.Black)
        VerticalSpacer(MaterialTheme.spacing.small)
        Text(text = subTitle,fontSize = 16.sp,color = Color.Gray)
    }
}


@Preview()
@Composable
fun LoginRegisterPreview() {
    GroceriesAppTheme {
        LoginRegisterHeader("Login","Enter your email and password")
    }
}
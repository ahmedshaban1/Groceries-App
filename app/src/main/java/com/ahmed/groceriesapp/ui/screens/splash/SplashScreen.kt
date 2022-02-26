package com.ahmed.groceriesapp.ui.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmed.groceriesapp.R
import com.ahmed.groceriesapp.ui.theme.GroceriesAppTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashTimeOut:()->Unit) {
    val scale = remember {
        Animatable(0f)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(id = R.drawable.logo), contentDescription = "Logo", modifier = Modifier
                .width(268.dp)
                .height(70.dp)
                .scale(scale = scale.value)
        )

        LaunchedEffect(key1 = true){
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis =3000,
                    easing ={
                        OvershootInterpolator(4f).getInterpolation(it)
                    }
                )
            )
            //splash timeout
            delay(3000)
            onSplashTimeOut()
        }

    }
}


@Preview
@Composable
fun SplashPreview() {
    GroceriesAppTheme {
        SplashScreen{}
    }
}
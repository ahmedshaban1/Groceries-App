package com.ahmed.groceriesapp.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.ahmed.groceriesapp.ui.theme.spacing

@Composable
fun VerticalSpacer(space: Dp =  MaterialTheme.spacing.medium) {
    Spacer(modifier = Modifier.height(space))
}

@Composable
fun HorizontalSpacer(space: Dp =  MaterialTheme.spacing.medium) {
    Spacer(modifier = Modifier.width(space))
}
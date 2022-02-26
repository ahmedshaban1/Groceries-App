package com.ahmed.groceriesapp.ui.common

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ahmed.groceriesapp.ui.theme.GroceriesAppTheme

@Composable
fun GButton(
    text: String,
    modifier: Modifier = Modifier,
    onClicked: () -> Unit
) {
    Button(onClick = onClicked ,modifier = modifier) {
        Text(text = text)
    }
}


@Preview
@Composable
fun GButtonPreview() {
    GroceriesAppTheme {
        GButton(text = "Click me") {

        }
    }

}
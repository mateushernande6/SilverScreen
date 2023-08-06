package br.com.silverscreen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window

@Composable
fun ShowSplashScreen() {
    Window(
        icon = painterResource("./Silver Screen.png"),
        onCloseRequest = { },
        undecorated = true,
        resizable = false,
        transparent = true

    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {

            MaterialTheme(colors = darkColors()) {
                Image(
                    painterResource("./Silver Screen.png"),
                    contentDescription = "Splash Image Silver Screen",
                    modifier = Modifier.width(200.dp).height(200.dp),
                    alignment = Alignment.Center
                )
            }


        }
    }

}





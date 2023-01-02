package com.example.myapplication1.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import java.lang.reflect.Modifier

@Composable
fun LogInScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginScreenTopView()
    }
}


@Composable
fun LoginScreenTopView() {
    TODO("Not yet implemented")
}

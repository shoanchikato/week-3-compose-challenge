/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.navigation.Screen
import com.example.androiddevchallenge.ui.shared.BasicButton
import com.example.androiddevchallenge.ui.shared.BasicTextField
import com.example.androiddevchallenge.ui.theme.Gray_800
import com.example.androiddevchallenge.ui.theme.MySootheTheme
import com.example.androiddevchallenge.ui.theme.White

@Composable
fun LoginScreen(
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val image = if (isSystemInDarkTheme())
            painterResource(R.drawable.dark_login)
        else
            painterResource(R.drawable.light_login)

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = image,
            contentDescription = "Login Background Image",
            contentScale = ContentScale.FillBounds
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier.paddingFromBaseline(top = 200.dp, bottom = 32.dp),
                    text = "LOG IN",
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Center,
                )
            }
            val color: Color = if (isSystemInDarkTheme()) Gray_800 else White
            BasicTextField(
                name = "Email address",
            )
            BasicTextField(
                name = "Password",
            )
            BasicButton(
                name = "LOG IN",
                backgroundColor = MaterialTheme.colors.primary,
                onClick = {
                    navController.navigate(Screen.HomeScreen.route)
                }
            )
            Column(
                modifier = Modifier
                    .height(32.dp),
                verticalArrangement = Arrangement.Bottom,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "Don't have an account? ",
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        text = "Sign up",
                        style = MaterialTheme.typography.body1
                            .copy(textDecoration = TextDecoration.Underline),
                    )
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailScreenLightPreview() {
    MySootheTheme(darkTheme = false) {
        LoginScreen(rememberNavController())
    }
}

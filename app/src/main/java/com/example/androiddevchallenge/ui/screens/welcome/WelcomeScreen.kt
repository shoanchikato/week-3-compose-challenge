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
package com.example.androiddevchallenge.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.navigation.Screen
import com.example.androiddevchallenge.ui.shared.BasicButton
import com.example.androiddevchallenge.ui.theme.MySootheTheme

@Composable
fun WelcomeScreen(
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val image = if (isSystemInDarkTheme())
            painterResource(R.drawable.dark_welcome)
        else
            painterResource(R.drawable.light_welcome)

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = image,
            contentDescription = "Welcome Background Image",
            contentScale = ContentScale.FillBounds
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        Column(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val image = if (isSystemInDarkTheme())
                    painterResource(R.drawable.dark_logo)
                else
                    painterResource(R.drawable.light_logo)
                Image(
                    painter = image,
                    contentDescription = "Logo Image",
                    contentScale = ContentScale.FillHeight
                )
            }
            BasicButton(
                name = "SIGN UP",
                backgroundColor = MaterialTheme.colors.primary,
                color = MaterialTheme.colors.onPrimary,
            )
            Spacer(modifier = Modifier.height(8.dp))
            BasicButton(
                name = "LOG IN",
                backgroundColor = MaterialTheme.colors.secondary,
                color = MaterialTheme.colors.onSecondary,
                onClick = {
                    navController.navigate(Screen.LoginScreen.route)
                }
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailScreenLightPreview() {
    MySootheTheme(darkTheme = false) {
        WelcomeScreen(rememberNavController())
    }
}

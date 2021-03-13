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
package com.example.androiddevchallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.screens.home.HomeScreen
import com.example.androiddevchallenge.ui.screens.login.LoginScreen
import com.example.androiddevchallenge.ui.screens.welcome.WelcomeScreen

sealed class Screen(val route: String, val name: String, val icon: Int? = null) {
    object WelcomeScreen : Screen("welcome_screen", "Welcome")
    object LoginScreen : Screen("login_screen", "Login")
    object HomeScreen : Screen("home_screen", "Home", R.drawable.spa)
    object ProfileScreen : Screen("welcome_screen", "Profile", R.drawable.account_circle)
}

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.WelcomeScreen.route) {
        composable(Screen.WelcomeScreen.route) {
            WelcomeScreen(navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
    }
}

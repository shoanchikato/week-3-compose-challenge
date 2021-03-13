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
package com.example.androiddevchallenge.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.data.ImageLinks
import com.example.androiddevchallenge.ui.navigation.Screen
import com.example.androiddevchallenge.ui.shared.BasicTextField
import com.example.androiddevchallenge.ui.shared.BodyContent
import com.example.androiddevchallenge.ui.theme.Black_800
import com.example.androiddevchallenge.ui.theme.MySootheTheme
import com.example.androiddevchallenge.ui.theme.Taupe_100
import com.example.androiddevchallenge.ui.theme.Taupe_800
import com.example.androiddevchallenge.ui.theme.White
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun HomeScreen(
    navController: NavController,
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton()
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        drawerElevation = 4.dp,
    ) { innerPadding ->
        ProvideWindowInsets {
            BodyContent(
                Modifier
                    .statusBarsPadding()
                    .navigationBarsPadding()
                    .padding(innerPadding)
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 56.dp)
                        .padding(horizontal = 16.dp)
                ) {
                    SearchTextField()
                    FavoriteImageRow()
                    AlignBodyRow()
                    AlignMindRow()
                }
            }
        }
    }
}

@Composable
fun AlignMindRow() {
    FavouriteText(
        "ALIGN YOUR MIND"
    )
    val items = ImageLinks.values().toList().subList(fromIndex = 12, toIndex = 17)
    LazyRow {
        items.map {
            item {
                CircularImage(link = it.link, value = it.value)
            }
        }
    }
}

@Composable
fun AlignBodyRow() {
    FavouriteText(
        "ALIGN YOUR BODY"
    )
    val items = ImageLinks.values().toList().subList(fromIndex = 6, toIndex = 11)
    LazyRow {
        items.map {
            item {
                CircularImage(link = it.link, value = it.value)
            }
        }
    }
}

@Composable
fun FavoriteImageRow() {
    FavouriteText(
        "FAVORITE COLLECTIONS"
    )
    val collection = ImageLinks.values().take(6)
    LazyRow {
        collection
            .withIndex()
            .groupBy { it.index / 2 }
            .map { pair ->
                item {
                    Column {
                        FavouritePill(
                            link = pair.value[0].value.link,
                            value = pair.value[0].value.value
                        )
                        FavouritePill(
                            link = pair.value[1].value.link,
                            value = pair.value[1].value.value
                        )
                    }
                }
            }
    }
}

@Composable
fun CircularImage(
    link: String,
    value: String,
) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CoilImage(
            data = link,
            contentDescription = value,
            modifier = Modifier
                .size(88.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        ) {
            Column(
                modifier = Modifier
                    .size(88.dp)
                    .clip(shape = CircleShape)
                    .background(MaterialTheme.colors.surface),
            ) {}
        }
        Text(
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = value,
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
fun FavouritePill(
    link: String,
    value: String,
) {
    Column {
        Row(
            modifier = Modifier
                .width(192.dp)
                .height(56.dp)
                .padding(8.dp)
                .clip(shape = MaterialTheme.shapes.small),
        ) {
            Column(
                modifier = Modifier
                    .weight(42f / 192)
                    .fillMaxHeight(),
            ) {
                CoilImage(
                    data = link,
                    contentDescription = value,
                    modifier = Modifier
                        .size(42.dp),
                    contentScale = ContentScale.Crop
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colors.surface),
                    ) {}
                }
            }
            Column(
                modifier = Modifier
                    .weight(150f / 192)
                    .background(MaterialTheme.colors.surface)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = value,
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun FavouriteText(
    label: String = "FAVORITE COLLECTIONS"
) {
    Column {
        val color: Color = if (isSystemInDarkTheme()) Taupe_100 else Taupe_800
        Text(
            modifier = Modifier.paddingFromBaseline(top = 40.dp, bottom = 8.dp),
            text = label,
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Start,
            color = color,
        )
    }
}

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        val color: Color = if (isSystemInDarkTheme()) White else Black_800
        BasicTextField(
            name = "Search",
            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .size(18.dp),
                    painter = painterResource(R.drawable.search),
                    contentDescription = "Search Icon",
                    tint = color,
                )
            }
        )
    }
}

@Composable
fun BottomBar(navController: NavController) {
    val screens = listOf(Screen.HomeScreen, Screen.ProfileScreen)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
    ) {
        val selectedColor = if (isSystemInDarkTheme()) Taupe_100 else Taupe_800
        screens.map { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(screen.icon!!),
                        contentDescription = screen.route,
                    )
                },
                label = { Text(screen.name) },
                selected = currentRoute == screen.route,
                selectedContentColor = selectedColor,
                unselectedContentColor = selectedColor.copy(alpha = .5f),
                onClick = {
                    // This is the equivalent to popUpTo the start destination
                    navController.popBackStack(navController.graph.startDestination, false)

                    // This if check gives us a "singleTop" behavior where we do not create a
                    // second instance of the composable if we are already on that destination
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

@Composable
fun FloatingActionButton() {
    Column(
        modifier = Modifier
            .size(42.dp)
            .clip(shape = CircleShape)
            .background(MaterialTheme.colors.primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(R.drawable.play_arrow),
            contentDescription = "Play Icon",
            tint = MaterialTheme.colors.onPrimary,
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenLightPreview() {
    MySootheTheme(darkTheme = false) {
        HomeScreen(rememberNavController())
    }
}

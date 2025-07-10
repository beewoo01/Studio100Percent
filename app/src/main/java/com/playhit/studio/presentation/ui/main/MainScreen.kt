package com.playhit.studio.presentation.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playhit.studio.R
import com.playhit.studio.presentation.theme.Studio100PercentTheme
import com.playhit.studio.presentation.ui.home.HomeScreen
import kotlinx.coroutines.launch


@Composable
fun MainScreen(modifier: Modifier) {
    MainView()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val selectedItem = remember { mutableStateOf(DrawerMenuItem.HOME) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Surface(
                modifier = Modifier
                    .width(270.dp)
                    .fillMaxHeight()
            ) {
                DrawerContent(onItemClick = { type ->
                    selectedItem.value = type
                    scope.launch { drawerState.close() }
                })
            }

        }
    ) {
        // 메인 콘텐츠
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Image(
                            painter = painterResource(R.drawable.main_white_logo),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .width(126.dp)
                                .height(47.dp)
                        )
                    },
                    actions = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "메뉴 열기")
                        }
                    }
                )
            }
        ) { padding ->

            Box(modifier = Modifier.padding(padding)) {
                when (selectedItem.value) {
                    DrawerMenuItem.HOME -> HomeScreen()
                    DrawerMenuItem.LIBRARY -> Text("보관함")
                    DrawerMenuItem.EXPLORE -> Text("탐색")
                    DrawerMenuItem.AUTOPLAY -> Text("취향 맞춤 자동 재생")
                    DrawerMenuItem.MY_ACCOUNT -> Text("내 정보")
                }

            }

        }
    }
}


@SuppressLint("ResourceType")
@Composable
@Preview
fun DrawerContent(
    onItemClick: (DrawerMenuItem) -> Unit = {},
    onLogoutClick: () -> Unit = {}
) {
    ModalDrawerSheet {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(16.dp)
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            Image(
                painter = painterResource(R.drawable.drawer_app_icon),
                contentDescription = null,
                modifier = Modifier
                    .width(127.dp)
                    .height(47.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            HorizontalDivider()

            NavigationDrawerItem(
                colors = NavigationDrawerItemDefaults.colors(
                    selectedIconColor = colorResource(R.color.black),
                    unselectedIconColor = colorResource(R.color.black),
                    selectedTextColor = colorResource(R.color.black),
                    unselectedTextColor = colorResource(R.color.black),
                ),
                label = {
                    Text(
                        "메인",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.splash_logo),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                onClick = {
                    onItemClick(DrawerMenuItem.HOME)
                }
            )

            NavigationDrawerItem(
                colors = NavigationDrawerItemDefaults.colors(
                    selectedIconColor = colorResource(R.color.black),
                    unselectedIconColor = colorResource(R.color.black),
                    selectedTextColor = colorResource(R.color.black),
                    unselectedTextColor = colorResource(R.color.black),
                ),
                label = {
                    Text(
                        "보관함",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.splash_logo),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                onClick = {
                    onItemClick(DrawerMenuItem.LIBRARY)
                }
            )

            NavigationDrawerItem(
                colors = NavigationDrawerItemDefaults.colors(
                    selectedIconColor = colorResource(R.color.black),
                    unselectedIconColor = colorResource(R.color.black),
                    selectedTextColor = colorResource(R.color.black),
                    unselectedTextColor = colorResource(R.color.black),
                ),
                label = {
                    Text(
                        "탐색",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.splash_logo),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                onClick = {
                    onItemClick(DrawerMenuItem.EXPLORE)
                }
            )

            NavigationDrawerItem(
                colors = NavigationDrawerItemDefaults.colors(
                    selectedIconColor = colorResource(R.color.black),
                    unselectedIconColor = colorResource(R.color.black),
                    selectedTextColor = colorResource(R.color.black),
                    unselectedTextColor = colorResource(R.color.black),
                ),
                label = {
                    Text(
                        "취향 맞춤 자동 재생",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.splash_logo),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                onClick = {
                    onItemClick(DrawerMenuItem.AUTOPLAY)
                }
            )

            NavigationDrawerItem(
                colors = NavigationDrawerItemDefaults.colors(
                    selectedIconColor = colorResource(R.color.black),
                    unselectedIconColor = colorResource(R.color.black),
                    selectedTextColor = colorResource(R.color.black),
                    unselectedTextColor = colorResource(R.color.black),
                ),
                label = {
                    Text(
                        "내정보",
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.splash_logo),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                onClick = {
                    onItemClick(DrawerMenuItem.MY_ACCOUNT)
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            TextButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.White,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.White,
                ),
                border = BorderStroke(width = 1.dp, color = Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 20.dp),
                onClick = onLogoutClick
            ) {
                Text(
                    "로그아웃",
                    style = MaterialTheme.typography.labelLarge.copy(color = Color.Black)
                )
            }

        }
    }

}

enum class DrawerMenuItem {
    HOME, LIBRARY, EXPLORE, AUTOPLAY, MY_ACCOUNT
}

@Composable
@Preview
fun MainScreenPreview() {
    Studio100PercentTheme {
        MainView()
    }
}
package com.playhit.studio.presentation.ui.home

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playhit.studio.R
import com.playhit.studio.presentation.theme.Studio100PercentTheme
import kotlinx.coroutines.launch

@Composable
fun HomeScreen() {
    HomeView()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Surface(
                modifier = Modifier.width(270.dp)
                    .fillMaxHeight()
            ) {
                DrawerContent(onItemClick = {
                    scope.launch { drawerState.close() }
                })
            }

        }
    ) {
        // 메인 콘텐츠
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Drawer 예제") },
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
                Text("메인 콘텐츠")
            }

        }
    }
}

@SuppressLint("ResourceType")
@Composable
@Preview
fun DrawerContent(
    onItemClick: (Int) -> Unit = {},
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
                label = { Text("메인") },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.splash_logo),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                onClick = {
                    onItemClick(1)
                }
            )

            NavigationDrawerItem(
                label = { Text("보관함") },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.splash_logo),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                onClick = {
                    onItemClick(2)
                }
            )

            NavigationDrawerItem(
                label = { Text("탐색") },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.splash_logo),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                onClick = {
                    onItemClick(3)
                }
            )

            NavigationDrawerItem(
                label = { Text("취향 맞춤 자동 재생") },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.splash_logo),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                onClick = {
                    onItemClick(4)
                }
            )

            NavigationDrawerItem(
                label = { Text("내정보") },
                selected = false,
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.splash_logo),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                },
                onClick = {
                    onItemClick(5)
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

@Composable
@Preview
fun HomeScreenPreview() {
    Studio100PercentTheme {
        HomeView()
    }
}
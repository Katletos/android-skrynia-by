package com.example.lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.lab.ui.ObjectCard
import com.example.lab.ui.theme.LabTheme

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselecdedIcon: ImageVector,
    val hasBadge: Boolean,
    val badgeCount: Int? = null
)

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabTheme {
                val items = listOf(
                    BottomNavigationItem(
                        title = "Home",
                        selectedIcon = Icons.Filled.Home,
                        unselecdedIcon = Icons.Outlined.Home,
                        hasBadge = false,
                        badgeCount = 0
                    ),
                    BottomNavigationItem(
                        title = "Favorites",
                        selectedIcon = Icons.Filled.Favorite,
                        unselecdedIcon = Icons.Outlined.Favorite,
                        hasBadge = true,
                        badgeCount = 0
                    ),
                    BottomNavigationItem(
                        title = "Account",
                        selectedIcon = Icons.Filled.AccountCircle,
                        unselecdedIcon = Icons.Outlined.AccountCircle,
                        hasBadge = false,
                        badgeCount = 0
                    ),
                )

                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Scaffold(
                        floatingActionButton = {
                            FloatingActionButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        },
                        topBar = {
                            TopAppBar(title = {
                                Text(text = "bar content")
                            })
                        },
                        bottomBar = {
                            NavigationBar() {
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = index == selectedItemIndex,
                                        onClick = {
                                            selectedItemIndex = index
//                                            navController.navigate(item.title)
                                                  },
                                        label = {
                                                Text(text = item.title)
                                        },
                                        icon = {
                                            BadgedBox(badge = {
                                                if (item.badgeCount != null){
                                                    Badge {
                                                        Text(text = item.badgeCount.toString())
                                                    }
                                                } else if (item.hasBadge) {
                                                    Badge()
                                                }
                                            }) {
                                                Icon(
                                                    imageVector = if(index == selectedItemIndex) {
                                                        item.selectedIcon
                                                    } else item.unselecdedIcon,
                                                    contentDescription = item.title
                                                )
                                            }
                                        }
                                    )
                                }
                            }
                        }
                    ) { values ->
                        LazyColumn(contentPadding = values)  {
                            items(20) {
                                ObjectCard(
                                    title = "asd",
                                    description = "asd",
                                    Modifier.padding(16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}




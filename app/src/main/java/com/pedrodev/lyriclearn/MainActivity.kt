package com.pedrodev.lyriclearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pedrodev.lyriclearn.ui.screens.FavoritesScreen
import com.pedrodev.lyriclearn.ui.screens.HomeScreen
import com.pedrodev.lyriclearn.ui.screens.PlayerScreen
import com.pedrodev.lyriclearn.ui.theme.LyricLearnTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            LyricLearnTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home-screen"){
                    composable("home-screen") {
                        HomeScreen(
                            onNavigateToPlayer = {videoId ->
                            navController.navigate("player/$videoId")
                        },
                            onNavigateToFavorites = {
                                navController.navigate("favorite-screen")
                            }
                        )
                    }
                    composable(
                        route="player/{videoId}",
                        arguments = listOf(
                            navArgument("videoId"){
                                type = NavType.StringType
                                nullable = false
                                defaultValue = "Unknow"
                            }
                        )
                    )  {
                        it.arguments?.getString("videoId")?.let{
                            PlayerScreen(it)
                    }
                        }
                    composable("favorite-screen") {
                        FavoritesScreen(
                            onNavigateToPlayer = {videoId ->
                                navController.navigate("player/$videoId")
                            },
                            onNavigateToHome = {
                                navController.navigate("home-screen")
                            }
                        )

                    }
                }
            }
        }
    }
}


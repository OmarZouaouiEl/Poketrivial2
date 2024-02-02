package com.example.poketrivial2

import GameScreen
import ResultScreen
import SplashScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.poketrivial2.ui.theme.Poketrivial2Theme
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.poketrivia.Difficulty


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Poketrivial2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.MenuScreen.route
                    ) {
                        composable(
                            Routes.SplashScreen.route
                        ) {
                            SplashScreen()
                        }
                        composable(
                            Routes.MenuScreen.route
                        ) {
                            MenuScreen(navigationController)
                        }
                        composable(Routes.GameScreen.route) {
                            GameScreen(navigationController, selectedDifficulty = Difficulty.MEDIUM)

                        }
                        composable(Routes.GameScreen.route) {
                            ResultScreen(navigationController, userScore = Int )

                        }
                        composable(Routes.SettingsScreen.route) { Routes.SettingsScreen.route }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
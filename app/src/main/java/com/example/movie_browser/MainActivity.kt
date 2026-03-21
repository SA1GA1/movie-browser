package com.example.movie_browser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.movie_browser.ui.screens.home.HomeScreen
import com.example.movie_browser.ui.theme.MoviebrowserTheme
import android.util.Log
import androidx.compose.material3.Text
import androidx.navigation.compose.rememberNavController
import com.example.movie_browser.ui.navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviebrowserTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
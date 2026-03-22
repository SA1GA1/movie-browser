package com.example.movie_browser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.movie_browser.ui.theme.MoviebrowserTheme
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
package com.example.movie_browser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.movie_browser.ui.screens.home.HomeScreen
import com.example.movie_browser.ui.theme.MoviebrowserTheme
import android.util.Log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviebrowserTheme {
                HomeScreen()
            }
        }
    }
}
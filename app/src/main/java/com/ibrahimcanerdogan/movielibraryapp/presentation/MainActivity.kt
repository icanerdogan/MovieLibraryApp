package com.ibrahimcanerdogan.movielibraryapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ibrahimcanerdogan.movielibraryapp.presentation.ui.theme.MovieLibraryAppTheme
import com.ibrahimcanerdogan.movielibraryapp.presentation.view.MovieScreen
import com.ibrahimcanerdogan.movielibraryapp.util.Constant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieLibraryAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = ComposeScreen.MovieScreen.route) {
                        composable(route = ComposeScreen.MovieScreen.route) {
                            MovieScreen(navController = rememberNavController())
                        }
                        composable(route = ComposeScreen.MovieDetailScreen.route + "/${Constant.IMDB_ID}") {

                        }
                    }
                }
            }
        }
    }
}
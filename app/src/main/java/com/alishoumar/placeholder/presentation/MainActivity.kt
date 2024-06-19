package com.alishoumar.placeholder.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.alishoumar.placeholder.presentation.navigation.Screen
import com.alishoumar.placeholder.presentation.navigation.SetUpNavGraph
import com.alishoumar.placeholder.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                SetUpNavGraph(
                    startDestination = Screen.Users.route,
                    navController = navController)
            }
        }
    }
}


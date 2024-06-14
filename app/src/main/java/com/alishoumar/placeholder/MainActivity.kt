package com.alishoumar.placeholder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.alishoumar.placeholder.presentation.navigation.Screen
import com.alishoumar.placeholder.presentation.navigation.setUpNavGraph
import com.alishoumar.placeholder.presentation.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                setUpNavGraph(
                    startDestination = Screen.Users.route,
                    navController = navController)
            }
        }
    }
}


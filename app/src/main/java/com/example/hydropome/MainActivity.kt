package com.example.hydropome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hydropome.ui.login.LoginScreen
import com.example.hydropome.ui.register.RegisterScreen
import com.example.hydropome.ui.theme.HydropomeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            HydropomeTheme {
                val navController = rememberNavController()


                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("login") {
                            LoginScreen(
                                onRegisterClick = {
                                    navController.navigate("register")
                                }
                            )
                        }

                        composable("register") {
                            RegisterScreen(
                                onBackClick = {
                                    navController.popBackStack()   // balik ke halaman sebelumnya (login)
                                },
                                onLoginClick = {
                                    navController.popBackStack()   // klik "Masuk" dari register -> balik ke login
                                }
                            )
                        }
                    }

            }
        }
    }
}

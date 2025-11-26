package com.example.hydropome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.hydropome.ui.login.LoginScreen
import com.example.hydropome.ui.register.RegisterScreen
import com.example.hydropome.ui.theme.HydropomeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            HydropomeTheme {
                LoginScreen(
                    onRegisterClick = {
                        setContent {
                            HydropomeTheme {
                                RegisterScreen(
                                    onBackClick = { recreate() }
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}

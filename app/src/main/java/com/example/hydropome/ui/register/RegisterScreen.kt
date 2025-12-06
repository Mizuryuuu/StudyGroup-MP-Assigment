package com.example.hydropome.ui.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hydropome.R
import com.example.hydropome.ui.AppDestination
import com.example.hydropome.ui.theme.HydropomeTheme
import com.example.hydropome.ui.theme.AppColors

@Composable
fun RegisterScreen(
    navController: NavController
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    navController.popBackStack(AppDestination.Onboarding, false)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_arrow_left_alt_24),
                        contentDescription = "Kembali"
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.Start
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Daftar Akun dan Mulai\nBertani Hidroponik! 🌿",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = AppColors.text
            )

            Spacer(modifier = Modifier.height(32.dp))

            // ==== Nama Lengkap ====
            Text(
                text = "Nama Lengkap",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = AppColors.text
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = fullName,
                onValueChange = { fullName = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                placeholder = { Text("Masukkan Nama Lengkap") },
                shape = RoundedCornerShape(10.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // ==== Email ====
            Text(
                text = "Email",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = AppColors.text
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                placeholder = { Text("Masukkan Email") },
                shape = RoundedCornerShape(10.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // ==== Buat Password ====
            Text(
                text = "Buat Password",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = AppColors.text
            )
            Spacer(modifier = Modifier.height(8.dp))
            var passwordVisible by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                placeholder = { Text("Masukkan Password") },
                shape = RoundedCornerShape(10.dp),
                visualTransformation = if (passwordVisible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(
                            id = if (passwordVisible)
                                R.drawable.visibility_off_24dp_ffffff_fill0_wght400_grad0_opsz24
                            else
                                R.drawable.visibility_24dp_ffffff_fill0_wght400_grad0_opsz24
                        ),
                        contentDescription = if (passwordVisible) "Sembunyikan" else "Tampilkan",
                        modifier = Modifier.clickable {
                            passwordVisible = !passwordVisible
                        }
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // ==== Konfirmasi Password ====
            Text(
                text = "Konfirmasi Password",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = AppColors.text
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                placeholder = { Text("Masukkan Password") },
                shape = RoundedCornerShape(10.dp),
                visualTransformation = if (passwordVisible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(
                            id = if (passwordVisible)
                                R.drawable.visibility_off_24dp_ffffff_fill0_wght400_grad0_opsz24
                            else
                                R.drawable.visibility_24dp_ffffff_fill0_wght400_grad0_opsz24
                        ),
                        contentDescription = if (passwordVisible) "Sembunyikan" else "Tampilkan",
                        modifier = Modifier.clickable {
                            passwordVisible = !passwordVisible
                        }
                    )
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            // ==== Tombol Daftar ====
            Button(
                onClick = {
                    navController.navigate(AppDestination.Login) {
                        popUpTo(0)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppColors.primary,
                    contentColor = AppColors.textLight
                )
            ) {
                Text(
                    text = "Daftar Akun",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ==== Sudah punya akun? Masuk ====
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Sudah memiliki akun? ")
                Text(
                    text = "Masuk",
                    color = AppColors.primary,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .clickable {
                            navController.navigate(AppDestination.Login) {
                                popUpTo(0)
                            }
                        }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPreview() {
    HydropomeTheme {
        RegisterScreen(
            navController = rememberNavController()
        )
    }
}

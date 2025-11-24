package com.example.hydropome.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// Pastikan file theme ini ada di project Anda
import com.example.hydropome.ui.theme.BrandGreen
import com.example.hydropome.ui.theme.IntBackground

@Composable
@Preview
fun Login(){
    // Context belum terpakai, tapi tidak apa-apa dibiarkan
    val context = LocalContext.current


    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .padding(24.dp),
        // verticalArrangement = Arrangement.Center, // Baris ini dikomentari di kode asli Anda
        // horizontalAlignment = Alignment.CenterHorizontally, // Baris ini dikomentari di kode asli Anda
    ){
        IconButton(
            onClick ={},
            modifier = Modifier
                .size(48.dp)
                .offset(x = (-12).dp)
        ){

            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
        }

        Text(
            text = "Selamat Datang Kembali",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = "HydroPoMate! 🌿🍃",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Username", // Saya sesuaikan labelnya dengan input di bawahnya
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )


        TextField(
            value = username, // Sekarang ini tidak error karena variabel 'username' sudah ada di atas
            onValueChange = { value ->
                username = value
            },
            label = {
                Text("Username")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(12.dp))

        Text(
            text = "Password",
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )


        TextField(
            value = password,
            onValueChange = { value ->
                password = value
            },
            label = {
                Text("Password")
            },
            modifier = Modifier.fillMaxWidth(),

            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

        )

    }
}
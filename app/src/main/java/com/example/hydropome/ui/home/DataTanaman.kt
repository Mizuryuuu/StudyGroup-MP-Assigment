package com.example.hydropome.ui.home

import android.media.Image
import android.text.Html
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import com.example.hydropome.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object DataTanaman {
    //DataTanaman
    data class  PlantItem(
        val image : Int,
        val name : String,
        val level : String,
        val duration : String,
        val description : String,
        val toolsAndMaterials : List<Pair<String, String?>>,
        val judulTutorial : String,
        val tutorial : Int
    )

    val PlantList = listOf(
        PlantItem(
            image = R.drawable.selada_hidroponik,
            name = "Selada Hidroponik",
            level = "Mudah",
            duration = "3-5 Minggu",
            description = "Selada merupakan salah satu tanaman paling populer dalam budidaya hidroponik karena pertumbuhannya yang cepat dan perawatannya yang mudah. Tanaman ini cocok untuk pemula karena tidak memerlukan banyak nutrisi khusus atau perawatan intensif. Selada tumbuh subur di sistem hidroponik seperti NFT (Nutrient Film Technique) dan dapat dipanen dalam waktu 3–5 minggu setelah tanam",
            toolsAndMaterials = listOf(
                Pair("Wadah atau Bak Tanam", "Tempat air nutrisi dan tanaman diletakkan."),
                Pair("Net Pot / Pot kecil berlubang", "Untuk menahan tanaman dan media tanam."),
                Pair("Spons/Rockwool", "Media tanam tempat benih tumbuh."),
                Pair("Pompa Air (untuk NFT)", "Mengalirkan nutrisi secara sirkulasi."),
                Pair("Penutup atau Styrofoam (untuk rakit apung)", "Untuk menopang netpot."),
                Pair("Alat ukur pH dan TDS", "Untuk memantau kualitas larutan nutrisi."),
                Pair("Benih selada", null),
                Pair("Nutrisi AB Mix", null),
                Pair("Air Bersih", null)
            ),
            judulTutorial = "Menanam Selada Hidroponik",
            tutorial = R.drawable.video
        )
    )
}
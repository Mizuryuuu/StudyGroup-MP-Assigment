package com.example.wasapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hydropome.R
import com.example.hydropome.ui.home.Data.DataTanaman
import com.example.hydropome.ui.theme.AbuabuText
import com.example.hydropome.ui.theme.AbuabuTextSerch
import com.example.hydropome.ui.theme.AppColors

@Composable
fun Numbering (number: Int) {
    for (i in 1..number) {
        Text(
            text = "$i.",
            fontSize = 14.sp
        )
    }
}

@Composable
fun ToolsItem(name: String, description: String?) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                append(name)
            }
            append(" ")

            // Description jadi abu abu
            description?.let {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, color = Color.Gray)) {
                    append(it)
                }
            }
        },
        fontSize = 14.sp
    )
}

@Composable
fun ToolsAndMaterials(tools: List<Pair<String, String?>>) {
    Column {
        tools.forEachIndexed { index, (name, description) ->
            Row(
                modifier = Modifier
                    .padding(vertical = 4.dp))
            {
                // Nomor
                Text(
                    text = "${index + 1}.",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(3.dp))
                // Nama + description dalam satu Text
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                            append(name)
                        }
                        append(" ")
                        description?.let {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, color = Color.Gray)) {
                                append(it)
                            }
                        }
                    },
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
@Preview
fun LamanTanaman () {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(301.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.selada_hidroponik),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                )

                Button(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.TopStart)
                        .offset(x = 20.dp, y = 52.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColors.background
                    ),
                    shape = RoundedCornerShape(16.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.arrow_left),
                        contentDescription = "image"
                    )
                }
            }

            Spacer(modifier = Modifier.height(13.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(851.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .width(335.dp)
                        .height(851.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    //Nama tanaman
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.5f)
                        ) {
                            Text(
                                text = DataTanaman.PlantList[0].name,
                                fontSize = 24.sp
                            )
                        }
                        Row(
                            modifier = Modifier
                                .width(215.dp)
                                .height(165.dp),
                            verticalAlignment = Alignment.Bottom,
                        ) {
                            Row (
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ellipse_142),
                                    contentDescription = "image",
                                    modifier = Modifier.padding(end = 4.dp)
                                )
                                val levelTanaman = DataTanaman.PlantList[0].level
                                Text(
                                    text = levelTanaman,
                                    color = AppColors.primary
                                )
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Row (
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.clock),
                                    contentDescription = "image",
                                    modifier = Modifier.padding(end = 4.dp)
                                )
                                val levelTanaman = DataTanaman.PlantList[0].duration
                                Text(
                                    text = levelTanaman,
                                    color = AbuabuTextSerch
                                )
                            }
                        }
                    }

                    //Deskrpisi
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier
                                .height(19.dp)
                        ) {
                            Text(
                                text = "Deskripsi",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                        Row(
                            modifier = Modifier
                                .height(133.dp)
                        ) {
                            Text(
                                text = DataTanaman.PlantList[0].description,
                                fontSize = 12.sp,
                                lineHeight = 16.32.sp,
                                color = AbuabuText,
                                textAlign = TextAlign.Justify,
                            )
                        }
                    }

                    //Alat dan bahan
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(293.dp)
                    ) {
                        Row (
                            modifier = Modifier
                                .height(19.dp)
                        ){
                            Text(
                                text = "Alat dan Bahan",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Row {
                            Spacer(modifier = Modifier.height(8.dp))
                            ToolsAndMaterials(
                                tools = DataTanaman.PlantList[0].toolsAndMaterials
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(262.dp)
                    ) {
                        Row (
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                        ){
                            Text(
                                text = "Tutorial Menanam",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(264.dp)
                                .shadow(
                                    elevation = 1.dp,
                                    shape = RoundedCornerShape(16.dp),
                                    clip = false
                                )
                                .clip(shape = RoundedCornerShape(16.dp))
                                .background(Color.White),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(194.dp)
                                    .padding(vertical = 8.dp, horizontal = 8.dp)
                                    .clip(shape = RoundedCornerShape(8.dp))
                            ) {
                                Box (
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ){
                                    Image(
                                        painter = painterResource(DataTanaman.PlantList[0].tutorial),
                                        contentDescription = "image",
                                        contentScale = ContentScale.Crop
                                    )
                                    Button(
                                        onClick = { /* TODO */ },
                                        modifier = Modifier
                                            .size(48.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = AppColors.background
                                        ),
                                        shape = RoundedCornerShape(16.dp),
                                        contentPadding = PaddingValues(0.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.play_button),
                                            contentDescription = "image"
                                        )
                                    }
                                }
                            }

                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp)
                                    .padding(horizontal = 8.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = DataTanaman.PlantList[0].judulTutorial,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
            }

            Spacer(
                modifier = Modifier
                    .height(49.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .width(335.dp)
                        .height(48.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier
                            .height(50.dp)
                    ) {
                        Button(
                            onClick = { /* TODO */ },
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(shape = RoundedCornerShape(16.dp)),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = AppColors.primary
                            ),
                            shape = RoundedCornerShape(16.dp),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(
                                text = "Mulai Tanam dan Pantau"
                            )
                        }
                    }
                }
            }
            Spacer(
                modifier = Modifier
                    .height(30.dp)
            )
        }
    }
}
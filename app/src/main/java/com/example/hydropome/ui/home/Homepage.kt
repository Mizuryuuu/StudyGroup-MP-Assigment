package com.example.wasapp.ui.screens

<<<<<<< HEAD
import android.view.View
import com.example.hydropome.R
=======
import android.R.attr.text
>>>>>>> munif
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
<<<<<<< HEAD
import androidx.compose.foundation.layout.fillMaxHeight
=======
>>>>>>> munif
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
<<<<<<< HEAD
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
=======
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
>>>>>>> munif
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
<<<<<<< HEAD
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
=======
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hydropome.R
import com.example.hydropome.ui.home.Data.DataTanaman
import com.example.hydropome.ui.home.Data.DataTanaman.PlantList
>>>>>>> munif
import com.example.hydropome.ui.theme.Abuabu
import com.example.hydropome.ui.theme.AbuabuText
import com.example.hydropome.ui.theme.AbuabuTextSerch
import com.example.hydropome.ui.theme.HijauNormal

<<<<<<< HEAD
//DataTanaman
data class  PlantItem(
    val image : Int,
    val name : String,
    val level : String,
    val duration : String
)

val PlantList = listOf(
    PlantItem(
        image = R.drawable.selada_hidroponik,
        name = "Selada Hidroponik",
        level = "Mudah",
        duration = "3-5 Minggu"
    ),
    PlantItem(
        image = R.drawable.selada_hidroponik,
        name = "Selada Hidroponik",
        level = "Mudah",
        duration = "3-5 Minggu"
    ),
    PlantItem(
        image = R.drawable.selada_hidroponik,
        name = "Selada Hidroponik",
        level = "Mudah",
        duration = "3-5 Minggu"
    ),
    PlantItem(
        image = R.drawable.selada_hidroponik,
        name = "Selada Hidroponik",
        level = "Mudah",
        duration = "3-5 Minggu"
    ),
    PlantItem(
        image = R.drawable.selada_hidroponik,
        name = "Selada Hidroponik",
        level = "Mudah",
        duration = "3-5 Minggu"
    ),
    PlantItem(
        image = R.drawable.selada_hidroponik,
        name = "Selada Hidroponik",
        level = "Mudah",
        duration = "3-5 Minggu"
    )
)

=======
>>>>>>> munif
//DataStarterKit
data class StarterKitItem (
    val image : Int,
    val category : String,
    val name : String,
    val discountPrince : String,
    val price : String
)

val StarterKitList = listOf(
    StarterKitItem(
        image = R.drawable.paket_pipa_nft,
        category = "Starter Kit",
        name = "Starter Kit 1",
        discountPrince = "Rp. 100.000",
        price = "Rp. 200.000"
    ),
    StarterKitItem(
        image = R.drawable.paket_pipa_nft,
        category = "Starter Kit",
        name = "Starter Kit 1",
        discountPrince = "Rp. 100.000",
        price = "Rp. 200.000"
    ),
    StarterKitItem(
        image = R.drawable.paket_pipa_nft,
        category = "Starter Kit",
        name = "Starter Kit 1",
        discountPrince = "Rp. 100.000",
        price = "Rp. 200.000"
    ),
    StarterKitItem(
        image = R.drawable.paket_pipa_nft,
        category = "Starter Kit",
        name = "Starter Kit 1",
        discountPrince = "Rp. 100.000",
        price = "Rp. 200.000"
    ),
)

@Composable
<<<<<<< HEAD
fun PlantCard (item: PlantItem, modifier: Modifier = Modifier) {
=======
fun PlantCard (item: DataTanaman.PlantItem, modifier: Modifier = Modifier) {
>>>>>>> munif
    Column(
        modifier = modifier
            .padding(8.dp)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(12.dp),
                spotColor = Color.Black,
            )
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(8.dp)
    ) {
        Row {
            Column {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = item.name,
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    item.name,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                )
            }
        }
<<<<<<< HEAD
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(item.level, color = Color.Gray, fontSize = 12.sp)
            Text(item.duration, color = Color.Gray, fontSize = 12.sp)
=======
        Row(
            modifier = Modifier
                .height(14.dp)
                .width(131.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ellipse_142),
                    contentDescription = "image",
                    modifier = Modifier.padding(end = 2.dp).size(10.dp)
                )
                val levelTanaman = PlantList[0].level
                Text(
                    text = levelTanaman,
                    color = HijauNormal,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraLight
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = "image",
                    modifier = Modifier.padding(end = 2.dp).size(10.dp),
                )
                val levelTanaman = PlantList[0].duration
                Text(
                    text = levelTanaman,
                    color = AbuabuTextSerch,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraLight
                )
            }
>>>>>>> munif
        }
    }
}

@Composable
fun StarterKitCard (item: StarterKitItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(12.dp),
                spotColor = Color.Black,
            )
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(8.dp)
    ) {
        Row {
            Column {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = item.name,
                    modifier = Modifier
                        .width(141.dp)
                        .height(128.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
<<<<<<< HEAD

                Spacer(Modifier.height(8.dp))

                Text(
                    text = item.category,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Text(item.name, fontWeight = FontWeight.Bold)
            }
        }

        Row {
            Text(text = item.discountPrince)
            Text(text = item.price)
=======
                Text(
                    text = item.category,
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Text(
                    text = item.name,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Row(
            modifier = Modifier
                .width(141.dp)
                .height(17.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.discountPrince,
                    color = HijauNormal,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.price,
                    fontSize = 10.sp,
                    color = AbuabuTextSerch,
                    textDecoration = TextDecoration.LineThrough,
                )
            }
>>>>>>> munif
        }
    }
}


@Composable
@Preview
<<<<<<< HEAD
fun ChatPage () {

=======
fun Homepage() {
>>>>>>> munif
    //Homepage
    Box (
        modifier = Modifier
            .fillMaxSize()
<<<<<<< HEAD
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {

        Box (
            modifier = Modifier
                .height(239.dp)
                .background(Color.Green)
        ) {

        }
=======
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(color = HijauNormal) // warna contoh
        )
>>>>>>> munif

        //Container-Content --Start--
        Column {
            Spacer(modifier = Modifier
<<<<<<< HEAD
                .height(60  .dp)
            )

=======
                .height(60.dp)
            )
>>>>>>> munif
            //Content1-Header --Start--
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 23.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Halo, Userrrr",
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                    )
                    Text(
                        text = "Berkebun Apa Hari Ini?",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp,
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.poto_profil),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color.Gray)
                    )
                }
            }
            //Content1-Header --End--

            Spacer(modifier = Modifier
                .height(16.dp)
            )

            //Content2 --Start--
            Box (modifier = Modifier
                .fillMaxWidth()
                .height(245.dp),
                contentAlignment = Alignment.Center
            ) {
                Column (modifier = Modifier
                    .width(335.dp)
                    .height(245.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box (modifier = Modifier
                        .fillMaxWidth()
                        .height(177.dp)
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(16.dp),
                            spotColor = Color.Black,
                            clip = false
                        )
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(Color.White)
                    ){
                        Column (
                            modifier = Modifier
                                .fillMaxSize()
<<<<<<< HEAD
                                .padding(top = 35.5.dp, end = 119.dp, bottom = 35.5.dp, start = 16.dp),
=======
                                .padding(
                                    top = 35.5.dp,
                                    end = 119.dp,
                                    bottom = 35.5.dp,
                                    start = 16.dp
                                ),
>>>>>>> munif
                            verticalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(
                                text = "Belum Ada Progress Tanaman Hari Ini...",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Text(
                                text = "Ayo pilih tanaman pertama kamu dan mulai tanam sekarang!",
                                color = AbuabuText,
                                fontSize = 12.sp
                            )
                        }
                        Column (
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.End,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(end = 6.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.freepik__tree__inject_3),
                                contentDescription = "Plant",
                            )
                        }
                    }

                    Spacer(modifier = Modifier
                        .height(20.dp)
                    )

                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(color = Abuabu)
                        .padding(top = 14.dp, end = 27.dp, bottom = 14.dp, start = 16.dp),
                    ){
                        Column (
                            modifier = Modifier
                                .height(20.dp)
                                .width(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = "Search"
                            )
                        }
                        Column  (
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 12.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
<<<<<<< HEAD
                                text = "Cari tanaman...",
                                color = AbuabuTextSerch,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold
                            )
=======
                                text = "Cari Tanaman...",
                                color = AbuabuTextSerch,
                            )
//                            BasicTextField(
//                                value = "",
//                                onValueChange = {},
//                                modifier = Modifier
//                                    .fillMaxWidth(),
//                                singleLine = true,
//                                textStyle = LocalTextStyle.current,
//                            )
>>>>>>> munif
                        }
                    }
                }
            }
            //Content2 --End--

            Spacer(modifier = Modifier
                .height(17.dp)
            )

            //Content3 --Start--
            Box (modifier = Modifier
                .fillMaxWidth()
                .height(648.dp),
                contentAlignment = Alignment.Center
            ) {
                Column (modifier = Modifier
                    .width(335.dp)
                    .height(648.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .height(19.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "Rekomendasi Untukmu",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                        )

                        Text(
                            text = "Lihat Semua",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = HijauNormal,
                            modifier = Modifier
                                .padding(top = 5.dp)
                        )
                    }

                    Spacer(modifier = Modifier
                        .height(16.dp)
                    )

                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .height(613.dp)
                    ){
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            items(PlantList.size) { index ->
<<<<<<< HEAD
                                PlantCard(item = PlantList[index])
=======
                                PlantCard(
                                    item = PlantList[index],
                                )
>>>>>>> munif
                            }
                        }
                    }
                }
            }
            //Content3 --End--

            Spacer(modifier = Modifier
                .height(33.dp)
            )

            //Content4 --Start--
            Box (modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
                contentAlignment = Alignment.Center
            ) {
                Column (modifier = Modifier
                    .width(335.dp)
                    .height(250.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .height(22.dp)
                    ){
                        Text(
                            text = "Starter  Kit Flash Sale \uD83D\uDD25"
                        )
                    }

                    Spacer(modifier = Modifier
                        .height(20.dp)
                    )

                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .height(212.dp)
                    ){
                        LazyHorizontalGrid(
                            rows = GridCells.Fixed(1),
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            items(StarterKitList.size) { index ->
                                StarterKitCard(item = StarterKitList[index])
                            }
                        }
                    }
                }
            }
            //Content4 --End--

            Spacer(modifier = Modifier
                .height(41.dp)
            )
        }
    }
}
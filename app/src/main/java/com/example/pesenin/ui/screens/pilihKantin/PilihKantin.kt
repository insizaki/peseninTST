package com.example.pesenin.ui.screens.pilihKantin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.pesenin.HomeRoutes
import com.example.pesenin.R
import com.example.pesenin.data.model.Store
import com.example.pesenin.ui.theme.TopBar

@Composable
fun LihatDaftarMenu(
    modifier: Modifier = Modifier,
    pilihKantinViewModel: PilihKantinViewModel? = null,
    navController: NavHostController
) {

    var stores: List<Store> by remember { mutableStateOf(emptyList()) }
    pilihKantinViewModel!!.GetAllStore { storesData ->
        stores = storesData
        println("######################### $stores")
    }


    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .background(color = Color.White)
        ) {
            TopBar(true)
        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 10.dp,
                    y = 241.dp
                )
        ) {
            Text(
                text = "Kantin GKM FILKOM",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .offset(
                    x = 0.dp,
                    y = 86.dp
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.statustoko_wallpaper),
                contentDescription = "Kantin GKM FILKOM",
                modifier = Modifier
                    .requiredWidth(width = 360.dp)
                    .requiredHeight(height = 143.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .offset(
                    x = 0.dp,
                    y = 284.dp
                )
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color(0xfff4f5f9))
                .verticalScroll(rememberScrollState())
        ) {
            Row( //Fragment Menu
                horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.Start),
                modifier = Modifier
                    .offset(
                        x = 10.dp,
                        y = 20.dp
                    )
                    .requiredWidth(width = 360.dp)
                    .requiredHeight(height = 115.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(color = Color.White)
                    .padding(8.dp)
            ) {
                var urlPhoto: String by remember { mutableStateOf("") }

                Image(
                    painter = rememberImagePainter(data = urlPhoto), contentDescription = "",
                    modifier = Modifier
                        .requiredWidth(width = 148.dp)
                        .requiredHeight(height = 100.dp)
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(color = Color(0xfff4f5f9))
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(vertical = 6.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "CoffeeShop",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                        )
                    )
                    Text(
                        text = "Menyajikan kopi terbaik dari Malang Raya",
                        style = TextStyle(
                            fontSize = 7.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF313131),
                        )
                    )
                    Spacer(modifier = Modifier.weight(1.0f))
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 120.dp)
                            .requiredHeight(height = 25.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(color = Color(0xff3a62a0))
                    ) {
                        Button(
                            onClick = {
                                navController.navigate(HomeRoutes.MenuKantinKopi.name)
                            },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .align(alignment = Alignment.TopCenter)
                                .requiredWidth(150.dp)
                                .requiredHeight(150.dp),

                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(
                                    0xFF3A62A0
                                )
                            )
                        ) {
                            Text(
                                "Buka Toko",
                                color = Color.White,
                                fontSize = 8.sp,
                                modifier = Modifier.offset(y = (-2).dp)
                            )
                        }
                    }
                }
            }
            for (store in stores) {
                Row( //Fragment Menu
                    horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.Start),
                    modifier = Modifier
                        .offset(
                            x = 10.dp,
                            y = 20.dp
                        )
                        .requiredWidth(width = 360.dp)
                        .requiredHeight(height = 115.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(color = Color.White)
                        .padding(8.dp)
                ) {
                    var urlPhoto: String by remember { mutableStateOf("") }
                    pilihKantinViewModel.GetStorePhoto(store.photo ?: "") { url ->
                        urlPhoto = url
                    }
                    Image(
                        painter = rememberImagePainter(data = urlPhoto), contentDescription = "",
                        modifier = Modifier
                            .requiredWidth(width = 148.dp)
                            .requiredHeight(height = 100.dp)
                            .clip(shape = RoundedCornerShape(6.dp))
                            .background(color = Color(0xfff4f5f9))
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .padding(vertical = 6.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = store.name ?: "",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),
                            )
                        )
                        Text(
                            text = store.description ?: "",
                            style = TextStyle(
                                fontSize = 7.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF313131),
                            )
                        )
                        Spacer(modifier = Modifier.weight(1.0f))
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 120.dp)
                                .requiredHeight(height = 25.dp)
                                .clip(shape = RoundedCornerShape(5.dp))
                                .background(color = Color(0xff3a62a0))
                        ) {
                            Button(
                                onClick = {
                                    navController.navigate(HomeRoutes.MenuKantin.name)
                                },
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier
                                    .align(alignment = Alignment.TopCenter)
                                    .requiredWidth(150.dp)
                                    .requiredHeight(150.dp),

                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(
                                        0xFF3A62A0
                                    )
                                )
                            ) {
                                Text(
                                    "Buka Toko",
                                    color = Color.White,
                                    fontSize = 8.sp,
                                    modifier = Modifier.offset(y = (-2).dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//private fun LihatDaftarMenuPreview() {
//    LihatDaftarMenu(Modifier)
//}
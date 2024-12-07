package com.example.pesenin.ui.screens.menukantin

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.pesenin.HomeRoutes
import com.example.pesenin.R
import com.example.pesenin.data.model.Menu
import com.example.pesenin.data.model.MenuKopi
import com.example.pesenin.ui.theme.TopBar
import androidx.compose.material3.Card

@Composable
fun MenuKantinKopi(
    menuKopiViewModel: MenuKopiViewModel? = null,
    navController : NavController
) {

    val apiMenus = menuKopiViewModel?.apiMenus?.collectAsState()?.value

    print("########" + apiMenus)
    menuKopiViewModel?.fetchApiMenus()

//    // Memastikan data di-fetch pertama kali
//    LaunchedEffect(Unit) {
//        menuKopiViewModel?.fetchApiMenus()
//    }

    var x = 0
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .background(color = Color.White)
        ){
            TopBar(true)
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .offset(
                    y = 84.dp
                )
                .background(color = Color.White)
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            Text(
                text = "Menu Kantin",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
            )
            Spacer(modifier = Modifier.weight(1.0f))
            Box(
                modifier = Modifier
                    .requiredWidth(width = 120.dp)
                    .requiredHeight(height = 27.dp)
                    .clip(shape = RoundedCornerShape(5.dp))
                    .background(color = Color(0xff3a62a0))
            ) {
                Button(
                    onClick = {
                        navController.navigate(HomeRoutes.TambahMenuKantin.name)
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.align(alignment = Alignment.TopStart).width(126.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A62A0))
                ){
                    Text("+ Tambah Menu", color = Color.White, fontSize = 9.sp,
                        modifier =
                        Modifier.
                        offset(y=(0).dp))
                }
            }
        }
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .offset(
                    x = 0.dp,
                    y = 128.dp
                )
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.White)
                .padding(12.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(color = Color(0xfff4f5f9))
                    .padding(horizontal = 8.dp)
                    .height(40.dp)
                    .width(360.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(27.dp)
                        .height(13.dp)
                ){
                    Text(
                        text = "No",
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF303030),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(120.dp)
                        .height(13.dp)
                ){
                    Text(
                        text = "Nama",
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF303030),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(67.dp)
                        .height(13.dp)
                ){
                    Text(
                        text = "Harga",
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF303030),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(140.dp)
                        .height(13.dp)
                ){
                    Text(
                        text = "Aksi",
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF303030),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
            if (apiMenus != null) {
                for(MenuKopi in apiMenus) {
                    x += 1
                    Row(//menu
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(color = Color(0xfff4f5f9))
                            .padding(horizontal = 8.dp)
                            .height(40.dp)
                            .width(360.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .width(27.dp)
                                .height(12.dp)
                        ){
                            Text(
                                text = x.toString(),
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    lineHeight = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF303030),
                                    textAlign = TextAlign.Center,
                                )
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier
                                .width(120.dp)
                                .height(12.dp)
                        ){
                            Text(
                                text = MenuKopi.name ?: " ",
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    lineHeight = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF303030),
                                    textAlign = TextAlign.Center,
                                )
                            )

                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .width(67.dp)
                                .height(12.dp)
                        ){
                            Text(
                                text = MenuKopi.price.toString() ?: "",
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    lineHeight = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF303030),
                                    textAlign = TextAlign.Center,
                                )
                            )

                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .background(color = Color(0xfff4f5f9))
                                .padding(horizontal = 8.dp)
                                .height(40.dp)
                                .width(360.dp)
                        ){
                            Box(
                                modifier = Modifier
                                    .requiredWidth(width = 28.dp)
                                    .requiredHeight(height = 25.dp)
                                    .clip(shape = RoundedCornerShape(5.dp))
                                    .background(color = Color(0xff3a62a0))
                            ) {
                                Button(
                                    onClick = {
        //                                    navController.navigate("detail_menu_kantin/$key")
                                    },
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier
                                        .align(alignment = Alignment.TopCenter)
                                        .offset(
                                            x = 0.dp,
                                            y = (-1).dp
                                        )
                                        .requiredWidth(width = 250.dp)
                                        .requiredHeight(height = 250.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A62A0))
                                ){
                                    Image(
                                        painter = painterResource(id = R.drawable.bx_detail),
                                        contentDescription = "Detail",
                                        modifier = Modifier
                                            .size(21.dp)
                                            .background(
                                                color = Color(0xFF2B5699),
                                                shape = RoundedCornerShape(size = 5.dp)
                                            )
                                            .padding(start = 3.dp, top = 3.dp, end = 2.dp, bottom = 3.dp)
                                    )
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .requiredWidth(width = 28.dp)
                                    .requiredHeight(height = 25.dp)
                                    .clip(shape = RoundedCornerShape(5.dp))
                                    .background(color = Color(0xff3a62a0))
                            ) {
                                Button(
                                    onClick = {

                                    },
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier
                                        .align(alignment = Alignment.TopCenter)
                                        .offset(
                                            x = 0.dp,
                                            y = (-1).dp
                                        )
                                        .requiredWidth(width = 250.dp)
                                        .requiredHeight(height = 250.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEA5E5E))
                                ){
                                    Image(
                                        painter = painterResource(id = R.drawable.mdi_trash),
                                        contentDescription = "Delete",
                                        modifier = Modifier
                                            .size(21.dp)
                                            .background(
                                                color = Color(0xFFEA5E5E),
                                                shape = RoundedCornerShape(size = 5.dp)
                                            )
                                            .padding(start = 4.dp, top = 3.dp, end = 3.dp, bottom = 3.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.BottomStart)
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .background(color = Color.White)
        ) {}
    }
}


//@Preview(showBackground = true)
//@Composable
//private fun MenuKantinPreview() {
//    MenuKantin(modifier)
//}
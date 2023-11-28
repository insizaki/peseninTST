package com.example.pesenin.ui.screens.pesan

import  androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pesenin.R
import com.example.pesenin.ui.theme.BottomBar
import com.example.pesenin.ui.theme.TopBar

@Composable
fun HalamanStatusPesanan4(modifier: Modifier = Modifier) {
//    var pesan1 by remember { mutableIntStateOf(0) }

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
        ){
            TopBar(true)
        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(
                    x = 10.dp,
                    y = 84.dp
                )
        ) {
            Text(
                text = "Detail Pesanan",
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 150.dp)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(112.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.pesananterkirim),
                contentDescription = "BuktiPembayaran",
                modifier = Modifier
                    .size(188.dp, 131.dp)
            )
        }
        Box(
            modifier = Modifier
                .offset(x = 25.dp, y = 330.dp)
                .requiredWidth(width = 348.dp)
                .requiredHeight(height = 117.dp)
                .clip(shape = RoundedCornerShape(12.dp))
                .background(color = Color(0xFFFF9433))
                .padding(14.dp)

        ) {
            Text(
                text = "Terkirim",
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 17.sp),
                modifier = Modifier
                    .offset(x = 130.dp)
//                    .fillMaxSize()
            )
            Row(
                modifier = Modifier
//                    .fillMaxWidth()
                    .offset(x= 2.dp,y = 5.dp)
                    .align(Alignment.Center) // Align ke bawah dan di tengah
                    .padding(bottom = 10.dp) // Menambah jarak dari bawah
            ) {
                Image(
                    painter = painterResource(id = R.drawable.timer),
                    contentDescription = "Timer",
                    modifier = Modifier
                        .size(22.dp, 22.dp)
                        .align(Alignment.CenterVertically) // Align gambar di tengah vertikal
                )
                Text(
                    text = " - - -",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    style = TextStyle(
                        fontSize = 18.sp
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterVertically) // Align teks di tengah vertikal
                )
            }
            Text(
                text = "Pesanan telah diambil",
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 12.sp),
                modifier = Modifier
//                    .fillMaxSize()
                    .offset(x = 100.dp, y = 65.dp)
            )
        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.BottomStart)
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .background(color = Color.White)
        ){
            BottomBar(1)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HalamanStatusPesanan4Preview() {
    HalamanStatusPesanan4(Modifier)
}
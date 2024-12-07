package com.example.pesenin.ui.screens.menukantin


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pesenin.R
import com.example.pesenin.data.model.Menu
import com.example.pesenin.ui.theme.BottomBarKantin
import com.example.pesenin.ui.theme.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailMenuKantin(
    navController: NavController,
    menuKantinViewModel: MenuKantinViewModel,
    key: String
) {

//    var menus: List<Pair<String, com.example.pesenin.data.model.Menu>> by remember { mutableStateOf(emptyList()) }

    //textfield
    val nama = remember { mutableStateOf(TextFieldValue()) }
    val harga = remember { mutableStateOf(TextFieldValue()) }

//    val menuState = remember { mutableStateOf<Menu?>(null) }
//    val isLoading = remember { mutableStateOf(true) }

    //dropdown
    val opsi = arrayOf("Tersedia", "Tidak Tersedia")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(opsi[0])}

//    val menu = menuState.value
//
//    LaunchedEffect(key) {
//        menuKantinViewModel.getMenuByKey(key) { menu ->
//            menuState.value = menu
//            isLoading.value = false
//        }
//    }
//
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
                text = "Detail Menu Kantin",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
            )
        }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp),
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
                Image(
                    painter = painterResource(id = R.drawable.bx_detail),
                    contentDescription = "",
                    modifier = Modifier
                        .width(307.dp)
                        .height(143.dp)
                        .background(color = Color(0xFFF4F5F9), shape = RoundedCornerShape(size = 6.dp))
                )
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 106.dp)
                        .requiredHeight(height = 25.dp)
                        .clip(shape = RoundedCornerShape(5.dp))
                        .background(color = Color(0xff3a62a0))
                )
                Column (
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .offset(
                            x = 0.dp,
                            y = 20.dp
                        )
                        .width(307.dp)
                        .padding(12.dp)
                ) {
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        Row(
                            modifier = Modifier
                                .width(50.dp)
                        ){
                            Text(
                                text = "Nama",
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    lineHeight = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),

                                    )
                            )
                        }
                        Text(
                            text = ":",
                            style = TextStyle(
                                fontSize = 10.sp,
                                lineHeight = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),

                                )
                        )
                        OutlinedTextField(
                            modifier = Modifier
                                .background(color = Color(0xFFFFFFFF))
                                .height(50.dp),
                            value = nama.value,
                            onValueChange = { nama.value = it },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black,
                            ),
                            placeholder = {
                                Text(
                                    text = "",
                                    style = TextStyle(
                                        fontSize = 10.sp,
                                        lineHeight = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF757373),
                                    )
                                )
                            },
                        )
                    }
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        Row(
                            modifier = Modifier
                                .width(50.dp)
                        ){
                            Text(
                                text = "Harga",
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    lineHeight = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),

                                    )
                            )
                        }
                        Text(
                            text = ":",
                            style = TextStyle(
                                fontSize = 10.sp,
                                lineHeight = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),

                                )
                        )
                        Text(
                            text = "Rp.",
                            style = TextStyle(
                                fontSize = 10.sp,
                                lineHeight = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),

                                )
                        )
                        OutlinedTextField(
                            modifier = Modifier
                                .background(color = Color(0xFFFFFFFF))
                                .height(50.dp),
                            value = harga.value,
                            onValueChange = { harga.value = it },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black,
                            ),
                            placeholder = {
                                Text(
                                    text = "",
                                    style = TextStyle(
                                        fontSize = 10.sp,
                                        lineHeight = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF757373),
                                    )
                                )
                            },
                        )
                    }
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment =  Alignment.CenterVertically,
                    ){
                        Row(
                            modifier = Modifier
                                .width(50.dp)
                        ){
                            Text(
                                text = "Status",
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    lineHeight = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),

                                    )
                            )
                        }
                        Text(
                            text = ":",
                            style = TextStyle(
                                fontSize = 10.sp,
                                lineHeight = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),

                                )
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            ExposedDropdownMenuBox(
                                expanded = expanded,
                                onExpandedChange = {
                                    expanded = !expanded
                                }
                            ) {
                                TextField(
                                    value = selectedText,
                                    onValueChange = {},
                                    readOnly = true,
                                    modifier = Modifier
                                        .menuAnchor()
                                        .height(50.dp),
                                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                                        containerColor = Color(0xFFFFFFFF),
                                    ),
                                    textStyle = TextStyle(
                                        fontSize = 10.sp,
                                        lineHeight = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),
                                    ),
//                                trailingIcon = {
//                                    Image(
//                                        painter = painterResource(id = R.drawable.dropdownarrow),
//                                        contentDescription = "arrow",
//                                        modifier = Modifier
//                                            .size(16.dp)
//                                    )
//                                }
                                )
                                ExposedDropdownMenu(
                                    expanded = expanded,
                                    onDismissRequest = { expanded = false }
                                ) {
                                    DropdownMenuItem(
                                        text = { Text(
                                            text = "Tersedia",
                                            style = TextStyle(
                                                fontSize = 10.sp,
                                                lineHeight = 12.sp,
                                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                                fontWeight = FontWeight(400),
                                                color = Color(0xFF000000),
                                            )
                                        ) },
                                        onClick = {
                                            selectedText = "Tersedia"
                                            expanded = false
                                        }

                                    )
                                    DropdownMenuItem(
                                        text = { Text(
                                            text = "Tidak Tersedia",
                                            style = TextStyle(
                                                fontSize = 10.sp,
                                                lineHeight = 12.sp,
                                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                                fontWeight = FontWeight(400),
                                                color = Color(0xFF000000),
                                            )
                                        ) },
                                        onClick = {
                                            selectedText = "Tidak Tersedia"
                                            expanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                    Row (
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                    ){
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 106.dp)
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
                                    .requiredWidth(150.dp)
                                    .requiredHeight(150.dp),

                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A62A0))
                            ){
                                Text("Simpan", color = Color.White, fontSize = 8.sp,modifier = Modifier.offset ( y=(-2).dp))
                            }
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .align(alignment = Alignment.BottomStart)
                    .background(color = Color.White)
                    .fillMaxWidth()
            ){
                BottomBarKantin(2)
            }

    }
}


//@Preview(showBackground = true)
//@Composable
//private fun DetailMenuKantinPreview() {
//    DetailMenuKantin(Modifier)
//}
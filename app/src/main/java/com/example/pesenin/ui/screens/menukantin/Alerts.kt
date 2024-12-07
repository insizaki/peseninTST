package com.example.pesenin.ui.screens.menukantin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.pesenin.R

@Composable
fun HapusMenu(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        // Draw a rectangle shape with rounded corners inside the dialog
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White),
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hapusmenuwarning),
                    contentDescription = "Warning",
                    modifier = Modifier
                        .size(120.dp)
                )
                Text(
                    text = "Anda yakin ingin menghapus Menu?",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF595E61),
                        textAlign = TextAlign.Center,
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 80.dp)
                            .requiredHeight(height = 25.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(color = Color(0xFF83A976))
                    ) {
                        Button(
                            onClick = { onConfirmation() },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .align(alignment = Alignment.TopCenter)
                                .requiredWidth(width = 350.dp)
                                .requiredHeight(height = 350.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF83A976))
                        ){
                            Text(
                                text = "Ok",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    lineHeight = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFFFFFFFF),

                                    ),
                                modifier = Modifier.offset ( y=1.dp)
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 80.dp)
                            .requiredHeight(height = 25.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(color = Color(0xFFEA5E5E))
                    ) {
                        Button(
                            onClick = { onConfirmation() },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .align(alignment = Alignment.TopCenter)
                                .requiredWidth(width = 350.dp)
                                .requiredHeight(height = 350.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEA5E5E))
                        ){
                            Text(
                                text = "Batal",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    lineHeight = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFFFFFFFF),

                                    ),
                                modifier = Modifier.offset ( y=1.dp)
                            )
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Success(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    status: String,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        // Draw a rectangle shape with rounded corners inside the dialog
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White),
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tambahmenusuccess),
                    contentDescription = "Warning",
                    modifier = Modifier
                        .size(120.dp)
                )
                Text(
                    text = status,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF595E61),
                        textAlign = TextAlign.Center,
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 80.dp)
                            .requiredHeight(height = 25.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(color = Color(0xFF83A976))
                    ) {
                        Button(
                            onClick = { onConfirmation() },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .align(alignment = Alignment.TopCenter)
                                .requiredWidth(width = 350.dp)
                                .requiredHeight(height = 350.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF83A976))
                        ){
                            Text(
                                text = "Ok",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    lineHeight = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFFFFFFFF),

                                    ),
                                modifier = Modifier.offset ( y=1.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun HapusMenuPreview() {
//    HapusMenu(
//        onDismissRequest = { },
//        onConfirmation = { },
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun SuccessPreview() {
//    Success(
//        onDismissRequest = { },
//        onConfirmation = { },
//        status = "Menu berhasil dihapus",
//    )
//}
package com.example.pesenin.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import coil.compose.rememberImagePainter
import com.example.pesenin.LoginRoutes
import com.example.pesenin.R
import com.example.pesenin.data.model.User
import com.example.pesenin.ui.theme.PeseninTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(profileViewModel: ProfileViewModel? = null, navController: NavController? = null){

    var user: User by remember { mutableStateOf(User()) }
    profileViewModel!!.GetUserData { userData->
        user = userData
        println("######################### ${user}")
    }

    Column(
        modifier= Modifier
            .fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.logofilkom ),
            contentDescription = "Logo Filkom",
            modifier = Modifier
                .padding(top=20.dp)
                .height(25.60925.dp)
                .width(115.dp)
                .align(Alignment.CenterHorizontally))

        Image(painter = rememberImagePainter(data = user.profil),
            contentDescription = "ProfilePicture",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
                .padding(top = 23.4.dp)
        )

        TextButton(onClick = {
            profileViewModel.logOut()
            navController!!.navigate(LoginRoutes.SignIn.name) {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
            }

        },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 36.dp)) {
            Icon(imageVector  = Icons.Outlined.ExitToApp,
                contentDescription = "LogOut",
                tint = Color(0xFFFF0000))
            Text(
                text = "Log Out",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFF0000),
                    )
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 35.dp)
                .fillMaxSize()
                .background(
                    color = Color(0xFFFC7B33),
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
        ) {
            Row (
                Modifier
                    .padding(top = 74.dp)
                    .align(Alignment.CenterHorizontally)
                    .width(291.dp)
                    .height(59.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 6.dp))){

                Icon(imageVector  = Icons.Outlined.School,
                    contentDescription = "NIM",
                    tint = Color.Gray,
                    modifier= Modifier
                        .padding(start = 13.dp, end = 13.5.dp)
                        .align(Alignment.CenterVertically))

                Text(text = user.nim ?:"",
                    modifier= Modifier.align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF868889),
                    )

                )
            }


            Row (
                Modifier
                    .padding(top = 18.dp)
                    .align(Alignment.CenterHorizontally)
                    .width(291.dp)
                    .height(59.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 6.dp))){

                Icon(imageVector  = Icons.Outlined.Mail,
                    contentDescription = "Email",
                    tint = Color.Gray,
                    modifier= Modifier
                        .padding(start = 13.dp, end = 13.5.dp)
                        .align(Alignment.CenterVertically))

                Text(text = user.email ?:"",
                    modifier= Modifier.align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF868889),
                        )

                )
            }


            Row (
                Modifier
                    .padding(top = 18.dp)
                    .align(Alignment.CenterHorizontally)
                    .width(291.dp)
                    .height(59.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 6.dp))){

                Icon(imageVector  = Icons.Outlined.Phone,
                    contentDescription = "Phone",
                    tint = Color.Gray,
                    modifier= Modifier
                        .padding(start = 13.dp, end = 13.5.dp)
                        .align(Alignment.CenterVertically))

                Text(text = user.phone ?:"",
                    modifier= Modifier.align(Alignment.CenterVertically),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF868889),
                    )

                )
            }


            Row (
                Modifier
                    .padding(top = 18.dp, bottom = 52.dp)
                    .align(Alignment.CenterHorizontally)
                    .width(291.dp)
                    .height(59.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 6.dp))){

                Icon(imageVector  = Icons.Outlined.Lock,
                    contentDescription = "Email",
                    tint = Color.Gray,
                    modifier= Modifier
                        .padding(start = 13.dp, end = 13.5.dp)
                        .align(Alignment.CenterVertically))

                Image(painter = painterResource(id = R.drawable.pass),
                    modifier = Modifier
                        .width(115.5.dp)
                        .height(9.dp)
                        .align(Alignment.CenterVertically),
                    contentDescription = "adfaf")
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevProfileScreen(){
    PeseninTheme {
        ProfileScreen()
    }
}
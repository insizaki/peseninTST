package com.example.pesenin

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pesenin.nav.NavItem
import com.example.pesenin.ui.screens.BottomNavigationBar
import com.example.pesenin.ui.screens.homeScreen.Home
import com.example.pesenin.ui.screens.loginScreen.LoginScreen
import com.example.pesenin.ui.screens.loginScreen.LoginViewModel
import com.example.pesenin.ui.screens.loginScreen.SignUpScreen
import com.example.pesenin.ui.screens.menukantin.DetailMenuKantin
import com.example.pesenin.ui.screens.menukantin.HapusMenu
import com.example.pesenin.ui.screens.menukantin.MenuKantin
import com.example.pesenin.ui.screens.menukantin.MenuKantinKopi
import com.example.pesenin.ui.screens.menukantin.MenuKantinViewModel
import com.example.pesenin.ui.screens.menukantin.MenuKopiViewModel
import com.example.pesenin.ui.screens.menukantin.TambahMenu
import com.example.pesenin.ui.screens.pesan.HalamanKeranjang
import com.example.pesenin.ui.screens.pesan.HalamanPembayaran
import com.example.pesenin.ui.screens.pesan.HalamanPembayaran2
import com.example.pesenin.ui.screens.pesan.HalamanPembayaran3
import com.example.pesenin.ui.screens.pesan.HalamanPesanNanti
import com.example.pesenin.ui.screens.pesan.HalamanPilihPesanan
import com.example.pesenin.ui.screens.pesan.HalamanPilihPesanan2
import com.example.pesenin.ui.screens.pesan.HalamanStatusPesanan
import com.example.pesenin.ui.screens.pilihKantin.LihatDaftarMenu
import com.example.pesenin.ui.screens.pilihKantin.PilihKantinViewModel
import com.example.pesenin.ui.screens.profile.ProfileScreen
import com.example.pesenin.ui.screens.profile.ProfileViewModel

enum class LoginRoutes{
    SignUp,
    SignIn
}

enum class HomeRoutes{
    Home,
    Bucket,
    Pesanan2,
    PesanNanti,
    Bayar1,
    Bayar2,
    Bayar3,
    Status,
    MenuKantin,
    DetailMenu,
    AlertsMenu,
    TambahMenuKantin,
    MenuKantinKopi
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold (
        modifier = Modifier.fillMaxWidth(),
        bottomBar =
        {
            if (currentDestination?.route != LoginRoutes.SignIn.name
                && currentDestination?.route != LoginRoutes.SignUp.name
                && currentDestination?.route != HomeRoutes.Bucket.name
                && currentDestination?.route != HomeRoutes.Pesanan2.name
                && currentDestination?.route != HomeRoutes.Bayar1.name
                && currentDestination?.route != HomeRoutes.Bayar2.name
                && currentDestination?.route != HomeRoutes.Bayar3.name
                && currentDestination?.route != HomeRoutes.PesanNanti.name
                ) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { _ ->
        NavHost(navController = navController, startDestination = LoginRoutes.SignIn.name) {
            composable(route = LoginRoutes.SignIn.name){
                LoginScreen(onNavToHomePage = {
                    navController.navigate(HomeRoutes.Home.name){
                        launchSingleTop = true
                        popUpTo(route = LoginRoutes.SignIn.name){
                            inclusive = true
                        }
                    }
                },
                    loginViewModel = loginViewModel

                ) {
                    navController.navigate(LoginRoutes.SignUp.name){
                        launchSingleTop = true
                        popUpTo(LoginRoutes.SignIn.name){
                            inclusive = true
                        }
                    }
                }
            }

            composable(route = LoginRoutes.SignUp.name){
                SignUpScreen(onNavToHomePage = {
                    navController.navigate(HomeRoutes.Home.name){
                        popUpTo(LoginRoutes.SignUp.name){
                            inclusive = true
                        }
                    }
                },
                    loginViewModel = loginViewModel
                ) {
                    navController.navigate(LoginRoutes.SignIn.name)
                }
            }

            composable(route = NavItem.Home.path){
                Home(loginViewModel = loginViewModel, navController)
            }

            composable(NavItem.Home.path) { Home(loginViewModel = LoginViewModel(), navController) }
            composable(NavItem.Restaurant.path) { HalamanPilihPesanan(navController) }
            composable(HomeRoutes.Bucket.name) { HalamanKeranjang(navController) }
            composable(HomeRoutes.Pesanan2.name) { HalamanPilihPesanan2(navController)}
            composable(HomeRoutes.Bayar1.name) { HalamanPembayaran(navController) }
            composable(HomeRoutes.Bayar2.name) { HalamanPembayaran2(navController) }
            composable(HomeRoutes.Bayar3.name) { HalamanPembayaran3(navController) }
            composable(HomeRoutes.MenuKantin.name) { MenuKantin(navController = navController, menuKantinViewModel = MenuKantinViewModel()) }
            composable(HomeRoutes.MenuKantinKopi.name) { MenuKantinKopi(navController = navController, menuKopiViewModel = MenuKopiViewModel()) }
//            composable(
//                route = "detail_menu_kantin/{menuKey}",
//                arguments = listOf(navArgument("menuKey") { type = NavType.StringType })
//            ) { backStackEntry ->
//                val menuKey = backStackEntry.arguments?.getString("menuKey") ?: ""
//                DetailMenuKantin(navController, menuKantinViewModel, menuKey)
//            }
////            composable(HomeRoutes.DetailMenu.name) {
//                DetailMenuKantin(navController = navController, menuKantinViewModel = MenuKantinViewModel(), key = key) }
            composable(HomeRoutes.TambahMenuKantin.name) { TambahMenu(navController = navController, menuViewModel = MenuKantinViewModel()) }
            composable(HomeRoutes.AlertsMenu.name) { HapusMenu(onConfirmation = {}, onDismissRequest = {} ) }
            composable(NavItem.Home.path) { LihatDaftarMenu(navController = navController, pilihKantinViewModel = PilihKantinViewModel()) }
            composable(NavItem.Profile.path) { ProfileScreen(profileViewModel = ProfileViewModel(), navController) }
            composable(HomeRoutes.PesanNanti.name) { HalamanPesanNanti(navController) }
            composable(HomeRoutes.Status.name) { HalamanStatusPesanan(1)}
        }
    }
}
package com.example.loginpage.nav

import OtpScreen2
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginpage.LoginScreen
import reference2

enum class Screen {
    HOME,
    LOGIN,
    OTP,
    REFERRAL,
}

sealed class NavigationItem(val route: String) {
    object Home : NavigationItem(Screen.HOME.name)
    object Login : NavigationItem(Screen.LOGIN.name)
    object OTP : NavigationItem(Screen.OTP.name)
    object Referral : NavigationItem(Screen.REFERRAL.name)
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationItem.Login.route
    ) {
        composable(route = NavigationItem.Login.route) {
            LoginScreen(onContinueClick = { otp ->
                println("OTP Entered: $otp")
                navController.navigate(route = NavigationItem.OTP.route)
            })
        }

        composable(route = NavigationItem.OTP.route) {
            OtpScreen2(
                phoneNumber = "9891851352",
                onContinueClick = { otp ->
                    println("OTP Entered: $otp")
                    navController.navigate(route = NavigationItem.Referral.route)
                },
                onEditNumber = {
                    println("Edit Number Clicked")
                    navController.navigateUp()
                }
            )
        }

        composable(route = NavigationItem.Referral.route) {
            reference2()
        }
    }
}

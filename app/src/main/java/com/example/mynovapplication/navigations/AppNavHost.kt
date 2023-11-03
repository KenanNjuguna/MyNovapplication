package com.example.mynovapplication.navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvmnavigation.ui.theme.screens.about.BmiScreen
import com.example.mynovapplication.ui.theme.Screen.Calculator.CalculatorScreen
import com.example.mynovapplication.ui.theme.Screen.Home.HomeScreen
import com.example.mynovapplication.ui.theme.Screen.Intents.IntentsScreen

@Composable
fun AppNavHost(
    modifier: Modifier=Modifier,
    navcontroller:NavHostController= rememberNavController(),
    startDestination: String= ROUTE_HOME
){
    NavHost(navController = navcontroller,
        modifier = modifier,
        startDestination =startDestination ,
    ){
        composable(ROUTE_HOME){
            HomeScreen(navController  = navcontroller)
        }
        composable(ROUTE_CALCULATOR){
            CalculatorScreen(navController =  navcontroller)
        }
        composable(ROUTE_BMI){
           BmiScreen(navController   = navcontroller)
        }
        composable(ROUTE_INTENTS){
            IntentsScreen(navController = navcontroller)
        }

        }
    }

package com.example.mynovapplication.ui.theme.Screen.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mynovapplication.R
import com.example.mynovapplication.navigations.ROUTE_BMI
import com.example.mynovapplication.navigations.ROUTE_CALCULATOR
import com.example.mynovapplication.navigations.ROUTE_INTENTS

import com.example.mynovapplication.ui.theme.MyNovApplicationTheme

@Composable
fun HomeScreen(navController: NavController){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp, bottom = 20.dp),
    horizontalArrangement = Arrangement.SpaceEvenly)
    {
    Card (
        modifier = Modifier
            .width(165.dp)
            .height(200.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor =  Color.Red
        )
    ){
        Column ( modifier = Modifier
            .fillMaxWidth()
            .height(130.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Icon(
                painter = painterResource(id = R.drawable.baseline_monetization_on_24 ) ,
                contentDescription = "My icon",
                tint = Color.Black
            )
        }
        Column(modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .height(70.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { navController.navigate(ROUTE_INTENTS)}) {
                Text(text = "Intents")
            }


        }
    }

        Card (
            modifier = Modifier
                .width(165.dp)
                .height(200.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor =  Color.Black
            )
        ){
            Column ( modifier = Modifier
                .fillMaxWidth()
                .height(130.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Icon(
                    painter = painterResource(id = R.drawable.baseline_calculate_24 ) ,
                    contentDescription = "My icon",
                    tint = Color.Red
                )
            }

            Column(modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .height(70.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = { navController.navigate(ROUTE_CALCULATOR)}) {
                    Text(text = "Calculator")
                }


            }
        }

    }
    Row (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Card (
            modifier = Modifier
                .width(165.dp)
                .height(200.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor =  Color.Blue
            )
        ){
            Column ( modifier = Modifier
                .fillMaxWidth()
                .height(130.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Icon(
                    painter = painterResource(id = R.drawable.baseline_line_weight_24 ) ,
                    contentDescription = "My icon",
                    tint = Color.Red
                )
            }
            Column(modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .height(70.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = { navController.navigate(ROUTE_BMI)}) {
                    Text(text = "BMI")
                }


            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomescreenPreview(){
    MyNovApplicationTheme {
        HomeScreen(rememberNavController())
    }
}

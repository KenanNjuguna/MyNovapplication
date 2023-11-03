package com.example.mynovapplication.ui.theme.Screen.Calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mynovapplication.ui.theme.MyNovApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen(navController: NavHostController) {
    var firstNum by remember { mutableStateOf(TextFieldValue()) }
    var secondNum by remember { mutableStateOf(TextFieldValue()) }
    var answer by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "CALCULATOR SCREEN",
            fontFamily = FontFamily.Default,
            fontSize = 35.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(30.dp))

        val onValueChange: (TextFieldValue) -> Unit = {
            // Handle value changes for both fields here
            if (it == firstNum) {
                firstNum = it
            } else {
                secondNum = it
            }
        }

        OutlinedTextField(
            value = firstNum,
            label = {
                Text(
                    text = "First Number",
                    fontSize = 24.sp,
                    color = Color.Black,
                    fontFamily = FontFamily.Default
                )
            },
            onValueChange = onValueChange,
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = secondNum,
            label = {
                Text(
                    text = "Second Number",
                    fontSize = 24.sp,
                    color = Color.Black,
                    fontFamily = FontFamily.Default
                )
            },
            onValueChange = onValueChange,
        )

        Spacer(modifier = Modifier.height(70.dp))

        Text(
            text = "Result: $answer",
            fontFamily = FontFamily.Default,
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            val operators = listOf("+", "-", "*", "/")

            operators.forEach { operator ->
                Button(
                    onClick = {
                        val first = firstNum.text.trim().toDoubleOrNull()
                        val second = secondNum.text.trim().toDoubleOrNull()

                        if (first != null && second != null) {
                            when (operator) {
                                "+" -> answer = (first + second).toString()
                                "-" -> answer = (first - second).toString()
                                "*" -> answer = (first * second).toString()
                                "/" -> answer = (first / second).toString()
                            }
                        } else {
                            answer = "Please fill in all details"
                        }
                    },
                    modifier = Modifier.width(80.dp),
                    colors = ButtonDefaults.buttonColors(Color.Gray)
                ) {
                    Text(
                        text = operator,
                        color = Color.Black,
                        fontFamily = FontFamily.Default,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CalculatorPrev() {
    MyNovApplicationTheme {
        CalculatorScreen(rememberNavController())
    }
}
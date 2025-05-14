package com.jaytech.pacepro.ui.theme.screens.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.jaytech.pacepro.Navigations.ROUTE_LOGIN
import com.jaytech.pacepro.Navigations.ROUTE_REGISTER
import com.jaytech.pacepro.ui.theme.screens.custobars.BottomNav
import com.jaytech.pacepro.ui.theme.screens.custobars.TopBar

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = { TopBar("HOME SCREEN") },
        bottomBar = { BottomNav(navHostController) }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding) // Apply padding from Scaffold
        ) {
            Text(
                text = "Arsenal",
                color = Color.Black,
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Welcome to Arsenal",
                color = Color.Magenta,
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navHostController.navigate(ROUTE_LOGIN) },
                modifier = Modifier.width(300.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(
                    text = "Login",
                    color = Color.Red
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { navHostController.navigate(ROUTE_REGISTER) },
                modifier = Modifier.width(300.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(
                    text = "Register",
                    color = Color.Red
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
package com.jaytech.pacepro.ui.theme.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jaytech.pacepro.Navigations.ROUTE_LOGIN
import com.jaytech.pacepro.data.AuthViewModel


@Composable
fun Register_Screen(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var lname by remember { mutableStateOf(TextFieldValue("")) }
    var fname by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFECEFF1))
            .padding(16.dp)
    ) {
        Text(
            "Register",
            color = Color.Black,
            fontSize = 35.sp,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = fname,
            onValueChange = { fname = it },
            label = {
                Text(
                    "First Name",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Monospace,)},


            keyboardOptions = KeyboardOptions.Default.copy (imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )


        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = lname,
            onValueChange = { lname = it },
            label = {
                Text(
                    "Last Name",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Monospace,)  },

            keyboardOptions = KeyboardOptions.Default.copy (imeAction = ImeAction.Next),
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(
                    "Email",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Monospace,
                )
            },
            keyboardOptions = KeyboardOptions . Default . copy (imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(
                    "Password",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Monospace,
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(value =confirmpass , onValueChange = {
            confirmpass=it},
            label = { Text(text = "Enter Confirm Pass") },

            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                val myregister= AuthViewModel(navController,context)
                myregister.signup(fname.text.trim(),lname.text.trim(),email.text.trim(),password.text.trim(),confirmpass.text.trim())

            },
            colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier.fillMaxWidth()){


            Text(
                "Sign Up",
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FontFamily.Cursive
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Already have an account? Log in",
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier.clickable {
                navController.navigate(ROUTE_LOGIN)
            }
        )
    }
}

@Preview
@Composable
fun Register_ScreenPreview() {
    Register_Screen(rememberNavController())

}
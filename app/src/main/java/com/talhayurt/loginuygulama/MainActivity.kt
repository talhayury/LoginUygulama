package com.talhayurt.loginuygulama

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.talhayurt.loginuygulama.ui.theme.LoginUygulamaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginUygulamaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Sayfa()

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sayfa() {
    val kullaniciAdi = remember { mutableStateOf("")    }
    val sifre = remember { mutableStateOf("")    }
        Column (modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally){
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")
            TextField(value = kullaniciAdi.value, onValueChange = {kullaniciAdi.value=it}, label = { Text(text = "Kullanıcı Adı")} , colors =TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedTextColor = Color.Black,
                focusedIndicatorColor = Color.Red
            ))

            TextField(value = sifre.value, onValueChange = {sifre.value=it}, label = { Text(text = "Şifre")} , colors =TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedTextColor = Color.Black,
                focusedIndicatorColor = Color.Red
            ))
            
            Button(onClick = { Log.e("Button","Giris Yapildi")},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ), modifier = Modifier.size(250.dp,50.dp)
                ) {
                    Text(text = "Giriş Yap")
            }
        }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginUygulamaTheme {
        Sayfa()
    }
}
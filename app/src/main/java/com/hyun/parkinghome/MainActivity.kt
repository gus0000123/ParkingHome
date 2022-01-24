package com.hyun.parkinghome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hyun.parkinghome.components.TextSnackbar
import com.hyun.parkinghome.db.CarEntity
import com.hyun.parkinghome.ui.theme.ParkingHomeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewmodel: MainViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParkingHomeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    EnrollPage(viewmodel) { addr, number ->
                    }
                }
            }
        }
    }
}

@Composable
fun EnrollPage(viewmodel: MainViewmodel? = null, callback: (addr: String, number: String) -> Unit) {
    var addr by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "차량을 등록해주세요.", modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            TextField(
                value = addr, modifier = Modifier
                    .fillMaxWidth(), placeholder = {
                    Text(text = "동호수 (ex:501호)")
                }, onValueChange = {
                    addr = it
                })
            TextField(
                value = number, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp), placeholder = {
                    Text(text = "차량번호 (ex:123가1234)")
                }, onValueChange = {
                    number = it
                })

            Button(
                onClick = {
                    viewmodel?.selectAll()
//                    addr = ""
//                    number = ""
//                    callback(addr, number)
                }, modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "등록")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ParkingHomeTheme {
        EnrollPage { _, _ -> }
    }
}
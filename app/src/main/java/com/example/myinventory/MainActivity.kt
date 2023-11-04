package com.example.myinventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myinventory.ui.theme.MyInventoryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyInventoryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    
                    
                        ScreenSetup()
                }
            }
        }
    }
}



@Composable
fun ScreenSetup()
{
    MainScreen()
    
}


@Composable
fun MainScreen()
{
    Text(text = "Working !")
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyInventoryTheme {
        
    }
}
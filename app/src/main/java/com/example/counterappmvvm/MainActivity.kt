package com.example.counterappmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.counterappmvvm.ui.theme.CounterAppMVVMTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val counterViewModel= CounterViewModel()
            CounterAppMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterApp(counterViewModel = counterViewModel)
                }
            }
        }
    }
}

@Composable
fun CounterApp(counterViewModel: CounterViewModel){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(text = "Number ${counterViewModel.count.value}")
        Row(horizontalArrangement = Arrangement.SpaceBetween,) {
            Button(onClick = {
                counterViewModel.increment()
            }) {
                Text("Increment")
            }
            Spacer(modifier = Modifier.padding(8.dp))

            Button(onClick = {
                counterViewModel.decrement()
            }) {
                Text("Decrement")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val counterViewModel = CounterViewModel()
    CounterAppMVVMTheme {
        CounterApp(counterViewModel = counterViewModel)
    }
}
package com.mtanmay.gonukkadcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mtanmay.gonukkadcompose.ui.theme.GoNukkadComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoNukkadComposeTheme {
                Scaffold { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {
                        Header(username = "Jeffery")
                        SubHeader()
                        FilterCard(
                            modifier = Modifier.padding(10.dp)
                        )
                        ReceivedCallCard(Modifier.padding(10.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GoNukkadComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(Modifier.fillMaxSize()) {
                Header(username = "Jeffrey", modifier = Modifier.padding(innerPadding))
                SubHeader()
                FilterCard(
                    modifier = Modifier.padding(10.dp)
                )
                ReceivedCallCard(Modifier.padding(10.dp))
            }
        }
    }
}
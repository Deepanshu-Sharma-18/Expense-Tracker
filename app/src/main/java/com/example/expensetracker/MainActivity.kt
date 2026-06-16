package com.example.expensetracker

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCard
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), contentWindowInsets = WindowInsets.safeDrawing) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("Today") }

    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(text = "Hi, Justin", style = MaterialTheme.typography.titleSmall)
                Text(text = "Welcome Back!", style = MaterialTheme.typography.titleLarge)
            }

            Card(
                modifier = Modifier.size(48.dp), shape = CircleShape
            ) {
                Box (
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ){
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Profile",
                        modifier = Modifier,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier.height(300.dp),
            contentAlignment = Alignment.BottomStart,
        ){
            Card(modifier = Modifier.fillMaxWidth().offset(x= 10.dp, y = (-60).dp).zIndex(1f)) {
                Text(text = "VISA")
                Text(text = "**** **** **** 1234")
                Row() {
                    Column() {
                        Text(text = "Holder")
                        Text(text = "Imran Khan")
                    }

                    Column() {
                        Text(text = "Expiry Date")
                        Text(text = "02/27")
                    }
                }
            }

            Card(modifier = Modifier.fillMaxWidth().zIndex(2f)) {
                Text(text = "VISA")
                Text(text = "**** **** **** 1234")
                Row() {
                    Column() {
                        Text(text = "Holder")
                        Text(text = "Imran Khan")
                    }

                    Column() {
                        Text(text = "Expiry Date")
                        Text(text = "02/27")
                    }
                }
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Card() {
                Column() {
                    Icon(imageVector = Icons.Filled.AddCard, contentDescription = "")
                    Text(text="Deposit")
                }
            }
            Card() {
                Column() {
                    Icon(imageVector = Icons.Filled.AddCard, contentDescription = "")
                    Text(text="Deposit")
                }
            }
            Card() {
                Column() {
                    Icon(imageVector = Icons.Filled.AddCard, contentDescription = "")
                    Text(text="Deposit")
                }
            }
            Card() {
                Column() {
                    Icon(imageVector = Icons.Filled.AddCard, contentDescription = "")
                    Text(text="Deposit")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row() {
            Text(text = "All Transactions")
            Box(){
                Text(text = selected)
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    DropdownMenuItem(text = { Text("Today") }, onClick = { selected = "Today"; expanded = false })
                    DropdownMenuItem(text = { Text("Yesterday") }, onClick = { selected = "Yesterday"; expanded = false })

                }
            }
        }


    }
}

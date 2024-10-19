package com.vnteam.mainsubmoduleproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vnteam.mainsubmoduleproject.ui.theme.MainSubmoduleProjectTheme
import com.vnteam.submoduleproject.ui.SubModuleClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val subModuleClass = SubModuleClass()
        val  subModuleText = subModuleClass.textFromSubModule()
        Log.e("MainActivity", "Text from SubModuleClass subModuleText: $subModuleText")
        val coreModuleText = subModuleClass.coreModuleTextFromSubModule()
        Log.e("MainActivity", "Text from SubModuleClass coreModuleText: $coreModuleText")
        enableEdgeToEdge()
        setContent {
            MainSubmoduleProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainSubmoduleProjectTheme {
        Greeting("Android")
    }
}
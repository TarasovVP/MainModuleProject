package com.vnteam.mainmoduleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vnteam.mainmoduleproject.ui.theme.MainSubmoduleProjectTheme
import com.vnteam.submoduleproject.ui.SubModuleClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainModuleClass = MainModuleClass()
        val subModuleClass = SubModuleClass()
        enableEdgeToEdge()
        setContent {
            MainSubmoduleProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        mainModuleText = mainModuleClass.textFromMainModule(),
                        subModuleText = subModuleClass.textFromSubModule(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    mainModuleText: String,
    subModuleText: String,
    modifier: Modifier = Modifier
) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier.fillMaxSize()) {
        Text(
            text = mainModuleText,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().height(100.dp)
        )

        Text(
            text = subModuleText,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().height(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainSubmoduleProjectTheme {
        Greeting("Text from main module", "Text from submodule", Modifier)
    }
}
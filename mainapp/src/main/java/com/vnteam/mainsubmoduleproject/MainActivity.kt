package com.vnteam.mainsubmoduleproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vnteam.core.MainInnerModuleClass
import com.vnteam.mainsubmoduleproject.ui.theme.MainSubmoduleProjectTheme
import com.vnteam.submoduleproject.ui.SubModuleClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainModuleClass = MainModuleClass()
        val mainModuleText = mainModuleClass.textFromMainModule()
        val mainInnerModuleClass = MainInnerModuleClass()
        val mainInnerModuleText = mainInnerModuleClass.textFromMainInnerModule()
        val mainCoreModuleText = mainModuleClass.coreModuleTextFromMainModule()
        val subModuleClass = SubModuleClass()
        val subModuleText = subModuleClass.textFromSubModule()
        val subCoreModuleText = subModuleClass.coreModuleTextFromSubModule()
        enableEdgeToEdge()
        setContent {
            MainSubmoduleProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        mainModuleText = "Text from MainModule $mainModuleText",
                        mainInnerModuleText = "Text from MainInnerModule $mainInnerModuleText",
                        mainCoreModuleText = "Core text from MainModule $mainCoreModuleText",
                        subModuleText = "Text from SubModule $subModuleText",
                        subCoreModuleText = "Core text from SubModule $subCoreModuleText",
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
    mainInnerModuleText: String,
    mainCoreModuleText: String,
    subModuleText: String,
    subCoreModuleText: String,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = mainModuleText,
            modifier = modifier
        )

        Text(
            text = mainInnerModuleText,
            modifier = modifier
        )

        Text(
            text = mainCoreModuleText,
            modifier = modifier
        )

        Text(
            text = subModuleText,
            modifier = modifier
        )

        Text(
            text = subCoreModuleText,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainSubmoduleProjectTheme {
        Greeting("Android", "sdsd","sdsd", "dssds", "sasds")
    }
}
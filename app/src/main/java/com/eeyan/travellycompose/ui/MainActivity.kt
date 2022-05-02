package com.eeyan.travellycompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eeyan.travellycompose.R
import com.eeyan.travellycompose.ui.components.BottomBar
import com.eeyan.travellycompose.ui.home.HomePage
import com.eeyan.travellycompose.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(), bottomBar = {
                            BottomBar(modifier = Modifier.fillMaxWidth())
                    }) {

                    val navController = rememberNavController()

                    NavHost(navController = navController,
                        startDestination = AppPage.HomePage.route){

                        composable(route = AppPage.HomePage.route){
                            HomePage(navController = navController)
                        }


                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = dimensionResource(id = R.dimen.global_margin)),
            bottomBar = {
                BottomBar(modifier = Modifier.fillMaxWidth())
            }) {

            HomePage(navController = rememberNavController())
            
        }
        
    }
}
package com.eeyan.travellycompose.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.eeyan.travellycompose.R

@Composable
@ExperimentalMaterial3Api
fun HomePage(
    //navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    // load state from view model
    val state = homeViewModel.state.value

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)) {

        Column(modifier = Modifier.fillMaxSize()) {

                Row(modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp)) {

                    Text(text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.align(Alignment.Bottom))

                }

        }

    }

    
}
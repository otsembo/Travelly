package com.eeyan.travellycompose.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.eeyan.travellycompose.R

@Composable
@ExperimentalMaterial3Api
fun HomePage(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    // load state from view model
    val state = homeViewModel.state.value

        Column(modifier = Modifier.fillMaxSize()) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dimensionResource(id = R.dimen.global_margin),
                        end = dimensionResource(id = R.dimen.global_margin)),

                    horizontalArrangement = Arrangement.SpaceBetween) {

                    Text(text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.align(Alignment.CenterVertically))

                    AppImage(modifier = Modifier
                        .align(Alignment.CenterVertically), url = homeViewModel.profileURL)
                    
                }
        }
}


@Composable
fun AppImage(modifier: Modifier, url:String) {
    
    AsyncImage(
        modifier = modifier
            .width(dimensionResource(id = R.dimen.logo_size))
            .height(dimensionResource(id = R.dimen.logo_size))
            .clip(CircleShape),
        model = url,
        contentDescription = stringResource(id = R.string.avatar_image))
    
}
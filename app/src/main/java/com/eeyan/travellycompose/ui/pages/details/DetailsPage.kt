package com.eeyan.travellycompose.ui.pages.details

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.eeyan.travellycompose.R

@Composable
fun DetailsPage(
    navController: NavController,
    viewModel:DetailsVM = hiltViewModel()
) {

    val sightInfo = viewModel.sightState.value

    Box(modifier = Modifier.fillMaxSize()) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.details_image)),
            model = sightInfo.mainImage,
            contentDescription = null,
            contentScale = ContentScale.Crop)

    }

}
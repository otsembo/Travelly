package com.eeyan.travellycompose.ui.pages.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.eeyan.travellycompose.R
import com.eeyan.travellycompose.ui.components.CircledNavigator
import com.eeyan.travellycompose.ui.components.SightImage
import com.eeyan.travellycompose.ui.theme.md_theme_light_background
import com.eeyan.travellycompose.ui.theme.md_theme_light_secondary

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

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(
                dimensionResource(id = R.dimen.global_margin)
            )) {

            Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.global_margin))) {

                CircledNavigator( icon = R.drawable.ic_left)
                CircledNavigator( icon = R.drawable.ic_not_fav)

            }

            SightImage(modifier = Modifier.align(Alignment.End), image = sightInfo.thumbThree, isTop = true, )
            SightImage(modifier = Modifier.align(Alignment.End), image = sightInfo.thumbTwo, isTop = false, )
            SightImage(modifier = Modifier.align(Alignment.End), image = sightInfo.thumbOne, isTop = false, )

        }

    }

}
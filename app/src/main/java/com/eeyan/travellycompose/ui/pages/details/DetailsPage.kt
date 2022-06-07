package com.eeyan.travellycompose.ui.pages.details

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.eeyan.travellycompose.R
import com.eeyan.travellycompose.ui.components.CircledNavigator
import com.eeyan.travellycompose.ui.components.ReviewSection
import com.eeyan.travellycompose.ui.components.SightImage
import com.eeyan.travellycompose.ui.theme.md_theme_dark_primary
import com.eeyan.travellycompose.ui.theme.md_theme_light_background
import com.eeyan.travellycompose.ui.theme.md_theme_light_onPrimary
import com.eeyan.travellycompose.ui.theme.md_theme_light_secondary

@Composable
@OptIn(ExperimentalMaterial3Api::class)
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
            .fillMaxSize()) {

            Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = dimensionResource(id = R.dimen.global_margin),
                        start = dimensionResource(id = R.dimen.global_margin),
                        end = dimensionResource(id = R.dimen.global_margin)
                    )) {

                CircledNavigator( icon = R.drawable.ic_left, onClick = {navController.navigateUp()})
                CircledNavigator( icon = R.drawable.ic_not_fav, onClick = {})

            }

            SightImage(modifier = Modifier.align(Alignment.End), image = sightInfo.thumbThree, isTop = true, )
            SightImage(modifier = Modifier.align(Alignment.End), image = sightInfo.thumbTwo, isTop = false, )
            SightImage(modifier = Modifier.align(Alignment.End), image = sightInfo.thumbOne, isTop = false, )

            Card(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = dimensionResource(id = R.dimen.global_margin))
                .clip(
                    RoundedCornerShape(
                        topStart = dimensionResource(id = R.dimen.detail_card_corner),
                        topEnd = dimensionResource(id = R.dimen.detail_card_corner)
                    )
                )) {


                Column(modifier = Modifier
                    .padding(
                        top = dimensionResource(id = R.dimen.global_margin), 
                        end = dimensionResource(id = R.dimen.global_margin),
                        start = dimensionResource(id = R.dimen.global_margin))) {
                    
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        
                        Text(text = sightInfo.name, style = MaterialTheme.typography.headlineLarge)
                        Text(text = stringResource(id = R.string.travel_price), style = MaterialTheme.typography.bodyMedium, textDecoration = TextDecoration.LineThrough)

                    }

                    Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.Bottom,
                        modifier = Modifier.padding(top = dimensionResource(id = R.dimen.global_margin))) {

                        Text(text = "Overview", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(end = dimensionResource(id = R.dimen.global_margin)))
                        Text(text = "Reviews", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.bodyLarge)

                    }

                    Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.Bottom,
                        modifier = Modifier.padding(top = dimensionResource(id = R.dimen.global_margin))) {

                        ReviewSection(icon = R.drawable.ic_clock, modifier = Modifier)
                        ReviewSection(icon = R.drawable.ic_star, modifier = Modifier, title = "RATING", desc = "3.5 out of 5")

                    }

                    Text(text = stringResource(id = R.string.prop_desc), style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = dimensionResource(id = R.dimen.global_margin)))
                    
                    Button(onClick = { /*TODO*/ }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.global_margin))) {
                        
                        Text(text = "BOOK NOW", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onPrimary)

                    }
                    
                }

            }

        }

    }

}
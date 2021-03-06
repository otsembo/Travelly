package com.eeyan.travellycompose.ui.pages.home

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import com.eeyan.travellycompose.data.model.Adventure
import com.eeyan.travellycompose.data.model.Sight
import com.eeyan.travellycompose.ui.components.*
import com.eeyan.travellycompose.ui.navigation.AppPage

@Composable
@ExperimentalMaterial3Api
fun HomePage(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    // load state from view model
    val state = homeViewModel.state.value
    val sightsState = rememberLazyListState()

        Column(modifier = Modifier.fillMaxSize()) {

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dimensionResource(id = R.dimen.global_margin),
                        end = dimensionResource(id = R.dimen.global_margin),
                        top = dimensionResource(id = R.dimen.global_margin)
                    ),

                    horizontalArrangement = Arrangement.SpaceBetween) {

                    Text(text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.align(Alignment.CenterVertically))

                    AppImage(modifier = Modifier
                        .align(Alignment.CenterVertically), url = homeViewModel.profileURL)
                    
                }


                CustomTabs(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.global_margin),
                    top = dimensionResource(id = R.dimen.global_margin)), list = homeViewModel.titles)


                LazyRow(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.global_margin),
                    end = dimensionResource(id = R.dimen.global_margin), top = dimensionResource(id = R.dimen.global_margin)), state = sightsState){

                     items(homeViewModel.sights){

                         item: Sight -> SightCard(modifier = Modifier, sight = item, itemClick = {navController.navigate(AppPage.DetailsPage.route)})

                     }

                }


                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dimensionResource(id = R.dimen.global_margin),
                        end = dimensionResource(id = R.dimen.global_margin),
                        top = dimensionResource(id = R.dimen.global_margin)
                    ), horizontalArrangement = Arrangement.SpaceBetween){


                    Text(text = stringResource(id = R.string.adventurous), style = MaterialTheme.typography.bodyLarge)

                    Text(text = stringResource(id = R.string.all), style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary)


                }


                LazyRow(modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dimensionResource(
                            id = R.dimen.global_margin
                        ),
                        end = dimensionResource(
                            id = R.dimen.global_margin
                        ),
                        top = dimensionResource(id = R.dimen.global_margin)
                    )
                    .animateContentSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.global_margin))){
                    items(homeViewModel.adventureList){
                        item: Adventure -> AdventureMenu(modifier = Modifier, adventure = item)
                    }
                }

        }
}



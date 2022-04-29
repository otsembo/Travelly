package com.eeyan.travellycompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.compose.AsyncImage
import com.eeyan.travellycompose.R
import com.eeyan.travellycompose.data.model.Sight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SightCard(modifier: Modifier, sight: Sight) {

    ElevatedCard(modifier = modifier
        .fillMaxWidth()
        .height(height = dimensionResource(id = R.dimen.card_size))
        .padding(end = dimensionResource(id = R.dimen.global_margin))
        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.card_corner))),
        onClick = {}) {

        Box(modifier = Modifier.fillMaxSize()){

            AsyncImage(model = sight.imageUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,)

        }

    }

}
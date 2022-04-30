package com.eeyan.travellycompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.eeyan.travellycompose.R
import com.eeyan.travellycompose.data.model.Adventure

@Composable
fun AppImage(modifier: Modifier, url:String) {

    AsyncImage(
        modifier = modifier
            .width(dimensionResource(id = R.dimen.logo_size))
            .height(dimensionResource(id = R.dimen.logo_size))
            .clip(CircleShape),
        model = url,
        contentDescription = stringResource(id = R.string.avatar_image)
    )

}

@Composable
fun AdventureMenu(modifier: Modifier, adventure: Adventure) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model = adventure.icon,
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.adventure_icon)),
            )

        Text(
            text = adventure.title,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.like_btn_margin))
        )

    }

}
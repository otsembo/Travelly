package com.eeyan.travellycompose.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.eeyan.travellycompose.R

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
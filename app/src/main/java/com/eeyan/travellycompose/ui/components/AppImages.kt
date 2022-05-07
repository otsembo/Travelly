package com.eeyan.travellycompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.eeyan.travellycompose.R
import com.eeyan.travellycompose.data.model.Adventure
import com.eeyan.travellycompose.ui.theme.md_theme_light_secondary

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


@Composable
fun BottomBar(modifier: Modifier) {

    Row(modifier = modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.primaryContainer)
        .height(dimensionResource(id = R.dimen.bottom_bar_size)), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically,
    ) {

        IconButton(onClick = {  }) {
            Icon(Icons.Filled.Home, contentDescription = null)
        }

        IconButton(onClick = {  }) {
            Icon(Icons.Filled.Search, contentDescription = null)
        }

        IconButton(onClick = {  }) {
            Icon(Icons.Filled.Add, contentDescription = null)
        }

        IconButton(onClick = {  }) {
            Icon(Icons.Filled.Settings, contentDescription = null)
        }

        IconButton(onClick = {  }) {
            Icon(Icons.Filled.AccountCircle, contentDescription = null)
        }

    }
    
}


@Composable
fun CircledNavigator(icon:Int) {

    Box(
        modifier = Modifier
            .clip(
                CircleShape
            )
            .shadow(elevation = dimensionResource(id = R.dimen.card_elevation))
            .background(md_theme_light_secondary)
            .padding(
                dimensionResource(id = R.dimen.global_margin)
            ),
    ) {

        AsyncImage(model = icon, contentDescription = null, modifier = Modifier
            .align(
                Alignment.Center
            )
            .size(dimensionResource(id = R.dimen.like_btn_image_size)),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary))

    }

}


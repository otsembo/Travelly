package com.eeyan.travellycompose.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
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
        .background(MaterialTheme.colorScheme.inversePrimary)
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
@OptIn(ExperimentalMaterial3Api::class)
fun CircledNavigator(icon:Int, onClick: () -> Unit) {

    Surface(onClick = onClick, modifier = Modifier.clip(CircleShape)
        .shadow(elevation = dimensionResource(id = R.dimen.card_elevation))
        .background(MaterialTheme.colorScheme.surfaceVariant)
        .padding(
            dimensionResource(id = R.dimen.pop_icon_margin)
        )) {

            AsyncImage(model = icon, contentDescription = null, modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .size(dimensionResource(id = R.dimen.like_btn_image_size)),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary))

    }

}


@Composable
fun SightImage(modifier: Modifier, image:String, isTop:Boolean) {
    
    AsyncImage(model = image, contentDescription = null,
        modifier = modifier
            .padding(
                top = when (isTop) {
                    true -> dimensionResource(id = R.dimen.sight_image_top_margin)
                    else -> dimensionResource(id = R.dimen.sight_image_margin)
                }, end = dimensionResource(id = R.dimen.global_margin)
            )
            .border(
                width = dimensionResource(id = com.google.android.material.R.dimen.m3_badge_radius),
                color = MaterialTheme.colorScheme.surfaceVariant
            )
            .clip(RoundedCornerShape(dimensionResource(id = com.google.android.material.R.dimen.m3_badge_radius)))
            .size(dimensionResource(id = R.dimen.sight_image_size))
            , contentScale = ContentScale.Crop)
    
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewSection(@DrawableRes icon:Int, title:String = "DURATION", desc:String = "3 hours", modifier: Modifier) {
    Card(modifier = modifier
        .padding(PaddingValues(end = dimensionResource(id = R.dimen.global_margin)))
        .clip(RoundedCornerShape(5.dp))) {

        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = rememberAsyncImagePainter(model = icon), tint = MaterialTheme.colorScheme.primary ,contentDescription = null, modifier = Modifier.padding(end = 5.dp))
            Column {
                Text(text = title, style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(bottom = .05.dp))
                Text(text = desc, style = MaterialTheme.typography.bodyMedium)
            }

        }
    }
}

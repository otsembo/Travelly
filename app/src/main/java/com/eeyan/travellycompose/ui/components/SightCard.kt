package com.eeyan.travellycompose.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.eeyan.travellycompose.R
import com.eeyan.travellycompose.data.model.Sight
import com.eeyan.travellycompose.ui.theme.md_theme_image_overlay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SightCard(modifier: Modifier, sight: Sight, itemClick: () -> Unit) {

    ElevatedCard(modifier = modifier
        .width(width = dimensionResource(id = R.dimen.card_size_width))
        .height(height = dimensionResource(id = R.dimen.card_size))
        .padding(end = dimensionResource(id = R.dimen.global_margin))
        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.card_corner))),
        onClick = itemClick) {

        Box(modifier = Modifier.fillMaxSize()){

            AsyncImage(model = sight.imageUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,)

            Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
                drawRect(
                    color = md_theme_image_overlay
                )
            })

            Text(text = sight.title, 
                style = MaterialTheme.typography.bodyLarge, 
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(
                        start = dimensionResource(id = R.dimen.global_margin),
                        bottom = dimensionResource(id = R.dimen.global_margin)
                    ))

            LikeBtn(modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(
                    top = dimensionResource(id = R.dimen.global_margin),
                    end = dimensionResource(id = R.dimen.global_margin)
                ), isLiked = sight.isLiked)

        }

    }

}


@Composable
fun LikeBtn(modifier: Modifier, isLiked:Boolean) {

    var myLikes by remember { mutableStateOf(isLiked) }

    Box(modifier = modifier
        .size(dimensionResource(id = R.dimen.like_btn_size))
        .clip(CircleShape)
        .clickable(enabled = true, onClick = {myLikes =! myLikes}),){

        Image(painter = if(myLikes)
            painterResource(id = R.drawable.ic_fav)
            else painterResource(id = R.drawable.ic_not_fav),
            contentDescription = null, colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.like_btn_image_size))
                .align(Alignment.Center)
                .padding(dimensionResource(id = R.dimen.like_btn_margin)))

    }

}
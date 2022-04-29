package com.eeyan.travellycompose.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.eeyan.travellycompose.R
import com.eeyan.travellycompose.ui.theme.md_theme_dark_primary

@Composable
fun TabText(modifier: Modifier, isActive:Boolean = false, title:String) {

    Column(modifier = modifier
        .padding(end = dimensionResource(id = R.dimen.tab_text_pad)), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = title, style = MaterialTheme.typography.headlineSmall, color = if (isActive) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground)

        if(isActive){

            Canvas(modifier = Modifier
                .size(dimensionResource(id = R.dimen.tab_indicator))
                .padding(
                    top = dimensionResource(
                        id = R.dimen.text_icon_margin
                    )
                ), onDraw = {
                drawCircle(
                    color = md_theme_dark_primary,
                    radius = (15.dp.toPx()) / 2f
                )
            })

        }

    }

}


@Composable
fun CustomTabs(modifier: Modifier, list: List<String>) {

    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {

        TabText(modifier = modifier, title = list[0], isActive = true)
        TabText(modifier = modifier, title = list[1])
        TabText(modifier = modifier, title = list[2])

    }

}
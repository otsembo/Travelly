package com.eeyan.travellycompose.ui.pages.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.eeyan.travellycompose.domain.SightInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsVM
    @Inject constructor(): ViewModel() {

    private val _sightState = mutableStateOf(setUpInfo())
    val sightState : State<SightInfo>
        get() = _sightState


    private fun setUpInfo() : SightInfo{
        return SightInfo(
            mainImage = "https://images.unsplash.com/photo-1591129250837-b40afb3609e1?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
            thumbOne = "https://images.unsplash.com/photo-1646159755791-54e741749028?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTl8fG1vdW50JTIwa2VueWF8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
            thumbTwo = "https://images.unsplash.com/photo-1519659528534-7fd733a832a0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1026&q=80",
            thumbThree = "https://images.unsplash.com/photo-1519659528534-7fd733a832a0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1026&q=80",
            imgCount = 13,
            name = "Waduk Wonerejo",
            price = 95.0,
            time = 3,
            rating = 3.5,
            details = "On the floor of the Great Rift Valley, surrounded by wooded and bushy grassland, lies the beautiful Lake Nakuru National Park. Visitors can enjoy the wide ecological diversity and varied habitats that range from Lake Nakuru itself to the surrounding escarpment and picturesque ridges. Lake Nakuru National Park is ideal for bird watching, hiking,picnic and game drives."
        )
    }

}
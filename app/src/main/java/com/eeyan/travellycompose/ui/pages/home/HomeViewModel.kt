package com.eeyan.travellycompose.ui.pages.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.eeyan.travellycompose.common.Constants
import com.eeyan.travellycompose.data.model.Adventure
import com.eeyan.travellycompose.data.model.Sight
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject constructor(): ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state : State<HomeState>
        get() = _state

    val profileURL = Constants.PROFILE
    val titles = Constants.TAB_TITLES
    val sights = setSights()
    val adventureList = createAdventures()


    private fun setSights() : List<Sight>{
        val sightList = ArrayList<Sight>()

        sightList.add(
            Sight(title = "Masaai Mara", isLiked = false,
                imageUrl = "https://images.unsplash.com/photo-1519659528534-7fd733a832a0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1026&q=80")
        )

        sightList.add(
            Sight(title = "Mount Kenya", isLiked = true,
                imageUrl = "https://images.unsplash.com/photo-1646159755791-54e741749028?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTl8fG1vdW50JTIwa2VueWF8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60")
        )

        sightList.add(
            Sight(title = "Lake Nakuru national park", isLiked = true,
                imageUrl = "https://images.unsplash.com/photo-1591129250837-b40afb3609e1?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80")
        )

        return sightList
    }

    private fun createAdventures() : List<Adventure>{
        val adventures = ArrayList<Adventure>()

        adventures.add(
            Adventure(
            icon = "https://img.icons8.com/dusk/344/hammer-throw.png",
            title = "Athletics")
        )
        adventures.add(
            Adventure(
                icon = "https://img.icons8.com/dusk/344/cycling-road.png",
                title = "Cycling"
            ))
        adventures.add(
            Adventure(
                icon = "https://img.icons8.com/dusk/344/bowling.png",
                title = "Bowling"
            ))
        adventures.add(
            Adventure(
                icon = "https://img.icons8.com/dusk/344/tennis.png",
                title = "Tennis"
            ))

        return adventures
    }

}
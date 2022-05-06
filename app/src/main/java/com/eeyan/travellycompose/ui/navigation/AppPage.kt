package com.eeyan.travellycompose.ui.navigation

sealed class AppPage(val route:String){
    object HomePage : AppPage("home_page")
    object DetailsPage : AppPage("details_page")
}

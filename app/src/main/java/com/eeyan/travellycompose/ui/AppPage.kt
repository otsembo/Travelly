package com.eeyan.travellycompose.ui

sealed class AppPage(val route:String){
    object HomePage : AppPage("home_page")
}

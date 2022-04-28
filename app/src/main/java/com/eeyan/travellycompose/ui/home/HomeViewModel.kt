package com.eeyan.travellycompose.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.eeyan.travellycompose.common.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject constructor(): ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state : State<HomeState>
        get() = _state

    val profileURL = Constants.PROFILE

}
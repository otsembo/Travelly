package com.eeyan.travellycompose.domain

data class SightInfo(
    val mainImage:String,
    val thumbOne:String,
    val thumbTwo:String,
    val thumbThree:String,
    val imgCount:Int,
    val name:String,
    val price:Double,
    val time:Int,
    val rating:Double,
    val details:String,
)

package com.example.mvvmretro.mvvm.data

data class City(val placeName: String, val placeAddress: String) {
    override fun toString(): String {
        return "$placeName - $placeAddress"
    }
}
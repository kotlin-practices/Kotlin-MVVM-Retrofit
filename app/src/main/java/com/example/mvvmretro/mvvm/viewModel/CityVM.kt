package com.example.mvvmretro.mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretro.mvvm.data.City

class CityVM : ViewModel() {
    private var citiesList = mutableListOf<City>()
    private var cities = MutableLiveData<List<City>>()

    /*
    * In Kotlin, mutableListOf() method is used to instantiate
    * MutableList Interface. ... The method mutableListOf()
    * returns an instance of MutableList Interface and takes the
    * array of a particular type or mixed (depends on the type
    * of MutableList instance) elements or it can be null also.*/
    init {
        cities.value = citiesList
    }

    fun addCity(city: City) {
        citiesList.add(city)
        cities.value = citiesList
    }

    fun getCities() = cities as LiveData<List<City>>

    /*fun getCities(): LiveData<List<City>> {
        return cities
    }*/
}
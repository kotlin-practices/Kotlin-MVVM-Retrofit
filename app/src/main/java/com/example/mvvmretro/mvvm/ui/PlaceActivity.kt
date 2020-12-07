package com.example.mvvmretro.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretro.R
import com.example.mvvmretro.mvvm.data.City
import com.example.mvvmretro.mvvm.viewModel.CityVM

class PlaceActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var placeName: EditText
    private lateinit var address: EditText
    private lateinit var recyclerView: RecyclerView

    //private val example: ExampleVM = ExampleVM()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place)
        uiInitialize()

        val viewModel: CityVM = ViewModelProvider(this).get(CityVM::class.java)

        viewModel.getCities().observe(this, {
            run {
                Toast.makeText(this, "Added", Toast.LENGTH_LONG).show()
            }
        })

        button.setOnClickListener {
            val city = City("Kathmandu", "Nepal")
            viewModel.addCity(city)
        }
        /*example.addExample("name")
        example.examples*/
    }

    private fun uiInitialize() {
        recyclerView = findViewById(R.id.recyclerPlaces)
        button = findViewById(R.id.buttonAddPlace)
        placeName = findViewById(R.id.editTextPlaceName)
        address = findViewById(R.id.editTextPlaceAddress)
    }
}
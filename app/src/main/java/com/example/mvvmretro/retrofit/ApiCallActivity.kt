package com.example.mvvmretro.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mvvmretro.R
import com.example.mvvmretro.mvvm.data.City
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiCallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_call)
        val retrofitInstance = RetrofitInstance()
        val apiProvider = retrofitInstance.getRetroInstance().create(ApiProvider::class.java)
        val call: Call<List<ResponseModel>> = apiProvider.getPosts()
        call.enqueue(object : Callback<List<ResponseModel>> {
            override fun onResponse(
                call: Call<List<ResponseModel>>,
                response: Response<List<ResponseModel>>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(this@ApiCallActivity, "Successful", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<ResponseModel>>, t: Throwable) {
                Toast.makeText(this@ApiCallActivity, "Failed" + t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}
package com.example.lojaretrofit.service

import com.example.lojaretrofit.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("/android/rest/produto")
    fun list(): Call<List<Product>>

}
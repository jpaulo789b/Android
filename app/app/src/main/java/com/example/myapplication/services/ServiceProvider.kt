package com.example.myapplication.services


import com.example.myapplication.util.CustomDateSerializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.io.IOException
import java.util.Date

class ServiceProvider {


    fun criarRetrofit(configURL: ConfigURL): Retrofit {

        val url = ConfigURL.valueOf(configURL.name).url

        val gson = GsonBuilder().registerTypeAdapter(Date::class.java, CustomDateSerializer()).create()
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor { chain ->
                val originalRequest = chain.request()
                val urlBuilder = originalRequest.url().newBuilder()

                val request = originalRequest.newBuilder()
                    .url(urlBuilder.build())
                    .build()
                chain.proceed(request)
            }.build())
            .build()

        return retrofit
    }

    fun <T> createService(configURL: ConfigURL, serviceClass: Class<T>): T {
        var retrofit: Retrofit = criarRetrofit(configURL)
        return retrofit.create(serviceClass)
    }

}
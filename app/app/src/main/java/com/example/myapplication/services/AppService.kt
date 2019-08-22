package com.example.myapplication.services

import com.example.myapplication.entidades.Cliente
import com.example.myapplication.entidades.Pedido
import retrofit2.Call
import retrofit2.http.GET

interface AppService {

    @get:GET(".")
    val dadosCliente: Call<Cliente>

    @get:GET(".")
    val listaPedidos: Call<List<Pedido>>
}

package com.example.myapplication.services

import com.example.myapplication.entidades.Cliente
import com.example.myapplication.entidades.Pedido
import com.example.myapplication.retornos.RetornoCliente
import retrofit2.Call
import retrofit2.http.GET

interface AppService {

    @get:GET(".")
    val dadosCliente: Call<RetornoCliente>

    @get:GET(".")
    val listaPedidos: Call<List<Pedido>>
}

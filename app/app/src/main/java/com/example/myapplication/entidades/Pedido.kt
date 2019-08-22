package com.example.myapplication.entidades

data class Pedido (
    val numeroPedRca: Long,
    val numeroPedERP: String,
    val codigoCliente: String,
    val nomecliente: String,
    val data: String,
    val status: String,
    val critica: String? = null,
    val tipo: Tipo,
    val legendas: List<String>? = null
)


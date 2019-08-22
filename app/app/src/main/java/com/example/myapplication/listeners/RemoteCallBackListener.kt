package com.example.myapplication.listeners

interface RemoteCallBackListener<T> {
    fun recebeuDadosComSucesso(response: T)
    fun recebeuErroVindoDoServidor(erro: String)
    fun recebeuErroDeComunicacao(erro: String)
}

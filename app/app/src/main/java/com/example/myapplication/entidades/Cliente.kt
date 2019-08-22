package com.example.myapplication.entidades


data class Cliente (
    val id: Long,
    val codigo: String,
    val razaoSocial: String,
    val nomeFantasia: String,
    val cnpj: String,
    val ramoAtividade: String,
    val endereco: String,
    val status: String,
    val contatos: List<Contato>
)

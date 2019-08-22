package com.example.myapplication.entidades


data class Cliente (
    val id: Long,
    val codigo: String,
    val razao_social: String,
    val nomeFantasia: String,
    val cnpj: String,
    val ramo_atividade: String,
    val endereco: String,
    val status: String,
    val contatos: List<Contato>
)

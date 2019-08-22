package com.example.myapplication.model

import com.example.myapplication.R

enum class MainMenuEnumItens private constructor( internal var tituloRes: Int,internal var iconRes: Int) {

    CLIENTES(R.string.main_menu_clientes, R.drawable.ic_maxima_pessoas),
    PEDIDOS(R.string.main_menu_pedidos, R.drawable.ic_maxima_pedido),
    RESUMOVENDAS(R.string.main_menu_resumo_vendas, R.drawable.ic_maxima_resumo_vendas),
    FERRAMENTAS(R.string.main_menu_ferramentas, R.drawable.ic_maxima_ferramentas)
}

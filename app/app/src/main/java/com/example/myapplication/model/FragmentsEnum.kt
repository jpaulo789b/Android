package com.example.myapplication.model

import com.example.myapplication.R
import com.example.myapplication.fragments.AlvarasFragment
import com.example.myapplication.fragments.DadosDoClienteFragment
import com.example.myapplication.fragments.HistoricoPedidosFragment

enum class FragmentsEnum private constructor(val fragment: Class<*>,  val nomeFragment: Int) {
    DADOS(DadosDoClienteFragment::class.java, R.string.fragment_titulo_dados),
    HISTORICO(HistoricoPedidosFragment::class.java, R.string.fragment_titulo_historico),
    ALVARA(AlvarasFragment::class.java, R.string.fragment_titulo_alvara);


}

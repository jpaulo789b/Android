package com.example.myapplication.listeners

import com.example.myapplication.model.MainMenuEnumItens

interface MainMenuClickListener {
    fun onClickItemMenu(item: MainMenuEnumItens, position: Int)
}

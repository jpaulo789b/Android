package com.example.myapplication.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import com.example.myapplication.Adapter.AdapterMainMenu
import com.example.myapplication.listeners.MainMenuClickListener
import com.example.myapplication.model.MainMenuEnumItens
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.util.MenuItemDecoration
import java.util.ArrayList


class MainActivity : AppCompatActivity(), MainMenuClickListener {

    override fun onClickItemMenu(item: MainMenuEnumItens, position: Int) {
        when(item){
            MainMenuEnumItens.CLIENTES -> abrirActivity(ClienteInfoActivity())
            MainMenuEnumItens.FERRAMENTAS -> abrirActivity(ClienteInfoActivity())
            MainMenuEnumItens.RESUMOVENDAS -> abrirActivity(ClienteInfoActivity())
            MainMenuEnumItens.PEDIDOS -> abrirActivity(ClienteInfoActivity())
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager = GridLayoutManager(this, 2)
        rvListaMenu.layoutManager = layoutManager;
        rvListaMenu.setHasFixedSize(true)
        rvListaMenu.adapter = AdapterMainMenu(this);
        val dividerItemDecoration = MenuItemDecoration()
        rvListaMenu.addItemDecoration(dividerItemDecoration)

    }

    fun abrirActivity(actitivy:AppCompatActivity){
        val intent = Intent(this, actitivy::class.java)
        startActivity(intent)
    }
}

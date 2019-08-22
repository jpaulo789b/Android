package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.listeners.MainMenuClickListener
import com.example.myapplication.model.MainMenuEnumItens
import kotlinx.android.synthetic.main.main_menu_button.view.*
import com.example.myapplication.util.OnClickListenerImpedirDuplicados



class AdapterMainMenu(var onLisnener: MainMenuClickListener) : RecyclerView.Adapter<AdapterMainMenu.HolderItem>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderItem {
        return HolderItem(LayoutInflater.from(parent.context).inflate(R.layout.main_menu_button, parent, false))
    }

    override fun onBindViewHolder(holder: HolderItem, position: Int) {
        holder.montarDados(MainMenuEnumItens.values()[position],position);
    }

    override fun getItemCount(): Int {
        return MainMenuEnumItens.values().size
    }

    inner class HolderItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun montarDados(item: MainMenuEnumItens, posi: Int) {
            itemView.ivIcone.setImageDrawable(itemView.resources.getDrawable(item.iconRes))
            itemView.tvNome.setText(item.tituloRes)
            itemView.setOnClickListener(object : OnClickListenerImpedirDuplicados() {
                override fun onClickImplementacao(v: View) {
                    onLisnener.onClickItemMenu(item,posi)
                }
            })
        }
    }
}

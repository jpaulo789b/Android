package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.entidades.Contato
import kotlinx.android.synthetic.main.celula_item_contato.view.*


class AdapterContatosCliente(var contatos: List<Contato>) : RecyclerView.Adapter<AdapterContatosCliente.HolderItem>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderItem {
        return HolderItem(LayoutInflater.from(parent.context).inflate(R.layout.celula_item_contato, parent, false))
    }

    override fun onBindViewHolder(holder: HolderItem, position: Int) {
        holder.montarDados(contatos[position],position);
    }

    override fun getItemCount(): Int {
        return contatos.size;
    }

    inner class HolderItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun montarDados(item: Contato, posi: Int) {
            itemView.tvTelefoneFixo.text = item.telefone
            itemView.tvTelefoneCelular.text = item.celular
            itemView.tvConjuge.text = item.conjuge
            itemView.tvTipo.text = item.tipo
            itemView.tvHobbie.text = "-"
            itemView.tvEmail.text = item.e_mail
            itemView.tvDataNas.text = item.data_nascimento
            itemView.tvDataNasConjuce.text = item.dataNascimentoConjuge
            itemView.tvTime.text = item.time
        }
    }
}

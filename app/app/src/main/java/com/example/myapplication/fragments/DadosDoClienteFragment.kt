package com.example.myapplication.fragments

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.myapplication.Adapter.AdapterContatosCliente
import com.example.myapplication.R
import com.example.myapplication.entidades.Cliente
import com.example.myapplication.listeners.RemoteCallBackListener
import com.example.myapplication.retornos.RetornoCliente
import com.example.myapplication.services.AppService
import com.example.myapplication.services.ConfigURL
import com.example.myapplication.services.RetornoFromService
import com.example.myapplication.services.ServiceProvider
import com.example.myapplication.util.FragmentBase
import com.example.myapplication.util.OnClickListenerImpedirDuplicados
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.dados_cliente_fragment.*
import java.text.SimpleDateFormat
import java.util.*
import android.R.attr.gravity
import android.widget.FrameLayout




class DadosDoClienteFragment : FragmentBase() {
    var mServiceProvider: ServiceProvider = ServiceProvider()
    lateinit var cliente :Cliente;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadInfoDoCliente();
        return inflater.inflate(R.layout.dados_cliente_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnVerificarStatus.setOnClickListener(object : OnClickListenerImpedirDuplicados() {
            override fun onClickImplementacao(v: View) {
                //
                val fmt = SimpleDateFormat("dd/MM/yyyy")
                val snackbar = Snackbar.make(view, String.format("%s - Status %s",fmt.format(Calendar.getInstance().time),cliente.status), Snackbar.LENGTH_LONG)
                val view = snackbar.getView()
                val params = view.getLayoutParams() as FrameLayout.LayoutParams
                params.gravity = Gravity.TOP
                view.setLayoutParams(params)
                snackbar.show()
            }
        })
    }

    private fun loadInfoDoCliente() {
        mServiceProvider.createService(ConfigURL.DADOSCLIENTE, AppService::class.java).dadosCliente.enqueue(
            RetornoFromService(object :
                RemoteCallBackListener<RetornoCliente> {
                override fun recebeuDadosComSucesso(response: RetornoCliente) {
                    cliente =response.cliente;
                    clDados.visibility = VISIBLE
                    progressBar.visibility = GONE
                    montarDados(response.cliente)
                }

                override fun recebeuErroVindoDoServidor(erro: String) {

                }

                override fun recebeuErroDeComunicacao(erro: String) {

                }
            })
        );

    }

    private fun montarDados(dados: Cliente) {
        tvRazaoSocial.text = dados.razao_social;
        tvNomeFantasia.text = dados.nomeFantasia;
        tvCPF.text ="-";
        tvCNPJ.text = dados.cnpj;
        tvRamoAtividade.text = dados.ramo_atividade;
        tvEndereco.text = dados.endereco;

        rvListaContatos.adapter = AdapterContatosCliente(dados.contatos);

    }
}

package com.example.myapplication.Activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.entidades.Cliente
import com.example.myapplication.listeners.RemoteCallBackListener
import com.example.myapplication.model.FragmentsEnum
import com.example.myapplication.services.AppService
import com.example.myapplication.services.ConfigURL
import com.example.myapplication.services.RetornoFromService
import com.example.myapplication.services.ServiceProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_cliente_info.*


class ClienteInfoActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemReselectedListener  {

    private var transaction = supportFragmentManager.beginTransaction()
    private var mFabricaDeFragmentos = LinkedHashMap<String, Fragment>();
    var mServiceProvider: ServiceProvider = ServiceProvider();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente_info)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.fragment_titulo_dados)
        navigationView.setOnNavigationItemSelectedListener( this )
        navigationView.setOnNavigationItemReselectedListener( this )

    }

    fun mudarParaOFragment(item: MenuItem) {
        val fragmento:FragmentsEnum = when(item.itemId){
            R.id.nav_dados -> FragmentsEnum.DADOS
            R.id.nav_histo -> FragmentsEnum.HISTORICO
            R.id.nav_alvaras -> FragmentsEnum.ALVARA
            else ->return;
        };
        if (mFabricaDeFragmentos[fragmento.name] == null) {
            mFabricaDeFragmentos[fragmento.name] = criaInstancia(fragmento.fragment.name)
        }
        transaction =  supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainFragment,  mFabricaDeFragmentos[fragmento.name]!! )
        supportActionBar?.setTitle(fragmento.nomeFragment)
        transaction.addToBackStack(fragmento.name)
        transaction.commit()

        loadInfoDoCliente();
    }

    private fun loadInfoDoCliente() {
//        mServiceProvider.createService(ConfigURL.DADOSCLIENTE,AppService.class)
        mServiceProvider.createService(ConfigURL.DADOSCLIENTE,AppService::class.java).dadosCliente.enqueue(RetornoFromService(object :
            RemoteCallBackListener<Cliente> {
            override fun recebeuDadosComSucesso(response: Cliente) {

            }

            override fun recebeuErroVindoDoServidor(erro: String) {

            }

            override fun recebeuErroDeComunicacao(erro: String) {

            }
        }));

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                if(supportFragmentManager.backStackEntryCount !=0)
                    supportFragmentManager.popBackStack();
                else{
                    val intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                }

                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun criaInstancia(className: String): Fragment {
        var fragmentCriar: Any? = null;
        try {
            fragmentCriar = Class.forName(className).newInstance()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        }

        return fragmentCriar as Fragment;
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        mudarParaOFragment(item)
        return true
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        mudarParaOFragment(item)
    }
}

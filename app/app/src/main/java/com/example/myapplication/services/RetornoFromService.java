package com.example.myapplication.services;
import java.util.Locale;


import com.example.myapplication.listeners.RemoteCallBackListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Aqui trata o retorno HTTP se tudo OK então retorna
public class RetornoFromService<T> implements Callback<T> {


    private final RemoteCallBackListener<T> listener;



    public RetornoFromService(RemoteCallBackListener<T> listener) {
        this.listener = listener;
    }


    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.isSuccessful()) {
            if (response.body() == null || response.body().toString().trim().equals("")) {
                listener.recebeuErroVindoDoServidor("Erro");
            } else {
                listener.recebeuDadosComSucesso(response.body());
            }
        } else {
            listener.recebeuErroDeComunicacao(String.format(Locale.US,"Não foi possível realizar a conexão - %d", response.code()));
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        listener.recebeuErroDeComunicacao(String.format(Locale.US,"Não foi possível realizar a conexão - %s", t.getMessage()));
    }

}

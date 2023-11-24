package com.example.exemplocomunicacaoapi.controller;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemplocomunicacaoapi.dto.CepDTO;
import com.example.exemplocomunicacaoapi.retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CepController {

    public static void getViaCep(String cep, Context context, TextView tvResponse){

        Call<CepDTO> call = new RetrofitConfig().cepService().getViaCep(cep);
        call.enqueue(new Callback<CepDTO>() {
            @Override
            public void onResponse(Call<CepDTO> call, Response<CepDTO> response) {
                CepDTO cep = response.body();
                tvResponse.setText(cep.toString());
            }

            @Override
            public void onFailure(Call<CepDTO> call, Throwable t) {
                Toast.makeText(context, "Erro: "+t.getMessage(),
                        Toast.LENGTH_LONG).show();

            }
        });

    }

}

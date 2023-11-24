package com.example.exemplocomunicacaoexterna.controller;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemplocomunicacaoexterna.dto.CepDTO;
import com.example.exemplocomunicacaoexterna.retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CepController {

    public static void getViaCep(String cep, Context context,
                                 TextView tvResponse){

        try{
            Call<CepDTO> call =
                    new RetrofitConfig().cepService().getViaCep(cep);

            call.enqueue(new Callback<CepDTO>() {
                @Override
                public void onResponse(Call<CepDTO> call,
                                       Response<CepDTO> response) {

                    CepDTO dto = response.body();
                    tvResponse.setText(dto.toString());


                }

                @Override
                public void onFailure(Call<CepDTO> call, Throwable t) {
                    Toast.makeText(context, "Erro: "+t.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            });


        }catch (Exception ex){

        }

    }

}

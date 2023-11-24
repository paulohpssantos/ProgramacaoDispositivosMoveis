package com.example.exemploretrofit.controller;

import android.content.Context;
import android.util.Log;

import com.example.exemploretrofit.dto.CepDTO;
import com.example.exemploretrofit.dto.MunicipioDto;
import com.example.exemploretrofit.retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MunicipioController {

    public static void executarAPI(String cep, Context ctx){
        try{
            Call<CepDTO> call = new RetrofitConfig()
                    .cepService().getViaCep(cep);

            call.enqueue(new Callback<CepDTO>() {
                @Override
                public void onResponse(Call<CepDTO> call,
                                       Response<CepDTO> response) {
                    CepDTO dto = response.body();
                    String teste = "teste";
                }

                @Override
                public void onFailure(Call<CepDTO> call, Throwable t) {
                    Log.e("TESTE",
                            "Erro ao comunicar com a API: "+t.getMessage());
                }
            });


        }catch (Exception ex){
            String erro = ex.getMessage();
        }
    }

}

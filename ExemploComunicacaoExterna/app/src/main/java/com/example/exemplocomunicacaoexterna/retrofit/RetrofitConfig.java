package com.example.exemplocomunicacaoexterna.retrofit;

import com.example.exemplocomunicacaoexterna.service.ICepService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private static final String BASE_URL = "https://viacep.com.br/ws/";
    private Retrofit retrofit;

    public RetrofitConfig(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public ICepService cepService(){
        return this.retrofit.create(ICepService.class);
    }
}

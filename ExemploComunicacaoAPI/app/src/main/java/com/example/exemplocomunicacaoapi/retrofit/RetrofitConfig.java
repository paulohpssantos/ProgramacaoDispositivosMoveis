package com.example.exemplocomunicacaoapi.retrofit;

import com.example.exemplocomunicacaoapi.service.ICepService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit;
    private static final String BASE_URL = "https://viacep.com.br/ws/";

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public ICepService cepService(){
        return this.retrofit.create(ICepService.class);
    }
}

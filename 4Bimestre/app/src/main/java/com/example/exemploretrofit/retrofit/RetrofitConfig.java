package com.example.exemploretrofit.retrofit;

import com.example.exemploretrofit.service.IBGEService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    //url de conexão
    private static final String BASE_URL = "https://servicodados.ibge.gov.br/api/v1/";

    OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();

    public RetrofitConfig(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public IBGEService ibgeService(){
        return this.retrofit.create(IBGEService.class);
    }
}

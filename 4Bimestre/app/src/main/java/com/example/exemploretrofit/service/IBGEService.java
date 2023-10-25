package com.example.exemploretrofit.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IBGEService {

    @GET("localidades/estados/{UF}/municipios")
    Call<T> municipiosPorUF(@Path("UF") String uf);

}

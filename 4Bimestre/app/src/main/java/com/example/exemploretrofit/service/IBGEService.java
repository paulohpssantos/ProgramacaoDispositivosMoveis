package com.example.exemploretrofit.service;

import com.example.exemploretrofit.dto.MunicipioDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IBGEService {

    @GET("localidades/estados/{UF}/municipios")
    Call<MunicipioDto> municipiosPorUF(@Path("UF") String uf);

}

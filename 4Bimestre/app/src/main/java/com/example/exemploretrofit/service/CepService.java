package com.example.exemploretrofit.service;

import com.example.exemploretrofit.dto.CepDTO;
import com.example.exemploretrofit.dto.MunicipioDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CepService {

    @GET("{cep}/json/")
    Call<CepDTO> getViaCep(@Path("cep") String cep);

}

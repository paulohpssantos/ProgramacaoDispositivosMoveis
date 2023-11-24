package com.example.exemplocomunicacaoexterna.service;

import com.example.exemplocomunicacaoexterna.dto.CepDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ICepService {

    @GET("{cep}/json/")
    Call<CepDTO>getViaCep(@Path("cep") String cep);

}

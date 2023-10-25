package com.example.exemploretrofit.dto;

import java.util.ArrayList;
import java.util.List;

public class MunicipioDto {

    private ArrayList<DadosMunicipio> dados;

    public ArrayList<DadosMunicipio> getDados() {
        return dados;
    }

    public void setDados(ArrayList<DadosMunicipio> dados) {
        this.dados = dados;
    }
}

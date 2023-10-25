package com.example.exemploretrofit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DadosMunicipio {

    private long id;
    private String nome;
    private MicroRegiao microrregiao;
    private RegiaoImediata regiaoImediata;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public MicroRegiao getMicrorregiao() {
        return microrregiao;
    }

    public void setMicrorregiao(MicroRegiao microrregiao) {
        this.microrregiao = microrregiao;
    }

    public RegiaoImediata getRegiaoImediata() {
        return regiaoImediata;
    }

    public void setRegiaoImediata(RegiaoImediata regiaoImediata) {
        this.regiaoImediata = regiaoImediata;
    }
}

package com.example.exemploretrofit.dto;

public class RegiaoImediata {

    private long id;
    private String nome;
    private RegiaoIntermediara regiaoIntermediara;

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

    public RegiaoIntermediara getRegiaoIntermediara() {
        return regiaoIntermediara;
    }

    public void setRegiaoIntermediara(RegiaoIntermediara regiaoIntermediara) {
        this.regiaoIntermediara = regiaoIntermediara;
    }
}

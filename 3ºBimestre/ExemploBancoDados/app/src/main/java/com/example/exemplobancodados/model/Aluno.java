package com.example.exemplobancodados.model;

public class Aluno {

    private int raAluno;
    private String nomeAluno;

    public Aluno() {
    }

    public Aluno(int raAluno, String nomeAluno) {
        this.raAluno = raAluno;
        this.nomeAluno = nomeAluno;
    }

    public int getRaAluno() {
        return raAluno;
    }

    public void setRaAluno(int raAluno) {
        this.raAluno = raAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
}

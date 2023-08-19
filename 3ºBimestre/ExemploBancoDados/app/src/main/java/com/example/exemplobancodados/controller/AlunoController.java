package com.example.exemplobancodados.controller;

import android.content.Context;

import com.example.exemplobancodados.dao.AlunoDao;
import com.example.exemplobancodados.model.Aluno;

import java.text.NumberFormat;
import java.util.ArrayList;

public class AlunoController {

    private Context context;

    public AlunoController(Context context) {
        this.context = context;
    }

    public long salvarAluno(String ra, String nome){
        Aluno aluno = new Aluno(Integer.parseInt(ra), nome);
        return AlunoDao.getInstancia(context).insert(aluno);
    }

    public long atualizarAluno(String ra, String nome){
        Aluno aluno = new Aluno(Integer.parseInt(ra), nome);
        return AlunoDao.getInstancia(context).update(aluno);
    }

    public long apagarAluno(String ra, String nome){
        Aluno aluno = new Aluno(Integer.parseInt(ra), nome);
        return AlunoDao.getInstancia(context).delete(aluno);
    }

    public ArrayList<Aluno> retornarTodosAlunos(){
        return AlunoDao.getInstancia(context).getAll();
    }

    public Aluno retornarAluno(int ra){
        return AlunoDao.getInstancia(context).getById(ra);
    }

    public String validaAluno(String ra, String nome){
        String mensagem = "";
        if(ra == null || ra.isEmpty()){
            mensagem += "Ra do aluno deve ser preenchido!!\n";
        }else{
            try{
                if(Integer.parseInt(ra) <= 0){
                    mensagem += "Ra do aluno deve ser maior que zero!!\n";
                }
            }catch (NumberFormatException ex){
                mensagem += "Ra do aluno deve ser número válido!!\n";
            }
        }
        if(nome == null || nome.isEmpty()){
            mensagem += "Nome do aluno deve ser preenchido!!";
        }
        return mensagem;
    }

}

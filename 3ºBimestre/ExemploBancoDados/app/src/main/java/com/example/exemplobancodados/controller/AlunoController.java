package com.example.exemplobancodados.controller;

import android.content.Context;

import com.example.exemplobancodados.dao.AlunoDao;
import com.example.exemplobancodados.model.Aluno;

import java.util.ArrayList;

public class AlunoController {

    private Context context;

    public AlunoController(Context context) {
        this.context = context;
    }

    public long salvarAluno(Aluno aluno){
        return AlunoDao.getInstancia(context).insert(aluno);
    }

    public long atualizarAluno(Aluno aluno){
        return AlunoDao.getInstancia(context).update(aluno);
    }

    public long apagarAluno(Aluno aluno){
        return AlunoDao.getInstancia(context).delete(aluno);
    }

    public ArrayList<Aluno> retornarTodosAlunos(){
        return AlunoDao.getInstancia(context).getAll();
    }

    public Aluno retornarAluno(int ra){
        return AlunoDao.getInstancia(context).getById(ra);
    }

    public String validaAluno(Aluno aluno){
        String mensagem = "";
        if(aluno.getRaAluno() <= 0){
            mensagem += "Ra do aluno deve ser preenchido!!\n";
        }
        if(aluno.getNomeAluno() == null || aluno.getNomeAluno().isEmpty()){
            mensagem += "Nome do aluno deve ser preenchido!!";
        }

        return mensagem;
    }

}

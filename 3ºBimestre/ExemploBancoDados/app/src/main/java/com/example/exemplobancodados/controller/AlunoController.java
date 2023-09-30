package com.example.exemplobancodados.controller;

import android.content.Context;

import com.example.exemplobancodados.dao.AlunoDao;
import com.example.exemplobancodados.model.Aluno;

import java.text.NumberFormat;
import java.util.ArrayList;

public class AlunoController {

    private Context context;

    /**
     * Construtor da classe
     * @param context: activity que irá utilizar a classe
     */
    public AlunoController(Context context) {
        this.context = context;
    }

    /**
     * Chama o método do Dao para gravar o aluno
     * Cria o objeto Aluno
     * @param ra: Ra do aluno
     * @param nome Nome do Aluno
     * @return a linha que gravou a informação no banco
     *  se > 0 gravou corretamente
     *  se <= 0 teve erro ao gravar
     */
    public long salvarAluno(String ra, String nome){
        Aluno aluno = new Aluno(Integer.parseInt(ra), nome);
        return AlunoDao.getInstancia(context).insert(aluno);
    }

    /**
     * Chama o método de atualizar da Dao
     * Cria o Objeto Aluno
     * @param ra: Ra do aluno
     * @param nome Nome do Aluno
     * @return a linha que gravou a informação no banco
     *  se > 0 atualizou corretamente
     *  se <= 0 teve erro ao atualizar
     */
    public long atualizarAluno(String ra, String nome){
        Aluno aluno = new Aluno(Integer.parseInt(ra), nome);
        return AlunoDao.getInstancia(context).update(aluno);
    }

    /**
     * Chama o método de excluir o registro no DAO
     * @param ra: Ra do aluno
     * @param nome Nome do Aluno
     * @return a linha que apagou a informação no banco
     *  se > 0 apagou corretamente
     *  se <= 0 teve erro ao apagou
     */
    public long apagarAluno(String ra, String nome){
        Aluno aluno = new Aluno(Integer.parseInt(ra), nome);
        return AlunoDao.getInstancia(context).delete(aluno);
    }

    /**
     * Chama o método que retorna todos os dados do Dao
     * @return
     */
    public ArrayList<Aluno> retornarTodosAlunos(){
        return AlunoDao.getInstancia(context).getAll();
    }

    /**
     * Chama o método que retorna o Aluno pelo RA do DAO
     * @param ra
     * @return
     */
    public Aluno retornarAluno(int ra){
        return AlunoDao.getInstancia(context).getById(ra);
    }

    /**
     * Método para validar se os dados necessários para gravar o Aluno
     * no Banco estão válidos
     * RA - não pode ser nulo ou vazio e também não pode ser <= 0
     * NOME - não pode ser nulo ou vazio
     * @param ra
     * @param nome
     * @return: se os dados estão válidos retorna ""
     * se algum não for válido retorna mensagem informando o problema
     */
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

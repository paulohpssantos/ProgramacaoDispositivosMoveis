package com.example.exemplobancodados.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.exemplobancodados.helper.SQLiteDataHelper;
import com.example.exemplobancodados.model.Aluno;

import java.util.ArrayList;

public class AlunoDao implements GenericDao<Aluno>{

    //Abrir a conexão com a BD
    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase bd;

    //nome das colunas da tabela
    private String[]colunas = {"RA", "NOME"};

    //Nome da Tabela
    private String tableName = "ALUNO";

    private Context context;

    private static AlunoDao instancia;

    /**
     * Método que cria a instancia uma única vez
     * toda vez que for necessário utilizar essa classe,
     * retorna sempre a mesma instancia
     * @param context
     * @return
     */
    public static AlunoDao getInstancia(Context context){
        if(instancia == null)
            return instancia = new AlunoDao(context);
        else
            return instancia;
    }

    private AlunoDao(Context context) {
        this.context = context;
        //Carregando base de dados
        openHelper = new SQLiteDataHelper(this.context, "UNIPAR", null, 1);

        //Atribuindo a base de dados a variavel, e dando permissão para escrever nas tabelas
        bd = openHelper.getWritableDatabase();

    }


    @Override
    public long insert(Aluno obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put("RA", obj.getRaAluno());
            valores.put("NOME", obj.getNomeAluno());

            //método para inserir na tabela (<nome da tabela>, <coluna especifica que queira inserir>, <dados>);
            //retorna a linha que foi inserida na tabela
            return bd.insert(tableName, null, valores);

        }catch (SQLException ex){
            Log.e("insert", ex.getMessage());
        }
        return -1;
    }

    @Override
    public long update(Aluno obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put("NOME", obj.getNomeAluno());

            //identificador para o where
            String[]identificador = {String.valueOf(obj.getRaAluno())};
            
            //Método para atualizar
            //<nome da tabela>, <valores>, <clausula where (where RA = ?)>,
            // <valor do where (WHere RA = 1234)>
            return bd.update(tableName, valores, "RA = ?", identificador);

        }catch (SQLException ex){
            Log.e("update", ex.getMessage());
        }
        return -1;
    }

    @Override
    public long delete(Aluno obj) {
        return 0;
    }

    @Override
    public ArrayList<Aluno> getAll() {
        return null;
    }

    @Override
    public Aluno getById(int id) {
        return null;
    }
}

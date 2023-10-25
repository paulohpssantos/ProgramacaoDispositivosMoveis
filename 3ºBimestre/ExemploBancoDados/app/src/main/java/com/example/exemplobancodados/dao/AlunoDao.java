package com.example.exemplobancodados.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        openHelper = new SQLiteDataHelper(this.context, "UNIPAR",
                null, 1);

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
            Log.e("ERRO", "AlunoDao.insert(): "+ex.getMessage());
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
            Log.e("ERRO", "AlunoDao.update(): "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public long delete(Aluno obj) {
        try{
            String[]identificador = {String.valueOf(obj.getRaAluno())};
            return bd.delete(tableName, "RA = ?", identificador);

        }catch (SQLException ex){
            Log.e("ERRO", "AlunoDao.delete(): "+ex.getMessage());
        }
        return -1;
    }

    @Override
    public ArrayList<Aluno> getAll() {
        ArrayList<Aluno> lista = new ArrayList<>();

        try{
            Cursor cursor = bd.query(tableName, colunas,
                    null, null,
                    null, null, "RA");
            if(cursor.moveToFirst()){
                do{
                    Aluno aluno = new Aluno();
                    aluno.setRaAluno(cursor.getInt(0));
                    aluno.setNomeAluno(cursor.getString(1));

                    lista.add(aluno);
                }while(cursor.moveToNext());
            }
        }catch (SQLException ex){
            Log.e("ERRO", "AlunoDao.getAll(): "+ex.getMessage());
        }

        return lista;
    }

    @Override
    public Aluno getById(int id) {
        try{
            String[]identificador = {String.valueOf(id)};

            Cursor cursor = bd.query(tableName, colunas,
                    "RA = ?", identificador, null,
                    null, null);

            if(cursor.moveToFirst()){
                Aluno aluno = new Aluno();
                aluno.setRaAluno(cursor.getInt(0));
                aluno.setNomeAluno(cursor.getString(1));

                return aluno;
            }

        }catch (SQLException ex){
            Log.e("ERRO", "AlunoDao.getAll(): "+ex.getMessage());
        }
        return null;
    }
}

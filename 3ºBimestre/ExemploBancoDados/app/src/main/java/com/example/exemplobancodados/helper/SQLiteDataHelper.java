package com.example.exemplobancodados.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDataHelper extends SQLiteOpenHelper {

    public SQLiteDataHelper(@Nullable Context context,
                            @Nullable String name,
                            @Nullable SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, name, factory, version);
    }

    /**
     * Esse método é executado uma única vez quando o aplicativo é instalado no celular
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE ALUNO (RA INTEGER, NOME VARCHAR(100))");
    }

    /**
     * Esse método é executado qundo a versão aplicativo é atualizado no celular
     * @param sqLiteDatabase
     * @param oldVersion : versão antiga do app
     * @param newVersion : versão nova que está sendo instalada
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }


}

package com.example.exemplobancodados.dao;

import java.util.ArrayList;

/**
 * Regras que devem ser atribuídas a uma classe
 * ou seja, a classe deverá implementar todos os métodos
 * aqui descritos
 * @param <Object>: Objeto que será utilizado para ser implementado nos métodos
 */
public interface GenericDao<Object> {

    long insert(Object obj);
    long update(Object obj);
    long delete(Object obj);
    ArrayList<Object> getAll();
    Object getById(int id);

}

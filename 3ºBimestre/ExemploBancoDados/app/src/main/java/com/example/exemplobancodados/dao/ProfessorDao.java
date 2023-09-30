package com.example.exemplobancodados.dao;

import com.example.exemplobancodados.model.Professor;

import java.util.ArrayList;

public class ProfessorDao implements GenericDao<Professor>{
    @Override
    public long insert(Professor prof) {
        return 0;
    }

    @Override
    public long update(Professor prof) {
        return 0;
    }

    @Override
    public long delete(Professor obj) {
        return 0;
    }

    @Override
    public ArrayList<Professor> getAll() {
        return null;
    }

    @Override
    public Professor getById(int id) {
        return null;
    }
}

package com.example.exemplobancodados.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.exemplobancodados.R;
import com.example.exemplobancodados.adapter.AlunoListAdapter;
import com.example.exemplobancodados.controller.AlunoController;
import com.example.exemplobancodados.model.Aluno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListaAlunoActivity extends AppCompatActivity {

    private AlunoController controller;
    private RecyclerView rvAlunos;
    private FloatingActionButton btNovoAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_aluno);

        controller = new AlunoController(this);
        rvAlunos = findViewById(R.id.rvAlunos);
        btNovoAluno = findViewById(R.id.btNovoAluno);

        atualizarListaAlunos();
    }

    private void atualizarListaAlunos() {
        ArrayList<Aluno> listaAlunos = controller.retornarTodosAlunos();
        AlunoListAdapter adapter = new AlunoListAdapter(listaAlunos, this);
        rvAlunos.setLayoutManager(new LinearLayoutManager(this));
        rvAlunos.setAdapter(adapter);
    }
}
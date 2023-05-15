package com.example.exemploactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapters.AlunoAdapter;
import com.example.utils.Globais;

public class ListaAlunoActivity extends AppCompatActivity {

    private ListView lvAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_aluno);

        lvAlunos = findViewById(R.id.lvAlunos);

        AlunoAdapter adapter =
                new AlunoAdapter(this, Globais.listaAlunos);
        lvAlunos.setAdapter(adapter);

    }
}
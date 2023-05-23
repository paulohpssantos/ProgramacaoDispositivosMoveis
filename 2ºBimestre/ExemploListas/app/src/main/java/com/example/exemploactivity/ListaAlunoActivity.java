package com.example.exemploactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapters.AlunoAdapter;
import com.example.model.Aluno;
import com.example.utils.Globais;

import java.util.ArrayList;

public class ListaAlunoActivity extends AppCompatActivity {

    private ListView lvAlunos;
    private Aluno alunoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_aluno);

        lvAlunos = findViewById(R.id.lvAlunos);

        atualizaLista(Globais.listaAlunos);

        lvAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
                alunoSelecionado =
                        (Aluno) lvAlunos.getItemAtPosition(i);

                exibirAlunoSelecionado(alunoSelecionado);
            }
        });



    }

    //Atualiza a listView
    private void atualizaLista(ArrayList<Aluno> lista){
        AlunoAdapter adapter =
                new AlunoAdapter(this, lista);
        lvAlunos.setAdapter(adapter);
    }

    private void exibirAlunoSelecionado(Aluno aluno){
        Toast.makeText(this,
                "RA: "+aluno.getRa()+" Nome: "+aluno.getNome(),
                Toast.LENGTH_LONG).show();
    }
}
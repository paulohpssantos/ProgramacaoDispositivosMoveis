package com.example.exemploactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.model.Aluno;
import com.example.utils.Globais;

import java.util.ArrayList;

public class CadastroActivity extends AppCompatActivity {

    private EditText edRa;
    private EditText edNome;
    private Button btSalvar;
    private Spinner spCidades;

    private String cidadeSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edRa = findViewById(R.id.edRa);
        edNome = findViewById(R.id.edNome);
        btSalvar = findViewById(R.id.btSalvar);
        spCidades = findViewById(R.id.spCidades);

        String[] vetorCidades = new String[]{"","Toledo","Cascavel",
            "Palotina", "Mal. Cdo. Rondon"};

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, vetorCidades);

        spCidades.setAdapter(adapter);

        spCidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {
                cidadeSelecionada = (String) spCidades.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        if(Globais.listaAlunos == null) {
            Globais.listaAlunos = new ArrayList<>();
        }

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarAluno();
            }
        });
    }

    private void salvarAluno(){
        Aluno aluno = new Aluno();
        aluno.setRa(Integer.parseInt(edRa.getText().toString()));
        aluno.setNome(edNome.getText().toString());
        aluno.setCidade(cidadeSelecionada);

        Globais.listaAlunos.add(aluno);

        Toast.makeText(this,
                "Aluno Salvo com Sucesso!",
                Toast.LENGTH_LONG).show();

        finish();
    }
}
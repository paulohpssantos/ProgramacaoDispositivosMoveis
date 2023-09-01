package com.example.exemplobancodados.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exemplobancodados.R;
import com.example.exemplobancodados.controller.AlunoController;

public class MainActivity extends AppCompatActivity {

    private EditText edRaAluno;
    private EditText edNomeAluno;
    private Button btCadastroAluno;
    private AlunoController alunoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCadastroAluno = findViewById(R.id.btCadastroAluno);
        btCadastroAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity();
            }
        });

//        edRaAluno = findViewById(R.id.edRaAluno);
//        edNomeAluno = findViewById(R.id.edNomeAluno);
//        btSalvar = findViewById(R.id.btSalvar);

//        alunoController = new AlunoController(this);
//
//        btSalvar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                salvarAluno();
//            }
//        });
    }

    public void abrirActivity(){
        Intent intent = new Intent(MainActivity.this,
                ListaAlunoActivity.class);

        startActivity(intent);
    }

    private void salvarAluno() {
        String validacao = alunoController.validaAluno(
                edRaAluno.getText().toString(),
                edNomeAluno.getText().toString());

        if(!validacao.equals("")){
            if(validacao.contains("Ra")){
                edRaAluno.setError(validacao);
            }
            if(validacao.contains("Nome")){
                edNomeAluno.setError(validacao);
            }
        }else{
            if(alunoController.salvarAluno(
                    edRaAluno.getText().toString(),
                    edNomeAluno.getText().toString()) > 0){

                Toast.makeText(this,
                        "Aluno cadastrado com sucesso!!",
                        Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,
                        "Erro ao cadastrar Aluno, verifique LOG.",
                        Toast.LENGTH_LONG).show();
            }
        }

    }
}
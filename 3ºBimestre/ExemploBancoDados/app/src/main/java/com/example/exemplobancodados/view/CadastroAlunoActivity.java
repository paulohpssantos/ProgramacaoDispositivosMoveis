package com.example.exemplobancodados.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exemplobancodados.R;
import com.example.exemplobancodados.controller.AlunoController;

public class CadastroAlunoActivity extends AppCompatActivity {

    private EditText edRaAluno;
    private EditText edNomeAluno;
    private AlunoController alunoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);
        setTitle("Cadastrar Aluno");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mnInflater = getMenuInflater();
        mnInflater.inflate(R.menu.menu_padrao, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnSalvar) {//salvar aluno
            salvarAluno();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
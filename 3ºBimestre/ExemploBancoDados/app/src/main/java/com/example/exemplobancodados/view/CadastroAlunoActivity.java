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
        edRaAluno = findViewById(R.id.edRaAluno);
        edNomeAluno = findViewById(R.id.edNomeAluno);
    }

    /**Responsável por criar o menu na barra de ação da acitvity**/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /****Carrega o layout do menu*/
        MenuInflater mnInflater = getMenuInflater();
        mnInflater.inflate(R.menu.menu_padrao, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**Atribuir ação ao clicar no menu**/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnSalvar) {//salvar aluno
            salvarAluno();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Método para gravar aluno
     * é solicitado para o controller
     * validar e gravar o aluno na tabela
     */
    private void salvarAluno() {
        String validacao = alunoController.validaAluno(
                edRaAluno.getText().toString(),
                edNomeAluno.getText().toString());
        /**Se retornar msg de validação quer dizer
         * que o campo não foi aprovado**/
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
package com.example.exemplobancodados.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.exemplobancodados.R;

public class CadastroAlunoActivity extends AppCompatActivity {

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

    }
}
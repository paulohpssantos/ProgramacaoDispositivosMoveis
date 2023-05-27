package com.example.exemplicheckradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbAluno;
    private CheckBox cbProfessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbAluno = findViewById(R.id.cbAluno);
        cbProfessor = findViewById(R.id.cbProfessor);

        cbAluno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                validaCampos();
            }
        });

    }
    public void validaCampos(){
        if(cbAluno.isChecked()){
            Toast.makeText(this,
                    "Selecionou o Aluno",
                    Toast.LENGTH_LONG).show();
        }
        if(cbProfessor.isChecked()){
            Toast.makeText(this,
                    "Selecionou o Professor",
                    Toast.LENGTH_LONG).show();
        }
    }


    public void selecionarOpcao(View view) {
        RadioButton radio = (RadioButton) view;
        boolean checkado = radio.isChecked();

        if(view.getId() == R.id.rbSim && checkado){
            Toast.makeText(this,
                    "Selecionou o SIM!",
                    Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(this,
                    "Selecionou o NÃO!",
                    Toast.LENGTH_LONG).show();

        }
    }
}
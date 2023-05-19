package com.example.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edNome;
    private EditText edRa;
    private TextView tvResultado;
    private Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNome = findViewById(R.id.edNome);
        edRa = findViewById(R.id.edRa);
        tvResultado = findViewById(R.id.tvResultado);
        btSalvar = findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarAluno();
            }
        });


    }

    private void salvarAluno(){
        String nome = edNome.getText().toString();
        String ra = edRa.getText().toString();
        try{

            String resultado = tvResultado.getText().toString();
            if(!nome.equals("") && !ra.equals("")){
                resultado += "Nome: "+nome+" RA: "+ra+"\n";
                tvResultado.setText(resultado);

                Toast.makeText(this,
                        "Aluno Salvo com Sucesso!",
                        Toast.LENGTH_LONG).show();
            }else{
                if(nome.equals("")){
                    edNome.setError("Informe o nome!");
                }
                if(ra.equals("")){
                    edRa.setError("Informe o ra!");
                }
            }

            //Para enconder os campo da tela
            edNome.setVisibility(View.GONE);
            edRa.setVisibility(View.GONE);

            //Para exibir os campos
            edNome.setVisibility(View.VISIBLE);
            edRa.setVisibility(View.VISIBLE);

        }catch (Exception ex){
            Log.e("ERRO", ex.getMessage());
        }
    }

}
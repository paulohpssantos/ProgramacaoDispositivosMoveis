package com.example.exemplocomunicacaoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.example.exemplocomunicacaoapi.controller.CepController;

public class MainActivity extends AppCompatActivity {

    private TextView tvResponse;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResponse = findViewById(R.id.tvResponse);

        CepController.getViaCep("85910110", this, tvResponse);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Carregando....");
        progressDialog.setTitle("Sincronizar Dados");

        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    progressDialog.dismiss();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });



    }
}
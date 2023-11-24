package com.example.exemplocomunicacaoexterna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.exemplocomunicacaoexterna.controller.CepController;

public class MainActivity extends AppCompatActivity {

    private TextView tvResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResponse = findViewById(R.id.tvResponse);


        CepController.getViaCep("85906040", this, tvResponse);
    }
}
package com.example.exemploretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.exemploretrofit.controller.MunicipioController;
import com.example.exemploretrofit.dto.MunicipioDto;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MunicipioController.executarAPI("85810061", this);

    }
}
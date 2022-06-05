package com.proyect.prescriptionapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.proyect.prescriptionapp.R;

public class PacienteRegisterActivity extends AppCompatActivity {

    private String saludo ="hola mundo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente_register);
    }
}
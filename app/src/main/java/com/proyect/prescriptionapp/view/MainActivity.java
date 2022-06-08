package com.proyect.prescriptionapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.proyect.prescriptionapp.R;
import com.proyect.prescriptionapp.data.model.BodyLogin;
import com.proyect.prescriptionapp.data.model.Usuario;
import com.proyect.prescriptionapp.viewmodel.LoginViewModel;


public class MainActivity extends AppCompatActivity {

    private Button iniciar;
    private TextInputEditText nameUser;
    private TextInputEditText password;

    private LoginViewModel loginVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = findViewById(R.id.btn_iniciar);
        nameUser = findViewById(R.id.nameUser);
        password = findViewById(R.id.password);

        //inicializamos el view model
        loginVM = new ViewModelProvider(this).get(LoginViewModel.class);

        //usamos un observador
        loginVM.getUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                Toast.makeText(MainActivity.this, usuario.getNombre_completo(), Toast.LENGTH_SHORT).show();
            }
        });

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameUser.getText().toString();
                String pass = password.getText().toString();
                BodyLogin bodyLogin = new BodyLogin(name, pass);
                loginVM.validarUsuario(bodyLogin);
            }
        });
    }
}
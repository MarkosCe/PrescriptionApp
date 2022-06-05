package com.proyect.prescriptionapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.proyect.prescriptionapp.R;
import com.proyect.prescriptionapp.core.RetrofitHelper;
import com.proyect.prescriptionapp.data.model.BodyLogin;
import com.proyect.prescriptionapp.data.model.Usuario;
import com.proyect.prescriptionapp.data.network.CatalogRequest;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button iniciar;
    private TextInputEditText nameUser;
    private TextInputEditText password;

    private CatalogRequest servicio = RetrofitHelper.getRetrofit().create(CatalogRequest.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = findViewById(R.id.btn_iniciar);
        nameUser = findViewById(R.id.nameUser);
        password = findViewById(R.id.password);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameUser.getText().toString();
                String pass = password.getText().toString();

                BodyLogin bodyLogin = new BodyLogin(name, pass);
                Call<Usuario> listaUser = servicio.login(bodyLogin);
                listaUser.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(MainActivity.this, response.body().getNombre_completo(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, "credenciales invalidas", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                        Log.e("errorconexion", t.getMessage());
                    }
                });
            }
        });
    }
}
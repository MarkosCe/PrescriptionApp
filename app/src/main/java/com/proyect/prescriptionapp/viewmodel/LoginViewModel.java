package com.proyect.prescriptionapp.viewmodel;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.proyect.prescriptionapp.core.RetrofitHelper;
import com.proyect.prescriptionapp.data.model.BodyLogin;
import com.proyect.prescriptionapp.data.model.Usuario;
import com.proyect.prescriptionapp.data.network.CatalogRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<Usuario> usuario;

    private CatalogRequest servicio = RetrofitHelper.getRetrofit().create(CatalogRequest.class);


    public MutableLiveData<Usuario> getUsuario() {
        if (usuario == null)
            usuario = new MutableLiveData<>();
        return usuario;
    }

    public void validarUsuario(BodyLogin bodyLogin) {
        Call<Usuario> listaUser = servicio.login(bodyLogin);
        listaUser.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()){
                    //Toast.makeText(MainActivity.class, response.body().getNombre_completo(), Toast.LENGTH_SHORT).show();
                    getUsuario().postValue(response.body());
                    //Log.e("errorconexion", "se supone que que si ubo cambio de valor");
                }else {
                    //Toast.makeText(MainActivity.this, "credenciales invalidas", Toast.LENGTH_SHORT).show();
                    Log.e("errorconexion", response.message());
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                //Toast.makeText(MainActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                Log.e("errorconexion", t.getMessage());
            }
        });
    }

}

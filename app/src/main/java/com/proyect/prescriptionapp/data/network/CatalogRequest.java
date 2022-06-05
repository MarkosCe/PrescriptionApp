package com.proyect.prescriptionapp.data.network;

import com.proyect.prescriptionapp.data.model.BodyLogin;
import com.proyect.prescriptionapp.data.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CatalogRequest {
    @POST("login/")
    Call<Usuario> login(@Body BodyLogin bodyLogin);
}

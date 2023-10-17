package com.example.feiraunifunec.feiraretrofit.service;

import com.example.feiraunifunec.modelo.Tipo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TipoService {
    @GET("feira/tipos")
    Call<List<Tipo>> buscaTodos();

    @POST("feira/tipos")
    Call<Tipo> salva(@Body Tipo alunos);

    @DELETE("feira/tipos/{codtipo}")
    Call<Void> remove(@Path("codtipo") long codtipo);

    @PUT("feira/tipos/{codtipo}")
    Call<Void> edita(@Path("codtipo") long codtipo, @Body Tipo tipo);

    
}

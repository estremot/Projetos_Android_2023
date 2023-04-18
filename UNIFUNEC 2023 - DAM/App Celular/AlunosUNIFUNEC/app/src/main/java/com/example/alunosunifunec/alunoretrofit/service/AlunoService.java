package com.example.alunosunifunec.alunoretrofit.service;

import com.example.alunosunifunec.modelo.Alunos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlunoService {
    @GET("alunos")
    Call<List<Alunos>> buscaTodos();

    @POST("alunos")
    Call<Alunos> salva(@Body Alunos alunos);

    @DELETE("alunos/{codaluno}")
    Call<Void> remove(@Path("codaluno") long codaluno);

    @PUT("alunos/{codaluno}")
    Call<Void> edita(@Path("codaluno") long codaluno, @Body Alunos alunos);

    
}

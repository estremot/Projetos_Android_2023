package com.example.alunosunifunec.alunoretrofit;

import com.example.alunosunifunec.alunoretrofit.service.AlunoService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlunoRetrofit {

    private final AlunoService alunoService;

    public AlunoRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.5.55:8080/unifunec/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        alunoService = retrofit.create(AlunoService.class);
    }

    public AlunoService getAlunoService(){
        return alunoService;
    }
}

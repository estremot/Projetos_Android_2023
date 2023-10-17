package com.example.feiraunifunec.feiraretrofit.service;

import com.example.feiraunifunec.modelo.Produto;
import com.example.feiraunifunec.modelo.Tipo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProdutoService {
    @GET("feira/produtos")
    Call<List<Produto>> buscaTodos();

    @POST("feira/produtos")
    Call<Produto> salva(@Body Produto produtos);

    @DELETE("feira/produtos/{codproduto}")
    Call<Void> remove(@Path("codproduto") long codproduto);

    @PUT("feira/produtos/{codproduto}")
    Call<Void> edita(@Path("codproduto") long codproduto, @Body Produto produto);

    
}

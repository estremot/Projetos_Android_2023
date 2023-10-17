package com.example.feiraunifunec.feiraretrofit;


import com.example.feiraunifunec.feiraretrofit.service.ProdutoService;
import com.example.feiraunifunec.feiraretrofit.service.TipoService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FeiraRetrofit {

    private final TipoService tipoService;
    private final ProdutoService produtoService;

    public FeiraRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.5.59:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tipoService = retrofit.create(TipoService.class);
        produtoService = retrofit.create(ProdutoService.class);
    }


    public TipoService getTipoService(){
        return tipoService;
    }

    public ProdutoService getProdutoService() {
        return produtoService;
    }
}

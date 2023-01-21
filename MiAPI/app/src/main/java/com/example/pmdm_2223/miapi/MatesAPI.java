package com.example.pmdm_2223.miapi;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MatesAPI {

    private static MatesAPI instancia;

    MatesService service;

    private MatesAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.240:8000/")//URL de nuestro dominio y puerto
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service=retrofit.create(MatesService.class);
    }

    public static MatesAPI getInstance(){
        if(instancia==null){
            instancia=new MatesAPI();
        }
        return instancia;
    }

    public Call<Resultado> suma (int n1, int n2){
        return service.suma(n1,n2);
    }

    public Call<Resultado> resta (int n1, int n2){
        return service.resta(n1,n2);
    }

    public Call<Resultado> mult (int n1, int n2){
        return service.mult(n1,n2);
    }

    public Call<Resultado> div (int n1, int n2){
        return service.div(n1,n2);
    }

}

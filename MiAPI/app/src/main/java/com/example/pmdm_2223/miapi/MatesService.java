package com.example.pmdm_2223.miapi;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MatesService {
    @GET("/")
    Call<Resultado> raiz();

    @GET("suma/{n1}/{n2}/")
    Call<Resultado> suma(@Path("n1") int n1, @Path("n2") int n2);

    @GET("resta/{n1}/{n2}/")
    Call<Resultado> resta(@Path("n1") int n1, @Path("n2") int n2);

    @GET("mult/{n1}/{n2}/")
    Call<Resultado> mult(@Path("n1") int n1, @Path("n2") int n2);

    @GET("div/{n1}/{n2}/")
    Call<Resultado> div(@Path("n1") int n1, @Path("n2") int n2);
}

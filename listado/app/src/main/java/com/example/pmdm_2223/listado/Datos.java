package com.example.pmdm_2223.listado;

public class Datos {
    String j1,j2,j3,j4,nomJuego;
    int pto1,pto2,pto3,pto4;

    public String getJ1() {
        return j1;
    }
    public void setJ1(String j1) {
        this.j1 = j1;
    }
    public String getJ2() {
        return j2;
    }
    public void setJ2(String j2) {
        this.j2 = j2;
    }
    public String getJ3() {
        return j3;
    }
    public void setJ3(String j3) {
        this.j3 = j3;
    }
    public String getJ4() {
        return j4;
    }
    public void setJ4(String j4) {
        this.j4 = j4;
    }
    public String getNomJuego() {
        return nomJuego;
    }
    public void setNomJuego(String nomJuego) {
        this.nomJuego = nomJuego;
    }
    public int getPto1() {
        return pto1;
    }
    public void setPto1(int pto1) {
        this.pto1 = pto1;
    }
    public int getPto2() {
        return pto2;
    }
    public void setPto2(int pto2) {
        this.pto2 = pto2;
    }
    public int getPto3() {
        return pto3;
    }
    public void setPto3(int pto3) {
        this.pto3 = pto3;
    }
    public int getPto4() {
        return pto4;
    }
    public void setPto4(int pto4) {
        this.pto4 = pto4;
    }
    public Datos(String nomJuego,String j1,String j2,String j3,String j4,int pto1,int pto2,int pto3,int pto4){
        this.nomJuego=nomJuego;
        this.j1=j1;
        this.j2=j2;
        this.j3=j3;
        this.j4=j4;
        this.pto1=pto1;
        this.pto2=pto2;
        this.pto3=pto3;
        this.pto4=pto4;
    }
}

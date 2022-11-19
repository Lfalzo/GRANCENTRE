package com.example.proyectoandroid.cartelera;

public class filmData {
    private String nombreCine;
    private String peli1;
    private String peli2;
    private String peli3;
    private String direccion;
    private String website;


    public filmData(String nombreCine, String peli1, String peli2, String peli3, String direccion, String website) {
        this.nombreCine = nombreCine;
        this.peli1 = peli1;
        this.peli2 = peli2;
        this.peli3 = peli3;
        this.direccion = direccion;
        this.website = website;
    }


    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    public String getPeli1() {
        return peli1;
    }

    public void setPeli1(String peli1) {
        this.peli1 = peli1;
    }

    public String getPeli2() {
        return peli2;
    }

    public void setPeli2(String peli2) {
        this.peli2 = peli2;
    }

    public String getPeli3() {
        return peli3;
    }

    public void setPeli3(String peli3) {
        this.peli3 = peli3;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}

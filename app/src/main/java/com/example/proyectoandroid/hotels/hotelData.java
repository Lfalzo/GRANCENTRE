package com.example.proyectoandroid.hotels;

import android.sax.StartElementListener;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class hotelData {
    private String nombre;
    private Integer estrellas;
    private String descripcion;
    private String imatge;
    private String imatge2;
    private String direccion;
    private String telefono;
    private String email;
    private Integer valoracion;
    private String website;

    public hotelData(String nombre,int estrellas,String descripcion,String imatge, String imatge2,String direccion
    ,String telefono,String email, int valoracion,String website) {
        this.nombre = nombre;
        this.estrellas = estrellas;
        this.descripcion = descripcion;
        this.imatge = imatge;
        this.imatge2 = imatge2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.valoracion = valoracion;
        this.website = website;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getImatge2() {
        return imatge2;
    }

    public void setImatge2(String imatge2) {
        this.imatge2 = imatge2;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }
}

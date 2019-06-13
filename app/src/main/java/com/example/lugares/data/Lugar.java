package com.example.lugares.data;

import android.util.EventLogTags;
import android.widget.RatingBar;

import java.io.Serializable;

public class Lugar implements Serializable
{
    String nombre;
    String descripcion;
    Double latitud;
    Double longitud;
    float ratingBarLugar;

    public Lugar(String nombre, String descripcion, double latitud, double longitud, float ratingBarLugar)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.ratingBarLugar = ratingBarLugar;
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

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public float getRatingBarLugar() {
        return ratingBarLugar;
    }

    public void setRatingBarLugar(float ratingBarLugar) {
        this.ratingBarLugar = ratingBarLugar;
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", ratingBarLugar=" + ratingBarLugar +
                '}';
    }
}
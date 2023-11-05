package com.example.practica_permisos_y_recycleview.Models;


public class Permiso{

    String nombre;
    String descripcion;
    boolean estado;
    public Permiso(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public void setEstado(boolean estado)
    {
        this.estado=estado;
    }

    public boolean isEstado() {
        return estado;
    }
}

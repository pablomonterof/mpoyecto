package com.example.restservice;

public class Producto {

    private final String codigo;
    private final String descripcion;
    private final float precio;
    private final int cantidad;
    private final float total;

    public Producto(String codigo, String descripcion, float precio, int cantidad, float total) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getTotal() {
        return total;
    }

}

package com.example.myconsumo20223.Model;



public class Producto {
    private int id;
    private String descripcion;
    private double monto;
    private int stock;

    public Producto(int id, String descripcion, double monto, int stock) {
        this.id = id;
        this.descripcion = descripcion;
        this.monto = monto;
        this.stock = stock;
    }

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

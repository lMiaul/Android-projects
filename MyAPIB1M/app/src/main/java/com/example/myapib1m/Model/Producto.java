package com.example.myapib1m.Model;

public class Producto {
    private int codigoProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private int codigoCategoria;
    private int stockProducto;
    private float precioProducto;
    private String urlImagen;

    public Producto() {
    }

    public Producto(int codigoProducto, String nombreProducto, String descripcionProducto, int codigoCategoria, int stockProducto, float precioProducto, String urlImagen) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.codigoCategoria = codigoCategoria;
        this.stockProducto = stockProducto;
        this.precioProducto = precioProducto;
        this.urlImagen = urlImagen;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}

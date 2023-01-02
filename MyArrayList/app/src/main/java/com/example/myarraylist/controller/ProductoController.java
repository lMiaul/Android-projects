package com.example.myarraylist.controller;

import com.example.myarraylist.model.Producto;

import java.util.ArrayList;

public class ProductoController {
    private ArrayList<Producto> lstProducto;
    public ProductoController(){

        lstProducto = new ArrayList<Producto>();

    }

    public void add(Producto objPro){
        lstProducto.add(objPro);
    }

    public Producto get(int pos){
        return lstProducto.get(pos);
    }

    public int size(){
        return lstProducto.size();
    }
}

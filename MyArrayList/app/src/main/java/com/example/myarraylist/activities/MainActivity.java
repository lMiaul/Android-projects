package com.example.myarraylist.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myarraylist.R;
import com.example.myarraylist.controller.ProductoController;
import com.example.myarraylist.model.Producto;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText _etCodigo;
    private EditText _etNombre;
    private EditText _etPrecio;
    private EditText _etStock;
    private EditText _etResultado;
    private Button   _btnProcesar;
    private ProductoController productoController = new ProductoController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _etCodigo = (EditText) findViewById(R.id.etCodigo);
        _etNombre = (EditText) findViewById(R.id.etNombre);
        _etPrecio = (EditText) findViewById(R.id.etPrecio);
        _etStock = (EditText) findViewById(R.id.etStock);
        _etResultado = (EditText) findViewById(R.id.etResultado);
        _btnProcesar = (Button) findViewById(R.id.btnProcesar);

        _btnProcesar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        //Crear objeto
        Producto objPro = new Producto(getCodigo(), getNombre(), getPrecio(), getStock());

        //Adicionar al arreglo
        productoController.add(objPro);

        //Listar
        _etResultado.setText("");
        for(int i=0; i<productoController.size(); i++){
            _etResultado.append(productoController.get(i).getCodigo() + "-" +
                                productoController.get(i).getNombre() + "-" +
                                productoController.get(i).getPrecio() + "-" +
                                productoController.get(i).getStock()+ "\n");
        }
    }

    public int getCodigo(){
        return Integer.parseInt(_etCodigo.getText().toString());
    }

    public String getNombre(){
        return _etNombre.getText().toString();
    }

    public double getPrecio(){
        return Double.parseDouble(_etPrecio.getText().toString());
    }

    public int getStock(){
        return Integer.parseInt(_etStock.getText().toString());
    }
}
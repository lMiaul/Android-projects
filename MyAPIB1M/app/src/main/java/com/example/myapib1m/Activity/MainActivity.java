package com.example.myapib1m.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapib1m.Api.ServiceAPI;
import com.example.myapib1m.Model.Producto;
import com.example.myapib1m.R;
import com.example.myapib1m.Util.ConnectionREST;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText _etResultado;
    private EditText _etCodigo;
    private EditText _etNombre;
    private EditText _etDescripción;
    private EditText _etCodCategoría;
    private EditText _etPrecio;
    private EditText _etStock;
    private EditText _etUrlImagen;
    private Button _btnGrabar;
    private Button _btnModificar;
    private Button _btnEliminar;
    private ServiceAPI serviceAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _etCodigo = (EditText) findViewById(R.id.etCodigo);
        _etNombre = (EditText) findViewById(R.id.etNombre);
        _etDescripción = (EditText) findViewById(R.id.etDescripción);
        _etCodCategoría = (EditText) findViewById(R.id.etCodCategoría);
        _etPrecio = (EditText) findViewById(R.id.etPrecio);
        _etStock = (EditText) findViewById(R.id.etStock);
        _etUrlImagen = (EditText) findViewById(R.id.etUrlImagen);
        _etResultado = (EditText) findViewById(R.id.etResultado);
        _btnGrabar = (Button) findViewById(R.id.btnProcesar);
        _btnModificar = (Button) findViewById(R.id.btnModificar);
        _btnEliminar = (Button) findViewById(R.id.btnEliminar);


        serviceAPI = ConnectionREST.getConnection().create(ServiceAPI.class);

        load();

        _btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto pObj = new Producto(Integer.parseInt(_etCodigo.getText().toString()),
                        _etNombre.getText().toString(),
                        _etDescripción.getText().toString(),
                        Integer.parseInt(_etCodCategoría.getText().toString()),
                        Integer.parseInt(_etStock.getText().toString()),
                        Float.parseFloat(_etPrecio.getText().toString()),
                        _etUrlImagen.getText().toString()
                );
                addProducto(pObj);
            }
        });

        _btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarProducto(Integer.parseInt(_etCodigo.getText().toString()));
            }
        });

        _btnModificar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Producto pObj = new Producto(Integer.parseInt(_etCodigo.getText().toString()),
                        _etNombre.getText().toString(),
                        _etDescripción.getText().toString(),
                        Integer.parseInt(_etCodCategoría.getText().toString()),
                        Integer.parseInt(_etStock.getText().toString()),
                        Float.parseFloat(_etPrecio.getText().toString()),
                        _etUrlImagen.getText().toString()
                );
                modifyProducto(pObj);
            }
        });
    }


    private void eliminarProducto(int parseInt) {
        Call<Producto> call = serviceAPI.removeProducto(parseInt);
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                if(response.isSuccessful())
                {
                    mensaje("Los datos se eliminaron satisfactoriamente!!!");
                }
                else
                {
                    mensaje("Ocurrio un error desconocido!!!");
                }
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                mensaje("Ocurrio un error!!!" + t.getMessage());
            }
        });
    }

    private void modifyProducto(Producto pObj){
        Call<Producto> call = serviceAPI.modifyProducto(pObj);
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                if(response.isSuccessful())
                {
                    Producto pro = response.body();

                    mensaje("Los datos se modificaron satisfactoriamente!!!");
                }
                else
                {
                    mensaje("Ocurrio un error desconocido!!!");
                }
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                mensaje("Ocurrio un error!!!" + t.getMessage());
            }
        });
    }

    public void addProducto(Producto pObj)
    {
        Call<Producto> call = serviceAPI.addProducto(pObj);
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                if(response.isSuccessful())
                {
                    Producto pro = response.body();
                    mensaje("Registro grabado satisfactoriamente!");
                }
                else
                {
                    mensaje("Ocurrio un error al grabar los datos!");
                }
            }
            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                mensaje("Ocurrio un error desconocido!" + t.getMessage());
            }
        });
    }

    private void load() {
        /*Cargar la lista*/

        Call<List<Producto>> call = serviceAPI.listProduct();
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if(response.isSuccessful())
                {
                    List<Producto> respuesta = response.body();
                    _etResultado.setText("\n\n\n\n");
                    for(Producto x:respuesta)
                    {
                        _etResultado.append("Id:" + x.getCodigoProducto()+ "Nombre:" + x.getNombreProducto() + "Precio" + x.getPrecioProducto() + "Stock" + x.getStockProducto() + "\n");
                        Toast.makeText(getApplicationContext(),"" + x.getNombreProducto(), Toast.LENGTH_LONG).show();
                        mensaje(x.getCodigoProducto() + "-" + x.getNombreProducto());
                    }
                }
                else
                {
                    Toast.makeText(null,"Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Toast.makeText(null,"Ocurrio un error", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void mensaje(String msg){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage(msg);
        alerta.show();
    }
}
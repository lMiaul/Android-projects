package com.example.myaplicacion_b1m;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText etNota01;
    private EditText etNota02;
    private EditText etNota03;
    private Button btnProcesar;
    private EditText etResultado;
    private ArrayList<CPromedio> lstOperaciones = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) { //es como mi main en Java
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNota01 = (EditText) findViewById(R.id.txtNota1);
        etNota02 = (EditText) findViewById(R.id.txtNota2);
        etNota03 = (EditText) findViewById(R.id.txtNota3);
        btnProcesar = (Button) findViewById(R.id.btnProcesar);
        etResultado = (EditText) findViewById(R.id.txtResultado);

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n1 = Double.parseDouble(etNota01.getText().toString());
                double n2 = Double.parseDouble(etNota02.getText().toString());
                double n3 = Double.parseDouble(etNota03.getText().toString());

                CPromedio objPromedio = new CPromedio(n1,n2,n3);
                //double promedio = (n1+n2+n3)/3;
                etResultado.setText("El promedio es: " + objPromedio.getPromedio());

                lstOperaciones.add(objPromedio);

                etResultado.append("\n********************\n");
                for(int i=0; i<lstOperaciones.size(); i++){
                    etResultado.append("" + lstOperaciones.get(i).getN1() + "-" +
                            lstOperaciones.get(i).getPromedio() + "\n") ;

                }



            }
        });
        //Conectar la programacion con el diseño
    }
}
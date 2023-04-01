package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nuevo.R;

public class MainActivity extends AppCompatActivity {

    TextView jtvprecio, jtvpq, jtvadicionales, jtvtotal ;

    RadioButton jrbcasa, jrbfinca, jrbapartamento;

    EditText jetcantidad;

    CheckBox jcbparquiadero;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ASOCIAR OBJETOS XML CON LOS OBJETOS DE JAVA

        jtvprecio = findViewById(R.id.tvprecio);
        jtvpq = findViewById(R.id.tvpq);
        jtvadicionales = findViewById(R.id.tvadicionales);
        jtvtotal = findViewById(R.id.tvtotal);
        jrbcasa = findViewById(R.id.rbcasa);
        jrbapartamento = findViewById(R.id.rbapartamento);
        jrbfinca = findViewById(R.id.rbfinca);
        jetcantidad = findViewById(R.id.etcantidad);
        jcbparquiadero = findViewById(R.id.cbparquiadero);
    }

    public void Calcular(View view) {

        String cantidad;

        // pasar obj java a un var de la RAM

        cantidad = jetcantidad.getText().toString();

        //validar que cantidad no este vacio

        if (cantidad.isEmpty()) {

            Toast.makeText(this, "La cantidad de personas es requerida", Toast.LENGTH_SHORT).show();

        } else {

            int cantidad_habitaciones, valorInmueble =0 , valor_parqueadero;
            float subtotal =0 , adicionales = 0, total;

            // conversion de string a int

            cantidad_habitaciones = Integer.parseInt(cantidad);

            if (cantidad_habitaciones == 0) {

                Toast.makeText(this, "La cantidad de personas debe ser mayor a 0", Toast.LENGTH_SHORT).show();
                jetcantidad.setText("");
                jetcantidad.requestFocus();

            } else {

                //seleccionar el valor x habitaciones  dependiuendo la propiedad

                if (jrbcasa.isChecked()) {

                    jtvprecio.setText("$ 400.000");
                    valorInmueble = 400000;

                } else {
                    if ((jrbapartamento.isChecked())) {
                        jtvprecio.setText(" $ 300.000 ");
                        valorInmueble = 300000;
                    } else if (jrbfinca.isChecked()) {
                        jtvprecio.setText(" $ 600.000 ");
                        valorInmueble = 600000;
                    }



                }//fin valor inmueble

                //valor parqueadero

                if (jcbparquiadero.isChecked()) {

                    jtvpq.setText(" $ 100.000 ");
                    valor_parqueadero = 100000;
                } else {
                    jetcantidad.setText(" 0 ");
                    valor_parqueadero = 0;

                }// fin dl valor adicional parquiadero

                if (cantidad_habitaciones < 3) {

                    adicionales = 100000;


                }if (cantidad_habitaciones == 3  || cantidad_habitaciones == 4) {

                    adicionales = 200000 ;


                }if(cantidad_habitaciones >4){

                    adicionales = 300000 ;

                }

                total = adicionales + valorInmueble + valor_parqueadero;

                // imprimir resultados
                jtvprecio.setText(String.valueOf(valorInmueble));
                jtvpq.setText(String.valueOf(valor_parqueadero));
                jtvadicionales.setText(String.valueOf(adicionales));
                jtvtotal.setText(String.valueOf(total));

                //FIN CALCULAR


            }

        }
    }


    public void Limpiar (View view){

        jrbcasa.setChecked(true);
        jtvprecio.setText("400000");
        jcbparquiadero.setChecked(false);
        jtvpq.setText("0");
        jetcantidad.setText("");
        jtvadicionales.setText("");
        jtvtotal.setText("");
        jetcantidad.requestFocus();


    }
}
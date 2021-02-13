package com.example.guardardatos;

import android.app.Activity;
import android.widget.EditText;

import android.content.Intent;
import android.os.Bundle;



public class Actividad2 extends Activity {
    EditText Tx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        // Se Obtiene los datos pasados
        Intent intent = getIntent();
        //El archivo se obtiene desde un String con el nombre clave "cadena"
        String cadenita = intent.getStringExtra("cadena");

        Tx2=(EditText)findViewById(R.id.editText2);


        // Se muestra el resultado o la lectura del archivo en un EditText
        Tx2.setText(cadenita);



    }
}



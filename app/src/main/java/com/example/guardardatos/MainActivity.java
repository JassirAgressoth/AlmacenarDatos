package com.example.guardardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText Tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tx1=(EditText)findViewById(R.id.editText);
// Escribir en el archivo y asignarlo al botón Guardar
    }
    public void Escribir(View view) throws IOException {

        //Ciclo para generar serie de Fibonacci
        int i1 =0;
        int i2=1;
        String resultado=i1 + ",  ";

        int numero= Integer.parseInt(Tx1.getText().toString());
        for(int i =2; i<=numero; i++){
            if(i==numero){
                resultado+= i2;
            }else{
                resultado += i2 + ",  ";
            }
            i2=i1+i2;
            i1=i2-i1;
        }
        // Creación y escritura  del archivo
        File nuevaCarpeta=null;
        OutputStreamWriter Salida= null;
        // Se asigna una carpeta del celular en la que se guardará el archivo de texto
        nuevaCarpeta = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"Hola");
        //Garantizar que se creará
        //Nota: Modificar AndroidManifest.xml con los permisos de escritura y lectura
        nuevaCarpeta.mkdirs();
        // Se hace un try-catch para la creación del archivo y las excepeciones Java
        try{
            File Archivo;
            Archivo= new File(nuevaCarpeta, "Cadena.txt");
            Archivo.createNewFile();
            Salida=new OutputStreamWriter(new FileOutputStream(Archivo));
            //Se coloca write de tipo char
            Salida.write(resultado);
            Salida.close();
        }
        catch (IOException e){
        }


    }
    // Leer el archivo guardado y asignar función Onclick al botón Abrir
    public void leer(View view) throws IOException {
        File nuevaCarpeta = null;
        OutputStreamWriter Salida = null;
        nuevaCarpeta = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Hola");
    // Se hace un Try-catch como en Escribir
        File Archivo = null;
        try {
            Archivo = new File(nuevaCarpeta, "Cadena.txt");
            BufferedReader Buffer = new BufferedReader(
                    new InputStreamReader(new FileInputStream(Archivo)));
            //Con el buffer creado se dice que el archivo sea leído linea por línea
            String Texto = Buffer.readLine();
            //Se llama la segunda clase Activity2
            Intent intent = new Intent(MainActivity.this, Actividad2.class);
            // PutExtra es de tipo String
            intent.putExtra("cadena", Texto);
            startActivity(intent);


            Buffer.close();
        } catch (IOException e) {
        }


    }

}
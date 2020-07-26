package com.test.jrev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String ETIQUETA = "Review";
    private List<Integer> numeros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] dias = new String[10];
        dias[1] = "lunes";
        dias[2] = "martes";
        dias[3] = "miercoles";
        dias[4] = "jueves";
        dias[5] = "viernes";
        dias[6] = "sabado";
        dias[7] = "domingo";
        for(int j = 0; j < dias.length; j++){
            Log.d(ETIQUETA, "País es " + dias[j]);
        }
        //Trabajar con Listas
        //1. Llenar la lista, agregando números enteros
        for (int i = 0; i < 10; i++){
            numeros.add(i+1);
        }
        //2. Recorrer la lista y obtener cada elemento
        for (int i = 0; i < 10; i++){
            Log.d(ETIQUETA, "Número es " + numeros.get(i));
        }
        //3. Utilizar un for each


        //4. Ver Maps  (key, value)

    }
}

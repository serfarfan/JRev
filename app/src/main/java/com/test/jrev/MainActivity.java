package com.test.jrev;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //****************** ATRIBUTOS GLOBALES ******************
    private String ETIQUETA = "Review";
    private List<Integer> numeros = new ArrayList<>();
    CharSequence[] items = {"Google", "Apple", "Microsoft"};
    boolean[] itemsChecked = new boolean[items.length];

    //****************** MÉTODOS DE INSTANCIA ******************
    public void onClick(View v){
        showDialog(0);
    }

    //****************** MÉTODOS OVERRIDE ******************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        /*String[] dias = new String[10];
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
        }*/
        //3. Utilizar un for each
        //4. Ver Maps  (key, value)
    }

    @Override
    protected Dialog onCreateDialog(int id){
        switch (id){
        case 0:
            return new AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_launcher_foreground)
                    .setTitle("Este es un diálogo: ")
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getBaseContext(), "Aceptar fue cliqueado!", Toast.LENGTH_SHORT).show();
                                }
                            }
                    )
                    .setNegativeButton("Cancelar",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getBaseContext(), "Cancelar fue cliqueado!", Toast.LENGTH_SHORT).show();
                                }
                            }
                    )
                    .setMultiChoiceItems(items, itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    Toast.makeText(getBaseContext(),
                                            items[which] + (isChecked ? " Chequeado!" : " No chequeado!"),
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                    ).create();
    }
        return  null;
}
}

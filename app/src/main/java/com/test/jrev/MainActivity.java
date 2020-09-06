package com.test.jrev;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
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
    //Create progressDialog
    ProgressDialog dialog;

    //****************** MÉTODOS DE INSTANCIA ******************
    public void onClick(View v){
        showDialog(0);
    }

    //Método encargado de mostrar el Diálogo de progreso
    public void onClickProgress(View v){
        ProgressDialog.show(this, "Progreso en curso",
                "Por favor espere...", true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //Simular una operación
                    Thread.sleep(5000);
                    //Cerrar el diálogo
                    dialog.dismiss();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onClickModernProgress(View v){
        showDialog(1);
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

            case 1:
                dialog = new ProgressDialog(this);
                dialog.setIcon(R.drawable.ic_launcher_foreground);
                dialog.setTitle("Descargando archivos...");
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Aceptar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getBaseContext(), "Aceptar cliqueado", Toast.LENGTH_SHORT).show();
                            }
                        });

                //Botón para cancelar
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancelar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getBaseContext(), "Cancelar cliqueado", Toast.LENGTH_SHORT).show();
                            }
                        });
                return dialog;
    }
        return  null;
 }
}

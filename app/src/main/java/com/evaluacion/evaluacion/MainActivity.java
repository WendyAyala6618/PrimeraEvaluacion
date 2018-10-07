package com.evaluacion.evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Declaraciones de Variables
    private Button btnnuevo;
    private  Button btnlista;
    public static ArrayList<Estudiante> lstestudiantes;
    public static final int GUARDADOESTUDIANTE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializar las variables
        this.btnnuevo = findViewById(R.id.btnnuevo);
        this.btnlista = findViewById(R.id.btnlista);
        lstestudiantes = new ArrayList<>();

        //Establecemos los listener de los botones
        this.btnnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Agregamos el codigo que queremos que ejecute el programa cuando damos click al boton

                //Abrir la Activity NuevoEstudiante
                Intent nuevo = new Intent(MainActivity.this,NuevoEstudiante.class);
                //es este metodo porque esta activity recibe datos
                startActivityForResult(nuevo,GUARDADOESTUDIANTE);
            }
        });

        this.btnlista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListaEstudiante.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Procesar los datos que se reciben desde las activities
        switch (requestCode){
            case GUARDADOESTUDIANTE:
                if(data==null) return;
                Double promedio = (data.getExtras().getDouble("NOTA1")*0.30)+(data.getExtras().getDouble("NOTA2")*0.30)+(data.getExtras().getDouble("NOTA3")*0.40);
                Estudiante estudiante = new Estudiante(
                       data.getExtras().getString("NOMBRE"),
                        data.getExtras().getString("CODIGO"),
                        data.getExtras().getString("MATERIA"),
                        data.getExtras().getDouble("NOTA1"),
                        data.getExtras().getDouble("NOTA2"),
                        data.getExtras().getDouble("NOTA3"),
                        promedio
                );
                //Agregamos el objeto a la lista de estudiantes
                lstestudiantes.add(estudiante);
                btnlista.setText("LISTA DE ESTUDIANTES " +lstestudiantes.size());
                break;
        }
    }
}

package com.evaluacion.evaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListaEstudiante extends AppCompatActivity {
    //declaracion de variables
    private ListView lstestudiantes;
    private AdaptadorEstudiante adaptadorEstudiante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiante);
        setTitle("Lista de  Estudiantes");
        //inicializacion de variables
        lstestudiantes = findViewById(R.id.listestudiante);
        //inicializo el adaptador que recibe como parametros el constructor y la lista
        adaptadorEstudiante = new AdaptadorEstudiante(ListaEstudiante.this,MainActivity.lstestudiantes);
        //se le establece a el listview el adaptador con los datos a mostrar
        lstestudiantes.setAdapter(adaptadorEstudiante);
    }
}

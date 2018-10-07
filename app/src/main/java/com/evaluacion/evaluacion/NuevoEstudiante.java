package com.evaluacion.evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoEstudiante extends AppCompatActivity {
    //Declaracion de Variables
    private EditText txtnombre;
    private EditText txtcodigo;
    private EditText txtmateria;
    private EditText txtnota1;
    private EditText txtnota2;
    private EditText txtnota3;
    private Button btngurdar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_estudiante);
        setTitle("Formulario Nuevo Estudiante");
        //Inicializar las variables
        this.txtnombre = findViewById(R.id.txtnombre);
        this.txtcodigo = findViewById(R.id.txtcodigo);
        this.txtmateria = findViewById(R.id.txtmateria);
        this.txtnota1 = findViewById(R.id.txtprimer);
        this.txtnota2 = findViewById(R.id.txtsegundo);
        this.txtnota3 = findViewById(R.id.txttercer);
        this.btngurdar = findViewById(R.id.btnguardar);

        this.btngurdar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Vacio()){
                    Toast.makeText(NuevoEstudiante.this,"No deje Campos Vacios",Toast.LENGTH_SHORT).show();
                }else {

                    //Recibir los datos de los controles
                    String Nombre = txtnombre.getText().toString();
                    String Codigo = txtcodigo.getText().toString();
                    String Materia = txtmateria.getText().toString();
                    Double nota1 = Double.parseDouble(txtnota1.getText().toString());
                    Double nota2 = Double.parseDouble(txtnota2.getText().toString());
                    Double nota3 = Double.parseDouble(txtnota3.getText().toString());
                    //Enviando datos a la activity Principal

                    Intent resultado = new Intent();
                    resultado.putExtra("NOMBRE", Nombre);
                    resultado.putExtra("CODIGO", Codigo);
                    resultado.putExtra("MATERIA", Materia);
                    resultado.putExtra("NOTA1", nota1);
                    resultado.putExtra("NOTA2", nota2);
                    resultado.putExtra("NOTA3", nota3);
                    setResult(MainActivity.GUARDADOESTUDIANTE, resultado);
                    finish();
                }
            }
        });
    }

    private  Boolean Vacio(){
        boolean estavacio = false;
        if(txtnombre.getText().toString().isEmpty()) {
            estavacio = true;
        }
        if(txtcodigo.getText().toString().isEmpty()) {
            estavacio = true;
        }
        if(txtmateria.getText().toString().isEmpty()) {
            estavacio = true;
        }
        if(txtnota1.getText().toString().isEmpty()) {
            estavacio = true;
        }
        if(txtnota2.getText().toString().isEmpty()) {
            estavacio = true;
        }
        if(txtnota3.getText().toString().isEmpty()) {
            estavacio = true;
        }
        return estavacio;
    }
}

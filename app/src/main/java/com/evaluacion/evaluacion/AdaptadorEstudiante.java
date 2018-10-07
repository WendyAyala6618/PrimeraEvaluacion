package com.evaluacion.evaluacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorEstudiante extends BaseAdapter {
    //Declaracion de Variables
    private Context context;
    private List<Estudiante> lstestudiantes;

    //Creamos el constructor de la clase

    public AdaptadorEstudiante(Context context, List<Estudiante> lstestudiantes) {
        this.context = context;
        this.lstestudiantes = lstestudiantes;
    }

    //metodo que devuelve el tamaño de la lista
    @Override
    public int getCount() {
        return lstestudiantes.size();
    }

    //retorna el item seleccionado
    @Override
    public Object getItem(int position) {
        return lstestudiantes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //preguntamos si ya hay una vista predifinida
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_estudiante,parent,false);
        }
        //declaracion de variables
        TextView contador = convertView.findViewById(R.id.lblcontador);
        TextView nombre = convertView.findViewById(R.id.lblNombre);
        TextView codigo = convertView.findViewById(R.id.lblCodigo);
        TextView materia = convertView.findViewById(R.id.lblmateria);
        TextView promedio = convertView.findViewById(R.id.lblnota);
        //instancia del nuevo estudiante
        Estudiante estudiante = (Estudiante) getItem(position);

        contador.setText(String.valueOf(position+1));
        nombre.setText(estudiante.Nombre);
        codigo.setText(estudiante.Codigo);
        materia.setText(estudiante.Materia);
        promedio.setText(String.valueOf(estudiante.Promedio));
        return convertView;
    }
}

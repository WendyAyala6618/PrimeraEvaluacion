package com.evaluacion.evaluacion;

public class Estudiante {
    String Nombre;
    String Codigo;
    String Materia;
    Double Parcial1;
    Double Parcial2;
    Double Parcial3;
    Double Promedio;

    public Estudiante(String nombre, String codigo, String materia, Double parcial1, Double parcial2, Double parcial3, Double promedio) {
        Nombre = nombre;
        Codigo = codigo;
        Materia = materia;
        Parcial1 = parcial1;
        Parcial2 = parcial2;
        Parcial3 = parcial3;
        Promedio = promedio;
    }
}

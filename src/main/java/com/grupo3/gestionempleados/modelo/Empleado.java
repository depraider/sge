package com.grupo3.gestionempleados.modelo;

import java.io.Serializable;

public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String apellidos;
    private int edad;
    private String puesto;
    private double salario;

    // Constructor vacío necesario para JAXB
    public Empleado() {
    }

    public Empleado(String nombre, String apellidos, int edad, String puesto, double salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.puesto = puesto;
        this.salario = salario;
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    //Método to String
    @Override
    public String toString() {
        return nombre + " " + apellidos + " - " + puesto;
    }

}

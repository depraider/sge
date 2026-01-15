package com.gestionempleados.modelo;

import com.opencsv.bean.CsvBindByName;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "empleado")
@XmlAccessorType(XmlAccessType.FIELD)
public class Empleado implements Serializable {

  private static final long serialVersionUID = 1L;

  @CsvBindByName(column = "Nombre")
  private String nombre;

  @CsvBindByName(column = "Apellidos")
  private String apellidos;

  @CsvBindByName(column = "Edad")
  private int edad;

  @CsvBindByName(column = "Puesto")
  private String puesto;

  @CsvBindByName(column = "Salario")
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

  // Getters y setters
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

  @Override
  public String toString() {
    return nombre + " " + apellidos + " - " + puesto;
  }

}

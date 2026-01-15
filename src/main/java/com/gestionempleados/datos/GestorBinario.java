package com.gestionempleados.datos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.gestionempleados.modelo.Empleado;

public class GestorBinario {
  public void guardarEmpleados(String ruta, List<Empleado> empleados) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
      oos.writeObject(empleados);
      System.out.println("Fichero binario guardado: " + ruta);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  public List<Empleado> cargarEmpleados(String ruta) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
      return (List<Empleado>) ois.readObject();
    } catch (Exception e) {
      return new ArrayList<>();
    }
  }
}

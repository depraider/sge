package com.gestionempleados.datos;

import com.gestionempleados.modelo.Empleado;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GestorCSV {

  public void guardarEmpleados(String ruta, List<Empleado> empleados) {
    try (Writer writer = new FileWriter(ruta)) {
      StatefulBeanToCsv<Empleado> beanToCsv = new StatefulBeanToCsvBuilder<Empleado>(writer)
          .build();
      beanToCsv.write(empleados);
      System.out.println("Empleados guardados en CSV correctamente: " + ruta);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public List<Empleado> cargarEmpleados(String ruta) {
    try (FileReader reader = new FileReader(ruta)) {
      return new CsvToBeanBuilder<Empleado>(reader)
          .withType(Empleado.class)
          .build()
          .parse();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("No se pudo cargar el CSV (o no existe), devolviendo lista vacía.");
      return new ArrayList<>();
    }
  }
}

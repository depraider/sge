package com.grupo3.gestionempleados;

import com.grupo3.gestionempleados.datos.GestorCSV;
import com.grupo3.gestionempleados.datos.GestorJSON;
import com.grupo3.gestionempleados.datos.GestorXML;
import com.grupo3.gestionempleados.modelo.Empleado;
import com.grupo3.gestionempleados.modelo.ListaEmpleados;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        // Crear datos de prueba
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("Juan", "Pérez", 30, "Desarrollador", 30000));
        empleados.add(new Empleado("Ana", "García", 28, "Diseñadora", 32000));
        empleados.add(new Empleado("Luis", "López", 35, "Gerente", 50000));

        // Directorio de salida
        String outputDir = "datos_generados";
        new File(outputDir).mkdirs();

        // --- PRUEBA CSV ---
        System.out.println("\n--- PRUEBA CSV ---");
        GestorCSV gestorCSV = new GestorCSV();
        String rutaCSV = outputDir + "/empleados.csv";

        // Guardar CSV
        gestorCSV.guardarEmpleados(rutaCSV, empleados);

        // Cargar CSV
        List<Empleado> empleadosCSV = gestorCSV.cargarEmpleados(rutaCSV);
        if (empleadosCSV != null) {
            System.out.println("Empleados cargados desde CSV:");
            for (Empleado e : empleadosCSV) {
                System.out.println(e);
            }
        }

        // --- PRUEBA JSON ---
        System.out.println("\n--- PRUEBA JSON ---");
        GestorJSON gestorJSON = new GestorJSON();
        String rutaJSON = outputDir + "/empleados.json";

        // Guardar JSON
        gestorJSON.guardarEmpleados(rutaJSON, empleados);

        // Cargar JSON
        List<Empleado> empleadosJSON = gestorJSON.cargarEmpleados(rutaJSON);
        if (empleadosJSON != null) {
            System.out.println("Empleados cargados desde JSON:");
            for (Empleado e : empleadosJSON) {
                System.out.println(e);
            }
        }

        // --- PRUEBA XML ---
        System.out.println("\n--- PRUEBA XML ---");
        GestorXML gestorXML = new GestorXML();
        String rutaXML = outputDir + "/empleados.xml";
        ListaEmpleados listaWrapper = new ListaEmpleados(empleados);

        // Guardar XML
        gestorXML.guardarEmpleados(rutaXML, listaWrapper);

        // Cargar XML
        ListaEmpleados loadedWrapper = gestorXML.cargarEmpleados(rutaXML);
        if (loadedWrapper != null && loadedWrapper.getEmpleados() != null) {
            System.out.println("Empleados cargados desde XML:");
            for (Empleado e : loadedWrapper.getEmpleados()) {
                System.out.println(e);
            }
        }
    }
}

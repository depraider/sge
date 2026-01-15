package com.gestionempleados.datos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.gestionempleados.modelo.Empleado;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

public class GestorJSON {

    private final Gson gson;

    public GestorJSON() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void guardarEmpleados(String ruta, List<Empleado> empleados) {
        try (FileWriter writer = new FileWriter(ruta)) {
            gson.toJson(empleados, writer);
            System.out.println("Empleados guardados en JSON correctamente: " + ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Empleado> cargarEmpleados(String ruta) {
        try (FileReader reader = new FileReader(ruta)) {
            Type listType = new TypeToken<List<Empleado>>() {
            }.getType();
            return gson.fromJson(reader, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

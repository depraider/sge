package com.gestionempleados.datos;

import com.gestionempleados.modelo.ListaEmpleados;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class GestorXML {

    public void guardarEmpleados(String ruta, ListaEmpleados listaEmpleados) {
        try {
            JAXBContext context = JAXBContext.newInstance(ListaEmpleados.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(listaEmpleados, new File(ruta));
            System.out.println("Empleados guardados en XML correctamente: " + ruta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ListaEmpleados cargarEmpleados(String ruta) {
        try {
            JAXBContext context = JAXBContext.newInstance(ListaEmpleados.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (ListaEmpleados) unmarshaller.unmarshal(new File(ruta));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

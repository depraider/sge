package com.grupo3.gestionempleados.modelo;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "empleados")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaEmpleados {

    @XmlElement(name = "empleado")
    private List<Empleado> empleados;

    public ListaEmpleados() {
    }

    public ListaEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}

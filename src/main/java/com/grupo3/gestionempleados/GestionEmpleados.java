package com.grupo3.gestionempleados;

import com.grupo3.gestionempleados.vista.VistaEmpleados;
import javax.swing.SwingUtilities;

public class GestionEmpleados {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VistaEmpleados().setVisible(true);
        });
    }
}

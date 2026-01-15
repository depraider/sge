package com.gestionempleados;

import javax.swing.SwingUtilities;

import com.gestionempleados.vista.VistaEmpleados;

public class GestionEmpleados {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VistaEmpleados().setVisible(true);
        });
    }
}

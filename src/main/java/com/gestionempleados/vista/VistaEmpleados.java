package com.gestionempleados.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.gestionempleados.datos.GestorBinario;
import com.gestionempleados.datos.GestorCSV;
import com.gestionempleados.datos.GestorJSON;
import com.gestionempleados.datos.GestorXML;
import com.gestionempleados.modelo.Empleado;
import com.gestionempleados.modelo.ListaEmpleados;

public class VistaEmpleados extends javax.swing.JFrame {

    private ArrayList<Empleado> empleados = new ArrayList<>();
    private DefaultTableModel modeloTabla;

    // Componentes visuales
    private JTextField jTextField1; // Nombre
    private JTextField jTextField2; // Apellidos
    private JTextField jTextField3; // Edad
    private JTextField jTextField4; // Puesto
    private JTextField jTextField5; // Salario
    private JButton jButton1; // Add
    private JButton jButton2; // Modificar
    private JButton jButton3; // Eliminar
    private JButton jButton4; // Guardar
    private JButton jButton5; // Cargar
    private JTable jTable1;
    private JScrollPane jScrollPane1;

    public VistaEmpleados() {
        initComponents(); // Carga el diseño nuevo

        // Inicializar el modelo de la tabla
        modeloTabla = new DefaultTableModel(new String[]{"Nombre", "Apellidos", "Edad", "Puesto", "Salario"}, 0);
        jTable1.setModel(modeloTabla);

        // Listener para rellenar los campos al hacer clic en la tabla
        jTable1.getSelectionModel().addListSelectionListener(e -> {
            int fila = jTable1.getSelectedRow();
            if (fila >= 0 && fila < empleados.size()) {
                Empleado emp = empleados.get(fila);
                jTextField1.setText(emp.getNombre());
                jTextField2.setText(emp.getApellidos());
                jTextField3.setText(String.valueOf(emp.getEdad()));
                jTextField4.setText(emp.getPuesto());
                jTextField5.setText(String.valueOf(emp.getSalario()));
            }
        });

        // Activar botones de Guardar y Cargar
        iniciarListeners();
    }

    /**
     * Método de diseño reescrito manualmente para dividir la pantalla.
     */
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Empleados - DISEÑO NUEVO"); // Título cambiado para verificar actualización
        setSize(1000, 600); // Tamaño inicial más grande
        setLocationRelativeTo(null); // Centrar en pantalla

        // 1. Layout Principal: BorderLayout es mejor para paneles laterales
        setLayout(new BorderLayout());

        // --- PANEL IZQUIERDO (Formulario) ---
        JPanel panelIzquierdo = new JPanel(new GridBagLayout());
        panelIzquierdo.setPreferredSize(new Dimension(400, 0)); // Ancho fijo de 400px
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes
        panelIzquierdo.setBackground(new Color(245, 245, 245)); // Color gris claro de fondo

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5); // Más espacio vertical entre elementos
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // Título
        JLabel lblTitulo = new JLabel("DATOS DEL EMPLEADO");
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panelIzquierdo.add(lblTitulo, gbc);

        // Reset gridwidth
        gbc.gridwidth = 1;

        // Campo Nombre
        gbc.gridx = 0; gbc.gridy = 1;
        panelIzquierdo.add(new JLabel("Nombre:"), gbc);
        jTextField1 = new JTextField();
        gbc.gridx = 1;
        panelIzquierdo.add(jTextField1, gbc);

        // Campo Apellidos
        gbc.gridx = 0; gbc.gridy = 2;
        panelIzquierdo.add(new JLabel("Apellidos:"), gbc);
        jTextField2 = new JTextField();
        gbc.gridx = 1;
        panelIzquierdo.add(jTextField2, gbc);

        // Campo Edad
        gbc.gridx = 0; gbc.gridy = 3;
        panelIzquierdo.add(new JLabel("Edad:"), gbc);
        jTextField3 = new JTextField();
        gbc.gridx = 1;
        panelIzquierdo.add(jTextField3, gbc);

        // Campo Puesto
        gbc.gridx = 0; gbc.gridy = 4;
        panelIzquierdo.add(new JLabel("Puesto:"), gbc);
        jTextField4 = new JTextField();
        gbc.gridx = 1;
        panelIzquierdo.add(jTextField4, gbc);

        // Campo Salario
        gbc.gridx = 0; gbc.gridy = 5;
        panelIzquierdo.add(new JLabel("Salario:"), gbc);
        jTextField5 = new JTextField();
        gbc.gridx = 1;
        panelIzquierdo.add(jTextField5, gbc);

        // Separador visual
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        panelIzquierdo.add(new javax.swing.JSeparator(), gbc);

        // Panel de Botones CRUD (Añadir, Modificar, Eliminar)
        JPanel panelBotonesCRUD = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotonesCRUD.setOpaque(false);
        jButton1 = new JButton("Añadir");
        jButton2 = new JButton("Modificar");
        jButton3 = new JButton("Eliminar");
        panelBotonesCRUD.add(jButton1);
        panelBotonesCRUD.add(jButton2);
        panelBotonesCRUD.add(jButton3);

        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2; gbc.insets = new Insets(20, 5, 5, 5);
        panelIzquierdo.add(panelBotonesCRUD, gbc);

        // Panel de Botones Archivos (Guardar, Cargar)
        JPanel panelBotonesArchivos = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotonesArchivos.setOpaque(false);
        jButton4 = new JButton("GUARDAR");
        jButton5 = new JButton("CARGAR");
        // Colores para destacar
        jButton4.setBackground(new Color(200, 220, 240));
        jButton5.setBackground(new Color(200, 220, 240));
        panelBotonesArchivos.add(jButton4);
        panelBotonesArchivos.add(jButton5);

        gbc.gridy = 8;
        panelIzquierdo.add(panelBotonesArchivos, gbc);


        // --- PANEL DERECHO (Tabla) ---
        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.setBorder(BorderFactory.createTitledBorder(" Listado Completo de Empleados "));

        jTable1 = new JTable();
        // Configuración básica de tabla
        jTable1.setRowHeight(25);
        jTable1.getTableHeader().setReorderingAllowed(false);

        jScrollPane1 = new JScrollPane(jTable1);
        panelDerecho.add(jScrollPane1, BorderLayout.CENTER);


        // Añadir los dos paneles a la ventana usando BorderLayout
        // WEST = Izquierda, CENTER = Rellena el resto
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.CENTER);

        // Configurar acciones de botones CRUD
        configurarAccionesCRUD();
    }

    private void configurarAccionesCRUD() {
        // ADD
        jButton1.addActionListener(evt -> {
            try {
                String nombre = jTextField1.getText();
                String apellidos = jTextField2.getText();
                int edad = Integer.parseInt(jTextField3.getText());
                String puesto = jTextField4.getText();
                double salario = Double.parseDouble(jTextField5.getText());

                Empleado emp = new Empleado(nombre, apellidos, edad, puesto, salario);
                empleados.add(emp);
                modeloTabla.addRow(new Object[]{nombre, apellidos, edad, puesto, salario});
                limpiarCampos();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Edad y salario deben ser números", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // MODIFICAR
        jButton2.addActionListener(evt -> {
            int fila = jTable1.getSelectedRow();
            if (fila >= 0) {
                try {
                    Empleado emp = empleados.get(fila);
                    emp.setNombre(jTextField1.getText());
                    emp.setApellidos(jTextField2.getText());
                    emp.setEdad(Integer.parseInt(jTextField3.getText()));
                    emp.setPuesto(jTextField4.getText());
                    emp.setSalario(Double.parseDouble(jTextField5.getText()));

                    modeloTabla.setValueAt(emp.getNombre(), fila, 0);
                    modeloTabla.setValueAt(emp.getApellidos(), fila, 1);
                    modeloTabla.setValueAt(emp.getEdad(), fila, 2);
                    modeloTabla.setValueAt(emp.getPuesto(), fila, 3);
                    modeloTabla.setValueAt(emp.getSalario(), fila, 4);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Edad y salario deben ser números", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un empleado para modificar", "Atención", JOptionPane.WARNING_MESSAGE);
            }
        });

        // ELIMINAR
        jButton3.addActionListener(evt -> {
            int fila = jTable1.getSelectedRow();
            if (fila >= 0) {
                empleados.remove(fila);
                modeloTabla.removeRow(fila);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un empleado para eliminar", "Atención", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private void limpiarCampos() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
    }

    // --- LÓGICA DE FICHEROS (INTEGRACIÓN) ---
    private void iniciarListeners() {
        jButton4.addActionListener(e -> accionGuardar());
        jButton5.addActionListener(e -> accionCargar());
    }

    private void accionGuardar() {
        String[] opciones = {"JSON", "XML", "CSV", "BINARIO"};
        int seleccion = JOptionPane.showOptionDialog(this, "¿En qué formato quieres guardar?", "Guardar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion < 0) return;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar fichero");

        String extension = switch (seleccion) {
            case 0 -> ".json";
            case 1 -> ".xml";
            case 2 -> ".csv";
            case 3 -> ".dat";
            default -> "";
        };
        fileChooser.setSelectedFile(new File("empleados" + extension));

        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            if (!ruta.endsWith(extension)) ruta += extension;

            switch (seleccion) {
                case 0 -> new GestorJSON().guardarEmpleados(ruta, empleados);
                case 1 -> new GestorXML().guardarEmpleados(ruta, new ListaEmpleados(empleados));
                case 2 -> new GestorCSV().guardarEmpleados(ruta, empleados);
                case 3 -> new GestorBinario().guardarEmpleados(ruta, empleados);
            }
            JOptionPane.showMessageDialog(this, "Guardado correctamente en " + extension);
        }
    }

    private void accionCargar() {
        String[] opciones = {"JSON", "XML", "CSV", "BINARIO"};
        int seleccion = JOptionPane.showOptionDialog(this, "¿Qué formato quieres cargar?", "Cargar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion < 0) return;

        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            List<Empleado> listaCargada = new ArrayList<>();

            switch (seleccion) {
                case 0 -> listaCargada = new GestorJSON().cargarEmpleados(ruta);
                case 1 -> {
                    ListaEmpleados wrapper = new GestorXML().cargarEmpleados(ruta);
                    if (wrapper != null) listaCargada = wrapper.getEmpleados();
                }
                case 2 -> listaCargada = new GestorCSV().cargarEmpleados(ruta);
                case 3 -> listaCargada = new GestorBinario().cargarEmpleados(ruta);
            }

            empleados = (ArrayList<Empleado>) listaCargada;
            actualizarTablaVisual();
            JOptionPane.showMessageDialog(this, "Datos cargados: " + empleados.size() + " empleados.");
        }
    }

    private void actualizarTablaVisual() {
        modeloTabla.setRowCount(0);
        for (Empleado emp : empleados) {
            modeloTabla.addRow(new Object[]{
                    emp.getNombre(), emp.getApellidos(), emp.getEdad(), emp.getPuesto(), emp.getSalario()
            });
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new VistaEmpleados().setVisible(true);
        });
    }
}

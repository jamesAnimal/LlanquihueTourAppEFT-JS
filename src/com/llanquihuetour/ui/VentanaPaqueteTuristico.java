package com.llanquihuetour.ui;

import com.llanquihuetour.data.GestorCatalogo;
import com.llanquihuetour.model.GuiaTuristico;
import com.llanquihuetour.model.PaqueteTuristico;
import com.llanquihuetour.model.ProveedorAlojamiento;
import com.llanquihuetour.model.ProveedorTransporte;
import com.llanquihuetour.util.CargadorCombobox;
import com.llanquihuetour.util.ValidadorGeneral;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Clase que representa la interfaz gráfica para registrar un Paquete Turístico.
 * @author Jaime Seguel.
 * @since Semana 9
 */
public class VentanaPaqueteTuristico extends JDialog {

    // Declaración de los elementos de la ventana.
    private JPanel ventanaPaquete;
    private JButton btnRegistrarPaquete;
    private JTextField txtNombre;
    private JTextField txtFechas;
    private JComboBox cmbActividad1;
    private JComboBox cmbActividad2;
    private JComboBox cmbActividad3;
    private JComboBox cmbTransporte;
    private JComboBox cmbAlojamiento;
    private JComboBox cmbGuia;
    private JTextField txtPrecio;
    private JButton btnCancelarRegistro;
    private JLabel lblNombre;
    private JLabel lblFechas;
    private JLabel lblActividad1;
    private JLabel lblActividad2;
    private JLabel lblActividad3;
    private JLabel lblTransporte;
    private JLabel lblAlojamiento;
    private JLabel lblGuia;
    private JLabel lblPrecio;
    private JPanel contenedorBtns;

    /**
     * Constructor de la Ventana Paquete Turístico.
     * @param parent Ventana padre desde donde se invoca.
     */
    public VentanaPaqueteTuristico(JDialog parent) {

        super(parent, "Registrar Paquete Turístico", true);
        this.setContentPane(ventanaPaquete);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(parent);

        // Evento del botón Cancelar.
        btnCancelarRegistro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        // Evento del botón Registrar.
        btnRegistrarPaquete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                registrarPaquete();
            }
        });

        // Bucles que recorren la listas (personas/catalogo) y cargan directamente los datos en cada combobox según el tipo .
        com.llanquihuetour.data.GestorPersonas gestorPersonas = new com.llanquihuetour.data.GestorPersonas();

        for (com.llanquihuetour.model.Persona persona : gestorPersonas.getListaPersonas()) {

            if (persona instanceof com.llanquihuetour.model.ProveedorAlojamiento) cmbAlojamiento.addItem(persona.getNombre());
            else if (persona instanceof com.llanquihuetour.model.ProveedorTransporte) cmbTransporte.addItem(persona.getNombre());
            else if (persona instanceof com.llanquihuetour.model.GuiaTuristico) cmbGuia.addItem(persona.getNombre());
        }

        com.llanquihuetour.data.GestorCatalogo gestorCatalogo = new com.llanquihuetour.data.GestorCatalogo();
        cmbActividad1.addItem("Ninguno");
        cmbActividad2.addItem("Ninguno");
        cmbActividad3.addItem("Ninguno");

        for (com.llanquihuetour.model.Registrable r : gestorCatalogo.getListaCatalogo()) {

            if (r instanceof com.llanquihuetour.model.ServicioTuristico) {
                com.llanquihuetour.model.ServicioTuristico s = (com.llanquihuetour.model.ServicioTuristico) r;
                cmbActividad1.addItem(s.getNombre());
                cmbActividad2.addItem(s.getNombre());
                cmbActividad3.addItem(s.getNombre());
            }
        }
    }

    /**
     * Método que extrae, valida y guarda los datos del paquete turístico en un .txt.
     */
    private void registrarPaquete() {

        String nombre = txtNombre.getText();
        String fechas = txtFechas.getText();
        String precioStr = txtPrecio.getText();

        if (ValidadorGeneral.validarCamposVacios(nombre, fechas, precioStr)) {

            return;
        }

        int precio = ValidadorGeneral.validarEntero(precioStr, "Precio");

        if (precio == -1) {

            return;
        }

        String actividad1 = "Ninguno";

        if (cmbActividad1.getSelectedItem() != null) {

            actividad1 = cmbActividad1.getSelectedItem().toString();
        }
        
        String actividad2 = "Ninguno";

        if (cmbActividad2.getSelectedItem() != null) {

            actividad2 = cmbActividad2.getSelectedItem().toString();
        }
        
        String actividad3 = "Ninguno";

        if (cmbActividad3.getSelectedItem() != null) {

            actividad3 = cmbActividad3.getSelectedItem().toString();
        }

        ProveedorAlojamiento alojamiento = new ProveedorAlojamiento();

        if (cmbAlojamiento.getSelectedItem() != null) {

            alojamiento.setNombre(cmbAlojamiento.getSelectedItem().toString());

        } else {

            alojamiento.setNombre("Sin Alojamiento");
        }

        ProveedorTransporte transporte = new ProveedorTransporte();

        if (cmbTransporte.getSelectedItem() != null) {

            transporte.setNombre(cmbTransporte.getSelectedItem().toString());

        } else {

            transporte.setNombre("Sin Transporte");
        }

        GuiaTuristico guia = new GuiaTuristico();

        if (cmbGuia.getSelectedItem() != null) {

            guia.setNombre(cmbGuia.getSelectedItem().toString());

        } else {

            guia.setNombre("Sin Guía");
        }

        PaqueteTuristico paquete = new PaqueteTuristico();
        paquete.setNombre(nombre);
        paquete.setFechas(fechas);
        paquete.setPrecio(precio);
        paquete.setActividad1(actividad1);
        paquete.setActividad2(actividad2);
        paquete.setActividad3(actividad3);
        paquete.setAlojamiento(alojamiento);
        paquete.setTransporte(transporte);
        paquete.setGuiaAsignado(guia);

        GestorCatalogo gestor = new GestorCatalogo();
        gestor.agregarProducto(paquete);

        JOptionPane.showMessageDialog(this, "Paquete Turístico registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        ventanaPaquete = new JPanel();
        ventanaPaquete.setLayout(new GridBagLayout());
        lblNombre = new JLabel();
        lblNombre.setText("Nombre: ");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(lblNombre, gbc);
        lblFechas = new JLabel();
        lblFechas.setText("Fechas: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(lblFechas, gbc);
        lblActividad1 = new JLabel();
        lblActividad1.setText("Actividad 1: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(lblActividad1, gbc);
        lblActividad2 = new JLabel();
        lblActividad2.setText("Actividad 2: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(lblActividad2, gbc);
        lblActividad3 = new JLabel();
        lblActividad3.setText("Actividad 3: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(lblActividad3, gbc);
        lblTransporte = new JLabel();
        lblTransporte.setText("Transporte: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(lblTransporte, gbc);
        lblAlojamiento = new JLabel();
        lblAlojamiento.setText("Alojamiento: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(lblAlojamiento, gbc);
        lblGuia = new JLabel();
        lblGuia.setText("Guía Asignado: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(lblGuia, gbc);
        lblPrecio = new JLabel();
        lblPrecio.setText("Precio Total ($): ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(lblPrecio, gbc);
        txtNombre = new JTextField();
        txtNombre.setMaximumSize(new Dimension(350, 30));
        txtNombre.setMinimumSize(new Dimension(350, 30));
        txtNombre.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(txtNombre, gbc);
        txtFechas = new JTextField();
        txtFechas.setMaximumSize(new Dimension(350, 30));
        txtFechas.setMinimumSize(new Dimension(350, 30));
        txtFechas.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(txtFechas, gbc);
        cmbActividad1 = new JComboBox();
        cmbActividad1.setMaximumSize(new Dimension(350, 30));
        cmbActividad1.setMinimumSize(new Dimension(350, 30));
        cmbActividad1.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(cmbActividad1, gbc);
        cmbActividad2 = new JComboBox();
        cmbActividad2.setMaximumSize(new Dimension(350, 30));
        cmbActividad2.setMinimumSize(new Dimension(350, 30));
        cmbActividad2.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(cmbActividad2, gbc);
        cmbActividad3 = new JComboBox();
        cmbActividad3.setMaximumSize(new Dimension(350, 30));
        cmbActividad3.setMinimumSize(new Dimension(350, 30));
        cmbActividad3.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(cmbActividad3, gbc);
        cmbTransporte = new JComboBox();
        cmbTransporte.setMaximumSize(new Dimension(350, 30));
        cmbTransporte.setMinimumSize(new Dimension(350, 30));
        cmbTransporte.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(cmbTransporte, gbc);
        cmbAlojamiento = new JComboBox();
        cmbAlojamiento.setMaximumSize(new Dimension(350, 30));
        cmbAlojamiento.setMinimumSize(new Dimension(350, 30));
        cmbAlojamiento.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(cmbAlojamiento, gbc);
        cmbGuia = new JComboBox();
        cmbGuia.setMaximumSize(new Dimension(350, 30));
        cmbGuia.setMinimumSize(new Dimension(350, 30));
        cmbGuia.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(cmbGuia, gbc);
        txtPrecio = new JTextField();
        txtPrecio.setMaximumSize(new Dimension(350, 30));
        txtPrecio.setMinimumSize(new Dimension(350, 30));
        txtPrecio.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaPaquete.add(txtPrecio, gbc);
        contenedorBtns = new JPanel();
        contenedorBtns.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        ventanaPaquete.add(contenedorBtns, gbc);
        btnRegistrarPaquete = new JButton();
        btnRegistrarPaquete.setText("Registrar Paquete Turistico");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenedorBtns.add(btnRegistrarPaquete, gbc);
        btnCancelarRegistro = new JButton();
        btnCancelarRegistro.setText("Cancelar Registro");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenedorBtns.add(btnCancelarRegistro, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return ventanaPaquete;
    }

}

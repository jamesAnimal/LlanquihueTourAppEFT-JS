package com.llanquihuetour.ui;

import com.llanquihuetour.data.GestorPersonas;
import com.llanquihuetour.model.ProveedorTransporte;
import com.llanquihuetour.model.Direccion;
import com.llanquihuetour.util.CargadorCombobox;
import com.llanquihuetour.util.RutInvalidoException;
import com.llanquihuetour.util.ValidadorGeneral;
import com.llanquihuetour.util.ValidadorRut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Clase que representa la interfaz gráfica para registrar un Proveedor de Transporte.
 * @author Jaime Seguel.
 * @since Semana 9
 */
public class VentanaTransporte extends JDialog {

    // Declaración de los elementos de la ventana.
    private JPanel ventanaTransporte;
    private JTextField txtNombre;
    private JTextField txtRut;
    private JTextField txtTelefono;
    private JComboBox cmbRegion;
    private JComboBox cmbCiudad;
    private JTextField txtCalle;
    private JTextField txtNumeroCasa;
    private JTextField txtSitioWeb;
    private JTextField txtTarifa;
    private JTextField txtTipoVehiculos;
    private JTextField txtCantidadVehiculos;
    private JTextField txtPasajeros;
    private JButton registrarTransporteButton;
    private JButton btnCancelarRegistro;
    private JButton btnRegistrarTransporte;
    private JLabel lblNombre;
    private JLabel lblRut;
    private JLabel lblTelefono;
    private JLabel lblRegion;
    private JLabel lblCiudad;
    private JLabel lblCalle;
    private JLabel lblNumeroCasa;
    private JLabel lblSitioWeb;
    private JLabel lblTarifa;
    private JLabel lblTipoVehiculos;
    private JLabel lblCantidadVehiculos;
    private JLabel lblPasajeros;
    private JPanel contenedorBtns;

    /**
     * Constructor de la Ventana Proveedor de Transporte.
     * @param parent Ventana padre desde donde se invoca.
     */
    public VentanaTransporte(JDialog parent) {

        super(parent, "Registrar Proveedor de Transporte", true);
        this.setContentPane(ventanaTransporte);
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
        btnRegistrarTransporte.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                registrarTransportista();
            }
        });

        // // Llama al método que carga los combobox de region y ciudad al iniciar la ventana.
        CargadorCombobox.cargarRegiones(cmbRegion);
        CargadorCombobox.actualizarCiudades(cmbRegion.getSelectedItem().toString(), cmbCiudad);

        // Actualización dinámica de ciudades al cambiar región.
        cmbRegion.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    CargadorCombobox.actualizarCiudades(e.getItem().toString(), cmbCiudad);
                }
            }
        });
    }

    /**
     * Método que extrae, valida y guarda los datos del proveedor de transporte.
     */
    private void registrarTransportista() {

        String nombre = txtNombre.getText();
        String rut = txtRut.getText();
        String telefono = txtTelefono.getText();
        String region = cmbRegion.getSelectedItem().toString();
        String ciudad = cmbCiudad.getSelectedItem().toString();
        String calle = txtCalle.getText();
        String numero = txtNumeroCasa.getText();
        String sitioWeb = txtSitioWeb.getText();
        String tarifaStr = txtTarifa.getText();
        String tipoVehiculo = txtTipoVehiculos.getText();
        String cantidadStr = txtCantidadVehiculos.getText();
        String pasajerosStr = txtPasajeros.getText();

        if (ValidadorGeneral.validarCamposVacios(nombre, rut, telefono, calle, numero, sitioWeb, tarifaStr, tipoVehiculo, cantidadStr, pasajerosStr)) {

            return;
        }

        if (!ValidadorGeneral.validarTelefono(telefono)) {

            return;
        }

        int tarifa = ValidadorGeneral.validarEntero(tarifaStr, "Tarifa Base");

        if (tarifa == -1) {

            return;
        }

        int cantidad = ValidadorGeneral.validarEntero(cantidadStr, "Cantidad de Vehículos");

        if (cantidad == -1) {

            return;
        }

        int pasajeros = ValidadorGeneral.validarEntero(pasajerosStr, "Capacidad Pasajeros");

        if (pasajeros == -1) {

            return;
        }

        if (ValidadorRut.validarRutGUI(rut) == null) {
            return;
        }

        Direccion direccion = new Direccion(calle, numero, ciudad, region);
        ProveedorTransporte transporte = new ProveedorTransporte(sitioWeb, tarifa, nombre, rut, telefono, direccion, tipoVehiculo, cantidad, pasajeros);

        GestorPersonas gestor = new GestorPersonas();
        gestor.agregarPersona(transporte);

        JOptionPane.showMessageDialog(this, "Proveedor de Transporte registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
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
        ventanaTransporte = new JPanel();
        ventanaTransporte.setLayout(new GridBagLayout());
        lblNombre = new JLabel();
        lblNombre.setText("Nombre: ");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(lblNombre, gbc);
        lblRut = new JLabel();
        lblRut.setText("R.U.T: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(lblRut, gbc);
        lblTelefono = new JLabel();
        lblTelefono.setText("Teléfono: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(lblTelefono, gbc);
        lblRegion = new JLabel();
        lblRegion.setText("Región: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(lblRegion, gbc);
        lblCiudad = new JLabel();
        lblCiudad.setText("Ciudad: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(lblCiudad, gbc);
        lblCalle = new JLabel();
        lblCalle.setText("Calle: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(lblCalle, gbc);
        lblNumeroCasa = new JLabel();
        lblNumeroCasa.setText("Número de Casa: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(lblNumeroCasa, gbc);
        lblSitioWeb = new JLabel();
        lblSitioWeb.setText("Sitio Web: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(lblSitioWeb, gbc);
        lblTarifa = new JLabel();
        lblTarifa.setText("Tarifa ($): ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(lblTarifa, gbc);
        lblTipoVehiculos = new JLabel();
        lblTipoVehiculos.setText("Tipo de Vehículos: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(lblTipoVehiculos, gbc);
        lblCantidadVehiculos = new JLabel();
        lblCantidadVehiculos.setText("Cantidad de Vehículos: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(lblCantidadVehiculos, gbc);
        lblPasajeros = new JLabel();
        lblPasajeros.setText("Pasajeros por Vehículo: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(lblPasajeros, gbc);
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
        ventanaTransporte.add(txtNombre, gbc);
        txtRut = new JTextField();
        txtRut.setMaximumSize(new Dimension(350, 30));
        txtRut.setMinimumSize(new Dimension(350, 30));
        txtRut.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(txtRut, gbc);
        txtTelefono = new JTextField();
        txtTelefono.setMaximumSize(new Dimension(350, 30));
        txtTelefono.setMinimumSize(new Dimension(350, 30));
        txtTelefono.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(txtTelefono, gbc);
        cmbRegion = new JComboBox();
        cmbRegion.setMaximumSize(new Dimension(350, 30));
        cmbRegion.setMinimumSize(new Dimension(350, 30));
        cmbRegion.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(cmbRegion, gbc);
        cmbCiudad = new JComboBox();
        cmbCiudad.setMaximumSize(new Dimension(350, 30));
        cmbCiudad.setMinimumSize(new Dimension(350, 30));
        cmbCiudad.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(cmbCiudad, gbc);
        txtCalle = new JTextField();
        txtCalle.setMaximumSize(new Dimension(350, 30));
        txtCalle.setMinimumSize(new Dimension(350, 30));
        txtCalle.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(txtCalle, gbc);
        txtNumeroCasa = new JTextField();
        txtNumeroCasa.setMaximumSize(new Dimension(350, 30));
        txtNumeroCasa.setMinimumSize(new Dimension(350, 30));
        txtNumeroCasa.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(txtNumeroCasa, gbc);
        txtSitioWeb = new JTextField();
        txtSitioWeb.setMaximumSize(new Dimension(350, 30));
        txtSitioWeb.setMinimumSize(new Dimension(350, 30));
        txtSitioWeb.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(txtSitioWeb, gbc);
        txtTarifa = new JTextField();
        txtTarifa.setMaximumSize(new Dimension(350, 30));
        txtTarifa.setMinimumSize(new Dimension(350, 30));
        txtTarifa.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(txtTarifa, gbc);
        txtTipoVehiculos = new JTextField();
        txtTipoVehiculos.setMaximumSize(new Dimension(350, 30));
        txtTipoVehiculos.setMinimumSize(new Dimension(350, 30));
        txtTipoVehiculos.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(txtTipoVehiculos, gbc);
        txtCantidadVehiculos = new JTextField();
        txtCantidadVehiculos.setMaximumSize(new Dimension(350, 30));
        txtCantidadVehiculos.setMinimumSize(new Dimension(350, 30));
        txtCantidadVehiculos.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(txtCantidadVehiculos, gbc);
        txtPasajeros = new JTextField();
        txtPasajeros.setMaximumSize(new Dimension(350, 30));
        txtPasajeros.setMinimumSize(new Dimension(350, 30));
        txtPasajeros.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaTransporte.add(txtPasajeros, gbc);
        contenedorBtns = new JPanel();
        contenedorBtns.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        ventanaTransporte.add(contenedorBtns, gbc);
        btnRegistrarTransporte = new JButton();
        btnRegistrarTransporte.setText("Registrar Transporte");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenedorBtns.add(btnRegistrarTransporte, gbc);
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
        return ventanaTransporte;
    }

}

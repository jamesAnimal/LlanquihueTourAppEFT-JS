package com.llanquihuetour.ui;

import com.llanquihuetour.data.GestorPersonas;
import com.llanquihuetour.model.ProveedorAlojamiento;
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
 * Clase que representa la interfaz gráfica para registrar un Proveedor de Alojamiento.
 * @author Jaime Seguel.
 * @since Semana 9
 */
public class VentanaAlojamiento extends JDialog {

    // Declaración de los elementos de la ventana.
    private JLabel lblNombre;
    private JLabel lblRut;
    private JLabel lblTelefono;
    private JLabel lblRegion;
    private JLabel lblCiudad;
    private JLabel lblCalle;
    private JLabel lblNumeroCasa;
    private JLabel lblSitioWeb;
    private JLabel lblTarifa;
    private JLabel lblTipoAlojamiento;
    private JLabel lblCapacidad;
    private JLabel lblAlimentacion;
    private JTextField txtNombre;
    private JTextField txtRut;
    private JTextField txtTelefono;
    private JComboBox cmbRegion;
    private JComboBox cmbCiudad;
    private JTextField txtCalle;
    private JTextField txtNumeroCasa;
    private JTextField txtSitioWeb;
    private JTextField txtTarifa;
    private JTextField txtTipoAlojamiento;
    private JTextField txtCapacidad;
    private JTextField txtAlimentacion;
    private JButton btnRegistrarAlojamiento;
    private JButton btnCancelarRegistro;
    private JPanel ventanaAlojamiento;
    private JPanel contenedorBtns;

    /**
     * Constructor de la Ventana Proveedor de Alojamiento.
     * @param parent Ventana padre desde donde se invoca.
     */
    public VentanaAlojamiento(JDialog parent) {

        super(parent, "Registrar Proveedor de Alojamiento", true);
        this.setContentPane(ventanaAlojamiento);
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
        btnRegistrarAlojamiento.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                registrarAlojamiento();
            }
        });

        // Llama al método que carga los combobox de region y ciudad al iniciar la ventana.
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
     * Método que extrae, valida y guarda los datos del proveedor de alojamiento en un .txt.
     */
    private void registrarAlojamiento() {

        String nombre = txtNombre.getText();
        String rut = txtRut.getText();
        String telefono = txtTelefono.getText();
        String region = cmbRegion.getSelectedItem().toString();
        String ciudad = cmbCiudad.getSelectedItem().toString();
        String calle = txtCalle.getText();
        String numero = txtNumeroCasa.getText();
        String sitioWeb = txtSitioWeb.getText();
        String tarifaStr = txtTarifa.getText();
        String tipo = txtTipoAlojamiento.getText();
        String capacidadStr = txtCapacidad.getText();
        String regimen = txtAlimentacion.getText();

        if (ValidadorGeneral.validarCamposVacios(nombre, rut, telefono, calle, numero, sitioWeb, tarifaStr, tipo, capacidadStr, regimen)) {
            return;
        }

        if (!ValidadorGeneral.validarTelefono(telefono)) {
            return;
        }

        int tarifa = ValidadorGeneral.validarEntero(tarifaStr, "Tarifa Base");
        if (tarifa == -1) {
            return;
        }

        int capacidad = ValidadorGeneral.validarEntero(capacidadStr, "Capacidad Máxima");
        if (capacidad == -1) {
            return;
        }

        if (ValidadorRut.validarRutGUI(rut) == null) {
            return;
        }

        Direccion direccion = new Direccion(calle, numero, ciudad, region);
        ProveedorAlojamiento alojamiento = new ProveedorAlojamiento(sitioWeb, tarifa, nombre, rut, telefono, direccion, tipo, capacidad, regimen);

        GestorPersonas gestor = new GestorPersonas();
        gestor.agregarPersona(alojamiento);

        JOptionPane.showMessageDialog(this, "Proveedor de Alojamiento registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
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
        ventanaAlojamiento = new JPanel();
        ventanaAlojamiento.setLayout(new GridBagLayout());
        lblNombre = new JLabel();
        lblNombre.setText("Nombre: ");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(lblNombre, gbc);
        lblRut = new JLabel();
        lblRut.setText("R.U.T: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(lblRut, gbc);
        lblTelefono = new JLabel();
        lblTelefono.setText("Teléfono: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(lblTelefono, gbc);
        lblRegion = new JLabel();
        lblRegion.setText("Región: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(lblRegion, gbc);
        lblCiudad = new JLabel();
        lblCiudad.setText("Ciudad: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(lblCiudad, gbc);
        lblCalle = new JLabel();
        lblCalle.setText("Calle: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(lblCalle, gbc);
        lblNumeroCasa = new JLabel();
        lblNumeroCasa.setText("Número de Casa: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(lblNumeroCasa, gbc);
        lblSitioWeb = new JLabel();
        lblSitioWeb.setText("Sitio Web: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(lblSitioWeb, gbc);
        lblTarifa = new JLabel();
        lblTarifa.setText("Tarifa ($): ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(lblTarifa, gbc);
        lblTipoAlojamiento = new JLabel();
        lblTipoAlojamiento.setText("Tipo de Alojamiento: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(lblTipoAlojamiento, gbc);
        lblCapacidad = new JLabel();
        lblCapacidad.setText("Capacidad Total: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(lblCapacidad, gbc);
        lblAlimentacion = new JLabel();
        lblAlimentacion.setText("¿Incluye Alimentación?:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(lblAlimentacion, gbc);
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
        ventanaAlojamiento.add(txtNombre, gbc);
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
        ventanaAlojamiento.add(txtRut, gbc);
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
        ventanaAlojamiento.add(txtTelefono, gbc);
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
        ventanaAlojamiento.add(cmbRegion, gbc);
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
        ventanaAlojamiento.add(cmbCiudad, gbc);
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
        ventanaAlojamiento.add(txtCalle, gbc);
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
        ventanaAlojamiento.add(txtNumeroCasa, gbc);
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
        ventanaAlojamiento.add(txtSitioWeb, gbc);
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
        ventanaAlojamiento.add(txtTarifa, gbc);
        txtTipoAlojamiento = new JTextField();
        txtTipoAlojamiento.setMaximumSize(new Dimension(350, 30));
        txtTipoAlojamiento.setMinimumSize(new Dimension(350, 30));
        txtTipoAlojamiento.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(txtTipoAlojamiento, gbc);
        txtCapacidad = new JTextField();
        txtCapacidad.setMaximumSize(new Dimension(350, 30));
        txtCapacidad.setMinimumSize(new Dimension(350, 30));
        txtCapacidad.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(txtCapacidad, gbc);
        txtAlimentacion = new JTextField();
        txtAlimentacion.setMaximumSize(new Dimension(350, 30));
        txtAlimentacion.setMinimumSize(new Dimension(350, 30));
        txtAlimentacion.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaAlojamiento.add(txtAlimentacion, gbc);
        contenedorBtns = new JPanel();
        contenedorBtns.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        ventanaAlojamiento.add(contenedorBtns, gbc);
        btnRegistrarAlojamiento = new JButton();
        btnRegistrarAlojamiento.setText("Registrar Alojamiento");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenedorBtns.add(btnRegistrarAlojamiento, gbc);
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
        return ventanaAlojamiento;
    }

}

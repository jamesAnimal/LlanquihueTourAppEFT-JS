package com.llanquihuetour.ui;

import com.llanquihuetour.data.GestorReservas;
import com.llanquihuetour.model.Cliente;
import com.llanquihuetour.model.PaqueteTuristico;
import com.llanquihuetour.model.Reserva;
import com.llanquihuetour.util.ValidadorGeneral;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Clase que representa la interfaz gráfica para registrar una Reserva de Paquete Turístico.
 * @author Jaime Seguel.
 * @since Semana 9
 */
public class VentanaReservaPaquete extends JDialog {

    // Declaración de los elementos de la ventana.
    private JPanel ventanaReservaPaquete;
    private JButton btnConfirmarReserva;
    private JTextField txtNumero;
    private JTextField txtFecha;
    private JComboBox cmbCliente;
    private JComboBox cmbPaqueteAsociado;
    private JTextField txtCantidadPasajeros;
    private JComboBox cmbEstado;
    private JButton btnCancelarReserva;
    private JLabel lblNumero;
    private JLabel lblFecha;
    private JLabel lblCliente;
    private JLabel lblPaqueteAsociado;
    private JLabel lblCantidadPasajeros;
    private JLabel lblEstado;
    private JLabel lblTotalPagar;
    private JLabel lblResultadoTotal;
    private JPanel contenedorBtns;

    /**
     * Constructor de la Ventana Reserva de Paquete Turístico.
     * @param parent Ventana padre desde donde se invoca.
     */
    public VentanaReservaPaquete(JDialog parent) {

        super(parent, "Registrar Reserva de Paquete Turístico", true);
        this.setContentPane(ventanaReservaPaquete);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(parent);

        // Evento del botón Cancelar.
        btnCancelarReserva.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        // Evento del botón Registrar.
        btnConfirmarReserva.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                registrarReserva();
            }
        });

        // Evento para calcular el subtotal.
        DocumentListener calculadorDocListener = new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {

                calcularTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                calcularTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                calcularTotal();
            }
        };

        txtCantidadPasajeros.getDocument().addDocumentListener(calculadorDocListener);

        // Recalcular subtotal si cambia el paquete seleccionado
        cmbPaqueteAsociado.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {

                calcularTotal();
            }
        });

        // Extrae los datos desde los archivos a través de los Gestores para llenar los ComboBox con clientes, estados y paquetes con sus precios.
        com.llanquihuetour.util.CargadorCombobox.cargarEstadosReserva(cmbEstado);
        com.llanquihuetour.data.GestorPersonas gestorPersonas = new com.llanquihuetour.data.GestorPersonas();

        for (com.llanquihuetour.model.Persona p : gestorPersonas.getListaPersonas()) {

            if (p instanceof com.llanquihuetour.model.Cliente) cmbCliente.addItem(p.getNombre());
        }

        com.llanquihuetour.data.GestorCatalogo gestorCatalogo = new com.llanquihuetour.data.GestorCatalogo();

        for (com.llanquihuetour.model.Registrable r : gestorCatalogo.getListaCatalogo()) {

            if (r instanceof com.llanquihuetour.model.PaqueteTuristico) {

                com.llanquihuetour.model.PaqueteTuristico s = (com.llanquihuetour.model.PaqueteTuristico) r;
                cmbPaqueteAsociado.addItem(s.getNombre() + " - Precio Total: $" + s.getPrecio());
            }
        }
    }

    /**
     * Método para calcular y mostrar el subtotal dinámico.
     */
    private void calcularTotal() {

        try {

            int pasajeros = Integer.parseInt(txtCantidadPasajeros.getText().trim());
            Object seleccionado = cmbPaqueteAsociado.getSelectedItem();
            double precio = 0;

            if (seleccionado != null) {

                if (seleccionado instanceof PaqueteTuristico) {

                    precio = ((PaqueteTuristico) seleccionado).getPrecio();

                } else {

                    String str = seleccionado.toString();

                    if (str.contains("Precio Total: $")) {

                        String p = str.substring(str.indexOf("Precio Total: $") + 15).split("\n")[0];
                        precio = Double.parseDouble(p.trim());
                    }
                }
            }

            double total = pasajeros * precio;
            lblResultadoTotal.setText("$" + String.format("%.2f", total));

        } catch (Exception ex) {

            lblResultadoTotal.setText("$0.00");
        }
    }

    /**
     * Método que extrae, valida y guarda los datos de la reserva del paquete en un .txt.
     */
    private void registrarReserva() {

        String numeroStr = txtNumero.getText();
        String fecha = txtFecha.getText();
        String nombreCliente = "Sin Cliente";

        if (cmbCliente.getSelectedItem() != null) {

            nombreCliente = cmbCliente.getSelectedItem().toString();
        }

        String cantidadStr = txtCantidadPasajeros.getText();

        if (ValidadorGeneral.validarCamposVacios(numeroStr, fecha, cantidadStr)) {

            return;
        }

        int numero = ValidadorGeneral.validarEntero(numeroStr, "Número de Reserva");

        if (numero == -1) {

            return;
        }

        int cantidad = ValidadorGeneral.validarEntero(cantidadStr, "Cantidad de Pasajeros");

        if (cantidad == -1) {

            return;
        }

        String precioStr = lblResultadoTotal.getText().replace("$", "").replace(",", ".");

        double total = 0;

        try {

            total = Double.parseDouble(precioStr);

        } catch (Exception e) {

            total = 0;
        }

        Cliente cliente = new Cliente();
        cliente.setRut("0-0");
        cliente.setNombre(nombreCliente);

        Reserva reserva = new Reserva();
        reserva.setNumero(numero);
        reserva.setFecha(fecha);
        reserva.setCliente(cliente);
        reserva.setCantidadPasajeros(cantidad);
        reserva.setEstado(cmbEstado.getSelectedItem().toString());
        reserva.setTotalPagar((int) total);

        Object seleccionado = cmbPaqueteAsociado.getSelectedItem();
        PaqueteTuristico paquete = null;

        if (seleccionado instanceof PaqueteTuristico) {

            paquete = (PaqueteTuristico) seleccionado;

        } else {

            paquete = new PaqueteTuristico();

            if (seleccionado != null) {

                paquete.setNombre(seleccionado.toString());

            } else {

                paquete.setNombre("Sin Paquete");
            }
        }

        reserva.setPaqueteAsociado(paquete);

        GestorReservas gestor = new GestorReservas();
        gestor.agregarReserva(reserva);

        JOptionPane.showMessageDialog(this, "Reserva de Paquete registrada exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
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
        ventanaReservaPaquete = new JPanel();
        ventanaReservaPaquete.setLayout(new GridBagLayout());
        lblNumero = new JLabel();
        lblNumero.setText("Número de Reserva: ");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaReservaPaquete.add(lblNumero, gbc);
        lblFecha = new JLabel();
        lblFecha.setText("Fecha: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaReservaPaquete.add(lblFecha, gbc);
        lblCliente = new JLabel();
        lblCliente.setText("Cliente: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaReservaPaquete.add(lblCliente, gbc);
        lblPaqueteAsociado = new JLabel();
        lblPaqueteAsociado.setText("Paquete Turístico: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaReservaPaquete.add(lblPaqueteAsociado, gbc);
        lblCantidadPasajeros = new JLabel();
        lblCantidadPasajeros.setText("Cantidad de Pasajeros: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaReservaPaquete.add(lblCantidadPasajeros, gbc);
        lblEstado = new JLabel();
        lblEstado.setText("Estado de la Reserva: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaReservaPaquete.add(lblEstado, gbc);
        lblTotalPagar = new JLabel();
        lblTotalPagar.setText("Total a Pagar ($): ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaReservaPaquete.add(lblTotalPagar, gbc);
        txtNumero = new JTextField();
        txtNumero.setMaximumSize(new Dimension(350, 30));
        txtNumero.setMinimumSize(new Dimension(350, 30));
        txtNumero.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaReservaPaquete.add(txtNumero, gbc);
        txtFecha = new JTextField();
        txtFecha.setMaximumSize(new Dimension(350, 30));
        txtFecha.setMinimumSize(new Dimension(350, 30));
        txtFecha.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaReservaPaquete.add(txtFecha, gbc);
        cmbCliente = new JComboBox();
        cmbCliente.setMaximumSize(new Dimension(350, 30));
        cmbCliente.setMinimumSize(new Dimension(350, 30));
        cmbCliente.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaReservaPaquete.add(cmbCliente, gbc);
        cmbPaqueteAsociado = new JComboBox();
        cmbPaqueteAsociado.setMaximumSize(new Dimension(350, 30));
        cmbPaqueteAsociado.setMinimumSize(new Dimension(350, 30));
        cmbPaqueteAsociado.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaReservaPaquete.add(cmbPaqueteAsociado, gbc);
        txtCantidadPasajeros = new JTextField();
        txtCantidadPasajeros.setMaximumSize(new Dimension(350, 30));
        txtCantidadPasajeros.setMinimumSize(new Dimension(350, 30));
        txtCantidadPasajeros.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaReservaPaquete.add(txtCantidadPasajeros, gbc);
        cmbEstado = new JComboBox();
        cmbEstado.setMaximumSize(new Dimension(350, 30));
        cmbEstado.setMinimumSize(new Dimension(350, 30));
        cmbEstado.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaReservaPaquete.add(cmbEstado, gbc);
        lblResultadoTotal = new JLabel();
        lblResultadoTotal.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaReservaPaquete.add(lblResultadoTotal, gbc);
        contenedorBtns = new JPanel();
        contenedorBtns.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        ventanaReservaPaquete.add(contenedorBtns, gbc);
        btnConfirmarReserva = new JButton();
        btnConfirmarReserva.setText("Confirmar Reserva");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenedorBtns.add(btnConfirmarReserva, gbc);
        btnCancelarReserva = new JButton();
        btnCancelarReserva.setText("Cancelar Reserva");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenedorBtns.add(btnCancelarReserva, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return ventanaReservaPaquete;
    }

}

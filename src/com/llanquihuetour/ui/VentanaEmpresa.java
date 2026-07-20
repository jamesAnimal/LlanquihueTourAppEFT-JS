package com.llanquihuetour.ui;

import com.llanquihuetour.data.GestorCatalogo;
import com.llanquihuetour.data.GestorPersonas;
import com.llanquihuetour.util.CargadorCombobox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Clase que representa la interfaz gráfica de Gestión de Empresa.
 * Permite administrar el registro de diferentes tipos de personal y servicios del catálogo.
 * @author Jaime Seguel.
 * @since Semana 9
 */
public class VentanaEmpresa extends JDialog {

    // Declaración de los elementos de la ventana.
    private JTabbedPane tabbedPrincipal;
    private JPanel panelPersonal;
    private JPanel panelCatalogo;
    private JLabel lblInstruccionesEmpresa;
    private JButton btnRegistrarCliente;
    private JButton btnRegistrarEmpleado;
    private JButton btnRegistrarGuia;
    private JButton btnRegistrarAlojamiento;
    private JButton btnRegistrarTransportista;
    private JLabel lblElegirFiltroPersonal;
    private JComboBox cmbFiltrosPersonal;
    private JTextArea textAreaPersonal;
    private JButton btnRegistrarPaseo;
    private JButton btnRegistrarExcursion;
    private JButton btnRegistrarRuta;
    private JButton btnRegistrarPaquete;
    private JLabel lblElegirFiltroCatalogo;
    private JComboBox cmbFiltroCatalogo;
    private JTextArea txtAreaCatalogo;
    private JButton btnVolver;
    private JPanel contenerBotones;
    private JPanel contenedorBtns1;
    private JPanel contenedorBtns2;
    private JPanel contenedorBtns3;
    private JPanel contenedorBtns4;
    private JPanel ventanaEmpresa;

    /**
     * Constructor de la Ventana de Gestión de Empresa.
     * @param parent Ventana padre desde donde se invoca.
     */
    public VentanaEmpresa(JFrame parent) {

        super(parent, "Llanquihue Tour - Gestión de Empresa", true);
        this.setContentPane(ventanaEmpresa);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(parent);

        // Evento del botón Volver.
        btnVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        // Eventos para abrir ventanas de la pestaña Personal.
        btnRegistrarGuia.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaGuia ventana = new VentanaGuia(VentanaEmpresa.this);
                ventana.setVisible(true);
            }
        });

        btnRegistrarAlojamiento.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaAlojamiento ventana = new VentanaAlojamiento(VentanaEmpresa.this);
                ventana.setVisible(true);
            }
        });

        btnRegistrarTransportista.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaTransporte ventana = new VentanaTransporte(VentanaEmpresa.this);
                ventana.setVisible(true);
            }
        });

        btnRegistrarCliente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaCliente ventana = new VentanaCliente(VentanaEmpresa.this);
                ventana.setVisible(true);
            }
        });

        btnRegistrarEmpleado.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaEmpleado ventana = new VentanaEmpleado(VentanaEmpresa.this);
                ventana.setVisible(true);
            }
        });

        // Eventos para abrir ventanas de la pestaña Catálogo.
        btnRegistrarPaseo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaPaseoLacustre ventana = new VentanaPaseoLacustre(VentanaEmpresa.this);
                ventana.setVisible(true);
            }
        });

        btnRegistrarExcursion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaExcursionCultural ventana = new VentanaExcursionCultural(VentanaEmpresa.this);
                ventana.setVisible(true);
            }
        });

        btnRegistrarRuta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaRutaGastronomica ventana = new VentanaRutaGastronomica(VentanaEmpresa.this);
                ventana.setVisible(true);
            }
        });

        btnRegistrarPaquete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaPaqueteTuristico ventana = new VentanaPaqueteTuristico(VentanaEmpresa.this);
                ventana.setVisible(true);
            }
        });

        // Llama al método que carga los combobox de los filtros.
        CargadorCombobox.cargarFiltrosPersonal(cmbFiltrosPersonal);
        CargadorCombobox.cargarFiltrosCatalogo(cmbFiltroCatalogo);

        // Evento para actualizar las áreas de texto cuando cambia el filtro.
        cmbFiltrosPersonal.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                    GestorPersonas gestor = new GestorPersonas();
                    textAreaPersonal.setText(gestor.obtenerResumenPersonas(e.getItem().toString()));
                    textAreaPersonal.setCaretPosition(0);
                }
            }
        });

        cmbFiltroCatalogo.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                    GestorCatalogo gestor = new GestorCatalogo();
                    txtAreaCatalogo.setText(gestor.obtenerResumenCatalogo(e.getItem().toString()));
                    txtAreaCatalogo.setCaretPosition(0);
                }
            }
        });

        // Carga inicial de datos en las áreas de texto,
        GestorPersonas gestorPersonas = new GestorPersonas();
        textAreaPersonal.setText(gestorPersonas.obtenerResumenPersonas("Todos"));
        textAreaPersonal.setCaretPosition(0);

        GestorCatalogo gestorCatalogo = new GestorCatalogo();
        txtAreaCatalogo.setText(gestorCatalogo.obtenerResumenCatalogo("Todos"));
        txtAreaCatalogo.setCaretPosition(0);
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
        ventanaEmpresa = new JPanel();
        ventanaEmpresa.setLayout(new GridBagLayout());
        lblInstruccionesEmpresa = new JLabel();
        lblInstruccionesEmpresa.setText("Seleccione la pestaña 'Personal' para registrar empleados o asociados, y la pestaña 'Catálogo' para registrar servicios y paquetes.");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        ventanaEmpresa.add(lblInstruccionesEmpresa, gbc);
        tabbedPrincipal = new JTabbedPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        ventanaEmpresa.add(tabbedPrincipal, gbc);
        panelPersonal = new JPanel();
        panelPersonal.setLayout(new GridBagLayout());
        tabbedPrincipal.addTab("Personal", panelPersonal);
        btnRegistrarGuia = new JButton();
        btnRegistrarGuia.setMaximumSize(new Dimension(198, 34));
        btnRegistrarGuia.setMinimumSize(new Dimension(198, 34));
        btnRegistrarGuia.setPreferredSize(new Dimension(198, 34));
        btnRegistrarGuia.setText("Registrar Guia");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelPersonal.add(btnRegistrarGuia, gbc);
        btnRegistrarAlojamiento = new JButton();
        btnRegistrarAlojamiento.setMaximumSize(new Dimension(198, 34));
        btnRegistrarAlojamiento.setMinimumSize(new Dimension(198, 34));
        btnRegistrarAlojamiento.setPreferredSize(new Dimension(198, 34));
        btnRegistrarAlojamiento.setText("Registrar Alojamiento");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelPersonal.add(btnRegistrarAlojamiento, gbc);
        btnRegistrarTransportista = new JButton();
        btnRegistrarTransportista.setMaximumSize(new Dimension(198, 34));
        btnRegistrarTransportista.setMinimumSize(new Dimension(198, 34));
        btnRegistrarTransportista.setPreferredSize(new Dimension(198, 34));
        btnRegistrarTransportista.setText("Registrar Transportista");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelPersonal.add(btnRegistrarTransportista, gbc);
        final JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setMaximumSize(new Dimension(600, 200));
        scrollPane1.setMinimumSize(new Dimension(600, 200));
        scrollPane1.setPreferredSize(new Dimension(600, 200));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelPersonal.add(scrollPane1, gbc);
        textAreaPersonal = new JTextArea();
        scrollPane1.setViewportView(textAreaPersonal);
        contenerBotones = new JPanel();
        contenerBotones.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panelPersonal.add(contenerBotones, gbc);
        btnRegistrarCliente = new JButton();
        btnRegistrarCliente.setMaximumSize(new Dimension(198, 34));
        btnRegistrarCliente.setMinimumSize(new Dimension(198, 34));
        btnRegistrarCliente.setPreferredSize(new Dimension(198, 34));
        btnRegistrarCliente.setText("Registrar Cliente");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenerBotones.add(btnRegistrarCliente, gbc);
        btnRegistrarEmpleado = new JButton();
        btnRegistrarEmpleado.setMaximumSize(new Dimension(198, 34));
        btnRegistrarEmpleado.setMinimumSize(new Dimension(198, 34));
        btnRegistrarEmpleado.setPreferredSize(new Dimension(198, 34));
        btnRegistrarEmpleado.setText("Registrar Empleado");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenerBotones.add(btnRegistrarEmpleado, gbc);
        contenedorBtns3 = new JPanel();
        contenedorBtns3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panelPersonal.add(contenedorBtns3, gbc);
        lblElegirFiltroPersonal = new JLabel();
        lblElegirFiltroPersonal.setText("Elegir filtro");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenedorBtns3.add(lblElegirFiltroPersonal, gbc);
        cmbFiltrosPersonal = new JComboBox();
        cmbFiltrosPersonal.setMaximumSize(new Dimension(350, 34));
        cmbFiltrosPersonal.setMinimumSize(new Dimension(350, 34));
        cmbFiltrosPersonal.setPreferredSize(new Dimension(350, 34));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenedorBtns3.add(cmbFiltrosPersonal, gbc);
        panelCatalogo = new JPanel();
        panelCatalogo.setLayout(new GridBagLayout());
        tabbedPrincipal.addTab("Catalogo", panelCatalogo);
        final JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setMaximumSize(new Dimension(600, 200));
        scrollPane2.setMinimumSize(new Dimension(600, 200));
        scrollPane2.setPreferredSize(new Dimension(600, 200));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelCatalogo.add(scrollPane2, gbc);
        txtAreaCatalogo = new JTextArea();
        scrollPane2.setViewportView(txtAreaCatalogo);
        contenedorBtns1 = new JPanel();
        contenedorBtns1.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panelCatalogo.add(contenedorBtns1, gbc);
        btnRegistrarPaseo = new JButton();
        btnRegistrarPaseo.setMaximumSize(new Dimension(198, 34));
        btnRegistrarPaseo.setMinimumSize(new Dimension(198, 34));
        btnRegistrarPaseo.setPreferredSize(new Dimension(198, 34));
        btnRegistrarPaseo.setText("Registrar Paseo Lacustre");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenedorBtns1.add(btnRegistrarPaseo, gbc);
        btnRegistrarExcursion = new JButton();
        btnRegistrarExcursion.setMaximumSize(new Dimension(198, 34));
        btnRegistrarExcursion.setMinimumSize(new Dimension(198, 34));
        btnRegistrarExcursion.setPreferredSize(new Dimension(198, 34));
        btnRegistrarExcursion.setText("Registrar Excursion Cultural");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenedorBtns1.add(btnRegistrarExcursion, gbc);
        contenedorBtns2 = new JPanel();
        contenedorBtns2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panelCatalogo.add(contenedorBtns2, gbc);
        btnRegistrarRuta = new JButton();
        btnRegistrarRuta.setMaximumSize(new Dimension(198, 34));
        btnRegistrarRuta.setMinimumSize(new Dimension(198, 34));
        btnRegistrarRuta.setPreferredSize(new Dimension(198, 34));
        btnRegistrarRuta.setText("Registrar Ruta Gastronomica");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenedorBtns2.add(btnRegistrarRuta, gbc);
        btnRegistrarPaquete = new JButton();
        btnRegistrarPaquete.setMaximumSize(new Dimension(198, 34));
        btnRegistrarPaquete.setMinimumSize(new Dimension(198, 34));
        btnRegistrarPaquete.setPreferredSize(new Dimension(198, 34));
        btnRegistrarPaquete.setText("Registrar Paquete Turistico");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenedorBtns2.add(btnRegistrarPaquete, gbc);
        contenedorBtns4 = new JPanel();
        contenedorBtns4.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panelCatalogo.add(contenedorBtns4, gbc);
        lblElegirFiltroCatalogo = new JLabel();
        lblElegirFiltroCatalogo.setText("Elegir filtro");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenedorBtns4.add(lblElegirFiltroCatalogo, gbc);
        cmbFiltroCatalogo = new JComboBox();
        cmbFiltroCatalogo.setMaximumSize(new Dimension(350, 34));
        cmbFiltroCatalogo.setMinimumSize(new Dimension(350, 34));
        cmbFiltroCatalogo.setPreferredSize(new Dimension(350, 34));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        contenedorBtns4.add(cmbFiltroCatalogo, gbc);
        btnVolver = new JButton();
        btnVolver.setMaximumSize(new Dimension(200, 34));
        btnVolver.setMinimumSize(new Dimension(200, 34));
        btnVolver.setPreferredSize(new Dimension(200, 34));
        btnVolver.setText("Volver a la ventana principal");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        ventanaEmpresa.add(btnVolver, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return ventanaEmpresa;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

package com.llanquihuetour.app;

import com.llanquihuetour.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que inicia la aplicación.
 */
public class Main {

    /**
     * Constructor que inicializa la ventana principal de la interfaz gráfica.
     * @param args
     */
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {

            com.llanquihuetour.ui.VentanaBienvenida bienvenida = new com.llanquihuetour.ui.VentanaBienvenida();
            bienvenida.setVisible(true);
        });
    }
}
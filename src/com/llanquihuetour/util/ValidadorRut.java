package com.llanquihuetour.util;

import javax.swing.JOptionPane;

/**
 * Clase centralizada para la validación del formato del RUT.
 * @author Jaime Seguel
 */
public class ValidadorRut {

    /**
     * Método que evalúa la regla y lanza su excepción personalizada si falla.
     */
    public static void comprobarFormato(String rut) throws RutInvalidoException {

        if (rut == null || rut.trim().isEmpty() || !rut.matches("[0-9]{7,8}-[0-9kK]")) {

            throw new RutInvalidoException("El RUT ingresado no es válido. Formato esperado: 12345678-9");
        }
    }

    /**
     * Método para la GUI que atrapa el error y muestra el popup directamente.
     */
    public static String validarRutGUI(String textoRut) {

        try {

            comprobarFormato(textoRut);
            return textoRut;

        } catch (RutInvalidoException e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}

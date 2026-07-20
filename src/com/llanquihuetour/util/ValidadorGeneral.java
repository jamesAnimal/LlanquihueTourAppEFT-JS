package com.llanquihuetour.util;

import javax.swing.JOptionPane;

/**
 * Clase centralizada para la validación de campos numéricos y el formato del Rut.
 * @author Jaime Seguel
 * @since Semana 8
 */
public class ValidadorGeneral {

    /**
     * Método que valida que un número guardado en texto represente un número entero positivo mayor a cero.
     * @param texto El número en formato texto ingresado por el usuario.
     * @param nombreCampo El nombre del campo (ej: "Edad", "Sueldo") para el mensaje de error.
     * @return El número validado, o -1 si hubo un error de validación.
     */
    public static int validarEntero(String texto, String nombreCampo) {

        try {

            int numero = Integer.parseInt(texto.trim());

            if (numero <= 0) {

                JOptionPane.showMessageDialog(null, "El campo " + nombreCampo + " debe ser un número entero positivo", "Valor Inválido", JOptionPane.ERROR_MESSAGE);
                return -1;
            }

            return numero;

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null, "El campo " + nombreCampo + " debe ser un número entero positivo.", "Valor Inválido", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    /**
     * Método que valida que un número guardado en texto represente un número decimal positivo mayor a cero.
     * @param texto El texto ingresado por el usuario.
     * @param nombreCampo El nombre del campo (ej: "Precio", "Duración") para los mensajes de error.
     * @return El número validado, o -1.0 si hubo un error de validación.
     */
    public static double validarDecimal(String texto, String nombreCampo) {

        try {

            double numero = Double.parseDouble(texto.trim());

            if (numero <= 0.0) {

                JOptionPane.showMessageDialog(null, "El campo " + nombreCampo + " debe ser un número decimal positivo", "Valor Inválido", JOptionPane.ERROR_MESSAGE);
                return -1.0;
            }

            return numero;

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null, "El campo " + nombreCampo + " debe ser un número decimal válido.", "Valor Inválido", JOptionPane.ERROR_MESSAGE);
            return -1.0;
        }
    }

    /**
     * Método que valida que no existan campos vacíos ni nulos en el formulario.
     * @param campos Parámetro variable (varargs) con los campos de texto a evaluar.
     * @return true si encuentra un campo vacío o nulo, false si todos están correctos.
     */
    public static boolean validarCamposVacios(String... campos) {

        for (String campo : campos) {

            if (campo == null || campo.trim().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos del formulario.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
                return true;
            }
        }
        return false;
    }

    /**
     * Método que valida que el número de teléfono cumpla con el formato chileno (+56 seguido de 9 dígitos).
     * @param telefono String con el teléfono a validar.
     * @return true si es válido, false si es inválido y muestra el popup de error.
     */
    public static boolean validarTelefono(String telefono) {

        if (telefono != null && telefono.matches("\\+56[0-9]{9}")) {

            return true;

        } else {

            JOptionPane.showMessageDialog(null, "El teléfono ingresado no es válido.\nFormato esperado: +56912345678", "Teléfono Inválido", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}

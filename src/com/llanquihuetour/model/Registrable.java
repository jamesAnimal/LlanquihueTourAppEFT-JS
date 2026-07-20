package com.llanquihuetour.model;

/**
 * Interfaz que define el contrato común para todas las entidades registrables.
 * @author Jaime Seguel.
 * @since Semana 8
 */
public interface Registrable {

    /**
     * Método que retorna un texto formateado de los datos de la entidad.
     * @return Texto con el resumen de la entidad.
     */
    public String mostrarDatos();

    /**
     * Método que formatea un texto con los datos que seran escritos en sus respectivos archivos .txt.
     * @return String con resumen del objeto.
     */
    public String Registrar();

}

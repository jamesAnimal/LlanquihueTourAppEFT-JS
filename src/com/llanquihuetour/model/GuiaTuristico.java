package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase Persona e implementa Registrable para definir los métodos y atributos de un objeto guía turístico.
 * @author Jaime Seguel.
 * @since Semana 8
 */
public class GuiaTuristico extends Persona implements Registrable {

    private String idiomas;
    private String zonasDeTrabajo;
    private String credencialSernatur;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public GuiaTuristico() {

        super();
        this.idiomas = "Sin registrar";
        this.zonasDeTrabajo = "Sin registrar";
        this.credencialSernatur = "Sin registrar";
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param nombre Nombre del guía turístico.
     * @param rut Rut del guía turístico.
     * @param fono Teléfono del guía turístico.
     * @param direccion Dirección del guía turístico.
     * @param idiomas Idiomas que maneja el guía turístico.
     * @param zonasDeTrabajo Zonas en donde trabaja el guía turístico.
     * @param credencialSernatur Credencial de Sernatur del guía turístico.
     */
    public GuiaTuristico(String nombre, String rut, String fono, Direccion direccion, String idiomas,
                         String zonasDeTrabajo, String credencialSernatur) {

        super(nombre, rut, fono, direccion);
        this.idiomas = idiomas;
        this.zonasDeTrabajo = zonasDeTrabajo;
        this.credencialSernatur = credencialSernatur;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getZonasDeTrabajo() {
        return zonasDeTrabajo;
    }

    public void setZonasDeTrabajo(String zonasDeTrabajo) {
        this.zonasDeTrabajo = zonasDeTrabajo;
    }

    public String getCredencialSernatur() {
        return credencialSernatur;
    }

    public void setCredencialSernatur(String credencialSernatur) {
        this.credencialSernatur = credencialSernatur;
    }

    /**
     * Método implementado desde Registrable para formatear los datos que se mostraran en las areas de texto.
     * @return String con texto formateado con los datos del objeto.
     */
    @Override
    public String mostrarDatos() {

        return "-----Datos del Guía Turístico-----\n"
                + super.mostrarDatos()
                + "Idiomas: " + idiomas + "\n"
                + "Zonas de Trabajo: " + zonasDeTrabajo + "\n"
                + "Credencial Sernatur: " + credencialSernatur + "\n";
    }

    /**
     * Método implementado desde Registrable que formatea el texto con los datos que serán escritos en sus respectivos archivos .txt.
     * @return String con los datos del objeto.
     */
    @Override
    public String Registrar() {

        return super.Registrar() + ";" + idiomas + ";" + zonasDeTrabajo + ";" + credencialSernatur;
    }

    /**
     * Método que formatea y retorna un resumen de la clase para mostrarlo por consola.
     * @return Texto en 2 líneas con la descripción de la clase.
     */
    @Override
    public String toString() {

        return "Guía Turístico: " + super.toString() + "\nIdiomas: " + idiomas + " / Zonas: " + zonasDeTrabajo + " / Credencial: " + credencialSernatur;
    }
}

package com.llanquihuetour.model;

import com.llanquihuetour.util.ValidadorRut;

/**
 * Clase que implementa Registrable para definir los métodos y atributos más básicos de las personas en la empresa.
 * @author Jaime Seguel.
 * @since Semana 3
 */
public abstract class Persona implements Registrable {

    private String nombre;
    private String rut;
    private String fono;
    private Direccion direccion;
    
    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public Persona() {

        this.nombre = "Sin registrar";
        this.rut = "Sin registrar";
        this.fono = "Sin registrar";
        this.direccion = new Direccion();
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param nombre Nombre de la persona.
     * @param rut Rut de la persona.
     * @param fono Teléfono de la persona.
     * @param direccion Dirección de la persona.
     */
    public Persona(String nombre, String rut, String fono, Direccion direccion) {

        this.nombre = nombre;
        this.rut = rut;
        this.fono = fono;
        this.direccion = direccion;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    // Asigna el RUT validando su formato con la clase ValidadorRut y lanza RutInvalidoException si es incorrecto.
    public void setRut(String rut) {

        ValidadorRut.comprobarFormato(rut);
        this.rut = rut;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Método implementado desde Registrable para formatear los datos que se mostraran en las areas de texto.
     * @return String con texto formateado con los datos del objeto.
     */
    @Override
    public String mostrarDatos() {

        return  "Nombre: " + nombre + "\n" +
                "Rut: " + rut + "\n" +
                "Fono: " + fono + "\n" +
                direccion + "\n";
    }

    /**
     * Método implementado desde Registrable que formatea el texto con los datos que serán escritos en sus respectivos archivos .txt.
     * @return String con los datos del objeto.
     */
    @Override
    public String Registrar() {

        return nombre + ";" + rut + ";" + fono + ";" + direccion.getCalle() + ";" + direccion.getNumero() +
                ";" + direccion.getCiudad() + ";" + direccion.getRegion();
    }

    /**
     * Método que formatea y retorna un resumen de la clase para mostrarlo por consola.
     * @return Texto formateado con la descripción de la clase.
     */
    @Override
    public String toString() {

        return nombre + " / RUT: " + rut + " / Fono: " + fono + " / Dirección: " + direccion.getCalle() + " " + direccion.getNumero();
    }
}

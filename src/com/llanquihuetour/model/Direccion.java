package com.llanquihuetour.model;

/**
 * Clase que define y maneja los datos de la dirección de una persona.
 * @author Jaime Seguel.
 * @since Semana 3
 */
public class Direccion {

    private String calle;
    private String numero;
    private String ciudad;
    private String region;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public Direccion() {

        this.calle = "Sin registrar";
        this.numero = "Sin registrar";
        this.ciudad = "Sin registrar";
        this.region = "Sin registrar";
    }

    /**
     * Constructor que inicializa el objeto con los datos de dirección agregados directamente.
     * @param calle Calle de residencia de la persona.
     * @param numero Número de residencia de la persona.
     * @param ciudad Ciudad de residencia de la persona.
     * @param region Región de residencia de la persona.
     */
    public Direccion(String calle, String numero, String ciudad, String region) {

        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.region = region;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Método que formatea y retorna los atributos de la clase para mostrarlos por consola.
     * @return Texto formateado con los datos de la dirección.
     */
    @Override
    public String toString() {

        return "Calle: " + calle + "\n"
                + "Número: " + numero + "\n"
                + "Ciudad: " + ciudad + "\n"
                + "Región: " + region;
    }
}

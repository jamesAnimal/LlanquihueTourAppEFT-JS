package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase Persona e implementa Registrable para definir los métodos y atributos de un objeto Proveedor.
 * @author Jaime Seguel.
 * @since Semana 9
 */
public abstract class Proveedor extends Persona implements Registrable {

    private String sitioWeb;
    private int tarifa;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public Proveedor() {

        super();
        this.sitioWeb = "Sin registrar";
        this.tarifa = 0;
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param sitioWeb Sitio web del proveedor.
     * @param tarifa Tarifa del servicio del proveedor.
     * @param nombre Nombre del proveedor.
     * @param rut Rut del proveedor.
     * @param fono Teléfono del proveedor.
     * @param direccion Dirección del proveedor.
     */
    public Proveedor(String sitioWeb, int tarifa, String nombre, String rut, String fono, Direccion direccion) {

        super(nombre, rut, fono, direccion);
        this.sitioWeb = sitioWeb;
        this.tarifa = tarifa;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * Método implementado desde Registrable para formatear los datos que se mostraran en las areas de texto.
     * @return String con texto formateado con los datos del objeto.
     */
    @Override
    public String mostrarDatos() {

        return super.mostrarDatos()
                + "Sitio Web: " + sitioWeb + "\n"
                + "Tarifa: " + tarifa + "\n";
    }

    /**
     * Método implementado desde Registrable que formatea el texto con los datos que serán escritos en sus respectivos archivos .txt.
     * @return String con los datos del objeto.
     */
    @Override
    public String Registrar() {

        return super.Registrar() + ";" + sitioWeb + ";" + tarifa;
    }

    /**
     * Método que formatea y retorna un resumen de la clase para mostrarlo por consola.
     * @return Texto en 2 líneas con la descripción de la clase.
     */
    @Override
    public String toString() {

        return super.toString() + " / Sitio Web: " + sitioWeb + "\nTarifa: $" + tarifa;
    }
}

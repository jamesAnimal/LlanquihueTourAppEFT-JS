package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase Proveedor e implementa Registrable para definir los métodos y atributos de un objeto operador de transporte.
 * @author Jaime Seguel.
 * @since Semana 9
 */
public class ProveedorTransporte extends Proveedor implements Registrable {

    private String tipoVehiculos;
    private int cantidadVehiculos;
    private int pasajerosPorVehiculo;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public ProveedorTransporte() {

        super();
        this.tipoVehiculos = "Sin Registrar";
        this.cantidadVehiculos = 0;
        this.pasajerosPorVehiculo = 0;
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param sitioWeb Sitio web del proveedor.
     * @param tarifa Tarifa del servicio del proveedor.
     * @param nombre Nombre del proveedor.
     * @param rut Rut del proveedor.
     * @param fono Teléfono del proveedor.
     * @param direccion Dirección del proveedor.
     * @param tipoVehiculos Tipos de vehículos que opera el proveedor.
     * @param cantidadVehiculos Cantidad de vehículos del proveedor.
     * @param pasajerosPorVehiculo Cantidad de pasajeros por vehículo.
     */
    public ProveedorTransporte(String sitioWeb, int tarifa, String nombre, String rut, String fono, Direccion direccion,
                               String tipoVehiculos, int cantidadVehiculos, int pasajerosPorVehiculo) {

        super(sitioWeb, tarifa, nombre, rut, fono, direccion);
        this.tipoVehiculos = tipoVehiculos;
        this.cantidadVehiculos = cantidadVehiculos;
        this.pasajerosPorVehiculo = pasajerosPorVehiculo;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getTipoVehiculos() {
        return tipoVehiculos;
    }

    public void setTipoVehiculos(String tipoVehiculos) {
        this.tipoVehiculos = tipoVehiculos;
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }

    public int getPasajerosPorVehiculo() {
        return pasajerosPorVehiculo;
    }

    public void setPasajerosPorVehiculo(int pasajerosPorVehiculo) {
        this.pasajerosPorVehiculo = pasajerosPorVehiculo;
    }

    /**
     * Método implementado desde Registrable para formatear los datos que se mostraran en las areas de texto.
     * @return String con texto formateado con los datos del objeto.
     */
    @Override
    public String mostrarDatos() {

        return "-----Operador de Transporte-----\n"
                + super.mostrarDatos()
                + "Tipo de Vehículos: " + tipoVehiculos + "\n"
                + "Cantidad de Vehículos: " + cantidadVehiculos + "\n"
                + "Pasajeros por Vehículo: " + pasajerosPorVehiculo + "\n";
    }

    /**
     * Método implementado desde Registrable que formatea el texto con los datos que serán escritos en sus respectivos archivos .txt.
     * @return String con los datos del objeto.
     */
    @Override
    public String Registrar() {

        return super.Registrar() + ";" + tipoVehiculos + ";" + cantidadVehiculos + ";" + pasajerosPorVehiculo;
    }

    /**
     * Método que formatea y retorna un resumen de la clase para mostrarlo por consola.
     * @return Texto en 2 líneas con la descripción de la clase.
     */
    @Override
    public String toString() {

        return "Proveedor Transporte: " + super.toString() + " / Vehículos: " + tipoVehiculos + " / Cantidad: " + cantidadVehiculos + " / Pax x vehículo: " + pasajerosPorVehiculo;
    }
}

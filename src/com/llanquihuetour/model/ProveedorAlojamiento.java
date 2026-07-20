package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase Proveedor e implementa Registrable para definir los métodos y atributos de un objeto operador de alojamiento.
 * @author Jaime Seguel.
 * @since Semana 9
 */
public class ProveedorAlojamiento extends Proveedor implements Registrable {

    private String tipoAlojamiento;
    private int capacidadTotal;
    private String incluyeAlimentacion;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public ProveedorAlojamiento() {

        super();
        this.tipoAlojamiento = "Sin Registrar";
        this.capacidadTotal = 0;
        this.incluyeAlimentacion = "Sin Registrar";
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param sitioWeb Sitio web del proveedor.
     * @param tarifa Tarifa del servicio del proveedor.
     * @param nombre Nombre del proveedor.
     * @param rut Rut del proveedor.
     * @param fono Teléfono del proveedor.
     * @param direccion Dirección del proveedor.
     * @param tipoAlojamiento Tipo de alojamiento que ofrece el proveedor.
     * @param capacidadTotal Capacidad total de huéspedes.
     * @param incluyeAlimentacion Qué tipo de alimentación incluye.
     */
    public ProveedorAlojamiento(String sitioWeb, int tarifa, String nombre, String rut, String fono, Direccion direccion,
                                String tipoAlojamiento, int capacidadTotal, String incluyeAlimentacion) {

        super(sitioWeb, tarifa, nombre, rut, fono, direccion);
        this.tipoAlojamiento = tipoAlojamiento;
        this.capacidadTotal = capacidadTotal;
        this.incluyeAlimentacion = incluyeAlimentacion;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public void setTipoAlojamiento(String tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public String getIncluyeAlimentacion() {
        return incluyeAlimentacion;
    }

    public void setIncluyeAlimentacion(String incluyeAlimentacion) {
        this.incluyeAlimentacion = incluyeAlimentacion;
    }

    /**
     * Método implementado desde Registrable para formatear los datos que se mostraran en las areas de texto.
     * @return String con texto formateado con los datos del objeto.
     */
    @Override
    public String mostrarDatos() {

        return "-----Operador de Alojamiento-----\n"
                + super.mostrarDatos()
                + "Tipo de Alojamiento: " + tipoAlojamiento + "\n"
                + "Capacidad Total: " + capacidadTotal + "\n"
                + "Incluye Alimentación: " + incluyeAlimentacion + "\n";
    }

    /**
     * Método implementado desde Registrable que formatea el texto con los datos que serán escritos en sus respectivos archivos .txt.
     * @return String con los datos del objeto.
     */
    @Override
    public String Registrar() {

        return super.Registrar() + ";" + tipoAlojamiento + ";" + capacidadTotal + ";" + incluyeAlimentacion;
    }

    /**
     * Método que formatea y retorna un resumen de la clase para mostrarlo por consola.
     * @return Texto en 2 líneas con la descripción de la clase.
     */
    @Override
    public String toString() {

        return "Proveedor Alojamiento: " + super.toString() + " / Tipo de Alojamiento: " + tipoAlojamiento + " / Capacidad: " + capacidadTotal + " / Alimentación: " + incluyeAlimentacion;
    }
}

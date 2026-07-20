package com.llanquihuetour.model;

/**
 * Clase que implementa Registrable para definir los métodos y atributos más básicos de los paquetes turísticos.
 * @author Jaime Seguel.
 * @since Semana 9
 */
public class PaqueteTuristico implements Registrable {

    private String nombre;
    private String fechas;
    private String actividad1;
    private String actividad2;
    private String actividad3;
    private ProveedorTransporte transporte;
    private ProveedorAlojamiento alojamiento;
    private GuiaTuristico guiaAsignado;
    private int precio;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public PaqueteTuristico() {

        this.nombre = "Sin Registrar";
        this.fechas = "Sin Registrar";
        this.actividad1 = "Sin Registrar";
        this.actividad2 = "Sin Registrar";
        this.actividad3 = "Sin Registrar";
        this.transporte = new ProveedorTransporte();
        this.alojamiento = new ProveedorAlojamiento();
        this.guiaAsignado = new GuiaTuristico();
        this.precio = 0;
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param nombre Nombre del paquete turístico.
     * @param fechas Fechas del paquete turístico.
     * @param actividad1 Primera actividad del paquete turístico.
     * @param actividad2 Segunda actividad del paquete turístico.
     * @param actividad3 Tercera actividad del paquete turístico.
     * @param transporte Operador de transporte asignado al paquete turístico.
     * @param alojamiento Operador de alojamiento asignado al paquete turístico.
     * @param guiaAsignado Guia asignado al paquete turístico.
     * @param precio Precio total del paquete turístico.
     */
    public PaqueteTuristico(String nombre, String fechas, String actividad1, String actividad2, String actividad3,
                            ProveedorTransporte transporte, ProveedorAlojamiento alojamiento, GuiaTuristico guiaAsignado, int precio) {

        this.nombre = nombre;
        this.fechas = fechas;
        this.actividad1 = actividad1;
        this.actividad2 = actividad2;
        this.actividad3 = actividad3;
        this.transporte = transporte;
        this.alojamiento = alojamiento;
        this.guiaAsignado = guiaAsignado;
        this.precio = precio;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public String getActividad1() {
        return actividad1;
    }

    public void setActividad1(String actividad1) {
        this.actividad1 = actividad1;
    }

    public String getActividad2() {
        return actividad2;
    }

    public void setActividad2(String actividad2) {
        this.actividad2 = actividad2;
    }

    public String getActividad3() {
        return actividad3;
    }

    public void setActividad3(String actividad3) {
        this.actividad3 = actividad3;
    }

    public ProveedorTransporte getTransporte() {
        return transporte;
    }

    public void setTransporte(ProveedorTransporte transporte) {
        this.transporte = transporte;
    }

    public ProveedorAlojamiento getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(ProveedorAlojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    public GuiaTuristico getGuiaAsignado() {
        return guiaAsignado;
    }

    public void setGuiaAsignado(GuiaTuristico guiaAsignado) {
        this.guiaAsignado = guiaAsignado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Método implementado desde Registrable para formatear los datos que se mostraran en las areas de texto.
     * @return String con texto formateado con los datos del objeto.
     */
    @Override
    public String mostrarDatos() {

        return "=====Paquete Turístico=====\n" +
                "Nombre del Paquete: " + nombre + "\n" +
                "Fechas: " + fechas + "\n" +
                "Actividades: " + actividad1 + ", " + actividad2 + ", " + actividad3 + "\n" +
                "Transporte: " + transporte.getNombre() + "\n" +
                "Alojamiento: " + alojamiento.getNombre() + "\n" +
                "Guía Asignado: " + guiaAsignado.getNombre() + "\n" +
                "Precio Total: $" + precio;
    }

    /**
     * Método implementado desde Registrable que formatea el texto con los datos que serán escritos en sus respectivos archivos .txt.
     * @return String con los datos del objeto.
     */
    @Override
    public String Registrar() {

        return nombre + ";" + fechas + ";" + transporte.getNombre() + ";" + alojamiento.getNombre() + ";" + guiaAsignado.getNombre() + ";" + precio + ";" + actividad1 + ";" + actividad2 + ";" + actividad3;
    }

    /**
     * Método que formatea y retorna un resumen de la clase para mostrarlo por consola.
     * @return Texto en 2 líneas con la descripción de la clase.
     */
    @Override
    public String toString() {

        return "Paquete: " + nombre + " / Fechas: " + fechas + " / Transporte: " + transporte.getNombre() + "\nAlojamiento: " + alojamiento.getNombre() + " / Guía: " + guiaAsignado.getNombre() + " / Precio: $" + precio;
    }
}

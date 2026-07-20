package com.llanquihuetour.model;

/**
 * Clase que implementa Registrable para definir los métodos y atributos más básicos de las reservas.
 * @author Jaime Seguel.
 * @since Semana 9
 */
public class Reserva implements Registrable {

    private int numero;
    private String fecha;
    private Cliente cliente;
    private int cantidadPasajeros;
    private PaqueteTuristico paqueteAsociado;
    private ServicioTuristico servicioAsociado;
    private String estado;
    private int totalPagar;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto.
     */
    public Reserva() {

        this.numero = 0;
        this.fecha = "Sin Registrar";
        this.cliente = new Cliente();
        this.cantidadPasajeros = 0;
        this.paqueteAsociado = null;
        this.servicioAsociado = null;
        this.estado = "Sin Registrar";
        this.totalPagar = 0;
    }

    /**
     * Constructor para inicializar una reserva con un paquete turístico.
     * @param numero Numero de la reserva.
     * @param fecha Fecha en que se hizo de la reserva.
     * @param cliente Cliente que hizo la reserva.
     * @param cantidadPasajeros Cantidad de pasajeros totales de la reserva.
     * @param paqueteAsociado Paquete turístico asociado a la reserva.
     * @param estado Estado de la reserva.
     * @param totalPagar Valor total a pagar por la reserva.
     */
    public Reserva(int numero, String fecha, Cliente cliente, int cantidadPasajeros,
                   PaqueteTuristico paqueteAsociado, String estado, int totalPagar) {

        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.cantidadPasajeros = cantidadPasajeros;
        this.paqueteAsociado = paqueteAsociado;
        this.estado = estado;
        this.totalPagar = totalPagar;
    }

    /**
     * Constructor para inicializar una reserva con un servicio turístico.
     * @param numero Numero de la reserva.
     * @param fecha Fecha en que se hizo de la reserva.
     * @param cliente Cliente que hizo la reserva.
     * @param cantidadPasajeros Cantidad de pasajeros totales de la reserva.
     * @param servicioAsociado Servicio turístico individual asociado a la reserva.
     * @param estado Estado de la reserva.
     * @param totalPagar Valor total a pagar por la reserva.
     */
    public Reserva(int numero, String fecha, Cliente cliente, int cantidadPasajeros,
                   ServicioTuristico servicioAsociado, String estado, int totalPagar) {

        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.cantidadPasajeros = cantidadPasajeros;
        this.servicioAsociado = servicioAsociado;
        this.estado = estado;
        this.totalPagar = totalPagar;
    }

    // Métodos setters y getters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public PaqueteTuristico getPaqueteAsociado() {
        return paqueteAsociado;
    }

    public void setPaqueteAsociado(PaqueteTuristico paqueteAsociado) {
        this.paqueteAsociado = paqueteAsociado;
    }

    public ServicioTuristico getServicioAsociado() {
        return servicioAsociado;
    }

    public void setServicioAsociado(ServicioTuristico servicioAsociado) {
        this.servicioAsociado = servicioAsociado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    /**
     * Método que retorna el nombre del producto asociado a la reserva.
     * @return Nombre del servicio o paquete.
     */
    private String obtenerNombreProductoReservado() {

        if (this.paqueteAsociado != null) {

            return this.paqueteAsociado.getNombre();

        } else if (this.servicioAsociado != null) {

            return this.servicioAsociado.getNombre();

        } else {

            return "Sin Asignar";
        }
    }

    /**
     * Método implementado desde Registrable para formatear los datos que se mostraran en las areas de texto.
     * @return String con texto formateado con los datos del objeto.
     */
    @Override
    public String mostrarDatos() {

        String tipoProducto = "Desconocido";

        if (paqueteAsociado != null) {

            tipoProducto = "Paquete Turístico";

        } else if (servicioAsociado != null) {

            tipoProducto = "Servicio Turístico";
        }

        return "=====Reserva N.º " + numero + "=====\n" +
                "Fecha de la Reserva: " + fecha + "\n" +
                "Cliente Titular: " + cliente.getNombre() + "\n" +
                "Cantidad de Pasajeros: " + cantidadPasajeros + "\n" +
                "Tipo de Producto: " + tipoProducto + "\n" +
                "Producto Reservado: " + obtenerNombreProductoReservado() + "\n" +
                "Estado de la reserva: " + estado + "\n" +
                "Valor total de la reserva: " + totalPagar;
    }

    /**
     * Método implementado desde Registrable que formatea el texto con los datos que serán escritos en sus respectivos archivos .txt.
     * @return String con los datos del objeto.
     */
    @Override
    public String Registrar() {

        String tipoProducto = "Desconocido";

        if (paqueteAsociado != null) {

            tipoProducto = "Paquete";

        } else if (servicioAsociado != null) {

            tipoProducto = servicioAsociado.getClass().getSimpleName();
        }

        return numero + ";" + fecha + ";" + cliente.getNombre() + ";" + cantidadPasajeros + ";" +
                tipoProducto + ";" + obtenerNombreProductoReservado() + ";" + estado + ";" + totalPagar;
    }

    /**
     * Método que formatea y retorna un resumen de la clase para mostrarlo por consola.
     * @return Texto en 2 líneas con la descripción de la clase.
     */
    @Override
    public String toString() {

        return "Reserva N.º: " + numero + " / Fecha: " + fecha + " / Cliente: " + cliente.getNombre() + " / Pasajeros: " + cantidadPasajeros + "\nProducto Reservado: " + obtenerNombreProductoReservado() + " / Estado: " + estado + " / Total a pagar: $" + totalPagar;
    }
}

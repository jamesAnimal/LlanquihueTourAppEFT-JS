package com.llanquihuetour.model;

/**
 * Clase que implementa Registrable para definir los métodos y atributos más básicos de los servicios turísticos en la agencia.
 * @author Jaime Seguel.
 * @since Semana 6
 */
public abstract class ServicioTuristico implements Registrable {

    private int codigo;
    private String nombre;
    private Double duracionHoras;
    private String comuna;
    private Double precio;
    private String horario;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public ServicioTuristico() {

        this.codigo = 0;
        this.nombre = "Sin Registrar";
        this.duracionHoras = 0.0;
        this.comuna = "Sin Registrar";
        this.precio = 0.0;
        this.horario = "Sin Registrar";
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param codigo Código del servicio turístico.
     * @param nombre Nombre del servicio turístico.
     * @param duracionHoras Duración del servicio turístico.
     * @param comuna Comuna en donde se desarrolla el servicio turístico.
     * @param precio Precio del servicio turístico.
     * @param horario Horario del servicio turístico.
     */
    public ServicioTuristico(int codigo, String nombre, Double duracionHoras, String comuna, Double precio, String horario) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
        this.comuna = comuna;
        this.precio = precio;
        this.horario = horario;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(Double duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * Método implementado desde Registrable para formatear los datos que se mostraran en las areas de texto.
     * @return String con texto formateado con los datos del objeto.
     */
    @Override
    public String mostrarDatos() {

        return  "Código de Tour: " + codigo + "\n" +
                "Nombre del Tour: " + nombre + "\n" +
                "Duración en Horas: " + duracionHoras + "\n" +
                "Comuna en donde se desarrolla: " + comuna + "\n" +
                "Precio de Tour: " + precio + "\n" +
                "Horario: " + horario;
    }

    /**
     * Método implementado desde Registrable que formatea el texto con los datos que serán escritos en sus respectivos archivos .txt.
     * @return String con los datos del objeto.
     */
    @Override
    public String Registrar() {

        return codigo + ";" + nombre + ";" + duracionHoras + ";" + comuna + ";" + precio + ";" + horario;
    }

    /**
     * Método que formatea y retorna un resumen de la clase para mostrarlo por consola.
     * @return Texto en 2 líneas con la descripción de la clase.
     */
    @Override
    public String toString() {

        return "Código: " + codigo + " / Nombre: " + nombre + " / Duración: " + duracionHoras + " hrs / Comuna: " + comuna + " / Precio: $" + precio + "\nHorario: " + horario;
    }
}

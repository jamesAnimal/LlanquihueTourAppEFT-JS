package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase ServicioTuristico e implementa Registrable para definir los métodos y atributos de un objeto ExcursionCultural.
 * @author Jaime Seguel.
 * @since Semana 6
 */
public class ExcursionCultural extends ServicioTuristico implements Registrable {

    private String lugarHistorico;
    private String idiomaGuia;
    private boolean incluyeEntradas;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public ExcursionCultural() {

        super();
        this.lugarHistorico = "Sin Registrar";
        this.idiomaGuia = "Sin Registrar";
        this.incluyeEntradas = false;
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param codigo Código de la excursion cultural.
     * @param nombre Nombre de la excursion cultural.
     * @param duracionHoras Duración en horas de la excursion cultural.
     * @param comuna Comuna en donde se realiza la excursion cultural.
     * @param precio Precio de la excursion cultural.
     * @param horario Horario de la excursion cultural.
     * @param lugarHistorico Lugar histórico a visitar en la excursion cultural.
     * @param idiomaGuia Idiomas que maneja el guía de la excursion cultural.
     * @param incluyeEntradas Si el servicio turístico incluye las entradas a los lugares históricos o no.
     */
    public ExcursionCultural(int codigo, String nombre, Double duracionHoras, String comuna, Double precio, String horario,
                             String lugarHistorico, String idiomaGuia, boolean incluyeEntradas) {

        super(codigo, nombre, duracionHoras, comuna, precio, horario);
        this.lugarHistorico = lugarHistorico;
        this.idiomaGuia = idiomaGuia;
        this.incluyeEntradas = incluyeEntradas;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    public String getIdiomaGuia() {
        return idiomaGuia;
    }

    public void setIdiomaGuia(String idiomaGuia) {
        this.idiomaGuia = idiomaGuia;
    }

    public boolean isIncluyeEntradas() {
        return incluyeEntradas;
    }

    public void setIncluyeEntradas(boolean incluyeEntradas) {
        this.incluyeEntradas = incluyeEntradas;
    }

    // Método para formatear un boolean a string.
    public String incluyeEntradasFormateo() {

        if (this.isIncluyeEntradas()) {

            return "Sí";

        } else  {

            return "No";
        }
    }

    /**
     * Método implementado desde Registrable para formatear los datos que se mostraran en las areas de texto.
     * @return String con texto formateado con los datos del objeto.
     */
    @Override
    public String mostrarDatos() {
        
        return "===Excursión Cultural===\n" +
                "Código: " + getCodigo() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Duración Horas: " + getDuracionHoras() + "\n" +
                "Comuna: " + getComuna() + "\n" +
                "Precio: " + getPrecio() + "\n" +
                "Horario: " + getHorario() + "\n" +
                "Lugar Histórico: " + getLugarHistorico() + "\n" +
                "Idioma Guía: " + getIdiomaGuia() + "\n" +
                "Incluye Entradas: " + incluyeEntradasFormateo();
    }

    /**
     * Método implementado desde Registrable que formatea el texto con los datos que serán escritos en sus respectivos archivos .txt.
     * @return String con los datos del objeto.
     */
    @Override
    public String Registrar() {
        
        return super.Registrar() + ";" + lugarHistorico + ";" + idiomaGuia + ";" + incluyeEntradas;
    }

    /**
     * Método que formatea y retorna un resumen de la clase para mostrarlo por consola.
     * @return Texto en 2 líneas con la descripción de la clase.
     */
    @Override
    public String toString() {
        
        return "Excursión Cultural: " + super.toString() + " / Lugar: " + lugarHistorico + " / Idioma Guía: " + idiomaGuia + " / Entradas: " + incluyeEntradasFormateo();
    }
}

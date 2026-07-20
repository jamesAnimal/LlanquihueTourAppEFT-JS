package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase ServicioTuristico e implementa Registrable para definir los métodos y atributos de un objeto PaseoLacustre.
 * @author Jaime Seguel.
 * @since Semana 6
 */
public class PaseoLacustre extends ServicioTuristico implements Registrable {

    private String tipoEmbarcacion;
    private int capacidadPasajeros;
    private boolean permitePescar;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public PaseoLacustre() {

        super();
        this.tipoEmbarcacion = "Sin Registrar";
        this.capacidadPasajeros = 0;
        this.permitePescar = false;
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param codigo Código del paseo lacustre.
     * @param nombre Nombre del paseo lacustre.
     * @param duracionHoras Duración en horas del paseo lacustre.
     * @param comuna Comuna en donde se realiza el paseo lacustre.
     * @param precio Precio del paseo lacustre.
     * @param horario Horario del paseo lacustre.
     * @param tipoEmbarcacion Tipo de la embarcación a usar en el paseo lacustre.
     * @param permitePescar Si se permite pescar en el paseo lacustre o no.
     * @param capacidadPasajeros Capacidad de pasajeros de la embarcación del paseo lacustre.
     */
    public PaseoLacustre(int codigo, String nombre, Double duracionHoras, String comuna, Double precio, String horario,
                         String tipoEmbarcacion, boolean permitePescar, int capacidadPasajeros) {

        super(codigo, nombre, duracionHoras, comuna, precio, horario);
        this.tipoEmbarcacion = tipoEmbarcacion;
        this.permitePescar = permitePescar;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public boolean isPermitePescar() {
        return permitePescar;
    }

    public void setPermitePescar(boolean permitePescar) {
        this.permitePescar = permitePescar;
    }

    // Método para formatear un boolean a string.
    public String permisoPescaFormateo() {

        if (this.isPermitePescar()) {

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
        
        return "===Paseo Lacustre===\n" +
                "Código: " + getCodigo() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Duración Horas: " + getDuracionHoras() + "\n" +
                "Comuna: " + getComuna() + "\n" +
                "Precio: " + getPrecio() + "\n" +
                "Horario: " + getHorario() + "\n" +
                "Tipo Embarcación: " + getTipoEmbarcacion() + "\n" +
                "Capacidad de Pasajeros: " + getCapacidadPasajeros() + "\n" +
                "Permite Pescar: " + permisoPescaFormateo();
    }

    /**
     * Método implementado desde Registrable que formatea el texto con los datos que serán escritos en sus respectivos archivos .txt.
     * @return String con los datos del objeto.
     */
    @Override
    public String Registrar() {
        
        return super.Registrar() + ";" + tipoEmbarcacion + ";" + permitePescar + ";" + capacidadPasajeros;
    }

    /**
     * Método que formatea y retorna un resumen de la clase para mostrarlo por consola.
     * @return Texto en 2 líneas con la descripción de la clase.
     */
    @Override
    public String toString() {
        
        return "Paseo Lacustre: " + super.toString() + " / Embarcación: " + tipoEmbarcacion + " / Capacidad Pax: " + capacidadPasajeros + " / Pesca: " + permisoPescaFormateo();
    }
}

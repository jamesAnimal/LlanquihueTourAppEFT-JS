package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase ServicioTuristico e implementa Registrable para definir los métodos y atributos de un objeto RutaGastronomica.
 * @author Jaime Seguel.
 * @since Semana 6
 */
public class RutaGastronomica extends ServicioTuristico implements Registrable {

    private int numeroDeParadas;
    private boolean opcionVegetariana;
    private String condicionAlimentaria;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public RutaGastronomica() {

        super();
        this.numeroDeParadas = 0;
        this.opcionVegetariana = false;
        this.condicionAlimentaria = "Sin Registrar";
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param codigo Código de la ruta gastronómica.
     * @param nombre Nombre de la ruta gastronómica.
     * @param duracionHoras Duración en horas de la ruta gastronómica.
     * @param comuna Comuna en donde se realiza la ruta gastronómica.
     * @param precio Precio de la ruta gastronómica.
     * @param horario Horario de la ruta gastronómica.
     * @param numeroDeParadas Número de locales que va a recorrer la ruta gastronómica.
     * @param opcionVegetariana Si la ruta gastronómica tiene opción vegetariana o no.
     * @param condicionAlimentaria Qué condiciones de salud alimentaria tiene la ruta gastronómica.
     */
    public RutaGastronomica(int codigo, String nombre, Double duracionHoras, String comuna, Double precio, String horario,
                            int numeroDeParadas, boolean opcionVegetariana, String condicionAlimentaria) {

        super(codigo, nombre, duracionHoras, comuna, precio, horario);
        this.numeroDeParadas = numeroDeParadas;
        this.opcionVegetariana = opcionVegetariana;
        this.condicionAlimentaria = condicionAlimentaria;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroParadas) {
        this.numeroDeParadas = numeroParadas;
    }

    public boolean isOpcionVegetariana() {
        return opcionVegetariana;
    }

    public void setOpcionVegetariana(boolean opcionVegetariana) {
        this.opcionVegetariana = opcionVegetariana;
    }

    public String getCondicionAlimentaria() {
        return condicionAlimentaria;
    }

    public void setCondicionAlimentaria(String condicionAlimentaria) {
        this.condicionAlimentaria = condicionAlimentaria;
    }

    // Método para formatear un boolean a string.
    public String opcionVegetarianFormateo() {

        if (this.isOpcionVegetariana()) {

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
        
        return "===Ruta Gastronómica===\n" +
                "Código: " + getCodigo() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Duración Horas: " + getDuracionHoras() + "\n" +
                "Comuna: " + getComuna() + "\n" +
                "Precio: " + getPrecio() + "\n" +
                "Horario: " + getHorario() + "\n" +
                "Número de Paradas: " + getNumeroDeParadas() + "\n" +
                "Opción Vegetariana: " + opcionVegetarianFormateo() + "\n" +
                "Condición Alimentaria: " + getCondicionAlimentaria();
    }

    /**
     * Método implementado desde Registrable que formatea el texto con los datos que serán escritos en sus respectivos archivos .txt.
     * @return String con los datos del objeto.
     */
    @Override
    public String Registrar() {
        
        return super.Registrar() + ";" + numeroDeParadas + ";" + opcionVegetariana + ";" + condicionAlimentaria;
    }

    /**
     * Método que formatea y retorna un resumen de la clase para mostrarlo por consola.
     * @return Texto en 2 líneas con la descripción de la clase.
     */
    @Override
    public String toString() {
        
        return "Ruta Gastronómica: " + super.toString() + " / Paradas: " + numeroDeParadas + " / Opción Veg: " + opcionVegetarianFormateo() + " / Condición Alim: " + condicionAlimentaria;
    }
}

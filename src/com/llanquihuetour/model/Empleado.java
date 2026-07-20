package com.llanquihuetour.model;

/**
 * Clase que se extiende de la clase Persona e implementa Registrable para definir los métodos y atributos de un objeto Empleado.
 * @author Jaime Seguel.
 * @since Semana 3
 */
public class Empleado extends Persona implements Registrable {

    private String cargo;
    private String turno;
    private Double sueldo;

    /**
     * Constructor que inicializa el objeto con datos vacíos por defecto para luego ser rellenados.
     */
    public Empleado() {

        super();
        this.cargo = "Sin registrar";
        this.turno = "Sin registrar";
        this.sueldo = 0.0;
    }

    /**
     * Constructor que inicializa el objeto con los datos agregados directamente.
     * @param cargo Cargo del empleado.
     * @param turno Turno del empleado.
     * @param sueldo Sueldo del empleado.
     * @param nombre Nombre del empleado.
     * @param rut Rut del empleado.
     * @param fono Teléfono del empleado.
     * @param direccion Dirección del empleado.
     */
    public Empleado(String cargo, String turno, Double sueldo, String nombre, String rut, String fono, Direccion direccion) {

        super(nombre, rut, fono, direccion);
        this.cargo = cargo;
        this.turno = turno;
        this.sueldo = sueldo;
    }

    // Métodos setters y getters para crear el flujo de datos con los atributos privados.
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Método implementado desde Registrable para formatear los datos que se mostraran en las areas de texto.
     * @return String con texto formateado con los datos del objeto.
     */
    @Override
    public String mostrarDatos() {

        return "-----Datos del Empleado-----\n"
                + super.mostrarDatos()
                + "Cargo: " + cargo + "\n"
                + "Turno: " + turno + "\n"
                + "Sueldo: " + sueldo + "\n";
    }

    /**
     * Método implementado desde Registrable que formatea el texto con los datos que serán escritos en sus respectivos archivos .txt.
     * @return String con los datos del objeto.
     */
    @Override
    public String Registrar() {

        return super.Registrar() + ";" + cargo + ";" + turno + ";" + sueldo;
    }

    /**
     * Método que formatea y retorna un resumen de la clase para mostrarlo por consola.
     * @return Texto en 2 líneas con la descripción de la clase.
     */
    @Override
    public String toString() {

        return "Empleado: " + super.toString() + "\nCargo: " + cargo + " / Turno: " + turno + " / Sueldo: $" + sueldo;
    }
}

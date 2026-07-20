package com.llanquihuetour.data;

import com.llanquihuetour.model.*;
import com.llanquihuetour.util.GestorArchivos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de almacenar y gestionar a todas las personas de la agencia.
 * @author Jaime Seguel.
 * @since Semana 9
 */
public class GestorPersonas {

    private List<Persona> listaPersonas;
    private String rutaClientes = "src/resources/files/Clientes.txt";
    private String rutaEmpleados = "src/resources/files/Empleados.txt";
    private String rutaGuias = "src/resources/files/GuiasTuristicos.txt";
    private String rutaTransportes = "src/resources/files/ProveedoresTransporte.txt";
    private String rutaAlojamientos = "src/resources/files/ProveedoresAlojamiento.txt";

    /**
     * Constructor que inicializa la lista leyendo los datos desde los archivos .txt.
     */
    public GestorPersonas() {

        this.listaPersonas = new ArrayList<>();
        cargarPersonasDesdeArchivo();
    }

    /**
     * Método que procesa los datos extraídos de los archivos .txt y reconstruye los objetos para cargarlos en la lista.
     */
    private void cargarPersonasDesdeArchivo() {

        ArrayList<String[]> lineas;

        lineas = GestorArchivos.leerArchivoGeneral(rutaClientes);

        for (String[] partes : lineas) {

            String nombre = partes[0];
            String rut = partes[1];
            String fono = partes[2];
            String calle = partes[3];
            String numero = partes[4];
            String ciudad = partes[5];
            String region = partes[6];
            int edad = Integer.parseInt(partes[7]);
            String idioma = partes[8];
            String emergencia = partes[9];
            
            Direccion dir = new Direccion(calle, numero, ciudad, region);
            Cliente cliente = new Cliente(idioma, edad, emergencia, nombre, rut, fono, dir);
            this.listaPersonas.add(cliente);
        }

        lineas = GestorArchivos.leerArchivoGeneral(rutaEmpleados);

        for (String[] partes : lineas) {

            String nombre = partes[0];
            String rut = partes[1];
            String fono = partes[2];
            String calle = partes[3];
            String numero = partes[4];
            String ciudad = partes[5];
            String region = partes[6];
            String cargo = partes[7];
            String turno = partes[8];
            Double sueldo = Double.parseDouble(partes[9]);
            
            Direccion dir = new Direccion(calle, numero, ciudad, region);
            Empleado empleado = new Empleado(cargo, turno, sueldo, nombre, rut, fono, dir);
            this.listaPersonas.add(empleado);
        }

        lineas = GestorArchivos.leerArchivoGeneral(rutaGuias);

        for (String[] partes : lineas) {

            String nombre = partes[0];
            String rut = partes[1];
            String fono = partes[2];
            String calle = partes[3];
            String numero = partes[4];
            String ciudad = partes[5];
            String region = partes[6];
            String idiomas = partes[7];
            String zonas = partes[8];
            String credencial = partes[9];
            
            Direccion dir = new Direccion(calle, numero, ciudad, region);
            GuiaTuristico guia = new GuiaTuristico(nombre, rut, fono, dir, idiomas, zonas, credencial);
            this.listaPersonas.add(guia);
        }

        lineas = GestorArchivos.leerArchivoGeneral(rutaTransportes);

        for (String[] partes : lineas) {

            String nombre = partes[0];
            String rut = partes[1];
            String fono = partes[2];
            String calle = partes[3];
            String numero = partes[4];
            String ciudad = partes[5];
            String region = partes[6];
            String sitioWeb = partes[7];
            int tarifa = Integer.parseInt(partes[8]);
            String tipoVehiculos = partes[9];
            int cantidad = Integer.parseInt(partes[10]);
            int pasajeros = Integer.parseInt(partes[11]);
            
            Direccion dir = new Direccion(calle, numero, ciudad, region);
            ProveedorTransporte transporte = new ProveedorTransporte(sitioWeb, tarifa, nombre, rut, fono, dir, tipoVehiculos, cantidad, pasajeros);
            this.listaPersonas.add(transporte);
        }

        lineas = GestorArchivos.leerArchivoGeneral(rutaAlojamientos);

        for (String[] partes : lineas) {

            String nombre = partes[0];
            String rut = partes[1];
            String fono = partes[2];
            String calle = partes[3];
            String numero = partes[4];
            String ciudad = partes[5];
            String region = partes[6];
            String sitioWeb = partes[7];
            int tarifa = Integer.parseInt(partes[8]);
            String tipoAlojamiento = partes[9];
            int capacidad = Integer.parseInt(partes[10]);
            String alimentacion = partes[11];
            
            Direccion dir = new Direccion(calle, numero, ciudad, region);
            ProveedorAlojamiento alojamiento = new ProveedorAlojamiento(sitioWeb, tarifa, nombre, rut, fono, dir, tipoAlojamiento, capacidad, alimentacion);
            this.listaPersonas.add(alojamiento);
        }
    }

    /**
     * Método que agrega una nueva persona a la lista (listaPersonas) y escribe sus datos en el archivo .txt correspondiente.
     * @param persona Objeto Persona ya validado y creado.
     */
    public void agregarPersona(Persona persona) {

        this.listaPersonas.add(persona);

        if (persona instanceof Cliente) {

            GestorArchivos.escribirArchivoGeneral(rutaClientes, persona.Registrar());

        } else if (persona instanceof Empleado) {

            GestorArchivos.escribirArchivoGeneral(rutaEmpleados, persona.Registrar());

        } else if (persona instanceof GuiaTuristico) {

            GestorArchivos.escribirArchivoGeneral(rutaGuias, persona.Registrar());

        } else if (persona instanceof ProveedorTransporte) {

            GestorArchivos.escribirArchivoGeneral(rutaTransportes, persona.Registrar());

        } else if (persona instanceof ProveedorAlojamiento) {

            GestorArchivos.escribirArchivoGeneral(rutaAlojamientos, persona.Registrar());
        }
    }

    /**
     * Método que construye un texto con el resumen de las personas ya filtradas según el tipo seleccionado.
     * @param filtro Criterio de filtro ("Todos", "Cliente", "Empleado", "Guía Turístico", "ProveedorTransporte", "ProveedorAlojamiento").
     * @return String con la lista formateada de resúmenes.
     */
    public String obtenerResumenPersonas(String filtro) {

        if (this.listaPersonas.isEmpty()) {

            return "No hay registros de personas en el sistema.";
        }

        String resumen = "";

        for (Persona persona : listaPersonas) {

            if (persona instanceof Cliente) {

                if (filtro.equals("Todos") || filtro.equals("Cliente")) {

                    resumen += persona.mostrarDatos() + "\n";
                    resumen += "--------------------------------------------------\n";
                }

            } else if (persona instanceof Empleado) {

                if (filtro.equals("Todos") || filtro.equals("Empleado")) {

                    resumen += persona.mostrarDatos() + "\n";
                    resumen += "--------------------------------------------------\n";
                }

            } else if (persona instanceof GuiaTuristico) {

                if (filtro.equals("Todos") || filtro.equals("Guía Turístico")) {

                    resumen += persona.mostrarDatos() + "\n";
                    resumen += "--------------------------------------------------\n";
                }

            } else if (persona instanceof ProveedorTransporte) {

                if (filtro.equals("Todos") || filtro.equals("Proveedor Transporte")) {

                    resumen += persona.mostrarDatos() + "\n";
                    resumen += "--------------------------------------------------\n";
                }

            } else if (persona instanceof ProveedorAlojamiento) {

                if (filtro.equals("Todos") || filtro.equals("Proveedor Alojamiento")) {

                    resumen += persona.mostrarDatos() + "\n";
                    resumen += "--------------------------------------------------\n";
                }
            }
        }

        if (resumen.isEmpty()) {

            return "No hay registros para la categoría seleccionada: " + filtro;
        }

        return resumen;
    }

    /**
     * Método que busca una persona por su RUT.
     * @param rut El RUT a buscar.
     * @return Persona si existe, o null si no se encuentra.
     */
    public Persona buscarPersonaPorRut(String rut) {

        for (Persona persona : listaPersonas) {

            if (persona.getRut().equals(rut)) {

                return persona;
            }
        }
        return null;
    }

    /**
     * Método que retorna la lista completa de las personas registradas.
     * @return Lista de todas las personas de la agencia.
     */
    public List<Persona> getListaPersonas() {

        return this.listaPersonas;
    }
}

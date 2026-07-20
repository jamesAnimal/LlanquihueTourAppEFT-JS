package com.llanquihuetour.data;

import com.llanquihuetour.model.*;
import com.llanquihuetour.util.GestorArchivos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de almacenar y gestionar todas las reservas de la agencia.
 * @author Jaime Seguel.
 * @since Semana 9
 */
public class GestorReservas {

    private List<Reserva> listaReservas;
    private String rutaReserva = "src/resources/files/Reservas.txt";

    /**
     * Constructor que inicializa la lista leyendo los datos desde el archivo .txt.
     */
    public GestorReservas() {

        this.listaReservas = new ArrayList<>();
        cargarReservasDesdeArchivo();
    }

    /**
     * Método que procesa los datos extraídos de los archivos .txt y reconstruye los objetos para cargarlos en la lista.
     */
    private void cargarReservasDesdeArchivo() {

        ArrayList<String[]> lineas = GestorArchivos.leerArchivoGeneral(rutaReserva);

        for (String[] partes : lineas) {

            int numero = Integer.parseInt(partes[0]);
            String fecha = partes[1];
            String nombreCliente = partes[2];
            int cantidadPasajeros = Integer.parseInt(partes[3]);
            String tipoProducto = partes[4];
            String nombreProducto = partes[5];
            String estado = partes[6];
            int totalPagar = Integer.parseInt(partes[7]);

            Reserva reserva = new Reserva();
            reserva.setNumero(numero);
            reserva.setFecha(fecha);
            reserva.setCantidadPasajeros(cantidadPasajeros);
            reserva.setEstado(estado);
            reserva.setTotalPagar(totalPagar);

            Cliente cliente = new Cliente();
            cliente.setNombre(nombreCliente);
            reserva.setCliente(cliente);

            if (tipoProducto.equals("Paquete")) {

                PaqueteTuristico paqueteTuristico = new PaqueteTuristico();
                paqueteTuristico.setNombre(nombreProducto);
                reserva.setPaqueteAsociado(paqueteTuristico);
                reserva.setServicioAsociado(null);

            } else if (tipoProducto.equals("PaseoLacustre")) {

                PaseoLacustre paseoLacustre = new PaseoLacustre();
                paseoLacustre.setNombre(nombreProducto);
                reserva.setServicioAsociado(paseoLacustre);
                reserva.setPaqueteAsociado(null);

            } else if (tipoProducto.equals("ExcursionCultural")) {

                ExcursionCultural excursion = new ExcursionCultural();
                excursion.setNombre(nombreProducto);
                reserva.setServicioAsociado(excursion);
                reserva.setPaqueteAsociado(null);

            } else if (tipoProducto.equals("RutaGastronomica")) {

                RutaGastronomica ruta = new RutaGastronomica();
                ruta.setNombre(nombreProducto);
                reserva.setServicioAsociado(ruta);
                reserva.setPaqueteAsociado(null);
            }

            this.listaReservas.add(reserva);
        }
    }

    /**
     * Método que agrega una nueva reserva a la lista (listaReservas) y escribe sus datos en el archivo .txt correspondiente.
     * @param reserva Objeto Reserva ya validado y creado.
     */
    public void agregarReserva(Reserva reserva) {

        this.listaReservas.add(reserva);
        GestorArchivos.escribirArchivoGeneral(rutaReserva, reserva.Registrar());
    }

    /**
     * Método que construye un texto con el resumen de las reservas ya filtradas según el tipo seleccionado.
     * @param filtro Criterio de filtro ("Todas", "Confirmada", "Pendiente", "Cancelada").
     * @return String con la lista formateada de resúmenes.
     */
    public String obtenerResumenReservas(String filtro) {

        if (this.listaReservas.isEmpty()) {

            return "No hay reservas registradas en el sistema.";
        }

        String resumen = "";

        for (Reserva reserva : listaReservas) {

            if (filtro.equals("Todas") || filtro.equals(reserva.getEstado())) {

                resumen += reserva.mostrarDatos() + "\n";
                resumen += "--------------------------------------------------\n";
            }
        }

        if (resumen.isEmpty()) {

            return "No hay reservas para la categoría seleccionada: " + filtro;
        }

        return resumen;
    }
}

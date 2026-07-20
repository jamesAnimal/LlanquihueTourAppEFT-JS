package com.llanquihuetour.data;

import com.llanquihuetour.model.*;
import com.llanquihuetour.util.GestorArchivos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de almacenar y gestionar todos los servicios y paquetes turísticos de la agencia.
 * @author Jaime Seguel.
 * @since Semana 9
 */
public class GestorCatalogo {

    private List<Registrable> listaCatalogo;
    private String rutaPaseos = "src/resources/files/PaseosLacustres.txt";
    private String rutaExcursiones = "src/resources/files/ExcursionesCulturales.txt";
    private String rutaRutas = "src/resources/files/RutasGastronomicas.txt";
    private String rutaPaquetes = "src/resources/files/PaquetesTuristicos.txt";

    /**
     * Constructor que inicializa la lista leyendo los datos desde los archivos .txt.
     */
    public GestorCatalogo() {

        this.listaCatalogo = new ArrayList<>();
        cargarCatalogoDesdeArchivo();
    }

    /**
     * Método que procesa los datos extraídos de los archivos .txt y reconstruye los objetos para cargarlos en la lista.
     */
    private void cargarCatalogoDesdeArchivo() {

        ArrayList<String[]> lineas;

        lineas = GestorArchivos.leerArchivoGeneral(rutaPaseos);

        for (String[] partes : lineas) {

            int codigo = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            double duracionHoras = Double.parseDouble(partes[2]);
            String comuna = partes[3];
            double precio = Double.parseDouble(partes[4]);
            String horario = partes[5];
            String tipoEmbarcacion = partes[6];
            boolean permitePescar = Boolean.parseBoolean(partes[7]);
            int capacidad = Integer.parseInt(partes[8]);
            
            PaseoLacustre paseo = new PaseoLacustre(codigo, nombre, duracionHoras, comuna, precio, horario, tipoEmbarcacion, permitePescar, capacidad);
            this.listaCatalogo.add(paseo);
        }

        lineas = GestorArchivos.leerArchivoGeneral(rutaExcursiones);

        for (String[] partes : lineas) {

            int codigo = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            double duracionHoras = Double.parseDouble(partes[2]);
            String comuna = partes[3];
            double precio = Double.parseDouble(partes[4]);
            String horario = partes[5];
            String lugarHistorico = partes[6];
            String idiomaGuia = partes[7];
            boolean incluyeEntradas = Boolean.parseBoolean(partes[8]);
            
            ExcursionCultural excursion = new ExcursionCultural(codigo, nombre, duracionHoras, comuna, precio, horario, lugarHistorico, idiomaGuia, incluyeEntradas);
            this.listaCatalogo.add(excursion);
        }

        lineas = GestorArchivos.leerArchivoGeneral(rutaRutas);

        for (String[] partes : lineas) {

            int codigo = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            double duracionHoras = Double.parseDouble(partes[2]);
            String comuna = partes[3];
            double precio = Double.parseDouble(partes[4]);
            String horario = partes[5];
            int numeroParadas = Integer.parseInt(partes[6]);
            boolean opcionVegetariana = Boolean.parseBoolean(partes[7]);
            String condicionAlimentaria = partes[8];
            
            RutaGastronomica ruta = new RutaGastronomica(codigo, nombre, duracionHoras, comuna, precio, horario, numeroParadas, opcionVegetariana, condicionAlimentaria);
            this.listaCatalogo.add(ruta);
        }

        lineas = GestorArchivos.leerArchivoGeneral(rutaPaquetes);

        for (String[] partes : lineas) {

            String nombre = partes[0];
            String fechas = partes[1];
            String nombreTransporte = partes[2];
            String nombreAlojamiento = partes[3];
            String nombreGuia = partes[4];
            int precio = Integer.parseInt(partes[5]);
            String actividad1 = partes[6];
            String actividad2 = partes[7];
            String actividad3 = partes[8];

            PaqueteTuristico paquete = new PaqueteTuristico();
            paquete.setNombre(nombre);
            paquete.setFechas(fechas);
            paquete.setPrecio(precio);

            ProveedorTransporte proveedorTransporte = new ProveedorTransporte();
            proveedorTransporte.setNombre(nombreTransporte);
            paquete.setTransporte(proveedorTransporte);

            ProveedorAlojamiento proveedorAlojamiento = new ProveedorAlojamiento();
            proveedorAlojamiento.setNombre(nombreAlojamiento);
            paquete.setAlojamiento(proveedorAlojamiento);

            GuiaTuristico guiaTuristico = new GuiaTuristico();
            guiaTuristico.setNombre(nombreGuia);
            paquete.setGuiaAsignado(guiaTuristico);
            
            paquete.setActividad1(actividad1);
            paquete.setActividad2(actividad2);
            paquete.setActividad3(actividad3);

            this.listaCatalogo.add(paquete);
        }
    }

    /**
     * Método que agrega un nuevo producto (paquete o servicio turístico) a la lista (listaCatalogo) y escribe sus datos en el archivo .txt correspondiente.
     * @param producto Objeto paquete turístico o servicio turístico ya validado y creado.
     */
    public void agregarProducto(Registrable producto) {

        this.listaCatalogo.add(producto);

        if (producto instanceof PaseoLacustre) {

            GestorArchivos.escribirArchivoGeneral(rutaPaseos, producto.Registrar());

        } else if (producto instanceof ExcursionCultural) {

            GestorArchivos.escribirArchivoGeneral(rutaExcursiones, producto.Registrar());

        } else if (producto instanceof RutaGastronomica) {

            GestorArchivos.escribirArchivoGeneral(rutaRutas, producto.Registrar());

        } else if (producto instanceof PaqueteTuristico) {

            GestorArchivos.escribirArchivoGeneral(rutaPaquetes, producto.Registrar());
        }
    }

    /**
     * Método que construye un texto con el resumen de los productos filtrados según el tipo seleccionado.
     * @param filtro Criterio de filtro ("Todos", "Servicios", "PaseoLacustre", "ExcursionCultural", "RutaGastronomica", "Paquetes").
     * @return String con la lista formateada de resúmenes.
     */
    public String obtenerResumenCatalogo(String filtro) {

        if (this.listaCatalogo.isEmpty()) {

            return "No hay items registrados en el catálogo.";
        }

        String resumen = "";

        for (Registrable producto : listaCatalogo) {

            if (producto instanceof PaseoLacustre) {

                if (filtro.equals("Todos") || filtro.equals("Paseo Lacustre")) {

                    resumen += producto.mostrarDatos() + "\n";
                    resumen += "--------------------------------------------------\n";
                }

            } else if (producto instanceof ExcursionCultural) {

                if (filtro.equals("Todos") || filtro.equals("Excursión Cultural")) {

                    resumen += producto.mostrarDatos() + "\n";
                    resumen += "--------------------------------------------------\n";
                }

            } else if (producto instanceof RutaGastronomica) {

                if (filtro.equals("Todos") || filtro.equals("Ruta Gastronómica")) {

                    resumen += producto.mostrarDatos() + "\n";
                    resumen += "--------------------------------------------------\n";
                }

            } else if (producto instanceof PaqueteTuristico) {

                if (filtro.equals("Todos") || filtro.equals("Paquete Turístico")) {

                    resumen += producto.mostrarDatos() + "\n";
                    resumen += "--------------------------------------------------\n";
                }
            }
        }

        if (resumen.isEmpty()) {

            return "No hay items para la categoría " + filtro;
        }

        return resumen;
    }

    /**
     * Método que retorna la lista completa del catálogo de productos.
     * @return Lista de todos los productos del catálogo.
     */
    public List<Registrable> getListaCatalogo() {

        return listaCatalogo;
    }
}

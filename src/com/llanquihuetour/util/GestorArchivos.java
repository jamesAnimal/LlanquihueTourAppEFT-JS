package com.llanquihuetour.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que gestiona la lectura y escritura general de archivos .txt.
 * @author Jaime Seguel.
 * @since Semana 9
 */
public class GestorArchivos {

    /**
     * Método que abre el archivo, procesa cada línea mediante un bucle, separa los datos por punto y coma, y retorna una lista de arreglos.
     * Incluye una estructura de control de excepciones (try-catch) para manejar errores de entrada/salida.
     * @param rutaArchivo Ruta del archivo .txt.
     * @return Lista dinámica de arreglos de texto (cada arreglo representa una línea).
     */
    public static ArrayList<String[]> leerArchivoGeneral(String rutaArchivo) {

        ArrayList<String[]> listaDeDatos = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] partes = linea.split(";");
                listaDeDatos.add(partes);
            }

        } catch (IOException e) {

            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return listaDeDatos;
    }

    /**
     * Método que inserta una nueva línea de datos al final de un archivo .txt en modo de adición (Append) para no sobrescribir el contenido existente.
     * Incluye una estructura de control de excepciones (try-catch) para manejar errores de escritura.
     * @param rutaArchivo Ruta del archivo .txt.
     * @param nuevaLinea Texto formateado con punto y coma que se va a guardar.
     */
    public static void escribirArchivoGeneral(String rutaArchivo, String nuevaLinea) {

                try (BufferedWriter bufWrite = new BufferedWriter(new FileWriter(rutaArchivo, true))) {

            bufWrite.write(nuevaLinea);
            bufWrite.newLine();

        } catch (IOException e) {

            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
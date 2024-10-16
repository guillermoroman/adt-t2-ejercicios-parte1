import java.io.*;

public class Ejercicios1 {
    public static void main(String[] args) {
        // Llamar a cada método desde el main para probarlos.
        // No todas las llamadas funcionarán de forma directa;
        // se ha de observar si los archivos necesarios están disponibles,
        // y, en caso negativo, crearlos de forma que cumplan los requisitos
        // de los métodos.
        //
        // Se recomienda probar los métodos uno a uno.


//        verificarPermisos("archivo.txt");
//        verificarArchivoDirectorio("directorio");
//        obtenerTamañoArchivo("archivo.txt");
//        obtenerDirectorioPadre("archivo.txt");
//        listarContenidoDirectorio(ruta);
//        crearArchivo(ruta);
//        crearArchivoTemporal(prefijo, sufijo);
//
//        eliminarArchivo(ruta);
//        renombrarArchivo(rutaActual, nuevaRuta);
//        escribirMensajeBytes(ruta, mensaje);
//        escribirNumeros(ruta);
//
//        crearDirectorio(ruta);
//        convertirAPath(ruta);
//        abrirArchivo(ruta);
//        leerPrimeros5Bytes(ruta);
//        leerEnBufferMasGrande(ruta);
//        escribirCaracter(ruta);
//
//        leerArchivoCaracterPorCaracter("archivo.txt");
//        leerArchivoEnArray("datos.txt");
//        escribirMatrizEnArchivo("matriz.txt");
//        leerArchivoEnFragmentos("fragmentos.txt");
//        copiarArchivo("original.txt", "copia.txt");
//        contarPalabrasEnArchivo("texto.txt");
        obtenerEstadisticasArchivo("estadisticas.txt");
    }

    // Ejercicio 1: Verificar permisos de lectura, escritura y ejecución
    public static void verificarPermisos(String ruta) {
        File archivo = new File(ruta);
        System.out.println("Permisos de " + archivo.getName() + ":");
        System.out.println("Puede leer: " + archivo.canRead());
        System.out.println("Puede escribir: " + archivo.canWrite());
        System.out.println("Puede ejecutar: " + archivo.canExecute());
    }

    // Ejercicio 2: Verificar si existe y es archivo o directorio
    public static void verificarArchivoDirectorio(String ruta) {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            if (archivo.isFile()) {
                System.out.println(archivo.getName() + " es un archivo.");
            } else if (archivo.isDirectory()) {
                System.out.println(archivo.getName() + " es un directorio.");
            }
        } else {
            System.out.println("El archivo o directorio no existe.");
        }
    }

    // Ejercicio 3: Obtener el tamaño de un archivo
    public static void obtenerTamañoArchivo(String ruta) {
        File archivo = new File(ruta);
        if (archivo.exists() && archivo.isFile()) {
            System.out.println("El tamaño del archivo es: " + archivo.length() + " bytes.");
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    // Ejercicio 4: Obtener el directorio padre
    public static void obtenerDirectorioPadre(String ruta) {
        File archivo = new File(ruta);
        System.out.println("El directorio padre es: " + archivo.getParent());
    }

    // Ejercicio 5: Listar el contenido de un directorio
    public static void listarContenidoDirectorio(String ruta) {
        File directorio = new File(ruta);
        if (directorio.isDirectory()) {
            String[] archivos = directorio.list();
            if (archivos != null) {
                for (String archivo : archivos) {
                    System.out.println(archivo);
                }
            }
        } else {
            System.out.println(ruta + " no es un directorio.");
        }
    }

    // Ejercicio 6: Crear archivos
    public static void crearArchivo(String ruta) throws IOException {
        File archivo = new File(ruta);
        if (archivo.createNewFile()) {
            System.out.println("Archivo creado: " + archivo.getName());
        } else {
            System.out.println("El archivo ya existe.");
        }
    }

    public static void crearArchivoTemporal(String prefijo, String sufijo) throws IOException {
        File archivoTemp = File.createTempFile(prefijo, sufijo);
        System.out.println("Archivo temporal creado: " + archivoTemp.getName());
    }

    // Ejercicio 7: Eliminar y renombrar archivos
    public static void eliminarArchivo(String ruta) {
        File archivo = new File(ruta);
        if (archivo.delete()) {
            System.out.println("El archivo ha sido eliminado.");
        } else {
            System.out.println("El archivo no pudo ser eliminado.");
        }
    }

    public static void renombrarArchivo(String rutaActual, String nuevaRuta) {
        File archivoActual = new File(rutaActual);
        File nuevoArchivo = new File(nuevaRuta);
        if (archivoActual.renameTo(nuevoArchivo)) {
            System.out.println("Archivo renombrado a: " + nuevaRuta);
        } else {
            System.out.println("El archivo no pudo ser renombrado.");
        }
    }

    // Ejercicio 8: Crear un directorio
    public static void crearDirectorio(String ruta) {
        File directorio = new File(ruta);
        if (directorio.mkdir()) {
            System.out.println("Directorio creado: " + ruta);
        } else {
            System.out.println("No se pudo crear el directorio.");
        }
    }

    // Ejercicio 9: Convertir a objeto Path
    public static void convertirAPath(String ruta) {
        File archivo = new File(ruta);
        System.out.println("Path del archivo: " + archivo.toPath());
    }

    // Ejercicio 10: Abrir un archivo y comprobar su acceso
    public static void abrirArchivo(String ruta) {
        try (FileInputStream fis = new FileInputStream(ruta)) {
            System.out.println("El archivo se ha abierto correctamente.");
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        }
    }

    // Ejercicio 11: Leer y mostrar los primeros 5 bytes de un archivo
    public static void leerPrimeros5Bytes(String ruta) {
        try (FileInputStream fis = new FileInputStream(ruta)) {
            byte[] buffer = new byte[5];
            int leido = fis.read(buffer);
            if (leido > 0) {
                System.out.println("Primeros 5 bytes: " + new String(buffer, 0, leido));
            } else {
                System.out.println("El archivo tiene menos de 5 bytes.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Ejercicio 12: Leer una parte específica de un archivo en un buffer más grande
    public static void leerEnBufferMasGrande(String ruta) {
        try (FileInputStream fis = new FileInputStream(ruta)) {
            byte[] buffer = new byte[10];
            int leido = fis.read(buffer, 0, 5);
            System.out.println("Bytes leídos: " + new String(buffer, 0, leido));
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Ejercicio 13: Escribir un solo carácter en un archivo
    public static void escribirCaracter(String ruta) {
        try (OutputStream os = new FileOutputStream(ruta)) {
            os.write('A');
            System.out.println("Carácter 'A' escrito en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Ejercicio 14: Escribir un mensaje desde un array de bytes
    public static void escribirMensajeBytes(String ruta, String mensaje) {
        try (OutputStream os = new FileOutputStream(ruta, true)) {
            byte[] bytes = mensaje.getBytes();
            os.write(bytes);
            System.out.println("Mensaje escrito en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Ejercicio 15: Escribir una serie de números en un archivo
    public static void escribirNumeros(String ruta) {
        try (OutputStream os = new FileOutputStream(ruta)) {
            for (int i = 1; i <= 10; i++) {
                os.write(Integer.toString(i).getBytes());
                os.write('\n');
            }
            System.out.println("Números del 1 al 10 escritos en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Ejercicio 16: Leer un archivo carácter por carácter
    public static void leerArchivoCaracterPorCaracter(String ruta) {
        try (InputStream is = new FileInputStream(ruta)) {
            int caracter;
            while ((caracter = is.read()) != -1) {
                System.out.print((char) caracter);
            }
            System.out.println("\nLectura completada.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Ejercicio 17: Leer un archivo y almacenar el contenido en un array de bytes
    public static void leerArchivoEnArray(String ruta) {
        byte[] buffer = new byte[1024];
        try (InputStream is = new FileInputStream(ruta)) {
            int bytesLeidos = is.read(buffer);
            System.out.println("Bytes leídos: " + bytesLeidos);
            System.out.println("Contenido leído: " + new String(buffer, 0, bytesLeidos));
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Ejercicio 18: Escribir una matriz de caracteres en un archivo
    public static void escribirMatrizEnArchivo(String ruta) {
        char[][] matriz = {
                {'H', 'o', 'l', 'a'},
                {'J', 'a', 'v', 'a'},
                {'M', 'u', 'n', 'd', 'o'}
        };
        try (OutputStream os = new FileOutputStream(ruta)) {
            for (char[] fila : matriz) {
                for (char c : fila) {
                    os.write(c);
                }
                os.write('\n');  // Añadir nueva línea después de cada fila
            }
            System.out.println("Matriz escrita en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Ejercicio 19: Leer un archivo en fragmentos
    public static void leerArchivoEnFragmentos(String ruta) {
        byte[] buffer = new byte[50];
        try (InputStream is = new FileInputStream(ruta)) {
            int bytesLeidos;
            while ((bytesLeidos = is.read(buffer)) != -1) {
                System.out.println("Fragmento: " + new String(buffer, 0, bytesLeidos));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Ejercicio 20: Crear un archivo de copia
    public static void copiarArchivo(String origen, String destino) {
        byte[] buffer = new byte[256];
        try (InputStream is = new FileInputStream(origen);
             OutputStream os = new FileOutputStream(destino)) {
            int bytesLeidos;
            while ((bytesLeidos = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesLeidos);
            }
            System.out.println("Archivo copiado de " + origen + " a " + destino);
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo: " + e.getMessage());
        }
    }

    // Ejercicio 21: Contar las palabras en un archivo
    public static void contarPalabrasEnArchivo(String ruta) {
        try (InputStream is = new FileInputStream(ruta)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String linea;
            int contadorPalabras = 0;
            while ((linea = reader.readLine()) != null) {
                String[] palabras = linea.split("\\s+");
                contadorPalabras += palabras.length;
            }
            System.out.println("Número total de palabras: " + contadorPalabras);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Ejercicio 22: Realizar estadísticas de un archivo de texto
    public static void obtenerEstadisticasArchivo(String ruta) {
        try (InputStream is = new FileInputStream(ruta)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String linea;
            int contadorCaracteres = 0;
            int contadorPalabras = 0;
            int contadorLineas = 0;

            while ((linea = reader.readLine()) != null) {
                contadorLineas++;
                contadorCaracteres += linea.length() + 1;  // +1 por el salto de línea
                String[] palabras = linea.split("\\s+");
                contadorPalabras += palabras.length;
            }

            System.out.println("Estadísticas del archivo:");
            System.out.println("Total de caracteres: " + contadorCaracteres);
            System.out.println("Total de palabras: " + contadorPalabras);
            System.out.println("Total de líneas: " + contadorLineas);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }



}
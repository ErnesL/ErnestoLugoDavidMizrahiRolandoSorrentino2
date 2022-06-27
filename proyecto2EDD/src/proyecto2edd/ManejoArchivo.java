/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import static proyecto2edd.Metodos.hashFunc;

/**
 *
 * @author davidmizrahi
 */
public class ManejoArchivo {

    //Esta funcionalidad permite la creacion y escritura del archivo.
    public static void crearArchivo(String resumenes) {

        //File archivo = new File(nombreArchivo);
        try {
            PrintWriter pw = new PrintWriter("test//resumenes.txt");

//            PrintWriter salida = new PrintWriter(archivo);
//            salida.close();
            pw.print(resumenes);
            System.out.println("Se ha creado el archivo.");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void lecturaArchivo(String resumen, Articulo articulo) {

        Scanner scanner = new Scanner(resumen);
        int i = 0;
        String[] arrayCampos = new String[15];
        String linea = "";
        Lista<String> autores = new Lista<>();
        Lista<String> palabrasClave = new Lista<>();
        String concatenado = "";
        while (scanner.hasNext()) {
//                 i++;
//                 arrayCampos = new String[i+1];
            linea = scanner.nextLine();

            arrayCampos[i] = linea;
            i++;

        }

        articulo.setTitulo(arrayCampos[0]);
//                for (int j = 0; j < arrayCampos.length; j++) {
//                    System.out.println(arrayCampos[j]);
//            
//        }

        int j = 0;
        while (j < arrayCampos.length) {

            if (arrayCampos[j] != null) {

                if (arrayCampos[j].contains("Autores")) {

                    while (!arrayCampos[j + 1].contains("Resumen")) {

                        autores.agregarElemento(arrayCampos[j + 1]);
                        j++;
                    }
                } else if (arrayCampos[j].contains("Resumen")) {

                    articulo.setCuerpo(arrayCampos[j + 1]);
//                            System.out.println(articulo.getCuerpo());
                } else if (arrayCampos[j].contains("Palabras clave")) {
                    break;
                }
            }
            j++;
        }

        articulo.setAutores(autores);
        String keyWords = arrayCampos[j].substring(17).replace(", ", "/");

        String[] keyWordsArr = keyWords.split("/");
        for (int k = 0; k < keyWordsArr.length; k++) {
            palabrasClave.agregarElemento(keyWordsArr[k]);

        }

        articulo.mostrarInfo();

    }

    public static void eliminarArchivo() {
        File f0 = new File("test//resumenes.txt");
        if (f0.delete()) {
            System.out.println(f0.getName() + " file is deleted successfully.");
        } else {
            System.out.println("Unexpected error found in deletion of the file.");
        }

    }
}

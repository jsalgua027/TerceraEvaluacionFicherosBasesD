/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package general;

/**
 *
 * @author nacho
 */
public class Main7D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String directorio= "copias";
        String archivoVacioPrueba="ArchivoVacio.txt";
        ServicioArchivos.crearDirectorio(directorio);
        
        ServicioArchivos.crearFicheroVacio(directorio, archivoVacioPrueba);
    }
    
}

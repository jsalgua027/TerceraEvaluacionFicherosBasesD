/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package TXT;

/**
 *
 * @author Windows10
 */
public class PruebaTxt {

    public static void main(String[] args) {
        
           int matrizNumeros[][] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
           String archivo= "prueba.txt";
           
           Escritura.escrituraMatrizEnteros(matrizNumeros, archivo);
           
        
        
    }
}

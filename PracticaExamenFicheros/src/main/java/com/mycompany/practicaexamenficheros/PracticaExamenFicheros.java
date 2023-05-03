/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.practicaexamenficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows10
 */
public class PracticaExamenFicheros {
    
      public static void escritura(List<String> aux, String ruta) {

        String tmp = " ";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {

            for (String s : aux) {
                tmp = s.toString();
                flujo.write(tmp);
                flujo.newLine();
            }

            flujo.flush();

            System.out.println("Fichero " + ruta + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    
    

    public static void main(String[] args) {
       String palabra="";
       List<String>listadoPalabras=new ArrayList();
         JOptionPane.showMessageDialog(null, "Indique las palabras que quiera, para terminar indique terminar");
        do {            
          
            palabra=JOptionPane.showInputDialog(palabra);
            if(palabra.contains("teminar")){
            
            }else{
             listadoPalabras.add(palabra);
            }
           
            
        } while (!palabra.contains("terminar"));
        
        listadoPalabras.remove(listadoPalabras.size()-1);
                
        listadoPalabras.forEach(System.out::println);
        
        escritura(listadoPalabras, "ListaPalabras.txt");
        
    }
    
           
      
    
}

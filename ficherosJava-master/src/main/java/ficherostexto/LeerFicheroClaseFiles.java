/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherostexto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author carlos
 */
public class LeerFicheroClaseFiles {

    public static void main(String[] args) {
        List<String> lineas=new ArrayList<>();
        try {
            lineas = Files.readAllLines(Paths.get("RegAlum.csv"),
                    StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero");
        }
        for (String linea : lineas) {
            System.out.println(linea);
        }
    }
    
    

}

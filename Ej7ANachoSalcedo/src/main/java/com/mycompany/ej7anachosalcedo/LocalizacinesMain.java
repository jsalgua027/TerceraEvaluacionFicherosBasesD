/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ej7anachosalcedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author nacho
 */
public class LocalizacinesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UtilidadesFicheros.lecturaFicheroYMuestro("localizaciones.txt");

        List<String> listaStringCompleta = new ArrayList<>();

        List<String> listaStringPuntosCardinales = new ArrayList<>();
        Map<String, Integer> contadorPuntos = new TreeMap<>();

        listaStringCompleta = UtilidadesFicheros.lecturaFicheroPasoALista("localizaciones.txt");

        for (String l : listaStringCompleta) {

            System.out.println(l.toString());

        }

        listaStringPuntosCardinales = UtilidadesFicheros.devolverPuntosCardinales(listaStringCompleta);

        listaStringPuntosCardinales.forEach(System.out::println);

        contadorPuntos = UtilidadesFicheros.devulevoMap(listaStringCompleta);

        for (Map.Entry<String, Integer> entry : contadorPuntos.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println("key: " + key + "-- value: " + val);

        }

    }

}

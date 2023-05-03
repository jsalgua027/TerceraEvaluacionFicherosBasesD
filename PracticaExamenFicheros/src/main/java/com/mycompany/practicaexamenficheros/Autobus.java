/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaexamenficheros;

import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Windows10
 */
public class Autobus {
    
    
    private String codigoBus;
    private String origen;
    private String destino;
    private List<LocalTime> horarios;

    public Autobus() {
    }

    public String getCodigoBus() {
        return codigoBus;
    }

    public void setCodigoBus(String codigoBus) {
        this.codigoBus = codigoBus;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public List<LocalTime> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<LocalTime> horarios) {
        this.horarios = horarios;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Autobus{");
        sb.append("codigoBus=").append(codigoBus);
        sb.append(", origen=").append(origen);
        sb.append(", destino=").append(destino);
        sb.append(", horarios=").append(horarios);
        sb.append('}');
        return sb.toString();
    }

    

    
  
    
    
}

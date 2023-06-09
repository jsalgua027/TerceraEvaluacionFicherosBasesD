/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eje7fnachosalcedo;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author nacho
 */
public class Empleado {
    
    private String apellido;
    private String nombre;
    private String dni;
    private String puesto;
    private LocalDate fechaPosesion;
    private LocalDate fechaCese;
    private String telefono;
    private boolean evaluador; // si true no false;
    private boolean coodinador;

    public Empleado() {
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public LocalDate getFechaPosesion() {
        return fechaPosesion;
    }

    public void setFechaPosesion(LocalDate fechaPosesion) {
        this.fechaPosesion = fechaPosesion;
    }

    public LocalDate getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(LocalDate fechaCese) {
        this.fechaCese = fechaCese;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEvaluador() {
        return evaluador;
    }

    public void setEvaluador(boolean evaluador) {
        this.evaluador = evaluador;
    }

    public boolean isCoodinador() {
        return coodinador;
    }

    public void setCoodinador(boolean coodinador) {
        this.coodinador = coodinador;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("apellido=").append(apellido);
        sb.append(", nombre=").append(nombre);
        sb.append(", dni=").append(dni);
        sb.append(", puesto=").append(puesto);
        sb.append(", fechaPosesion=").append(fechaPosesion);
        sb.append(", fechaCese=").append(fechaCese);
        sb.append(", telefono=").append(telefono);
        sb.append(", evaluador=").append(evaluador);
        sb.append(", coodinador=").append(coodinador);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.apellido);
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + Objects.hashCode(this.dni);
        hash = 71 * hash + Objects.hashCode(this.puesto);
        hash = 71 * hash + Objects.hashCode(this.fechaPosesion);
        hash = 71 * hash + Objects.hashCode(this.fechaCese);
        hash = 71 * hash + Objects.hashCode(this.telefono);
        hash = 71 * hash + (this.evaluador ? 1 : 0);
        hash = 71 * hash + (this.coodinador ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        return Objects.equals(this.dni, other.dni);
    }

    
    
    
    
}

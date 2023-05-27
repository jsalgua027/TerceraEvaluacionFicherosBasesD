/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author nacho
 */
@Entity
@Table(name = "Musico")
@NamedQueries({
    @NamedQuery(name = "Musico.findAll", query = "SELECT m FROM Musico m"),
    @NamedQuery(name = "Musico.findByIdMusico", query = "SELECT m FROM Musico m WHERE m.idMusico = :idMusico"),
    @NamedQuery(name = "Musico.findByNombre", query = "SELECT m FROM Musico m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Musico.findByGenero", query = "SELECT m FROM Musico m WHERE m.genero = :genero")})
public class Musico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMusico")
    private Integer idMusico;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "genero")
    private String genero;
    @JoinColumn(name = "idInstrumento", referencedColumnName = "idInstrumento")
    @ManyToOne
    private Instrumento idInstrumento;
    @OneToOne(mappedBy = "idMusico")
    private Biografia biografia;

    public Musico() {
    }

    public Musico(Integer idMusico) {
        this.idMusico = idMusico;
    }

    public Musico(String nombre, String genero, Instrumento idInstrumento, Biografia biografia) {
        this.nombre = nombre;
        this.genero = genero;
        this.idInstrumento = idInstrumento;
        this.biografia = biografia;
    }

    
    
    public Integer getIdMusico() {
        return idMusico;
    }

    public void setIdMusico(Integer idMusico) {
        this.idMusico = idMusico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Instrumento getIdInstrumento() {
        return idInstrumento;
    }

    public void setIdInstrumento(Instrumento idInstrumento) {
        this.idInstrumento = idInstrumento;
    }

    public Biografia getBiografia() {
        return biografia;
    }

    public void setBiografia(Biografia biografia) {
        this.biografia = biografia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMusico != null ? idMusico.hashCode() : 0);
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
        final Musico other = (Musico) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        return Objects.equals(this.idMusico, other.idMusico);
    }

 

  

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Musico{");
        sb.append("idMusico=").append(idMusico);
        sb.append(", nombre=").append(nombre);
        sb.append(", genero=").append(genero);
        try {
            sb.append(", idInstrumento=").append(idInstrumento.getNombre());
        } catch (NullPointerException e) {
            sb.append(", idInstrumento=").append("No hay instrumento asociado");
        }
        try {
            sb.append(", biografia=").append(biografia.getLugarNacimiento());
        } catch (NullPointerException e) {
            sb.append(", biografia=").append("No hay biografia asociada");
        }

        sb.append('}');
        return sb.toString();
    }


    public String toString2() {
        return   idMusico + ";" + nombre + ";" + genero + ";" + idInstrumento.getNombre() + ";" + biografia.getDescripcion() ;
    }
    
    
    
    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Windows10
 */
@Entity
@Table(name = "musico")
@XmlRootElement
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
    @OneToOne(mappedBy = "idMusico")
    private Instrumento instrumento;

    public Musico() {
    }

    public Musico(Integer idMusico) {
        this.idMusico = idMusico;
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

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMusico != null ? idMusico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musico)) {
            return false;
        }
        Musico other = (Musico) object;
        if ((this.idMusico == null && other.idMusico != null) || (this.idMusico != null && !this.idMusico.equals(other.idMusico))) {
            return false;
        }
        return true;
    }


    
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Musico{");
        sb.append("idMusico=").append(idMusico);
        sb.append(", nombre=").append(nombre);
        sb.append(", genero=").append(genero);
        try {
            sb.append(", idInstrumento=").append(instrumento.getNombre());
        } catch (NullPointerException e) {
            sb.append(", idInstrumento=").append("No hay instrumento asociado");
        }
        

        sb.append('}');
        return sb.toString();
    }


    public String toString2() {
        return   idMusico + ";" + nombre + ";" + genero + ";" + instrumento.getIdInstrumento() ;
    }
    
    
    
}

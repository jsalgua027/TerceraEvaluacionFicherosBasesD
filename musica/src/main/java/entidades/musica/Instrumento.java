/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.musica;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nacho
 */
@Entity
@Table(name = "Instrumento")
@NamedQueries({
    @NamedQuery(name = "Instrumento.findAll", query = "SELECT i FROM Instrumento i"),
    @NamedQuery(name = "Instrumento.findByIdInstrumento", query = "SELECT i FROM Instrumento i WHERE i.idInstrumento = :idInstrumento"),
    @NamedQuery(name = "Instrumento.findByNombre", query = "SELECT i FROM Instrumento i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Instrumento.findByTipo", query = "SELECT i FROM Instrumento i WHERE i.tipo = :tipo")})
public class Instrumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idInstrumento")
    private Integer idInstrumento;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo")
    private String tipo;
    
    @JoinColumn(name="IdInstrumento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Instrumento instrumento;
    
    @OneToMany (mappedBy = "Instrumento")
    private List<Grabacion> listaGrabaciones;
    

    public Instrumento() {
    }

    public Instrumento(Integer idInstrumento) {
        this.idInstrumento = idInstrumento;
    }

    public Integer getIdInstrumento() {
        return idInstrumento;
    }

    public void setIdInstrumento(Integer idInstrumento) {
        this.idInstrumento = idInstrumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public List<Grabacion> getListaGrabaciones() {
        return listaGrabaciones;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstrumento != null ? idInstrumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instrumento)) {
            return false;
        }
        Instrumento other = (Instrumento) object;
        if ((this.idInstrumento == null && other.idInstrumento != null) || (this.idInstrumento != null && !this.idInstrumento.equals(other.idInstrumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.musica.Instrumento[ idInstrumento=" + idInstrumento + " ]";
    }

}

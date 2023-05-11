/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nacho
 */
@Entity
@Table(name = "centros")
@NamedQueries({
    @NamedQuery(name = "Centros.findAll", query = "SELECT c FROM Centros c"),
    @NamedQuery(name = "Centros.findByNumce", query = "SELECT c FROM Centros c WHERE c.numce = :numce"),
    @NamedQuery(name = "Centros.findByNomce", query = "SELECT c FROM Centros c WHERE c.nomce = :nomce"),
    @NamedQuery(name = "Centros.findByDirce", query = "SELECT c FROM Centros c WHERE c.dirce = :dirce"),
    @NamedQuery(name = "Centros.findByCodpostal", query = "SELECT c FROM Centros c WHERE c.codpostal = :codpostal")})
public class Centros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numce")
    private Integer numce;
    @Basic(optional = false)
    @Column(name = "nomce")
    private String nomce;
    @Basic(optional = false)
    @Column(name = "dirce")
    private String dirce;
    @Basic(optional = false)
    @Column(name = "codpostal")
    private String codpostal;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "numce")
    private List<Departamentos> departamentosList;

    public Centros() {
    }

    public Centros(Integer numce) {
        this.numce = numce;
    }

    public Centros(Integer numce, String nomce, String dirce, String codpostal) {
        this.numce = numce;
        this.nomce = nomce;
        this.dirce = dirce;
        this.codpostal = codpostal;
    }

    public Integer getNumce() {
        return numce;
    }

    public void setNumce(Integer numce) {
        this.numce = numce;
    }

    public String getNomce() {
        return nomce;
    }

    public void setNomce(String nomce) {
        this.nomce = nomce;
    }

    public String getDirce() {
        return dirce;
    }

    public void setDirce(String dirce) {
        this.dirce = dirce;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public List<Departamentos> getDepartamentosList() {
        return departamentosList;
    }

    public void setDepartamentosList(List<Departamentos> departamentosList) {
        this.departamentosList = departamentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numce != null ? numce.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centros)) {
            return false;
        }
        Centros other = (Centros) object;
        if ((this.numce == null && other.numce != null) || (this.numce != null && !this.numce.equals(other.numce))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Centros[ numce=" + numce + " ]";
    }
    
}

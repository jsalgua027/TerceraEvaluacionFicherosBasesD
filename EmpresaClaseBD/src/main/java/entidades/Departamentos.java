/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "departamentos")
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByNumde", query = "SELECT d FROM Departamentos d WHERE d.numde = :numde"),
    @NamedQuery(name = "Departamentos.findByPresude", query = "SELECT d FROM Departamentos d WHERE d.presude = :presude"),
    @NamedQuery(name = "Departamentos.findByNomde", query = "SELECT d FROM Departamentos d WHERE d.nomde = :nomde")})
public class Departamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numde")
    private Integer numde;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "presude")
    private BigDecimal presude;
    @Basic(optional = false)
    @Column(name = "nomde")
    private String nomde;
    @JoinColumn(name = "numce", referencedColumnName = "numce")
    @ManyToOne(optional = false)
    private Centros numce;
    @OneToMany(mappedBy = "depende")
    private List<Departamentos> departamentosList;
    @JoinColumn(name = "depende", referencedColumnName = "numde")
    @ManyToOne
    private Departamentos depende;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "departamentos")
    private List<Dirigir> dirigirList;
    @OneToMany(mappedBy = "numde")
    private List<Empleados> empleadosList;

    public Departamentos() {
    }

    public Departamentos(Integer numde) {
        this.numde = numde;
    }

    public Departamentos(Integer numde, BigDecimal presude, String nomde) {
        this.numde = numde;
        this.presude = presude;
        this.nomde = nomde;
    }

    public Integer getNumde() {
        return numde;
    }

    public void setNumde(Integer numde) {
        this.numde = numde;
    }

    public BigDecimal getPresude() {
        return presude;
    }

    public void setPresude(BigDecimal presude) {
        this.presude = presude;
    }

    public String getNomde() {
        return nomde;
    }

    public void setNomde(String nomde) {
        this.nomde = nomde;
    }

    public Centros getNumce() {
        return numce;
    }

    public void setNumce(Centros numce) {
        this.numce = numce;
    }

    public List<Departamentos> getDepartamentosList() {
        return departamentosList;
    }

    public void setDepartamentosList(List<Departamentos> departamentosList) {
        this.departamentosList = departamentosList;
    }

    public Departamentos getDepende() {
        return depende;
    }

    public void setDepende(Departamentos depende) {
        this.depende = depende;
    }

    public List<Dirigir> getDirigirList() {
        return dirigirList;
    }

    public void setDirigirList(List<Dirigir> dirigirList) {
        this.dirigirList = dirigirList;
    }

    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numde != null ? numde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.numde == null && other.numde != null) || (this.numde != null && !this.numde.equals(other.numde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Departamentos[ numde=" + numde + " ]";
    }
    
}

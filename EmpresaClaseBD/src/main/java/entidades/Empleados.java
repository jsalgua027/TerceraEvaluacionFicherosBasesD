/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nacho
 */
@Entity
@Table(name = "empleados")
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByNumem", query = "SELECT e FROM Empleados e WHERE e.numem = :numem"),
    @NamedQuery(name = "Empleados.findByExtelem", query = "SELECT e FROM Empleados e WHERE e.extelem = :extelem"),
    @NamedQuery(name = "Empleados.findByFecnaem", query = "SELECT e FROM Empleados e WHERE e.fecnaem = :fecnaem"),
    @NamedQuery(name = "Empleados.findByFecinem", query = "SELECT e FROM Empleados e WHERE e.fecinem = :fecinem"),
    @NamedQuery(name = "Empleados.findBySalarem", query = "SELECT e FROM Empleados e WHERE e.salarem = :salarem"),
    @NamedQuery(name = "Empleados.findByComisem", query = "SELECT e FROM Empleados e WHERE e.comisem = :comisem"),
    @NamedQuery(name = "Empleados.findByNumhiem", query = "SELECT e FROM Empleados e WHERE e.numhiem = :numhiem"),
    @NamedQuery(name = "Empleados.findByNomem", query = "SELECT e FROM Empleados e WHERE e.nomem = :nomem"),
    @NamedQuery(name = "Empleados.findByApe1em", query = "SELECT e FROM Empleados e WHERE e.ape1em = :ape1em"),
    @NamedQuery(name = "Empleados.findByApe2em", query = "SELECT e FROM Empleados e WHERE e.ape2em = :ape2em"),
    @NamedQuery(name = "Empleados.findByDniem", query = "SELECT e FROM Empleados e WHERE e.dniem = :dniem"),
    @NamedQuery(name = "Empleados.findByUserem", query = "SELECT e FROM Empleados e WHERE e.userem = :userem"),
    @NamedQuery(name = "Empleados.findByPassem", query = "SELECT e FROM Empleados e WHERE e.passem = :passem")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numem")
    private Integer numem;
    @Column(name = "extelem")
    private String extelem;
    @Basic(optional = false)
    @Column(name = "fecnaem")
    @Temporal(TemporalType.DATE)
    private Date fecnaem;
    @Basic(optional = false)
    @Column(name = "fecinem")
    @Temporal(TemporalType.DATE)
    private Date fecinem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salarem")
    private BigDecimal salarem;
    @Column(name = "comisem")
    private BigDecimal comisem;
    @Column(name = "numhiem")
    private Short numhiem;
    @Column(name = "nomem")
    private String nomem;
    @Column(name = "ape1em")
    private String ape1em;
    @Column(name = "ape2em")
    private String ape2em;
    @Column(name = "dniem")
    private String dniem;
    @Column(name = "userem")
    private String userem;
    @Column(name = "passem")
    private String passem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleados")
    private List<Dirigir> dirigirList;
    @JoinColumn(name = "numde", referencedColumnName = "numde")
    @ManyToOne
    private Departamentos numde;

    public Empleados() {
    }

    public Empleados(Integer numem) {
        this.numem = numem;
    }

    public Empleados(Integer numem, Date fecnaem, Date fecinem) {
        this.numem = numem;
        this.fecnaem = fecnaem;
        this.fecinem = fecinem;
    }

    public Integer getNumem() {
        return numem;
    }

    public void setNumem(Integer numem) {
        this.numem = numem;
    }

    public String getExtelem() {
        return extelem;
    }

    public void setExtelem(String extelem) {
        this.extelem = extelem;
    }

    public Date getFecnaem() {
        return fecnaem;
    }

    public void setFecnaem(Date fecnaem) {
        this.fecnaem = fecnaem;
    }

    public Date getFecinem() {
        return fecinem;
    }

    public void setFecinem(Date fecinem) {
        this.fecinem = fecinem;
    }

    public BigDecimal getSalarem() {
        return salarem;
    }

    public void setSalarem(BigDecimal salarem) {
        this.salarem = salarem;
    }

    public BigDecimal getComisem() {
        return comisem;
    }

    public void setComisem(BigDecimal comisem) {
        this.comisem = comisem;
    }

    public Short getNumhiem() {
        return numhiem;
    }

    public void setNumhiem(Short numhiem) {
        this.numhiem = numhiem;
    }

    public String getNomem() {
        return nomem;
    }

    public void setNomem(String nomem) {
        this.nomem = nomem;
    }

    public String getApe1em() {
        return ape1em;
    }

    public void setApe1em(String ape1em) {
        this.ape1em = ape1em;
    }

    public String getApe2em() {
        return ape2em;
    }

    public void setApe2em(String ape2em) {
        this.ape2em = ape2em;
    }

    public String getDniem() {
        return dniem;
    }

    public void setDniem(String dniem) {
        this.dniem = dniem;
    }

    public String getUserem() {
        return userem;
    }

    public void setUserem(String userem) {
        this.userem = userem;
    }

    public String getPassem() {
        return passem;
    }

    public void setPassem(String passem) {
        this.passem = passem;
    }

    public List<Dirigir> getDirigirList() {
        return dirigirList;
    }

    public void setDirigirList(List<Dirigir> dirigirList) {
        this.dirigirList = dirigirList;
    }

    public Departamentos getNumde() {
        return numde;
    }

    public void setNumde(Departamentos numde) {
        this.numde = numde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numem != null ? numem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.numem == null && other.numem != null) || (this.numem != null && !this.numem.equals(other.numem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Empleados[ numem=" + numem + " ]";
    }
    
}

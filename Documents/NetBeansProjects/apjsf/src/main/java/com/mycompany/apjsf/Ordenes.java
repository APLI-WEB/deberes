/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apjsf;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author wiliam
 */
@Entity
@Table(name = "ordenes")
@NamedQueries({
    @NamedQuery(name = "Ordenes.findAll", query = "SELECT o FROM Ordenes o"),
    @NamedQuery(name = "Ordenes.findByOrdenid", query = "SELECT o FROM Ordenes o WHERE o.ordenid = :ordenid"),
    @NamedQuery(name = "Ordenes.findByFechaorden", query = "SELECT o FROM Ordenes o WHERE o.fechaorden = :fechaorden"),
    @NamedQuery(name = "Ordenes.findByDescuento", query = "SELECT o FROM Ordenes o WHERE o.descuento = :descuento")})
public class Ordenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordenid", nullable = false)
    private Integer ordenid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaorden", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaorden;
    @Column(name = "descuento")
    private Integer descuento;
    @JoinColumn(name = "clienteid", referencedColumnName = "clienteid", nullable = false)
    @ManyToOne(optional = false)
    private Clientes clienteid;
    @JoinColumn(name = "empleadoid", referencedColumnName = "empleadoid", nullable = false)
    @ManyToOne(optional = false)
    private Empleados empleadoid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenes")
    private List<DetalleOrdenes> detalleOrdenesList;

    public Ordenes() {
    }

    public Ordenes(Integer ordenid) {
        this.ordenid = ordenid;
    }

    public Ordenes(Integer ordenid, Date fechaorden) {
        this.ordenid = ordenid;
        this.fechaorden = fechaorden;
    }

    public Integer getOrdenid() {
        return ordenid;
    }

    public void setOrdenid(Integer ordenid) {
        this.ordenid = ordenid;
    }

    public Date getFechaorden() {
        return fechaorden;
    }

    public void setFechaorden(Date fechaorden) {
        this.fechaorden = fechaorden;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Clientes getClienteid() {
        return clienteid;
    }

    public void setClienteid(Clientes clienteid) {
        this.clienteid = clienteid;
    }

    public Empleados getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(Empleados empleadoid) {
        this.empleadoid = empleadoid;
    }

    public List<DetalleOrdenes> getDetalleOrdenesList() {
        return detalleOrdenesList;
    }

    public void setDetalleOrdenesList(List<DetalleOrdenes> detalleOrdenesList) {
        this.detalleOrdenesList = detalleOrdenesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenid != null ? ordenid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenes)) {
            return false;
        }
        Ordenes other = (Ordenes) object;
        if ((this.ordenid == null && other.ordenid != null) || (this.ordenid != null && !this.ordenid.equals(other.ordenid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.apjsf.Ordenes[ ordenid=" + ordenid + " ]";
    }
    
}

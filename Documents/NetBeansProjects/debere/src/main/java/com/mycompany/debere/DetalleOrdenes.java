/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.debere;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author wiliam
 */
@Entity
@Table(name = "detalle_ordenes")
@NamedQueries({
    @NamedQuery(name = "DetalleOrdenes.findAll", query = "SELECT d FROM DetalleOrdenes d"),
    @NamedQuery(name = "DetalleOrdenes.findByOrdenid", query = "SELECT d FROM DetalleOrdenes d WHERE d.detalleOrdenesPK.ordenid = :ordenid"),
    @NamedQuery(name = "DetalleOrdenes.findByDetalleid", query = "SELECT d FROM DetalleOrdenes d WHERE d.detalleOrdenesPK.detalleid = :detalleid"),
    @NamedQuery(name = "DetalleOrdenes.findByCantidad", query = "SELECT d FROM DetalleOrdenes d WHERE d.cantidad = :cantidad")})
public class DetalleOrdenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleOrdenesPK detalleOrdenesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @JoinColumn(name = "ordenid", referencedColumnName = "ordenid", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ordenes ordenes;
    @JoinColumn(name = "productoid", referencedColumnName = "productoid", nullable = false)
    @ManyToOne(optional = false)
    private Productos productoid;

    public DetalleOrdenes() {
    }

    public DetalleOrdenes(DetalleOrdenesPK detalleOrdenesPK) {
        this.detalleOrdenesPK = detalleOrdenesPK;
    }

    public DetalleOrdenes(DetalleOrdenesPK detalleOrdenesPK, int cantidad) {
        this.detalleOrdenesPK = detalleOrdenesPK;
        this.cantidad = cantidad;
    }

    public DetalleOrdenes(int ordenid, int detalleid) {
        this.detalleOrdenesPK = new DetalleOrdenesPK(ordenid, detalleid);
    }

    public DetalleOrdenesPK getDetalleOrdenesPK() {
        return detalleOrdenesPK;
    }

    public void setDetalleOrdenesPK(DetalleOrdenesPK detalleOrdenesPK) {
        this.detalleOrdenesPK = detalleOrdenesPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Ordenes getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(Ordenes ordenes) {
        this.ordenes = ordenes;
    }

    public Productos getProductoid() {
        return productoid;
    }

    public void setProductoid(Productos productoid) {
        this.productoid = productoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleOrdenesPK != null ? detalleOrdenesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleOrdenes)) {
            return false;
        }
        DetalleOrdenes other = (DetalleOrdenes) object;
        if ((this.detalleOrdenesPK == null && other.detalleOrdenesPK != null) || (this.detalleOrdenesPK != null && !this.detalleOrdenesPK.equals(other.detalleOrdenesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.debere.DetalleOrdenes[ detalleOrdenesPK=" + detalleOrdenesPK + " ]";
    }
    
}

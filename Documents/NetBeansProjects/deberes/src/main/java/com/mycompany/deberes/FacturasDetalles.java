/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deberes;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author wiliam
 */
@Entity
@Table(name = "facturas_detalles", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_factura"}),
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "FacturasDetalles.findAll", query = "SELECT f FROM FacturasDetalles f"),
    @NamedQuery(name = "FacturasDetalles.findById", query = "SELECT f FROM FacturasDetalles f WHERE f.id = :id"),
    @NamedQuery(name = "FacturasDetalles.findByTipo", query = "SELECT f FROM FacturasDetalles f WHERE f.tipo = :tipo"),
    @NamedQuery(name = "FacturasDetalles.findByDescrFactura", query = "SELECT f FROM FacturasDetalles f WHERE f.descrFactura = :descrFactura"),
    @NamedQuery(name = "FacturasDetalles.findByCostoAsoc", query = "SELECT f FROM FacturasDetalles f WHERE f.costoAsoc = :costoAsoc"),
    @NamedQuery(name = "FacturasDetalles.findByIva", query = "SELECT f FROM FacturasDetalles f WHERE f.iva = :iva"),
    @NamedQuery(name = "FacturasDetalles.findByMedioDePago", query = "SELECT f FROM FacturasDetalles f WHERE f.medioDePago = :medioDePago"),
    @NamedQuery(name = "FacturasDetalles.findByDescrPago", query = "SELECT f FROM FacturasDetalles f WHERE f.descrPago = :descrPago")})
public class FacturasDetalles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo", nullable = false, length = 2147483647)
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descr_factura", nullable = false, length = 100)
    private String descrFactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_asoc", nullable = false, precision = 8, scale = 2)
    private BigDecimal costoAsoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva", nullable = false, precision = 10, scale = 2)
    private BigDecimal iva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "medio_de_pago", nullable = false, length = 2147483647)
    private String medioDePago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descr_pago", nullable = false, length = 100)
    private String descrPago;
    @JoinColumn(name = "id_factura", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private Facturas idFactura;

    public FacturasDetalles() {
    }

    public FacturasDetalles(Integer id) {
        this.id = id;
    }

    public FacturasDetalles(Integer id, String tipo, String descrFactura, BigDecimal costoAsoc, BigDecimal iva, String medioDePago, String descrPago) {
        this.id = id;
        this.tipo = tipo;
        this.descrFactura = descrFactura;
        this.costoAsoc = costoAsoc;
        this.iva = iva;
        this.medioDePago = medioDePago;
        this.descrPago = descrPago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescrFactura() {
        return descrFactura;
    }

    public void setDescrFactura(String descrFactura) {
        this.descrFactura = descrFactura;
    }

    public BigDecimal getCostoAsoc() {
        return costoAsoc;
    }

    public void setCostoAsoc(BigDecimal costoAsoc) {
        this.costoAsoc = costoAsoc;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }

    public String getDescrPago() {
        return descrPago;
    }

    public void setDescrPago(String descrPago) {
        this.descrPago = descrPago;
    }

    public Facturas getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Facturas idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturasDetalles)) {
            return false;
        }
        FacturasDetalles other = (FacturasDetalles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.deberes.FacturasDetalles[ id=" + id + " ]";
    }
    
}

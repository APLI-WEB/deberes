/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bromero;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "InvoiceLine")
@NamedQueries({
    @NamedQuery(name = "InvoiceLine.findAll", query = "SELECT i FROM InvoiceLine i"),
    @NamedQuery(name = "InvoiceLine.findByInvoiceLineId", query = "SELECT i FROM InvoiceLine i WHERE i.invoiceLineId = :invoiceLineId"),
    @NamedQuery(name = "InvoiceLine.findByUnitPrice", query = "SELECT i FROM InvoiceLine i WHERE i.unitPrice = :unitPrice"),
    @NamedQuery(name = "InvoiceLine.findByQuantity", query = "SELECT i FROM InvoiceLine i WHERE i.quantity = :quantity")})
public class InvoiceLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "InvoiceLineId")
    private Integer invoiceLineId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "InvoiceId", referencedColumnName = "InvoiceId")
    @ManyToOne(optional = false)
    private Invoice invoiceId;
    @JoinColumn(name = "TrackId", referencedColumnName = "TrackId")
    @ManyToOne(optional = false)
    private Track trackId;

    public InvoiceLine() {
    }

    public InvoiceLine(Integer invoiceLineId) {
        this.invoiceLineId = invoiceLineId;
    }

    public InvoiceLine(Integer invoiceLineId, BigDecimal unitPrice, int quantity) {
        this.invoiceLineId = invoiceLineId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Integer getInvoiceLineId() {
        return invoiceLineId;
    }

    public void setInvoiceLineId(Integer invoiceLineId) {
        this.invoiceLineId = invoiceLineId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Track getTrackId() {
        return trackId;
    }

    public void setTrackId(Track trackId) {
        this.trackId = trackId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceLineId != null ? invoiceLineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceLine)) {
            return false;
        }
        InvoiceLine other = (InvoiceLine) object;
        if ((this.invoiceLineId == null && other.invoiceLineId != null) || (this.invoiceLineId != null && !this.invoiceLineId.equals(other.invoiceLineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.bromero.InvoiceLine[ invoiceLineId=" + invoiceLineId + " ]";
    }
    
}

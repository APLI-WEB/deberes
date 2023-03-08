/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.willypages.util;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author wiliam
 */
@Entity
@Table(name = "shippers")
@NamedQueries({
    @NamedQuery(name = "Shippers.findAll", query = "SELECT s FROM Shippers s"),
    @NamedQuery(name = "Shippers.findByShipperId", query = "SELECT s FROM Shippers s WHERE s.shipperId = :shipperId"),
    @NamedQuery(name = "Shippers.findByCompanyName", query = "SELECT s FROM Shippers s WHERE s.companyName = :companyName"),
    @NamedQuery(name = "Shippers.findByPhone", query = "SELECT s FROM Shippers s WHERE s.phone = :phone")})
public class Shippers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipper_id")
    private Short shipperId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "company_name")
    private String companyName;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 24)
    @Column(name = "phone")
    private String phone;
    @OneToMany(mappedBy = "shipVia")
    private List<Orders> ordersList;

    public Shippers() {
    }

    public Shippers(Short shipperId) {
        this.shipperId = shipperId;
    }

    public Shippers(Short shipperId, String companyName) {
        this.shipperId = shipperId;
        this.companyName = companyName;
    }

    public Short getShipperId() {
        return shipperId;
    }

    public void setShipperId(Short shipperId) {
        this.shipperId = shipperId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shipperId != null ? shipperId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shippers)) {
            return false;
        }
        Shippers other = (Shippers) object;
        if ((this.shipperId == null && other.shipperId != null) || (this.shipperId != null && !this.shipperId.equals(other.shipperId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.willypages.util.Shippers[ shipperId=" + shipperId + " ]";
    }
    
}

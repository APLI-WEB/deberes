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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author wiliam
 */
@Entity
@Table(name = "customer_demographics")
@NamedQueries({
    @NamedQuery(name = "CustomerDemographics.findAll", query = "SELECT c FROM CustomerDemographics c"),
    @NamedQuery(name = "CustomerDemographics.findByCustomerTypeId", query = "SELECT c FROM CustomerDemographics c WHERE c.customerTypeId = :customerTypeId"),
    @NamedQuery(name = "CustomerDemographics.findByCustomerDesc", query = "SELECT c FROM CustomerDemographics c WHERE c.customerDesc = :customerDesc")})
public class CustomerDemographics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "customer_type_id")
    private String customerTypeId;
    @Size(max = 2147483647)
    @Column(name = "customer_desc")
    private String customerDesc;
    @JoinTable(name = "customer_customer_demo", joinColumns = {
        @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")}, inverseJoinColumns = {
        @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")})
    @ManyToMany
    private List<Customers> customersList;

    public CustomerDemographics() {
    }

    public CustomerDemographics(String customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(String customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }

    public List<Customers> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customers> customersList) {
        this.customersList = customersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerTypeId != null ? customerTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerDemographics)) {
            return false;
        }
        CustomerDemographics other = (CustomerDemographics) object;
        if ((this.customerTypeId == null && other.customerTypeId != null) || (this.customerTypeId != null && !this.customerTypeId.equals(other.customerTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.willypages.util.CustomerDemographics[ customerTypeId=" + customerTypeId + " ]";
    }
    
}

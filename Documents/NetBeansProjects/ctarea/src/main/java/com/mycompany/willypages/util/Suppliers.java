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
@Table(name = "suppliers")
@NamedQueries({
    @NamedQuery(name = "Suppliers.findAll", query = "SELECT s FROM Suppliers s"),
    @NamedQuery(name = "Suppliers.findBySupplierId", query = "SELECT s FROM Suppliers s WHERE s.supplierId = :supplierId"),
    @NamedQuery(name = "Suppliers.findByCompanyName", query = "SELECT s FROM Suppliers s WHERE s.companyName = :companyName"),
    @NamedQuery(name = "Suppliers.findByContactName", query = "SELECT s FROM Suppliers s WHERE s.contactName = :contactName"),
    @NamedQuery(name = "Suppliers.findByContactTitle", query = "SELECT s FROM Suppliers s WHERE s.contactTitle = :contactTitle"),
    @NamedQuery(name = "Suppliers.findByAddress", query = "SELECT s FROM Suppliers s WHERE s.address = :address"),
    @NamedQuery(name = "Suppliers.findByCity", query = "SELECT s FROM Suppliers s WHERE s.city = :city"),
    @NamedQuery(name = "Suppliers.findByRegion", query = "SELECT s FROM Suppliers s WHERE s.region = :region"),
    @NamedQuery(name = "Suppliers.findByPostalCode", query = "SELECT s FROM Suppliers s WHERE s.postalCode = :postalCode"),
    @NamedQuery(name = "Suppliers.findByCountry", query = "SELECT s FROM Suppliers s WHERE s.country = :country"),
    @NamedQuery(name = "Suppliers.findByPhone", query = "SELECT s FROM Suppliers s WHERE s.phone = :phone"),
    @NamedQuery(name = "Suppliers.findByFax", query = "SELECT s FROM Suppliers s WHERE s.fax = :fax"),
    @NamedQuery(name = "Suppliers.findByHomepage", query = "SELECT s FROM Suppliers s WHERE s.homepage = :homepage")})
public class Suppliers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "supplier_id")
    private Short supplierId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "company_name")
    private String companyName;
    @Size(max = 30)
    @Column(name = "contact_name")
    private String contactName;
    @Size(max = 30)
    @Column(name = "contact_title")
    private String contactTitle;
    @Size(max = 60)
    @Column(name = "address")
    private String address;
    @Size(max = 15)
    @Column(name = "city")
    private String city;
    @Size(max = 15)
    @Column(name = "region")
    private String region;
    @Size(max = 10)
    @Column(name = "postal_code")
    private String postalCode;
    @Size(max = 15)
    @Column(name = "country")
    private String country;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 24)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 24)
    @Column(name = "fax")
    private String fax;
    @Size(max = 2147483647)
    @Column(name = "homepage")
    private String homepage;
    @OneToMany(mappedBy = "supplierId")
    private List<Products> productsList;

    public Suppliers() {
    }

    public Suppliers(Short supplierId) {
        this.supplierId = supplierId;
    }

    public Suppliers(Short supplierId, String companyName) {
        this.supplierId = supplierId;
        this.companyName = companyName;
    }

    public Short getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Short supplierId) {
        this.supplierId = supplierId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierId != null ? supplierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suppliers)) {
            return false;
        }
        Suppliers other = (Suppliers) object;
        if ((this.supplierId == null && other.supplierId != null) || (this.supplierId != null && !this.supplierId.equals(other.supplierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.willypages.util.Suppliers[ supplierId=" + supplierId + " ]";
    }
    
}

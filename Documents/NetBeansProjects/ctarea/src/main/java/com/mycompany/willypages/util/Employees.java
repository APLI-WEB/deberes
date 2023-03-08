/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.willypages.util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author wiliam
 */
@Entity
@Table(name = "employees")
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findByEmployeeId", query = "SELECT e FROM Employees e WHERE e.employeeId = :employeeId"),
    @NamedQuery(name = "Employees.findByLastName", query = "SELECT e FROM Employees e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employees.findByFirstName", query = "SELECT e FROM Employees e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Employees.findByTitle", query = "SELECT e FROM Employees e WHERE e.title = :title"),
    @NamedQuery(name = "Employees.findByTitleOfCourtesy", query = "SELECT e FROM Employees e WHERE e.titleOfCourtesy = :titleOfCourtesy"),
    @NamedQuery(name = "Employees.findByBirthDate", query = "SELECT e FROM Employees e WHERE e.birthDate = :birthDate"),
    @NamedQuery(name = "Employees.findByHireDate", query = "SELECT e FROM Employees e WHERE e.hireDate = :hireDate"),
    @NamedQuery(name = "Employees.findByAddress", query = "SELECT e FROM Employees e WHERE e.address = :address"),
    @NamedQuery(name = "Employees.findByCity", query = "SELECT e FROM Employees e WHERE e.city = :city"),
    @NamedQuery(name = "Employees.findByRegion", query = "SELECT e FROM Employees e WHERE e.region = :region"),
    @NamedQuery(name = "Employees.findByPostalCode", query = "SELECT e FROM Employees e WHERE e.postalCode = :postalCode"),
    @NamedQuery(name = "Employees.findByCountry", query = "SELECT e FROM Employees e WHERE e.country = :country"),
    @NamedQuery(name = "Employees.findByHomePhone", query = "SELECT e FROM Employees e WHERE e.homePhone = :homePhone"),
    @NamedQuery(name = "Employees.findByExtension", query = "SELECT e FROM Employees e WHERE e.extension = :extension"),
    @NamedQuery(name = "Employees.findByNotes", query = "SELECT e FROM Employees e WHERE e.notes = :notes"),
    @NamedQuery(name = "Employees.findByPhotoPath", query = "SELECT e FROM Employees e WHERE e.photoPath = :photoPath")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "employee_id")
    private Short employeeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 30)
    @Column(name = "title")
    private String title;
    @Size(max = 25)
    @Column(name = "title_of_courtesy")
    private String titleOfCourtesy;
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
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
    @Size(max = 24)
    @Column(name = "home_phone")
    private String homePhone;
    @Size(max = 4)
    @Column(name = "extension")
    private String extension;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Size(max = 2147483647)
    @Column(name = "notes")
    private String notes;
    @Size(max = 255)
    @Column(name = "photo_path")
    private String photoPath;
    @JoinTable(name = "employee_territories", joinColumns = {
        @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")}, inverseJoinColumns = {
        @JoinColumn(name = "territory_id", referencedColumnName = "territory_id")})
    @ManyToMany
    private List<Territories> territoriesList;
    @OneToMany(mappedBy = "employeeId")
    private List<Orders> ordersList;
    @OneToMany(mappedBy = "reportsTo")
    private List<Employees> employeesList;
    @JoinColumn(name = "reports_to", referencedColumnName = "employee_id")
    @ManyToOne
    private Employees reportsTo;

    public Employees() {
    }

    public Employees(Short employeeId) {
        this.employeeId = employeeId;
    }

    public Employees(Short employeeId, String lastName, String firstName) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Short getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Short employeeId) {
        this.employeeId = employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleOfCourtesy() {
        return titleOfCourtesy;
    }

    public void setTitleOfCourtesy(String titleOfCourtesy) {
        this.titleOfCourtesy = titleOfCourtesy;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
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

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public List<Territories> getTerritoriesList() {
        return territoriesList;
    }

    public void setTerritoriesList(List<Territories> territoriesList) {
        this.territoriesList = territoriesList;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    public Employees getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employees reportsTo) {
        this.reportsTo = reportsTo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.willypages.util.Employees[ employeeId=" + employeeId + " ]";
    }
    
}

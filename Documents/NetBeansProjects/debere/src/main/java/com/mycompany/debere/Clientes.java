/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.debere;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "clientes")
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByClienteid", query = "SELECT c FROM Clientes c WHERE c.clienteid = :clienteid"),
    @NamedQuery(name = "Clientes.findByCedulaRuc", query = "SELECT c FROM Clientes c WHERE c.cedulaRuc = :cedulaRuc"),
    @NamedQuery(name = "Clientes.findByNombrecia", query = "SELECT c FROM Clientes c WHERE c.nombrecia = :nombrecia"),
    @NamedQuery(name = "Clientes.findByNombrecontacto", query = "SELECT c FROM Clientes c WHERE c.nombrecontacto = :nombrecontacto"),
    @NamedQuery(name = "Clientes.findByDireccioncli", query = "SELECT c FROM Clientes c WHERE c.direccioncli = :direccioncli"),
    @NamedQuery(name = "Clientes.findByFax", query = "SELECT c FROM Clientes c WHERE c.fax = :fax"),
    @NamedQuery(name = "Clientes.findByEmail", query = "SELECT c FROM Clientes c WHERE c.email = :email"),
    @NamedQuery(name = "Clientes.findByCelular", query = "SELECT c FROM Clientes c WHERE c.celular = :celular"),
    @NamedQuery(name = "Clientes.findByFijo", query = "SELECT c FROM Clientes c WHERE c.fijo = :fijo")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "clienteid", nullable = false)
    private Integer clienteid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cedula_ruc", nullable = false, length = 10)
    private String cedulaRuc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombrecia", nullable = false, length = 30)
    private String nombrecia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombrecontacto", nullable = false, length = 50)
    private String nombrecontacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccioncli", nullable = false, length = 50)
    private String direccioncli;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 12)
    @Column(name = "fax", length = 12)
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email", length = 50)
    private String email;
    @Size(max = 12)
    @Column(name = "celular", length = 12)
    private String celular;
    @Size(max = 12)
    @Column(name = "fijo", length = 12)
    private String fijo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteid")
    private List<Ordenes> ordenesList;

    public Clientes() {
    }

    public Clientes(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public Clientes(Integer clienteid, String cedulaRuc, String nombrecia, String nombrecontacto, String direccioncli) {
        this.clienteid = clienteid;
        this.cedulaRuc = cedulaRuc;
        this.nombrecia = nombrecia;
        this.nombrecontacto = nombrecontacto;
        this.direccioncli = direccioncli;
    }

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public String getCedulaRuc() {
        return cedulaRuc;
    }

    public void setCedulaRuc(String cedulaRuc) {
        this.cedulaRuc = cedulaRuc;
    }

    public String getNombrecia() {
        return nombrecia;
    }

    public void setNombrecia(String nombrecia) {
        this.nombrecia = nombrecia;
    }

    public String getNombrecontacto() {
        return nombrecontacto;
    }

    public void setNombrecontacto(String nombrecontacto) {
        this.nombrecontacto = nombrecontacto;
    }

    public String getDireccioncli() {
        return direccioncli;
    }

    public void setDireccioncli(String direccioncli) {
        this.direccioncli = direccioncli;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFijo() {
        return fijo;
    }

    public void setFijo(String fijo) {
        this.fijo = fijo;
    }

    public List<Ordenes> getOrdenesList() {
        return ordenesList;
    }

    public void setOrdenesList(List<Ordenes> ordenesList) {
        this.ordenesList = ordenesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteid != null ? clienteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.clienteid == null && other.clienteid != null) || (this.clienteid != null && !this.clienteid.equals(other.clienteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.debere.Clientes[ clienteid=" + clienteid + " ]";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deberes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author wiliam
 */
@Entity
@Table(name = "clientes", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nro_doc", "tipo_doc"}),
    @UniqueConstraint(columnNames = {"nombre", "apellido"}),
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"nro_tel_princ"})})
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findById", query = "SELECT c FROM Clientes c WHERE c.id = :id"),
    @NamedQuery(name = "Clientes.findByNombre", query = "SELECT c FROM Clientes c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Clientes.findByApellido", query = "SELECT c FROM Clientes c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Clientes.findByTipoDoc", query = "SELECT c FROM Clientes c WHERE c.tipoDoc = :tipoDoc"),
    @NamedQuery(name = "Clientes.findByNroDoc", query = "SELECT c FROM Clientes c WHERE c.nroDoc = :nroDoc"),
    @NamedQuery(name = "Clientes.findByNroTelPrinc", query = "SELECT c FROM Clientes c WHERE c.nroTelPrinc = :nroTelPrinc"),
    @NamedQuery(name = "Clientes.findByNroTelSec", query = "SELECT c FROM Clientes c WHERE c.nroTelSec = :nroTelSec"),
    @NamedQuery(name = "Clientes.findByEmail", query = "SELECT c FROM Clientes c WHERE c.email = :email")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "apellido", nullable = false, length = 30)
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo_doc", nullable = false, length = 20)
    private String tipoDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nro_doc", nullable = false, length = 20)
    private String nroDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nro_tel_princ", nullable = false, length = 40)
    private String nroTelPrinc;
    @Size(max = 40)
    @Column(name = "nro_tel_sec", length = 40)
    private String nroTelSec;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "email", length = 40)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<ComprasClientes> comprasClientesList;

    public Clientes() {
    }

    public Clientes(Integer id) {
        this.id = id;
    }

    public Clientes(Integer id, String nombre, String apellido, String tipoDoc, String nroDoc, String nroTelPrinc) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.nroTelPrinc = nroTelPrinc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(String nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getNroTelPrinc() {
        return nroTelPrinc;
    }

    public void setNroTelPrinc(String nroTelPrinc) {
        this.nroTelPrinc = nroTelPrinc;
    }

    public String getNroTelSec() {
        return nroTelSec;
    }

    public void setNroTelSec(String nroTelSec) {
        this.nroTelSec = nroTelSec;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ComprasClientes> getComprasClientesList() {
        return comprasClientesList;
    }

    public void setComprasClientesList(List<ComprasClientes> comprasClientesList) {
        this.comprasClientesList = comprasClientesList;
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
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.deberes.Clientes[ id=" + id + " ]";
    }
    
}

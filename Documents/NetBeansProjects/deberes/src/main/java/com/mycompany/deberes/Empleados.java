/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deberes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author wiliam
 */
@Entity
@Table(name = "empleados", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"tipo_doc", "nro_doc"}),
    @UniqueConstraint(columnNames = {"nro_doc", "cuil"}),
    @UniqueConstraint(columnNames = {"nombre", "apellido"}),
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"nro_tel_princ"})})
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findById", query = "SELECT e FROM Empleados e WHERE e.id = :id"),
    @NamedQuery(name = "Empleados.findByNombre", query = "SELECT e FROM Empleados e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleados.findByApellido", query = "SELECT e FROM Empleados e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Empleados.findByEdad", query = "SELECT e FROM Empleados e WHERE e.edad = :edad"),
    @NamedQuery(name = "Empleados.findByFechaNac", query = "SELECT e FROM Empleados e WHERE e.fechaNac = :fechaNac"),
    @NamedQuery(name = "Empleados.findByTipoDoc", query = "SELECT e FROM Empleados e WHERE e.tipoDoc = :tipoDoc"),
    @NamedQuery(name = "Empleados.findByNroDoc", query = "SELECT e FROM Empleados e WHERE e.nroDoc = :nroDoc"),
    @NamedQuery(name = "Empleados.findByCuil", query = "SELECT e FROM Empleados e WHERE e.cuil = :cuil"),
    @NamedQuery(name = "Empleados.findByDireccion", query = "SELECT e FROM Empleados e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empleados.findByNroTelPrinc", query = "SELECT e FROM Empleados e WHERE e.nroTelPrinc = :nroTelPrinc"),
    @NamedQuery(name = "Empleados.findByNroTelSec", query = "SELECT e FROM Empleados e WHERE e.nroTelSec = :nroTelSec"),
    @NamedQuery(name = "Empleados.findByEmail", query = "SELECT e FROM Empleados e WHERE e.email = :email"),
    @NamedQuery(name = "Empleados.findByCargo", query = "SELECT e FROM Empleados e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "Empleados.findByAntiguedad", query = "SELECT e FROM Empleados e WHERE e.antiguedad = :antiguedad"),
    @NamedQuery(name = "Empleados.findByFechaIngreso", query = "SELECT e FROM Empleados e WHERE e.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Empleados.findBySalarioAnual", query = "SELECT e FROM Empleados e WHERE e.salarioAnual = :salarioAnual")})
public class Empleados implements Serializable {

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
    @Column(name = "edad", nullable = false)
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nac", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo_doc", nullable = false, length = 50)
    private String tipoDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nro_doc", nullable = false, length = 20)
    private String nroDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cuil", nullable = false, length = 30)
    private String cuil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "direccion", nullable = false, length = 40)
    private String direccion;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "cargo", nullable = false, length = 40)
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "antiguedad", nullable = false, length = 30)
    private String antiguedad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "salario_anual", nullable = false, precision = 10, scale = 2)
    private BigDecimal salarioAnual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<Ventas> ventasList;

    public Empleados() {
    }

    public Empleados(Integer id) {
        this.id = id;
    }

    public Empleados(Integer id, String nombre, String apellido, int edad, Date fechaNac, String tipoDoc, String nroDoc, String cuil, String direccion, String nroTelPrinc, String cargo, String antiguedad, Date fechaIngreso, BigDecimal salarioAnual) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNac = fechaNac;
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.cuil = cuil;
        this.direccion = direccion;
        this.nroTelPrinc = nroTelPrinc;
        this.cargo = cargo;
        this.antiguedad = antiguedad;
        this.fechaIngreso = fechaIngreso;
        this.salarioAnual = salarioAnual;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
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

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public BigDecimal getSalarioAnual() {
        return salarioAnual;
    }

    public void setSalarioAnual(BigDecimal salarioAnual) {
        this.salarioAnual = salarioAnual;
    }

    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
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
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.deberes.Empleados[ id=" + id + " ]";
    }
    
}

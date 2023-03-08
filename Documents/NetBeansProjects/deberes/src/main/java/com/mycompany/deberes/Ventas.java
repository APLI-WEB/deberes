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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author wiliam
 */
@Entity
@Table(name = "ventas", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_factura"}),
    @UniqueConstraint(columnNames = {"id"})})
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v"),
    @NamedQuery(name = "Ventas.findById", query = "SELECT v FROM Ventas v WHERE v.id = :id")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Empleados idEmpleado;
    @JoinColumn(name = "id_factura", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private Facturas idFactura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenta")
    private List<ComprasClientes> comprasClientesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenta")
    private List<VentasProductos> ventasProductosList;

    public Ventas() {
    }

    public Ventas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empleados getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleados idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Facturas getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Facturas idFactura) {
        this.idFactura = idFactura;
    }

    public List<ComprasClientes> getComprasClientesList() {
        return comprasClientesList;
    }

    public void setComprasClientesList(List<ComprasClientes> comprasClientesList) {
        this.comprasClientesList = comprasClientesList;
    }

    public List<VentasProductos> getVentasProductosList() {
        return ventasProductosList;
    }

    public void setVentasProductosList(List<VentasProductos> ventasProductosList) {
        this.ventasProductosList = ventasProductosList;
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
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.deberes.Ventas[ id=" + id + " ]";
    }
    
}

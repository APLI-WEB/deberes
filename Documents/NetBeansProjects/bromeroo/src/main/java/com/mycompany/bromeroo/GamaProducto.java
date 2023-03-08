/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bromeroo;

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
@Table(name = "gama_producto")
@NamedQueries({
    @NamedQuery(name = "GamaProducto.findAll", query = "SELECT g FROM GamaProducto g"),
    @NamedQuery(name = "GamaProducto.findByGama", query = "SELECT g FROM GamaProducto g WHERE g.gama = :gama"),
    @NamedQuery(name = "GamaProducto.findByDescripcionTexto", query = "SELECT g FROM GamaProducto g WHERE g.descripcionTexto = :descripcionTexto"),
    @NamedQuery(name = "GamaProducto.findByDescripcionHtml", query = "SELECT g FROM GamaProducto g WHERE g.descripcionHtml = :descripcionHtml"),
    @NamedQuery(name = "GamaProducto.findByImagen", query = "SELECT g FROM GamaProducto g WHERE g.imagen = :imagen")})
public class GamaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gama", nullable = false, length = 50)
    private String gama;
    @Size(max = 2147483647)
    @Column(name = "descripcion_texto", length = 2147483647)
    private String descripcionTexto;
    @Size(max = 2147483647)
    @Column(name = "descripcion_html", length = 2147483647)
    private String descripcionHtml;
    @Size(max = 256)
    @Column(name = "imagen", length = 256)
    private String imagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gama")
    private List<Producto> productoList;

    public GamaProducto() {
    }

    public GamaProducto(String gama) {
        this.gama = gama;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getDescripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    public String getDescripcionHtml() {
        return descripcionHtml;
    }

    public void setDescripcionHtml(String descripcionHtml) {
        this.descripcionHtml = descripcionHtml;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gama != null ? gama.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GamaProducto)) {
            return false;
        }
        GamaProducto other = (GamaProducto) object;
        if ((this.gama == null && other.gama != null) || (this.gama != null && !this.gama.equals(other.gama))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.bromeroo.GamaProducto[ gama=" + gama + " ]";
    }
    
}

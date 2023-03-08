/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bromeroo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author wiliam
 */
@Embeddable
public class DetallePedidoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_pedido", nullable = false)
    private int codigoPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "codigo_producto", nullable = false, length = 15)
    private String codigoProducto;

    public DetallePedidoPK() {
    }

    public DetallePedidoPK(int codigoPedido, String codigoProducto) {
        this.codigoPedido = codigoPedido;
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoPedido;
        hash += (codigoProducto != null ? codigoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedidoPK)) {
            return false;
        }
        DetallePedidoPK other = (DetallePedidoPK) object;
        if (this.codigoPedido != other.codigoPedido) {
            return false;
        }
        if ((this.codigoProducto == null && other.codigoProducto != null) || (this.codigoProducto != null && !this.codigoProducto.equals(other.codigoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.bromeroo.DetallePedidoPK[ codigoPedido=" + codigoPedido + ", codigoProducto=" + codigoProducto + " ]";
    }
    
}

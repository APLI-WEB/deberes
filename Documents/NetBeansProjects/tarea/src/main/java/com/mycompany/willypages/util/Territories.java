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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "territories")
@NamedQueries({
    @NamedQuery(name = "Territories.findAll", query = "SELECT t FROM Territories t"),
    @NamedQuery(name = "Territories.findByTerritoryId", query = "SELECT t FROM Territories t WHERE t.territoryId = :territoryId"),
    @NamedQuery(name = "Territories.findByTerritoryDescription", query = "SELECT t FROM Territories t WHERE t.territoryDescription = :territoryDescription")})
public class Territories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "territory_id")
    private String territoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "territory_description")
    private String territoryDescription;
    @ManyToMany(mappedBy = "territoriesList")
    private List<Employees> employeesList;
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    @ManyToOne(optional = false)
    private Region regionId;

    public Territories() {
    }

    public Territories(String territoryId) {
        this.territoryId = territoryId;
    }

    public Territories(String territoryId, String territoryDescription) {
        this.territoryId = territoryId;
        this.territoryDescription = territoryDescription;
    }

    public String getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String territoryId) {
        this.territoryId = territoryId;
    }

    public String getTerritoryDescription() {
        return territoryDescription;
    }

    public void setTerritoryDescription(String territoryDescription) {
        this.territoryDescription = territoryDescription;
    }

    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    public Region getRegionId() {
        return regionId;
    }

    public void setRegionId(Region regionId) {
        this.regionId = regionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (territoryId != null ? territoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Territories)) {
            return false;
        }
        Territories other = (Territories) object;
        if ((this.territoryId == null && other.territoryId != null) || (this.territoryId != null && !this.territoryId.equals(other.territoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.willypages.util.Territories[ territoryId=" + territoryId + " ]";
    }
    
}

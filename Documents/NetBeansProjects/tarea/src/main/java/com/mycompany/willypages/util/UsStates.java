/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.willypages.util;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "us_states")
@NamedQueries({
    @NamedQuery(name = "UsStates.findAll", query = "SELECT u FROM UsStates u"),
    @NamedQuery(name = "UsStates.findByStateId", query = "SELECT u FROM UsStates u WHERE u.stateId = :stateId"),
    @NamedQuery(name = "UsStates.findByStateName", query = "SELECT u FROM UsStates u WHERE u.stateName = :stateName"),
    @NamedQuery(name = "UsStates.findByStateAbbr", query = "SELECT u FROM UsStates u WHERE u.stateAbbr = :stateAbbr"),
    @NamedQuery(name = "UsStates.findByStateRegion", query = "SELECT u FROM UsStates u WHERE u.stateRegion = :stateRegion")})
public class UsStates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "state_id")
    private Short stateId;
    @Size(max = 100)
    @Column(name = "state_name")
    private String stateName;
    @Size(max = 2)
    @Column(name = "state_abbr")
    private String stateAbbr;
    @Size(max = 50)
    @Column(name = "state_region")
    private String stateRegion;

    public UsStates() {
    }

    public UsStates(Short stateId) {
        this.stateId = stateId;
    }

    public Short getStateId() {
        return stateId;
    }

    public void setStateId(Short stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public String getStateRegion() {
        return stateRegion;
    }

    public void setStateRegion(String stateRegion) {
        this.stateRegion = stateRegion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsStates)) {
            return false;
        }
        UsStates other = (UsStates) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.willypages.util.UsStates[ stateId=" + stateId + " ]";
    }
    
}

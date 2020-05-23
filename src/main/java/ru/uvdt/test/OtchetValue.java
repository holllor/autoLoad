/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.uvdt.test;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author oleg
 */
@Entity
@Table(name = "otchet_value")
@NamedQueries({
    @NamedQuery(name = "OtchetValue.findAll", query = "SELECT o FROM OtchetValue o"),
    @NamedQuery(name = "OtchetValue.findById", query = "SELECT o FROM OtchetValue o WHERE o.id = :id"),
    @NamedQuery(name = "OtchetValue.findByRazdel", query = "SELECT o FROM OtchetValue o WHERE o.razdel = :razdel"),
    @NamedQuery(name = "OtchetValue.findByGraf", query = "SELECT o FROM OtchetValue o WHERE o.graf = :graf"),
    @NamedQuery(name = "OtchetValue.findByRow", query = "SELECT o FROM OtchetValue o WHERE o.row = :row"),
    @NamedQuery(name = "OtchetValue.findByUslValue", query = "SELECT o FROM OtchetValue o WHERE o.uslValue = :uslValue")})
public class OtchetValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "razdel")
    private Integer razdel;
    @Column(name = "graf")
    private Integer graf;
    @Column(name = "row")
    private Integer row;
    @Column(name = "usl_value")
    private String uslValue;
    @JoinColumn(name = "id_otchets", referencedColumnName = "id")
    @ManyToOne
    private Otchets idOtchets;

    public OtchetValue() {
    }

    public OtchetValue(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRazdel() {
        return razdel;
    }

    public void setRazdel(Integer razdel) {
        this.razdel = razdel;
    }

    public Integer getGraf() {
        return graf;
    }

    public void setGraf(Integer graf) {
        this.graf = graf;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public String getUslValue() {
        return uslValue;
    }

    public void setUslValue(String uslValue) {
        this.uslValue = uslValue;
    }

    public Otchets getIdOtchets() {
        return idOtchets;
    }

    public void setIdOtchets(Otchets idOtchets) {
        this.idOtchets = idOtchets;
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
        if (!(object instanceof OtchetValue)) {
            return false;
        }
        OtchetValue other = (OtchetValue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.uvdt.test.OtchetValue[ id=" + id + " ]";
    }
    
}

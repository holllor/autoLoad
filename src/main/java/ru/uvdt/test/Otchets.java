/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.uvdt.test;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author oleg
 */
@Entity
@Table(name = "otchets")
@NamedQueries({
    @NamedQuery(name = "Otchets.findAll", query = "SELECT o FROM Otchets o"),
    @NamedQuery(name = "Otchets.findById", query = "SELECT o FROM Otchets o WHERE o.id = :id"),
    @NamedQuery(name = "Otchets.findByNameOtch", query = "SELECT o FROM Otchets o WHERE o.nameOtch = :nameOtch"),
    @NamedQuery(name = "Otchets.findByNomer", query = "SELECT o FROM Otchets o WHERE o.nomer = :nomer"),
    @NamedQuery(name = "Otchets.findByCode", query = "SELECT o FROM Otchets o WHERE o.code = :code"),
    @NamedQuery(name = "Otchets.findByPeriod", query = "SELECT o FROM Otchets o WHERE o.period = :period"),
    @NamedQuery(name = "Otchets.findByYear", query = "SELECT o FROM Otchets o WHERE o.year = :year"),
    @NamedQuery(name = "Otchets.findByMonth", query = "SELECT o FROM Otchets o WHERE o.month = :month"),
    @NamedQuery(name = "Otchets.findByDay", query = "SELECT o FROM Otchets o WHERE o.day = :day")})
public class Otchets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name_otch")
    private String nameOtch;
    @Column(name = "nomer")
    private Integer nomer;
    @Column(name = "code")
    private String code;
    @Column(name = "period")
    private String period;
    @Column(name = "year")
    private String year;
    @Column(name = "month")
    private String month;
    @Column(name = "day")
    private String day;
    @Lob
    @Column(name = "values")
    private Object values;
    @Lob
    @Column(name = "blank_emty")
    private byte[] blankEmty;
    @Lob
    @Column(name = "blank_full")
    private byte[] blankFull;
    @OneToMany(mappedBy = "idOtchets")
    private List<OtchetValue> otchetValueList;

    public Otchets() {
    }

    public Otchets(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOtch() {
        return nameOtch;
    }

    public void setNameOtch(String nameOtch) {
        this.nameOtch = nameOtch;
    }

    public Integer getNomer() {
        return nomer;
    }

    public void setNomer(Integer nomer) {
        this.nomer = nomer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Object getValues() {
        return values;
    }

    public void setValues(Object values) {
        this.values = values;
    }

    public byte[] getBlankEmty() {
        return blankEmty;
    }

    public void setBlankEmty(byte[] blankEmty) {
        this.blankEmty = blankEmty;
    }

    public byte[] getBlankFull() {
        return blankFull;
    }

    public void setBlankFull(byte[] blankFull) {
        this.blankFull = blankFull;
    }

    public List<OtchetValue> getOtchetValueList() {
        return otchetValueList;
    }

    public void setOtchetValueList(List<OtchetValue> otchetValueList) {
        this.otchetValueList = otchetValueList;
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
        if (!(object instanceof Otchets)) {
            return false;
        }
        Otchets other = (Otchets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.uvdt.test.Otchets[ id=" + id + " ]";
    }
    
}

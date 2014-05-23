/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projektityo_server;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henri
 */
@Entity
@Table(name = "BIRD_OBSERVATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BirdObservation_1.findAll", query = "SELECT b FROM BirdObservation_1 b"),
    @NamedQuery(name = "BirdObservation_1.findById", query = "SELECT b FROM BirdObservation_1 b WHERE b.id = :id"),
    @NamedQuery(name = "BirdObservation_1.findByDate", query = "SELECT b FROM BirdObservation_1 b WHERE b.date = :date"),
    @NamedQuery(name = "BirdObservation_1.findByTime", query = "SELECT b FROM BirdObservation_1 b WHERE b.time = :time"),
    @NamedQuery(name = "BirdObservation_1.findByLatitudeE6", query = "SELECT b FROM BirdObservation_1 b WHERE b.latitudeE6 = :latitudeE6"),
    @NamedQuery(name = "BirdObservation_1.findByLongitudeE6", query = "SELECT b FROM BirdObservation_1 b WHERE b.longitudeE6 = :longitudeE6"),
    @NamedQuery(name = "BirdObservation_1.findBySpecies", query = "SELECT b FROM BirdObservation_1 b WHERE b.species = :species"),
    @NamedQuery(name = "BirdObservation_1.findByObserverId", query = "SELECT b FROM BirdObservation_1 b WHERE b.observerId = :observerId")})
public class BirdObservation_1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "TIME")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Basic(optional = false)
    @Column(name = "LATITUDE_E6")
    private int latitudeE6;
    @Basic(optional = false)
    @Column(name = "LONGITUDE_E6")
    private int longitudeE6;
    @Basic(optional = false)
    @Column(name = "SPECIES")
    private String species;
    @Basic(optional = false)
    @Column(name = "OBSERVER_ID")
    private int observerId;

    public BirdObservation_1() {
    }

    public BirdObservation_1(Integer id) {
        this.id = id;
    }

    public BirdObservation_1(Integer id, Date date, Date time, int latitudeE6, int longitudeE6, String species, int observerId) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.latitudeE6 = latitudeE6;
        this.longitudeE6 = longitudeE6;
        this.species = species;
        this.observerId = observerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getLatitudeE6() {
        return latitudeE6;
    }

    public void setLatitudeE6(int latitudeE6) {
        this.latitudeE6 = latitudeE6;
    }

    public int getLongitudeE6() {
        return longitudeE6;
    }

    public void setLongitudeE6(int longitudeE6) {
        this.longitudeE6 = longitudeE6;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getObserverId() {
        return observerId;
    }

    public void setObserverId(int observerId) {
        this.observerId = observerId;
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
        if (!(object instanceof BirdObservation_1)) {
            return false;
        }
        BirdObservation_1 other = (BirdObservation_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projektityo_server.BirdObservation_1[ id=" + id + " ]";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Progra1_DB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Junior Hernandez
 */
@Entity
@Table(name = "REPTILES", catalog = "", schema = "ZOOADMIN")
@NamedQueries({
    @NamedQuery(name = "Reptiles.findAll", query = "SELECT r FROM Reptiles r"),
    @NamedQuery(name = "Reptiles.findById", query = "SELECT r FROM Reptiles r WHERE r.id = :id"),
    @NamedQuery(name = "Reptiles.findByNombre", query = "SELECT r FROM Reptiles r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Reptiles.findByEspecie", query = "SELECT r FROM Reptiles r WHERE r.especie = :especie"),
    @NamedQuery(name = "Reptiles.findByEdad", query = "SELECT r FROM Reptiles r WHERE r.edad = :edad"),
    @NamedQuery(name = "Reptiles.findByDieta", query = "SELECT r FROM Reptiles r WHERE r.dieta = :dieta")})
public class Reptiles implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 0, scale = -127)
    private BigDecimal id;
    @Column(name = "NOMBRE", length = 100)
    private String nombre;
    @Column(name = "ESPECIE", length = 100)
    private String especie;
    @Column(name = "EDAD")
    private BigInteger edad;
    @Column(name = "DIETA", length = 50)
    private String dieta;

    public Reptiles() {
    }

    public Reptiles(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public BigInteger getEdad() {
        return edad;
    }

    public void setEdad(BigInteger edad) {
        this.edad = edad;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
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
        if (!(object instanceof Reptiles)) {
            return false;
        }
        Reptiles other = (Reptiles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Progra1_DB.Reptiles[ id=" + id + " ]";
    }
    
}

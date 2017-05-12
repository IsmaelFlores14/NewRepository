package com.mycompany.agendaweb.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ismael
 */
@Entity
@Table(name = "contacto", catalog = "agenda", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c")
    , @NamedQuery(name = "Contacto.findById", query = "SELECT c FROM Contacto c WHERE c.id = :id")
    , @NamedQuery(name = "Contacto.findByNombre", query = "SELECT c FROM Contacto c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Contacto.findByEmail", query = "SELECT c FROM Contacto c WHERE c.email = :email")
    , @NamedQuery(name = "Contacto.findByTelefono", query = "SELECT c FROM Contacto c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Contacto.findByDireccion", query = "SELECT c FROM Contacto c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Contacto.findByPropietario", query = "SELECT c FROM Contacto c WHERE c.propietario = :propietario")
    , @NamedQuery(name = "Contacto.findByMd5", query = "SELECT c FROM Contacto c WHERE c.md5 = :md5")})
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 30)
    @Column(name = "nombre", length = 30)
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "email", length = 30)
    private String email;
    @Size(max = 30)
    @Column(name = "telefono", length = 30)
    private String telefono;
    @Size(max = 30)
    @Column(name = "direccion", length = 30)
    private String direccion;
    @Size(max = 30)
    @Column(name = "propietario", length = 30)
    private String propietario;
    @Size(max = 30)
    @Column(name = "md5", length = 30)
    private String md5;

    public Contacto() {
    }

    public Contacto(Integer id) {
        this.id = id;
    }
    
    public Contacto(Integer Id, String nombre, String propietario, String md5) {
        this.id = Id;
        this.nombre = nombre;
        this.propietario = propietario;
        this.md5 = md5;
    }
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS METHODS">
    public Integer getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public String getPropietario() {
        return propietario;
    }
    
    public String getMd5() {
        return md5;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="SETTERS METHODS">
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    
    public void setMd5(String md5) {
        this.md5 = md5;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EQUALS & HASHCODE METHODS">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.propietario);
        hash = 47 * hash + Objects.hashCode(this.md5);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contacto other = (Contacto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.propietario, other.propietario)) {
            return false;
        }
        if (!Objects.equals(this.md5, other.md5)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
//</editor-fold>

    
    
}

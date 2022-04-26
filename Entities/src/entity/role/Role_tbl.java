/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.role;

import entity.user.User_tbl;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ashrafi
 */
@Entity
@Table(name = "tbl_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role_tbl.findAll", query = "SELECT r FROM Role_tbl r"),
    @NamedQuery(name = "Role_tbl.findById", query = "SELECT r FROM Role_tbl r WHERE r.id = :id"),
    @NamedQuery(name = "Role_tbl.findByName", query = "SELECT r FROM Role_tbl r WHERE r.name = :name")})
public class Role_tbl implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private Collection<User_tbl> usertblCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;

    public Role_tbl() {
    }

    public Role_tbl(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Role_tbl)) {
            return false;
        }
        Role_tbl other = (Role_tbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.role.Role_tbl[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<User_tbl> getUsertblCollection() {
        return usertblCollection;
    }

    public void setUsertblCollection(Collection<User_tbl> usertblCollection) {
        this.usertblCollection = usertblCollection;
    }
    
}

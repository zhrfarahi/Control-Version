/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.repository;

import entity.file.File_tbl;
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
@Table(name = "tbl_repository")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repository_tbl.findAll", query = "SELECT r FROM Repository_tbl r"),
    @NamedQuery(name = "Repository_tbl.findById", query = "SELECT r FROM Repository_tbl r WHERE r.id = :id"),
    @NamedQuery(name = "Repository_tbl.findByName", query = "SELECT r FROM Repository_tbl r WHERE r.name = :name"),
    @NamedQuery(name = "Repository_tbl.findByPath", query = "SELECT r FROM Repository_tbl r WHERE r.path = :path"),
    @NamedQuery(name = "Repository_tbl.delete", query = "DELETE FROM Repository_tbl r WHERE r.id = :id")})
public class Repository_tbl implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repositoryId")
    private Collection<File_tbl> filetblCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "PATH")
    private String path;

    public Repository_tbl() {
    }

    public Repository_tbl(Integer id) {
        this.id = id;
    }

    public Repository_tbl(Integer id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        if (!(object instanceof Repository_tbl)) {
            return false;
        }
        Repository_tbl other = (Repository_tbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.repository.Repository_tbl[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<File_tbl> getFiletblCollection() {
        return filetblCollection;
    }

    public void setFiletblCollection(Collection<File_tbl> filetblCollection) {
        this.filetblCollection = filetblCollection;
    }

}

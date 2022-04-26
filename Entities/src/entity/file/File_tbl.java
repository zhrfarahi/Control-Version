/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.file;

import entity.file_history.FileHistory_tbl;
import entity.locked_files.LockedFiles_tbl;
import entity.repository.Repository_tbl;
import entity.user.User_tbl;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_file")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "File_tbl.findAll", query = "SELECT f FROM File_tbl f"),
    @NamedQuery(name = "File_tbl.findById", query = "SELECT f FROM File_tbl f WHERE f.id = :id"),
    @NamedQuery(name = "File_tbl.findByName", query = "SELECT f FROM File_tbl f WHERE f.name = :name"),
    @NamedQuery(name = "File_tbl.findByPath", query = "SELECT f FROM File_tbl f WHERE f.path = :path"),
    @NamedQuery(name = "File_tbl.findByRepositoryId", query = "SELECT f FROM File_tbl f WHERE f.repositoryId.id = :repositoryId"),
    @NamedQuery(name = "File_tbl.findByRepositoryIdAndUserID", query = "SELECT f FROM File_tbl f WHERE (f.repositoryId.id = :repositoryId AND f.userId.id = :userId) OR (f.repositoryId.id = :repositoryId AND f.isPrivate = 0)"),
    @NamedQuery(name = "File_tbl.delete", query = "DELETE FROM File_tbl f WHERE f.id = :id")})
public class File_tbl implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fileId")
    private Collection<LockedFiles_tbl> lockedFilestblCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fileId")
    private Collection<FileHistory_tbl> fileHistorytblCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "PATH")
    private String path;
    @JoinColumn(name = "REPOSITORY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Repository_tbl repositoryId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User_tbl userId;
    @Column(name = "IS_PRIVATE")
    private Short isPrivate;

    public File_tbl() {
    }

    public File_tbl(Integer id) {
        this.id = id;
    }

    public File_tbl(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Repository_tbl getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(Repository_tbl repositoryId) {
        this.repositoryId = repositoryId;
    }
    
    public User_tbl getUserId() {
        return userId;
    }

    public void setUserId(User_tbl userId) {
        this.userId = userId;
    }
    
    public Short getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Short isPrivate) {
        this.isPrivate = isPrivate;
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
        if (!(object instanceof File_tbl)) {
            return false;
        }
        File_tbl other = (File_tbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.file.File_tbl[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<FileHistory_tbl> getFileHistorytblCollection() {
        return fileHistorytblCollection;
    }

    public void setFileHistorytblCollection(Collection<FileHistory_tbl> fileHistorytblCollection) {
        this.fileHistorytblCollection = fileHistorytblCollection;
    }

    @XmlTransient
    public Collection<LockedFiles_tbl> getLockedFilestblCollection() {
        return lockedFilestblCollection;
    }

    public void setLockedFilestblCollection(Collection<LockedFiles_tbl> lockedFilestblCollection) {
        this.lockedFilestblCollection = lockedFilestblCollection;
    }

}

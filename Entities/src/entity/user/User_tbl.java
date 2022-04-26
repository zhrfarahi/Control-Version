/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.user;

import entity.file_history.FileHistory_tbl;
import entity.locked_files.LockedFiles_tbl;
import entity.role.Role_tbl;
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
@Table(name = "tbl_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User_tbl.findAll", query = "SELECT u FROM User_tbl u"),
    @NamedQuery(name = "User_tbl.findById", query = "SELECT u FROM User_tbl u WHERE u.id = :id"),
    @NamedQuery(name = "User_tbl.findByName", query = "SELECT u FROM User_tbl u WHERE u.name = :name"),
    @NamedQuery(name = "User_tbl.findByPassword", query = "SELECT u FROM User_tbl u WHERE u.password = :password"),
    @NamedQuery(name = "User_tbl.findByLoggedIn", query = "SELECT u FROM User_tbl u WHERE u.loggedIn = :loggedIn"),
    @NamedQuery(name = "User_tbl.findByNameAndPassword", query = "SELECT u FROM User_tbl u WHERE (u.name = :name) AND (u.password = :password)"),
    @NamedQuery(name = "User_tbl.findByRoleId", query = "SELECT u FROM User_tbl u WHERE u.roleId.id = :roleId"),
    @NamedQuery(name = "User_tbl.updateLoggedIn", query = "UPDATE User_tbl u SET u.loggedIn = :loggedIn WHERE u.id = :id"),
    @NamedQuery(name = "User_tbl.updatePassword", query = "UPDATE User_tbl u SET u.password = :password WHERE u.id = :id"),
    @NamedQuery(name = "User_tbl.delete", query = "DELETE FROM User_tbl u WHERE u.id = :id")})
public class User_tbl implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<LockedFiles_tbl> lockedFilestblCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<FileHistory_tbl> fileHistorytblCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "LOGGED_IN")
    private Short loggedIn;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Role_tbl roleId;

    public User_tbl() {
    }

    public User_tbl(Integer id) {
        this.id = id;
    }

    public User_tbl(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Short loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Role_tbl getRoleId() {
        return roleId;
    }

    public void setRoleId(Role_tbl roleId) {
        this.roleId = roleId;
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
        if (!(object instanceof User_tbl)) {
            return false;
        }
        User_tbl other = (User_tbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User_tbl[ id=" + id + " ]";
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

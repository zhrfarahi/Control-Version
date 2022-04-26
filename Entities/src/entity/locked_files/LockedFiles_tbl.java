/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.locked_files;

import entity.file.File_tbl;
import entity.user.User_tbl;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ashrafi
 */
@Entity
@Table(name = "tbl_locked_files")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LockedFiles_tbl.findAll", query = "SELECT l FROM LockedFiles_tbl l"),
    @NamedQuery(name = "LockedFiles_tbl.findById", query = "SELECT l FROM LockedFiles_tbl l WHERE l.id = :id"),
    @NamedQuery(name = "LockedFiles_tbl.findByUserID", query = "SELECT l FROM LockedFiles_tbl l WHERE l.userId.id = :id"),
    @NamedQuery(name = "LockedFiles_tbl.findByFileID", query = "SELECT l FROM LockedFiles_tbl l WHERE l.fileId.id = :id"),
    @NamedQuery(name = "LockedFiles_tbl.delete", query = "DELETE FROM LockedFiles_tbl l WHERE l.id = :id")})
public class LockedFiles_tbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User_tbl userId;
    @JoinColumn(name = "FILE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private File_tbl fileId;

    public LockedFiles_tbl() {
    }

    public LockedFiles_tbl(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User_tbl getUserId() {
        return userId;
    }

    public void setUserId(User_tbl userId) {
        this.userId = userId;
    }

    public File_tbl getFileId() {
        return fileId;
    }

    public void setFileId(File_tbl fileId) {
        this.fileId = fileId;
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
        if (!(object instanceof LockedFiles_tbl)) {
            return false;
        }
        LockedFiles_tbl other = (LockedFiles_tbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.locked_files.LockedFiles_tbl[ id=" + id + " ]";
    }
    
}

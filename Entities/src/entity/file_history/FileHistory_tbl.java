/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.file_history;

import entity.file.File_tbl;
import entity.user.User_tbl;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ashrafi
 */
@Entity
@Table(name = "tbl_file_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FileHistory_tbl.findAll", query = "SELECT f FROM FileHistory_tbl f"),
    @NamedQuery(name = "FileHistory_tbl.findById", query = "SELECT f FROM FileHistory_tbl f WHERE f.id = :id"),
    @NamedQuery(name = "FileHistory_tbl.findByVersion", query = "SELECT f FROM FileHistory_tbl f WHERE f.version = :version"),
    @NamedQuery(name = "FileHistory_tbl.findByDate", query = "SELECT f FROM FileHistory_tbl f WHERE f.date = :date"),
    @NamedQuery(name = "FileHistory_tbl.findByComment", query = "SELECT f FROM FileHistory_tbl f WHERE f.comment = :comment"),
    @NamedQuery(name = "FileHistory_tbl.findByFileId", query = "SELECT f FROM FileHistory_tbl f WHERE f.fileId.id = :fileId"),
    @NamedQuery(name = "FileHistory_tbl.findByFileIdAndVersion", query = "SELECT f FROM FileHistory_tbl f WHERE (f.fileId.id = :fileId) AND (f.version = :version)"),
    @NamedQuery(name = "FileHistory_tbl.delete", query = "DELETE FROM FileHistory_tbl f WHERE f.id = :id")})
public class FileHistory_tbl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "VERSION")
    private Integer version;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "COMMENT")
    private String comment;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User_tbl userId;
    @JoinColumn(name = "FILE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private File_tbl fileId;

    public FileHistory_tbl() {
    }

    public FileHistory_tbl(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        if (!(object instanceof FileHistory_tbl)) {
            return false;
        }
        FileHistory_tbl other = (FileHistory_tbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.file_history.FileHistory_tbl[ id=" + id + " ]";
    }

}

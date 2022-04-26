package entity.file_history;

import entity.file.File_tbl;
import entity.user.User_tbl;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-18T11:29:02")
@StaticMetamodel(FileHistory_tbl.class)
public class FileHistory_tbl_ { 

    public static volatile SingularAttribute<FileHistory_tbl, Integer> id;
    public static volatile SingularAttribute<FileHistory_tbl, File_tbl> fileId;
    public static volatile SingularAttribute<FileHistory_tbl, User_tbl> userId;
    public static volatile SingularAttribute<FileHistory_tbl, Date> date;
    public static volatile SingularAttribute<FileHistory_tbl, String> comment;
    public static volatile SingularAttribute<FileHistory_tbl, Integer> version;

}
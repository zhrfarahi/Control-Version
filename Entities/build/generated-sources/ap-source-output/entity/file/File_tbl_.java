package entity.file;

import entity.file_history.FileHistory_tbl;
import entity.locked_files.LockedFiles_tbl;
import entity.repository.Repository_tbl;
import entity.user.User_tbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-18T11:29:02")
@StaticMetamodel(File_tbl.class)
public class File_tbl_ { 

    public static volatile SingularAttribute<File_tbl, Integer> id;
    public static volatile CollectionAttribute<File_tbl, LockedFiles_tbl> lockedFilestblCollection;
    public static volatile CollectionAttribute<File_tbl, FileHistory_tbl> fileHistorytblCollection;
    public static volatile SingularAttribute<File_tbl, Short> isPrivate;
    public static volatile SingularAttribute<File_tbl, String> name;
    public static volatile SingularAttribute<File_tbl, User_tbl> userId;
    public static volatile SingularAttribute<File_tbl, String> path;
    public static volatile SingularAttribute<File_tbl, Repository_tbl> repositoryId;

}
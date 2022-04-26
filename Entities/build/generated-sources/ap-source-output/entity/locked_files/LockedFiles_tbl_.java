package entity.locked_files;

import entity.file.File_tbl;
import entity.user.User_tbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-18T11:29:02")
@StaticMetamodel(LockedFiles_tbl.class)
public class LockedFiles_tbl_ { 

    public static volatile SingularAttribute<LockedFiles_tbl, Integer> id;
    public static volatile SingularAttribute<LockedFiles_tbl, File_tbl> fileId;
    public static volatile SingularAttribute<LockedFiles_tbl, User_tbl> userId;

}
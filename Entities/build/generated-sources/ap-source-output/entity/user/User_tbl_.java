package entity.user;

import entity.file_history.FileHistory_tbl;
import entity.locked_files.LockedFiles_tbl;
import entity.role.Role_tbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-18T11:29:02")
@StaticMetamodel(User_tbl.class)
public class User_tbl_ { 

    public static volatile SingularAttribute<User_tbl, Integer> id;
    public static volatile CollectionAttribute<User_tbl, LockedFiles_tbl> lockedFilestblCollection;
    public static volatile CollectionAttribute<User_tbl, FileHistory_tbl> fileHistorytblCollection;
    public static volatile SingularAttribute<User_tbl, String> name;
    public static volatile SingularAttribute<User_tbl, Short> loggedIn;
    public static volatile SingularAttribute<User_tbl, String> password;
    public static volatile SingularAttribute<User_tbl, Role_tbl> roleId;

}
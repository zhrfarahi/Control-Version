package entity.role;

import entity.user.User_tbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-18T11:29:02")
@StaticMetamodel(Role_tbl.class)
public class Role_tbl_ { 

    public static volatile SingularAttribute<Role_tbl, Integer> id;
    public static volatile CollectionAttribute<Role_tbl, User_tbl> usertblCollection;
    public static volatile SingularAttribute<Role_tbl, String> name;

}
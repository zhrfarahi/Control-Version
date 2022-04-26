package entity.repository;

import entity.file.File_tbl;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-18T11:29:02")
@StaticMetamodel(Repository_tbl.class)
public class Repository_tbl_ { 

    public static volatile SingularAttribute<Repository_tbl, Integer> id;
    public static volatile SingularAttribute<Repository_tbl, String> name;
    public static volatile SingularAttribute<Repository_tbl, String> path;
    public static volatile CollectionAttribute<Repository_tbl, File_tbl> filetblCollection;

}
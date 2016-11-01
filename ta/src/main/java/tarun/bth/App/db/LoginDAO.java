package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.Login;

import java.util.List;


@RegisterMapperFactory(BeanMapperFactory.class)
public interface LoginDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS login(id int auto_increment primary key, username varchar(12), password varchar(12))")
    public void createTable();

    //@SqlUpdate("Insert into login values(1,'admin','admin')")
    //public void insertAdminDetails();

    @SqlQuery("SELECT * FROM login;")
    public List<Login> getAllLogin();


    @SqlQuery("SELECT * FROM login WHERE id = :id")
    public Login findUserById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM login WHERE username= :username AND password = :password")
    public Login findUserByUsername(@Bind("username") String username,@Bind("password") String password);

    @SqlUpdate("INSERT INTO `login` VALUES(:id,:username,:password)")
    @GetGeneratedKeys
    public int create(@BindBean Login login);

    @SqlUpdate("UPDATE `login` set username= :username, password= :password WHERE id = :id")
    int update(@Bind("id") int id,@BindBean Login login);
}

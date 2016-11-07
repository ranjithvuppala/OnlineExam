package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.User;

import java.util.List;


@RegisterMapperFactory(BeanMapperFactory.class)
public interface UserDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS login(id int auto_increment primary key, username varchar(12), password varchar(12), role varchar(12))")
    public void createTable();

    //@SqlUpdate("Insert into login values(1,'admin','admin')")
    //public void insertAdminDetails();

    @SqlQuery("SELECT * FROM login;")
    public List<User> getAllLogin();


    @SqlQuery("SELECT * FROM login WHERE id = :id")
    public User findUserById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM user WHERE username= :username AND password = :password")
   // public User findUserByUsername(@Bind("username") String username,@Bind("password") String password);
    public User findUserByUsername(@BindBean User user);

    @SqlUpdate("INSERT INTO `user` VALUES(:id,:username,:password)")
    @GetGeneratedKeys
    public int create(@BindBean User user);

    @SqlUpdate("UPDATE `user` set username= :username, password= :password WHERE id = :id")
    public int update(@BindBean User user);
}

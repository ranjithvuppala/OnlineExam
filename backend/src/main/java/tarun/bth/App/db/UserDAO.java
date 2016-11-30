package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.User;

import java.util.List;


@RegisterMapperFactory(BeanMapperFactory.class)
public interface UserDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS user(id int auto_increment primary key, username varchar(100), password varchar(100), role varchar(12), UNIQUE(username))")
    public void createTable();

    @SqlUpdate("Merge into user values(0,'admin','admin','adm')")
    public void insertAdminDetails();

    @SqlQuery("SELECT * FROM user WHERE role = :role")
    public List<User> getUsersByRole(@Bind("role") String role);


    @SqlQuery("SELECT * FROM user WHERE id = :id")
    public User findUserById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM user WHERE username= :username AND password = :password")
    public User findUserByUsername(@BindBean User user);

    @SqlUpdate("INSERT INTO `user` VALUES(:id,:username,:password,:role)")
    @GetGeneratedKeys
    public int create(@BindBean User user);

    @SqlUpdate("UPDATE `user` set username= :username, password= :password, role= :role WHERE id = :id")
    public int update(@BindBean User user);
}

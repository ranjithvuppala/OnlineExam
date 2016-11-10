package tarun.bth.App.db;

/**
 * Created by souji on 10/11/16.
 */

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;


@RegisterMapperFactory(BeanMapperFactory.class)
public interface OptionDAO {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS Option(option_id int auto_increment primary key, option varchar(255))")
    public void createTable();

    @SqlQuery("SELECT * FROM Option")
    public List<Option> getAllOptions();

    @SqlUpdate("INSERT INTO `Option` VALUES(:option_id,:option )")
    @GetGeneratedKeys
    int create(@BindBean Option option);


    @SqlQuery("SELECT * FROM `Option` WHERE option_id = :option_id")
    public Option findOptionById(@Bind("option_id") int option_id);

    @SqlUpdate("UPDATE `Option` set option= :option WHERE option_id = :option_id")
    int update(@BindBean Option option);

    @SqlUpdate("DELETE FROM `Option` WHERE option_id = :option_id")
    int delete(@Bind("option_id") int option_id);

    //@SqlQuery("SELECT option_id,option From Option")
    //public List<Option> getOnlyOption();
}



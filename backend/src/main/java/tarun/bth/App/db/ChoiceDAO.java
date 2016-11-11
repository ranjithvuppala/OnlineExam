package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.Choice;

import java.util.List;


@RegisterMapperFactory(BeanMapperFactory.class)
public interface ChoiceDAO {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS Choice(id int auto_increment primary key, choice varchar(255))")
    public void createTable();

    @SqlQuery("SELECT * FROM Choice")
    public List<Choice> getAllChoices();

    @SqlUpdate("INSERT INTO `Choice` VALUES(:id,:choice )")
    @GetGeneratedKeys
    int create(@BindBean Choice choice);


    @SqlQuery("SELECT * FROM `Choice` WHERE id = :id")
    public Choice findChoiceById(@Bind("id") int id);

    @SqlUpdate("UPDATE `Choice` set choice= :choice WHERE id = :id")
    int update(@BindBean Choice choice);

    @SqlUpdate("DELETE FROM `Choice` WHERE id = :id")
    int delete(@Bind("id") int id);

    //@SqlQuery("SELECT choice_id,choice From Choice")
    //public List<Choice> getOnlyChoice();
}



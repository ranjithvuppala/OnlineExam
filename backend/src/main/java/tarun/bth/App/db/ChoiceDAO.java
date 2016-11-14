package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.Choice;

import java.util.List;


@RegisterMapperFactory(BeanMapperFactory.class)
public interface ChoiceDAO {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS Choice(choice_id int auto_increment primary key, choice varchar(255))")
    public void createTable();

    @SqlQuery("SELECT * FROM Choice")
    public List<Choice> getAllChoices();

    @SqlUpdate("INSERT INTO `Choice` VALUES(:choice_id,:choice )")
    @GetGeneratedKeys
    int create(@BindBean Choice choice);


    @SqlQuery("SELECT * FROM `Choice` WHERE choice_id = :choice_id")
    public Choice findChoiceById(@Bind("choice_id") int choice_id);

    @SqlUpdate("UPDATE `Choice` set choice= :choice WHERE choice_id = :choice_id")
    int update(@BindBean Choice choice);

    @SqlUpdate("DELETE FROM `Choice` WHERE choice_id = :choice_id")
    int delete(@Bind("choice_id") int choice_id);

    //@SqlQuery("SELECT choice_id,choice From Choice")
    //public List<Choice> getOnlyChoice();
}



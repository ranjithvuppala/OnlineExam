package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.QuestionChoice;
import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface QuestionChoiceDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS QuestionChoice(question_id int, choice_id int, UNIQUE(question_id,choice_id))")
    void createTable();

    @SqlUpdate("INSERT INTO `QuestionChoice` VALUES(:question_id,:choice_id )")
    @GetGeneratedKeys
    int create(@BindBean QuestionChoice questionChoice);

    @SqlUpdate("DELETE FROM `QuestionChoice` WHERE choice_id = :choice_id")
    int deleteByChoiceId(@Bind("choice_id") int choice_id);

    @SqlUpdate("DELETE FROM `QuestionChoice` WHERE question_id = :question_id")
    int deleteByQuestionId(@Bind("question_id") int question_id);

    @SqlQuery("SELECT choice_id FROM `QuestionChoice` WHERE question_id = :question_id")
    List<Integer> findQuestionChoiceById(@Bind("question_id") int question_id);


}

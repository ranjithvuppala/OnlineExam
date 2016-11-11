package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import tarun.bth.App.db.entity.QuestionChoice;

/**
 * Created by user on 11-11-2016.
 */
public interface QuestionChoiceDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS QuestionChoice(question_id int, choice_id int, UNIQUE(question_id,choice_id))")
    public void createTable();

    @SqlUpdate("INSERT INTO `QuestionChoice` VALUES(:question_id,:choice_id )")
    @GetGeneratedKeys
    int create(@BindBean QuestionChoice questionChoice);

    @SqlUpdate("DELETE FROM `QuestionChoice` WHERE choice_id = :choice_id")
    int delete(@Bind("choice_id") int choice_id);

    @SqlQuery("SELECT * FROM `QuestionChoice` WHERE question_id = :question_id")
    public QuestionChoice findQuestionChoiceById(@Bind("question_id") int question_id);


}

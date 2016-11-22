package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.Question;

import java.util.List;


@RegisterMapperFactory(BeanMapperFactory.class)
public interface QuestionDAO {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS Question(question_id int auto_increment primary key, question varchar(255), correctChoice_id int)")
    public void createTable();

    @SqlQuery("SELECT * FROM Question")
    public List<Question> getAllQuestions();

    @SqlUpdate("INSERT INTO `Question` VALUES(:question_id,:question,:correctChoice_id)")
    @GetGeneratedKeys
    int create(@BindBean Question question);


    @SqlQuery("SELECT * FROM `Question` WHERE question_id = :question_id")
    public Question findQuestionById(@Bind("question_id") int question_id);

    @SqlQuery("SELECT question_id FROM `Question` WHERE correctChoice_id = :correctChoice_id")
    public List<Integer> findByCorrectChoiceId(@Bind("correctChoice_id") int correctChoice_id);

    @SqlQuery("SELECT correctChoice_id FROM `Question` WHERE question_id = :question_id")
    public int findCorrectChoiceByQuestionId(@Bind("question_id") int question_id);


    @SqlUpdate("UPDATE `Question` set question= :question, correctChoice_id = :correctChoice_id WHERE question_id = :question_id")
    int update(@BindBean Question question);

    @SqlUpdate("DELETE FROM `Question` WHERE question_id = :question_id")
    int delete(@Bind("question_id") int question_id);


    @SqlUpdate("DELETE FROM `Question` WHERE correctChoice_id = :correctChoice_id")
    int deleteByCorrectOptionId(@Bind("correctChoice_id") int correctChoice_id);

}

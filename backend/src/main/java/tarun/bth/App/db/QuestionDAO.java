package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.Question;
import tarun.bth.App.db.entity.QuestionName;

import java.util.List;


@RegisterMapperFactory(BeanMapperFactory.class)
public interface QuestionDAO {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS Question(question_id int auto_increment primary key, question varchar(255), firstoption varchar(255), secondoption varchar(255),thirdoption varchar(255),fourthoption varchar(255), correctoption varchar(255))")
    public void createTable();

    @SqlQuery("SELECT * FROM Question")
    public List<Question> getAllQuestions();

    @SqlUpdate("INSERT INTO `Question` VALUES(:question_id,:question,:firstoption,:secondoption,:thirdoption,:fourthoption, :correctoption)")
    @GetGeneratedKeys
    int create(@BindBean Question question);


    @SqlQuery("SELECT * FROM `Question` WHERE question_id = :question_id")
    public Question findQuestionById(@Bind("question_id") int question_id);

    @SqlUpdate("UPDATE `Question` set question= :question,firstoption= :firstoption,secondoption= :secondoption,thirdoption= :thirdoption,fourthoption= :fourthoption, correctoption= :correctoption WHERE question_id = :question_id")
    int update(@BindBean Question question);

    @SqlUpdate("DELETE FROM `Question` WHERE question_id = :question_id")
    int delete(@Bind("question_id") int question_id);

    @SqlQuery("SELECT question_id,question From Question")
    public List<QuestionName> getOnlyQuestions();
}

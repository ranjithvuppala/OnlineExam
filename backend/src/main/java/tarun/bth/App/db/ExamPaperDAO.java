package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.ExamPaper;
import tarun.bth.App.db.entity.Login;

import java.util.List;


@RegisterMapperFactory(BeanMapperFactory.class)
public interface ExamPaperDAO {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS ExamPaper(question_id int auto_increment primary key, question varchar(255), firstoption varchar(255), secondoption varchar(255),thirdoption varchar(255),fourthoption varchar(255),correctoption varchar(255))")
    public void createTable();

    @SqlQuery("SELECT * FROM ExamPaper")
    public List<ExamPaper> getAllQuestions();

    @SqlUpdate("INSERT INTO `ExamPaper` VALUES(:question_id,:question,:firstoption,:secondoption,:thirdoption,:fourthoption,:correctoption)")
    @GetGeneratedKeys
    int create(@BindBean ExamPaper examPaper);


    @SqlQuery("SELECT * FROM `ExamPaper` WHERE question_id = :question_id")
    public ExamPaper findQuestionById(@Bind("question_id") int question_id);

    @SqlUpdate("UPDATE `ExamPaper` set question= :question,firstoption= :firstoption,secondoption= :secondoption,thirdoption= :thirdoption,fourthoption= :fourthoption, correctoption= :correctoption WHERE question_id = :question_id")
    int update(@BindBean ExamPaper examPaper);

    @SqlUpdate("DELETE FROM `ExamPaper` WHERE question_id = :question_id")
    int delete(@Bind("question_id") int question_id);
}

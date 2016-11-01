package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.ExamPaper;
import tarun.bth.App.db.entity.Login;

import java.util.List;

/**
 * Created by user on 27-10-2016.
 */
@RegisterMapperFactory(BeanMapperFactory.class)
public interface ExamPaperDAO {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS ExamPaper(question_id int auto_increment primary key, question varchar(255), firstoption varchar(255), secondoption varchar(255),thirdoption varchar(255),fourthoption varchar(255))")
    public void createTable();

    @SqlQuery("SELECT * FROM ExamPaper")
    public List<ExamPaper> getAllQuestions();

    @SqlUpdate("INSERT INTO `ExamPaper` VALUES(:question_id,:question,:firstoption,:secondoption,:thirdoption,:fourthoption)")
    @GetGeneratedKeys
    int create(@BindBean ExamPaper examPaper);


    @SqlQuery("SELECT * FROM `ExamPaper` WHERE question_id = :question_id")
    public ExamPaper findQuestionById(@Bind("question_id") int question_id);
}
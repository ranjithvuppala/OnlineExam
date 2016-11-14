package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.ExamQuestion;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface ExamQuestionDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS ExamQuestion(exam_id int,question_id int,UNIQUE(exam_id,question_id))")
    public void createTable();

    @SqlUpdate("INSERT INTO `ExamQuestion` VALUES(:exam_id,:question_id )")
    @GetGeneratedKeys
    int create(@BindBean ExamQuestion examQuestion);

    @SqlUpdate("DELETE FROM `ExamQuestion` WHERE question_id = :question_id")
    int delete(@Bind("choice_id") int question_id);

    @SqlQuery("SELECT * FROM `ExamQuestion` WHERE exam_id = :exam_id")
    @GetGeneratedKeys
    public ExamQuestion findExamQuestionById(@Bind("exam_id") int exam_id);

    //@SqlQuery("SELECT * FROM `ExamQuestion` WHERE exam_id = :exam_id")
    //public ExamQuestion findExamQuestionById(@Bind("exam_id") int exam_id);
}

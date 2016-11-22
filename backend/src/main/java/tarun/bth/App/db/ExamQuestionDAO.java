package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.ExamQuestion;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface ExamQuestionDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS ExamQuestion(exam_id int,question_id int,UNIQUE(exam_id,question_id))")
    public void createTable();

    @SqlUpdate("INSERT INTO `ExamQuestion` VALUES(:exam_id,:question_id )")
    @GetGeneratedKeys
    int create(@BindBean ExamQuestion examQuestion);

    @SqlUpdate("DELETE FROM `ExamQuestion` WHERE exam_id = :exam_id")
    int deleteByExamId(@Bind("exam_id") int exam_id);

    @SqlUpdate("DELETE FROM `ExamQuestion` WHERE question_id = :question_id")
    int deleteByQuestionId(@Bind("question_id") int question_id);

    @SqlQuery("SELECT question_id FROM `ExamQuestion` WHERE exam_id = :exam_id")
    @GetGeneratedKeys
    List<Integer> findExamQuestionById(@Bind("exam_id") int exam_id);

}

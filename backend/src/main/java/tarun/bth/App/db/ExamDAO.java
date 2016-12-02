package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.Exam;

import java.util.List;


@RegisterMapperFactory(BeanMapperFactory.class)
public interface ExamDAO {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS Exam(exam_id int auto_increment primary key, exam varchar(25))")
    public void createTable();

    @SqlQuery("SELECT * FROM Exam")
    public List<Exam> getExams();

    @SqlUpdate("INSERT INTO `Exam` VALUES(:exam_id,:exam)")
    @GetGeneratedKeys
    int create(@BindBean Exam exam);

    @SqlQuery("SELECT * FROM `Exam` WHERE exam_id = :exam_id")
    public Exam findExamById(@Bind("exam_id") int exam_id);

    @SqlUpdate("UPDATE `Exam` set exam = :exam WHERE exam_id = :exam_id")
    int update(@BindBean Exam exam);

    @SqlUpdate("DELETE FROM `Exam` WHERE exam_id = :exam_id")
    int delete(@Bind("exam_id") int exam_id);

}

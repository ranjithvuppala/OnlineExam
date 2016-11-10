package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.Exam;

import java.util.List;


@RegisterMapperFactory(BeanMapperFactory.class)
public interface ExamDAO {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS Exam(exam_id int auto_increment primary key, firstquestion_id int, secondquestion_id int, thirdquestion_id int , fourthquestion_id int , fifthquestion_id int)")
    public void createTable();

    @SqlQuery("SELECT * FROM Exam")
    public List<Exam> getSelectedQuestions();

    @SqlUpdate("INSERT INTO `Exam` VALUES(:exam_id,:firstquestion_id,:secondquestion_id,:thirdquestion_id,:fourthquestion_id, :fifthquestion_id)")
    @GetGeneratedKeys
    int create(@BindBean Exam exam);


    @SqlQuery("SELECT * FROM `Exam` WHERE exam_id = :exam_id")
    public Exam findExamById(@Bind("exam_id") int exam_id);

    @SqlUpdate("UPDATE `Exam` set firstquestion_id= :firstquestion_id,secondquestion_id= :secondquestion_id,thirdquestion_id= :thirdquestion_id,fourthquestion_id= :fourthquestion_id, fifthquestion_id= :fifthoption WHERE exam_id = :exam_id")
    int update(@BindBean Exam exam);

    @SqlUpdate("DELETE FROM `Exam` WHERE exam_id = :exam_id")
    int delete(@Bind("exam_id") int exam_id);

   // @SqlQuery("SELECT exam_id,exam From Exam")
    //public List<Exam> getSelectedQuestions();
}

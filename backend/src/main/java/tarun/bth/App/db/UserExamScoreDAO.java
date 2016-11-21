package tarun.bth.App.db;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import tarun.bth.App.db.entity.UserExamScore;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface UserExamScoreDAO {

        @SqlUpdate("CREATE TABLE IF NOT EXISTS UserExamScore(id int auto_increment primary key,userId int, examId int, score int, UNIQUE(userId,examId) )")
        public void createTable();

        @SqlQuery("SELECT * FROM UserExamScore")
        public List<UserExamScore> getUserExamScores();

        @SqlUpdate("INSERT INTO `UserExamScore` VALUES(:userId,:examId)")
        int create(@BindBean UserExamScore UserExamScore);


        @SqlQuery("SELECT * FROM `UserExamScore` WHERE id = :id")
        public UserExamScore findUserExamScoreById(@Bind("id") int id);

        @SqlUpdate("UPDATE `UserExamScore` set userId = :userId, examId = :examId, score = :score WHERE id = :id")
        int update(@BindBean UserExamScore userExamScore);

       /* @SqlUpdate("DELETE FROM `Exam` WHERE exam_id = :exam_id")
        int delete(@Bind("exam_id") int exam_id);*/

}
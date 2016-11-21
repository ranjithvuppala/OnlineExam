package tarun.bth.App.process;

import tarun.bth.App.db.entity.UserExamScore;

public interface UserExamScoreProcess {
    UserExamScore findbyId(Integer id);
    Integer  updateResult(UserExamScore userExamScore);
}

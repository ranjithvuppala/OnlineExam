package tarun.bth.App.process;


import tarun.bth.App.db.UserExamScoreDAO;
import tarun.bth.App.db.entity.UserExamScore;

public class UserExamScoreProcessDbImpl implements UserExamScoreProcess {

    private UserExamScoreDAO userExamScoreDAO;

    public UserExamScoreProcessDbImpl(UserExamScoreDAO userExamScoreDAO) {
        this.userExamScoreDAO = userExamScoreDAO;
    }

    @Override
    public UserExamScore findbyId(Integer id) {
        return this.userExamScoreDAO.findUserExamScoreById(id);
    }

    @Override
    public Integer updateResult(UserExamScore userExamScore) {
        return this.userExamScoreDAO.update(userExamScore);
    }
}

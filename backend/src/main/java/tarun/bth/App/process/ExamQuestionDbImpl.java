package tarun.bth.App.process;

import tarun.bth.App.db.ExamQuestionDAO;
import tarun.bth.App.db.entity.ExamQuestion;


public class ExamQuestionDbImpl implements ExamQuestionProcess {
    private ExamQuestionDAO examQuestionDAO;

    public ExamQuestionDbImpl(ExamQuestionDAO examQuestionDAO) {
        this.examQuestionDAO = examQuestionDAO;
    }

    @Override
    public ExamQuestion create(ExamQuestion examQuestion) {
        return this.examQuestionDAO.findExamQuestionById(this.examQuestionDAO.create(examQuestion));
    }
}

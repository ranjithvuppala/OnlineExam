package tarun.bth.App.process;

import tarun.bth.App.db.ExamQuestionDAO;
import tarun.bth.App.db.entity.ExamQuestion;
import tarun.bth.App.db.entity.QuestionChoice;

import java.util.ArrayList;
import java.util.List;


public class ExamQuestionDbImpl implements ExamQuestionProcess {
    private ExamQuestionDAO examQuestionDAO;

    public ExamQuestionDbImpl(ExamQuestionDAO examQuestionDAO) {
        this.examQuestionDAO = examQuestionDAO;
    }

    @Override
    public int create(List<ExamQuestion> examQuestion){

        for(ExamQuestion i : examQuestion){

            this.examQuestionDAO.create(i);

        }

        return(0);
    }

    @Override
    public List<Integer> find(int exam_id) {
        return this.examQuestionDAO.findExamQuestionById(exam_id);
    }

    @Override
    public void deleteByExamId(int exam_id) {
        this.examQuestionDAO.deleteByExamId(exam_id);
    }

    @Override
    public void deleteByQuestionId(int question_id) {
        this.examQuestionDAO.deleteByQuestionId(question_id);
    }
}

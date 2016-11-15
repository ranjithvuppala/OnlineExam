package tarun.bth.App.process;


import tarun.bth.App.db.ExamDAO;
import tarun.bth.App.db.QuestionDAO;
import tarun.bth.App.db.entity.Exam;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;


public class ExamProcessDbImpl implements ExamProcess {

    private ExamDAO examDAO;
    public ExamProcessDbImpl(ExamDAO examDAO) {
        this.examDAO = examDAO;
    }


    @Override
    public List<Exam> getExams() {return examDAO.getExams(); }

    @Override
    public Exam create(Exam exam) {
        return this.examDAO.findExamById(this.examDAO.create(exam));
    }



    @Override
    public Exam update(Integer exam_id, Exam updatedExamPaper) throws NotFoundException {
        Exam exam = this.find(exam_id);
        exam.setExam(updatedExamPaper.getExam());
        this.examDAO.update(exam);
        return exam;
    }

    @Override
    public Exam find(Integer id) throws NotFoundException {
        return Optional
                .ofNullable(this.examDAO.findExamById(id))
                .orElseThrow(() -> new NotFoundException("Exam does not exist"));
    }

    @Override
    public void delete(Integer exam_id) {
        this.examDAO.delete(exam_id);
    }

   // @Override
    //public List<Exam> getSelectedQuestions() {return this.examDAO.getSelectedQuestions();}
}

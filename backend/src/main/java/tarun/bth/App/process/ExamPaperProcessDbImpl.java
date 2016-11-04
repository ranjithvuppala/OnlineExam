package tarun.bth.App.process;

import tarun.bth.App.db.ExamPaperDAO;
import tarun.bth.App.db.LoginDAO;
import tarun.bth.App.db.entity.ExamPaper;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;


public class ExamPaperProcessDbImpl implements ExamPaperProcess{

    private ExamPaperDAO examPaperDAO;

    public ExamPaperProcessDbImpl(ExamPaperDAO examPaperDAO) {
        this.examPaperDAO = examPaperDAO;
    }

    @Override
    public List<ExamPaper> getAllQuestions() {
        return examPaperDAO.getAllQuestions() ;
    }

    @Override
    public ExamPaper create(ExamPaper examPaper) {
        return this.examPaperDAO.findQuestionById(this.examPaperDAO.create(examPaper));
    }

    @Override
    public ExamPaper update(Integer question_id, ExamPaper updatedexamPaper) throws NotFoundException {
        ExamPaper examPaper = this.find(question_id);
        examPaper.setQuestion(updatedexamPaper.getQuestion());
        examPaper.setFirstoption(updatedexamPaper.getFirstoption());
        examPaper.setSecondoption(updatedexamPaper.getSecondoption());
        examPaper.setThirdoption(updatedexamPaper.getThirdoption());
        examPaper.setFourthoption(updatedexamPaper.getFourthoption());
        examPaper.setCorrectoption(updatedexamPaper.getCorrectoption());
        this.examPaperDAO.update(examPaper);
        return examPaper;
    }

    @Override
    public ExamPaper find(Integer id) throws NotFoundException {
        return Optional
                .ofNullable(this.examPaperDAO.findQuestionById(id))
                .orElseThrow(() -> new NotFoundException("Question does not exist"));
    }

    @Override
    public void delete(Integer question_id) {
        this.examPaperDAO.delete(question_id);
    }
}

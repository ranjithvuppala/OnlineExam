package tarun.bth.App.process;

import tarun.bth.App.db.QuestionDAO;
import tarun.bth.App.db.entity.Question;
import tarun.bth.App.db.entity.QuestionName;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;


public class QuestionProcessDbImpl implements QuestionProcess {

    private QuestionDAO questionDAO;

    public QuestionProcessDbImpl(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionDAO.getAllQuestions() ;
    }

    @Override
    public Question create(Question question) {
        return this.questionDAO.findQuestionById(this.questionDAO.create(question));
    }

    @Override
    public Question update(Integer question_id, Question updatedexamPaper) throws NotFoundException {
        Question question = this.find(question_id);
        question.setQuestion(updatedexamPaper.getQuestion());
        question.setFirstoption(updatedexamPaper.getFirstoption());
        question.setSecondoption(updatedexamPaper.getSecondoption());
        question.setThirdoption(updatedexamPaper.getThirdoption());
        question.setFourthoption(updatedexamPaper.getFourthoption());
        this.questionDAO.update(question);
        return question;
    }

    @Override
    public Question find(Integer id) throws NotFoundException {
        return Optional
                .ofNullable(this.questionDAO.findQuestionById(id))
                .orElseThrow(() -> new NotFoundException("QuestionName does not exist"));
    }

    @Override
    public void delete(Integer question_id) {
        this.questionDAO.delete(question_id);
    }

    @Override
    public List<QuestionName> getOnlyQuestions() {
        return this.questionDAO.getOnlyQuestions();
    }
}

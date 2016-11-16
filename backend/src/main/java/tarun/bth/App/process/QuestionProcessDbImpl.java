package tarun.bth.App.process;

import tarun.bth.App.db.ChoiceDAO;
import tarun.bth.App.db.QuestionChoiceDAO;
import tarun.bth.App.db.QuestionDAO;
import tarun.bth.App.db.entity.Choice;
import tarun.bth.App.db.entity.Question;
import tarun.bth.App.db.entity.QuestionResponse;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class QuestionProcessDbImpl implements QuestionProcess {

    private QuestionDAO questionDAO;

    private QuestionChoiceProcess questionChoiceProcess;

    private ChoiceProcess choiceProcess;

    public QuestionProcessDbImpl(QuestionDAO questionDAO, QuestionChoiceProcess questionChoiceProcess, ChoiceProcess choiceProcess) {
        this.questionDAO = questionDAO;
        this.questionChoiceProcess = questionChoiceProcess;
        this.choiceProcess = choiceProcess;
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
        question.setCorrectChoice_id(updatedexamPaper.getCorrectChoice_id());
        this.questionDAO.update(question);
        return question;
    }

    @Override
    public Question find(Integer question_id) throws NotFoundException {
        return Optional
                .ofNullable(this.questionDAO.findQuestionById(question_id))
                .orElseThrow(() -> new NotFoundException("QuestionName does not exist"));
    }

    @Override
    public void delete(Integer question_id) {
        this.questionDAO.delete(question_id);
    }

    @Override
    public List<QuestionResponse> findList(List<Integer> questionIdList) throws NotFoundException {

        List<QuestionResponse> questionResponseList = new ArrayList<QuestionResponse>();
        for(Integer i : questionIdList){

            List<Integer> choiceIdList = this.questionChoiceProcess.find(i);
            List<Choice> choiceList = this.choiceProcess.findList(choiceIdList);
            Question question= this.find(i);
            question.setCorrectChoice_id(null);
            QuestionResponse questionResponse = new QuestionResponse(question,choiceList);
            questionResponse.setQuestion(question);
            questionResponse.setChoiceList(choiceList);
            questionResponseList.add(questionResponse);

        }

        return questionResponseList;

    }

    @Override
    public int findChoice(Integer question_id) {
       return this.questionDAO.findCorrectChoiceByQuestionId(question_id);
    }
}

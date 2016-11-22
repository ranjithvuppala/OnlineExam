package tarun.bth.App.process;

import tarun.bth.App.db.ChoiceDAO;
import tarun.bth.App.db.ExamQuestionDAO;
import tarun.bth.App.db.QuestionChoiceDAO;
import tarun.bth.App.db.QuestionDAO;
import tarun.bth.App.db.entity.Choice;
import tarun.bth.App.db.entity.ExamQuestion;
import tarun.bth.App.db.entity.Question;
import tarun.bth.App.db.entity.QuestionResponse;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class QuestionProcessDbImpl implements QuestionProcess {

    private QuestionDAO questionDAO;

    private QuestionChoiceDAO questionChoiceDAO;

    private ChoiceDAO choiceDAO;

    private ExamQuestionDAO examQuestionDAO;

    public QuestionProcessDbImpl(QuestionDAO questionDAO, QuestionChoiceDAO questionChoiceDAO, ChoiceDAO choiceDAO, ExamQuestionDAO examQuestionDAO) {
        this.questionDAO = questionDAO;
        this.questionChoiceDAO = questionChoiceDAO;
        this.choiceDAO = choiceDAO;
        this.examQuestionDAO=examQuestionDAO;
    }

    @Override
    public List<QuestionResponse> getAllQuestions() {
        List<Question> questionList = questionDAO.getAllQuestions() ;
        List<Integer> questionIdList = new ArrayList<Integer>();

        for(Question i : questionList){
            questionIdList.add(i.getQuestion_id());
        }

        return(this.findList(questionIdList));


    }


    @Override
    public List<Question> getAll() {
        return questionDAO.getAllQuestions();
    }

    @Override
    public Question create(Question question) {
        return this.questionDAO.findQuestionById(this.questionDAO.create(question));
    }

    @Override
    public Question update(Integer question_id, Question updatedexamPaper) throws NotFoundException {
        Question question = this.findByQuestionId(question_id);
        question.setQuestion(updatedexamPaper.getQuestion());
        question.setCorrectChoice_id(updatedexamPaper.getCorrectChoice_id());
        this.questionDAO.update(question);
        return question;
    }

    @Override
    public Question findByQuestionId(Integer question_id) throws NotFoundException {
        return Optional
                .ofNullable(this.questionDAO.findQuestionById(question_id))
                .orElseThrow(() -> new NotFoundException("QuestionName does not exist"));
    }

    @Override
    public void delete(Integer question_id) {
        this.questionDAO.delete(question_id);
        this.questionChoiceDAO.deleteByQuestionId(question_id);
        this.examQuestionDAO.deleteByQuestionId(question_id);
    }

    @Override
    public List<QuestionResponse> findList(List<Integer> questionIdList) throws NotFoundException {

        List<QuestionResponse> questionResponseList = new ArrayList<QuestionResponse>();
        for(Integer i : questionIdList){
            QuestionResponse questionResponse = this.find(i);
            questionResponseList.add(questionResponse);

        }

        return questionResponseList;

    }

    @Override
    public int findChoice(Integer question_id) {
       return this.questionDAO.findCorrectChoiceByQuestionId(question_id);
    }

    @Override
    public void deleteByCorrectOptionId(int choice_id) {
        this.questionDAO.deleteByCorrectOptionId(choice_id);
    }


    @Override
    public QuestionResponse find(Integer question_id) {

        List<Integer> choiceIdList = this.questionChoiceDAO.findQuestionChoiceById(question_id);
        List<Choice> choiceList = this.findChoiceList(choiceIdList);
        Question question= this.findByQuestionId(question_id);
        question.setCorrectChoice_id(null);
        QuestionResponse questionResponse = new QuestionResponse(question,choiceList);
        questionResponse.setQuestion(question);
        questionResponse.setChoiceList(choiceList);

        return questionResponse;
    }



    @Override
    public List<Choice> findChoiceList(List<Integer> choice_id_list) throws NotFoundException {

        List<Choice> choiceList = new ArrayList<Choice>();
        for(Integer i : choice_id_list){

            choiceList.add(this.choiceDAO.findChoiceById(i));

        }

        return choiceList;

    }


}

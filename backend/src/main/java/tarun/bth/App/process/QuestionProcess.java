package tarun.bth.App.process;

import tarun.bth.App.db.entity.Choice;
import tarun.bth.App.db.entity.Question;
import tarun.bth.App.db.entity.QuestionResponse;

import javax.ws.rs.NotFoundException;
import java.util.List;


public interface QuestionProcess {
    List<QuestionResponse> getAllQuestions();
    List<Question> getAll();
    Question create(Question question);
    Question update(Integer question_id, Question question) throws NotFoundException;
    Question findByQuestionId(Integer question_id) throws NotFoundException;
    QuestionResponse find(Integer question_id);
    void delete(Integer question_id);
    List<QuestionResponse> findList(List<Integer> questionIdlist);
    int findChoice(Integer question_id);
    void deleteByCorrectOptionId(int choice_id);
    List<Choice> findChoiceList(List<Integer> choice_id_list);


}

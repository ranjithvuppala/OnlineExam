package tarun.bth.App.process;

import tarun.bth.App.db.entity.Question;
import tarun.bth.App.db.entity.QuestionName;

import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * Created by user on 03-11-2016.
 */
public interface QuestionProcess {
    List<Question> getAllQuestions();
    Question create(Question question);
    Question update(Integer question_id, Question question) throws NotFoundException;
    Question find(Integer question_id) throws NotFoundException;
    void delete(Integer question_id);

    List<QuestionName> getOnlyQuestions();
}

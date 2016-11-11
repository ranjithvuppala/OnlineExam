package tarun.bth.App.process;

import tarun.bth.App.db.entity.Choice;

import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * Created by user on 03-11-2016.
 */
public interface ChoiceProcess {
    List<Choice> getAllChoices();
    Choice create(Choice choice);
    Choice update(Integer id, Choice choice) throws NotFoundException;
    Choice find(Integer id) throws NotFoundException;
    void delete(Integer id);

    //List<QuestionName> getOnlyQuestions();
}
